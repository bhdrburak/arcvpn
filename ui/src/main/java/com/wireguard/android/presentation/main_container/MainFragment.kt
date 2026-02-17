package com.wireguard.android.presentation.main_container

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.wireguard.android.R
import com.wireguard.android.databinding.FragmentMainBinding
import com.wireguard.android.presentation.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainFragment @Inject constructor(

) : BaseFragment() {


    private lateinit var binding: FragmentMainBinding


    companion object {
        var isUpdateAvailable = false
        val updateNotification = MutableLiveData<Boolean>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {

            Log.d("TestNavigate", "mainfragment onCreate")
            //isSuccessEnroll = arguments?.containsKey("successEnroll") == true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentMainBinding.bind(inflater.inflate(R.layout.fragment_main, container, false))

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigationMenu()
    }

    private fun initNavigationMenu() {
        Log.d("TestNavigate", "mainfragment onCreate")
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNav.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_UNLABELED
        binding.bottomNav.setupWithNavController(navController)
        binding.bottomNav.visibility = View.VISIBLE
        isUpdateAvailable = true

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {

            }
        }
    }
}