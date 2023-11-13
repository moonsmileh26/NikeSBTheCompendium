package com.moonsmileh.nikesbcompendium.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moonsmileh.nikesbcompendium.databinding.FragmentSneakersBinding

class SneakersFragment : Fragment() {

    private lateinit var _binding: FragmentSneakersBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSneakersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}