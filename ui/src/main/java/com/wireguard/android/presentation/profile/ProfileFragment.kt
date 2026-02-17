package com.wireguard.android.presentation.profile

import android.app.AlertDialog
import android.content.ComponentName
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wireguard.android.R
import com.wireguard.android.databinding.FragmentProfileBinding
import com.wireguard.android.presentation.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ProfileFragment @Inject constructor(

) : BaseFragment() {




    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private var otpDialog: AlertDialog? = null

    companion object {
        var adminPassword: String? = "102938"
        var instance: ProfileFragment? = null
        fun isInstanceCreated(): Boolean {
            return instance != null
        }
    }


    var mDeviceAdminSample: ComponentName? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.bind(
            inflater.inflate(
                R.layout.fragment_profile,
                container,
                false
            )
        )
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this

    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



}
