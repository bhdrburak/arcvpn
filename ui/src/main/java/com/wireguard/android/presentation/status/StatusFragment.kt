/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.status

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.wireguard.android.R
import com.wireguard.android.databinding.FragmentStatusBinding
import com.wireguard.android.presentation.common.BaseFragment
import com.wireguard.android.presentation.common.uihelpers.Helpers
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class StatusFragment : BaseFragment() {

    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ServerCountryAdapter


    private val viewModel: StatusViewModel by viewModels()

    private var selectedConfigId = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllNodes()
        lifecycleScope.launch {

            viewModel.uiState.collect { state ->
                binding.swipeRefreshLayout.isRefreshing = false
                when (state) {
                    is StatusUiState.Loading -> {
                        binding.emptyCatalog.visibility = View.VISIBLE
                        binding.emptyCatalogAppImg.visibility = View.VISIBLE
                    }

                    is StatusUiState.Idle -> {

                    }

                    is StatusUiState.ValidationErrors -> {
                        binding.emptyCatalog.visibility = View.VISIBLE
                        binding.emptyCatalogAppImg.visibility = View.VISIBLE
                    }

                    is StatusUiState.Success -> {
                        if (!state.data.nodes.isNullOrEmpty()) {
                            binding.emptyCatalog.visibility = View.GONE
                            binding.emptyCatalogAppImg.visibility = View.GONE
                            adapter.updateServerList(state.data.grouped)
                        } else {
                            binding.emptyCatalog.visibility = View.VISIBLE
                            binding.emptyCatalogAppImg.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
        observeEvents()
        setupRecyclerView()

    }


    private fun observeEvents(){
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is StatusUiEvent.NavigateToQuickConnect -> {
                        if (findNavController().currentDestination?.id == R.id.statusFragment) {
                            val bundle = Bundle().apply {
                                putParcelable("quick_config", event.quickConnect)
                                putInt("config_id", selectedConfigId)
                            }
                            Log.d("TestNavigate", "vpndetail")
                            findNavController().navigate(R.id.action_statusFragment_to_vpnDetailFragment, bundle
                            )
                        }
                    }

                    is StatusUiEvent.ShowError -> {
                        Helpers.showCustomSnackbar(binding.root,event.message.asString(requireContext()))
                    }
                }
            }
        }

    }


    private fun setupRecyclerView() {

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getAllNodes()
        }
        adapter = ServerCountryAdapter(
            emptyList(),
            onItemClick = { selectedServer ->
                selectedConfigId = selectedServer.id ?: 0
                viewModel.getQuickConnect(selectedServer.id ?: 0)
            }
        )
        binding.serversListRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@StatusFragment.adapter
            setHasFixedSize(true)
        }
    }
}