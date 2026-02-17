package com.wireguard.android.presentation.status


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wireguard.android.data.remote.dto.NodeModel
import com.wireguard.android.databinding.ServerListItemBinding

class ServerListAdapter(
    private var serverList: List<NodeModel>,
    private val onItemClick: (NodeModel) -> Unit,
) : RecyclerView.Adapter<ServerListAdapter.ServerViewHolder>() {

    inner class ServerViewHolder(
        private val binding: ServerListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(server: NodeModel) {
            binding.tvIp.text = server.ipAddress
            binding.tvUsername.text = server.name
            binding.tvCountryCode.text = server.countryCode

            binding.root.setOnClickListener {
                onItemClick(server)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerViewHolder {
        val binding = ServerListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ServerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServerViewHolder, position: Int) {
        holder.bind(serverList[position])
    }

    override fun getItemCount(): Int = serverList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateServerList(newList: List<NodeModel>) {
        serverList = newList
        notifyDataSetChanged()
    }

    fun getServerAt(position: Int): NodeModel {
        return serverList[position]
    }

}