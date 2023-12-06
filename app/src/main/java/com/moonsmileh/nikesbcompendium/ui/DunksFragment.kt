package com.moonsmileh.nikesbcompendium.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.moonsmileh.nikesbcompendium.databinding.FragmentDunksBinding
import com.moonsmileh.nikesbcompendium.ui.adapter.SneakersAdapter
import com.moonsmileh.nikesbcompendium.ui.dunkdetail.DunksViewModel
import kotlinx.coroutines.launch

class DunksFragment : Fragment() {

    private lateinit var _binding: FragmentDunksBinding
    private val binding get() = _binding

    private val viewModel by viewModels<DunksViewModel>()

    private lateinit var sneakersAdapter: SneakersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDunksBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    private fun initUI() {
        initUIState()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        sneakersAdapter = SneakersAdapter(onItemSelected = {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
                .show()
        })

        binding.recyclerViewSneakers.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = sneakersAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.boxes.collect {
                    sneakersAdapter.updateList(it)
                }
            }
        }
    }
}