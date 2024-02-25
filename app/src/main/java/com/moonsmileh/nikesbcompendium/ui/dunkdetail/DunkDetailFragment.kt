package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.moonsmileh.nikesbcompendium.R
import com.moonsmileh.nikesbcompendium.databinding.FragmentDunkDetailBinding

class DunkDetailFragment : Fragment() {

    private lateinit var binding: FragmentDunkDetailBinding
    private val dunkDetailViewModel: DunkDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dunk_detail, container, false)
    }

}