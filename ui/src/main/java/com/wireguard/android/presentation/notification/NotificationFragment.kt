package com.wireguard.android.presentation.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wireguard.android.R
import com.wireguard.android.data.remote.dto.NotificationModel
import com.wireguard.android.databinding.FragmentNotificationBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotificationFragment : Fragment() {


    private val viewModel by viewModels<NotificationsViewModel>()

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    companion object {
        var isUpdateAvailable = false
        val updateNotification = MutableLiveData<Boolean>()
    }

    @Inject
    lateinit var notificationsAdapter: NotificationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.bind(
            inflater.inflate(
                R.layout.fragment_notification,
                container,
                false
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isUpdateAvailable = true
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack()
        }
        callback.isEnabled

        binding.notificationRecyclerView.adapter = notificationsAdapter
        /*val nots = viewModel.finalNotificationList
        notificationsAdapter.notificationAdapterDiffer.submitList(nots)
        viewModel.getNotifications()
        viewModel.notifications.observe(viewLifecycleOwner, notificationsObserver)
        updateNotification.observe(viewLifecycleOwner, updateObserver)*/

        val isShowIcon = arguments?.getBoolean("showCloseBtn") ?: false

        binding.fragmentNavBar.appBarHeader.text = getString(R.string.notifications)
        if (isShowIcon) {
            binding.fragmentNavBar.ibAction.visibility = View.VISIBLE
        }

        binding.fragmentNavBar.ibAction.setOnClickListener {
            findNavController().popBackStack()
        }


        binding.fragmentNavBar.ibActionSecond.setOnClickListener {

        }

        notificationsAdapter.onDeleteClick = { notification, position ->

        }
    }


    private val notificationsObserver =
        Observer<MutableList<NotificationModel>> { notificationList ->
            try {
                val newList = notificationList
                notificationsAdapter.notificationAdapterDiffer.submitList(newList){
                    binding.notificationRecyclerView.smoothScrollToPosition(0)
                }
                if (newList.isEmpty()) {
                    binding.fragmentNavBar.ibActionSecond.visibility = View.GONE
                    binding.emptyLayout.visibility = View.VISIBLE
                } else {
                    binding.fragmentNavBar.ibActionSecond.visibility = View.VISIBLE
                    binding.emptyLayout.visibility = View.GONE
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

    private val updateObserver = Observer<Boolean> { update ->
        if (update) {
            //viewModel.getNotifications()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        isUpdateAvailable = false
        _binding = null
    }


}