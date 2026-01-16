/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.profile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.wireguard.android.R
import com.wireguard.android.databinding.ConfigurationProfileItemViewBinding
import com.wireguard.android.domain.model.VpnProfile

class ProfilesAdapter(
    private var profiles: List<VpnProfile>,
    private val onItemClick: (VpnProfile) -> Unit,
) : RecyclerView.Adapter<ProfilesAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(
        private val binding: ConfigurationProfileItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(profile: VpnProfile) {
            binding.tvProfileConectionName.text = profile.details.connectionName
            binding.tvServerAddress.text = profile.details.host
            binding.tvPort.text = profile.details.port.toString()

            binding.root.setOnClickListener {
                onItemClick(profile)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding = ConfigurationProfileItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(profiles[position])
    }

    override fun getItemCount(): Int = profiles.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<VpnProfile>) {
        profiles = newList
        notifyDataSetChanged()
    }

    fun getProfileAt(position: Int): VpnProfile {
        return profiles[position]
    }

}
