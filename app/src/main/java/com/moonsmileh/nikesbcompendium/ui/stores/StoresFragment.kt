package com.moonsmileh.nikesbcompendium.ui.stores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moonsmileh.nikesbcompendium.databinding.FragmentStoresBinding

class StoresFragment : Fragment() {

    private lateinit var _binding: FragmentStoresBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoresBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}