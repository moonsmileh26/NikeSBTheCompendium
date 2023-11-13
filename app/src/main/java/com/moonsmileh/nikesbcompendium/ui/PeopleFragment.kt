package com.moonsmileh.nikesbcompendium.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moonsmileh.nikesbcompendium.databinding.FragmentPeopleBinding


class PeopleFragment : Fragment() {

    private lateinit var _binding: FragmentPeopleBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeopleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}