package com.wireguard.android.presentation.status


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wireguard.android.data.remote.dto.CountryGroup
import com.wireguard.android.data.remote.dto.NodeModel
import com.wireguard.android.databinding.ServerCountryListItemBinding
import com.wireguard.android.databinding.ServerListItemBinding


class ServerCountryAdapter(
    private var serverList: List<Pair<String, CountryGroup>>,
    private val onItemClick: (NodeModel) -> Unit,
) : RecyclerView.Adapter<ServerCountryAdapter.ServerCountryViewHolder>() {

    inner class ServerCountryViewHolder(
        private val binding: ServerCountryListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val countryAdapter = ServerListAdapter(
            emptyList(),
            onItemClick = { selectedServer ->
                onItemClick(selectedServer)
            }
        )

        init {
            binding.serversListRv.apply {
                layoutManager = LinearLayoutManager(
                    binding.root.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = countryAdapter
            }
        }

        fun bind(countryCode: String, countryGroup: CountryGroup) {
            binding.tvCountryCode.text = countryGroup.flagEmoji +  " " +countryGroup.country


            val nodesList = countryGroup.locations.values.flatten()
            countryAdapter.updateServerList(nodesList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerCountryViewHolder {
        val binding = ServerCountryListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ServerCountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServerCountryViewHolder, position: Int) {
        val (countryCode, countryGroup) = serverList[position]
        holder.bind(countryCode, countryGroup)
    }

    override fun getItemCount(): Int = serverList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateServerList(newList: Map<String, CountryGroup>) {
        serverList = newList.toList()
        notifyDataSetChanged()
    }

    fun getServerAt(key: String): CountryGroup? {
        return serverList.find { it.first == key }?.second
    }
}