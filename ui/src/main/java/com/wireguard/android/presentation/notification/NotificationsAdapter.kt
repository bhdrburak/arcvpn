package com.wireguard.android.presentation.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.wireguard.android.Application
import com.wireguard.android.R
import com.wireguard.android.data.remote.dto.NotificationModel
import com.wireguard.android.databinding.RowNotificationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotificationsAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<NotificationModel>() {
        override fun areItemsTheSame(
            oldItem: NotificationModel,
            newItem: NotificationModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: NotificationModel,
            newItem: NotificationModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    val notificationAdapterDiffer = AsyncListDiffer(this, diffUtil)

    var notificationsList: List<NotificationModel>
        get() = notificationAdapterDiffer.currentList
        set(value) = notificationAdapterDiffer.submitList(value)
    private lateinit var binding: RowNotificationBinding
    var onDeleteClick: ((NotificationModel, Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(Application.instance.applicationContext)
            .inflate(R.layout.row_notification, parent, false)
        return NotificationsAdapterHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binding = RowNotificationBinding.bind(holder.itemView)


        val notification = notificationsList[position]
        binding.txtNotificationDescription.text = notification.message
        binding.txtNotificationTitle.text = notification.title


        binding.deleteNotification.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                onDeleteClick?.invoke(notification, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return notificationsList.size
    }

}

class NotificationsAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
