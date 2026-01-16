package com.wireguard.android.presentation.profile

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.wireguard.android.R
import com.wireguard.android.common.knobs.AdminKnobs
import com.wireguard.android.common.knobs.ProfileManager
import com.wireguard.android.databinding.FragmentConfigurationProfilesBinding
import com.wireguard.android.presentation.common.BaseFragment
import com.wireguard.android.presentation.common.uihelpers.Helpers
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ConfigurationProfilesFragment : BaseFragment() {

    private var _binding: FragmentConfigurationProfilesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ProfilesAdapter
    private val viewModel: ProfileViewModel by viewModels()
    private var restrictionsReceiver: BroadcastReceiver? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfigurationProfilesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadAndDisplayProfiles()

        observeEvents()

        binding.apply {
            addVpnProfileButton.setOnClickListener {
                findNavController().navigate(R.id.action_configurationProfilesFragment_to_hostSetupFragment)
            }
        }

        if (restrictionsReceiver == null) {
            val filter = IntentFilter(Intent.ACTION_APPLICATION_RESTRICTIONS_CHANGED)
            restrictionsReceiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    ProfileManager.updateFromRestrictions()
                    loadAndDisplayProfiles()

                }
            }
            ContextCompat.registerReceiver(
                requireContext(),
                restrictionsReceiver,
                filter,
                ContextCompat.RECEIVER_NOT_EXPORTED
            )
        }
        enableSwipeToDelete()
    }
    private fun enableSwipeToDelete() {
        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun getSwipeDirs(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                //val profile = adapter.getProfileAt(viewHolder.adapterPosition)
                //return if (profile.isUserProfile) super.getSwipeDirs(recyclerView, viewHolder) else 0
                val position = viewHolder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = adapter.getProfileAt(position)
                    return if (profile.isUserProfile) super.getSwipeDirs(recyclerView, viewHolder) else 0
                }
                return 0

            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val profile = adapter.getProfileAt(position)
                if (position != RecyclerView.NO_POSITION) {
                    ProfileManager.deleteUserProfile(profile.id)
                    loadAndDisplayProfiles()
                    Helpers.showCustomSnackbarWithAction(
                        binding.root,
                        getString(R.string.profile_deleted),
                        actionText = getString(R.string.undo)
                    ) {
                        ProfileManager.restoreUserProfile(profile)
                        //adapter.updateList(ProfileManager.getAllProfiles())
                        loadAndDisplayProfiles()
                    }
                }
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val itemView = viewHolder.itemView
                val paint = Paint().apply { color = Color.RED }
                val icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_action_delete)

                if (dX < 0) {
                    c.drawRect(
                        itemView.right + dX, itemView.top.toFloat(),
                        itemView.right.toFloat(), itemView.bottom.toFloat(), paint
                    )

                    val iconMargin = (itemView.height - icon!!.intrinsicHeight) / 2
                    val iconTop = itemView.top + iconMargin
                    val iconBottom = iconTop + icon.intrinsicHeight
                    val iconLeft = itemView.right - icon.intrinsicWidth - iconMargin
                    val iconRight = itemView.right - iconMargin

                    icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
                    icon.draw(c)
                }

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.profilesRecyclerview)
    }

    private fun loadAndDisplayProfiles() {
        val updatedProfiles = ProfileManager.getAllProfiles()
        adapter.updateList(updatedProfiles)

        if (_binding == null) return

        _binding?.apply {
            tvEmptyProfile.isVisible = updatedProfiles.isEmpty()
            profilesRecyclerview.isVisible = updatedProfiles.isNotEmpty()
        }

    }

    private fun setupRecyclerView() {

        adapter = ProfilesAdapter(
            emptyList(),
            onItemClick = { selectedProfile ->
                viewModel.onProfileSelected(selectedProfile)
            }
        )


        binding.profilesRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ConfigurationProfilesFragment.adapter
            setHasFixedSize(true)
        }
    }


    private fun observeEvents(){
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is ProfileUiEvent.NavigateToManualSetup -> {
                        val bundle = Bundle().apply {
                            putBoolean("credential", event.loginMethods.credential)
                            putBoolean("certification", event.loginMethods.certification)
                            putBoolean("validDevice", event.loginMethods.validDevice)
                        }
                        /*
                        findNavController().navigate(
                            R.id.action_configurationProfilesFragment_to_manualSetupFragment,
                            bundle
                        )
                        */
                        if (findNavController().currentDestination?.id == R.id.configurationProfilesFragment) {
                            findNavController().navigate(R.id.action_configurationProfilesFragment_to_manualSetupFragment,bundle
                            )
                        } else {
                            // Backstack bozulmuşsa önce geri git, sonra yönlendir
                            findNavController().popBackStack(R.id.configurationProfilesFragment, false)
                            findNavController().navigate(
                                R.id.action_configurationProfilesFragment_to_manualSetupFragment,
                                bundle
                            )
                        }
                    }

                    is ProfileUiEvent.ShowError -> {
                        Helpers.showCustomSnackbar(binding.root,event.message.asString(requireContext()))
                    }
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        restrictionsReceiver?.let {
            requireContext().unregisterReceiver(it)
            restrictionsReceiver = null
        }
    }
}