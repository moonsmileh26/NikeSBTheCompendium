package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.moonsmileh.nikesbcompendium.R
import com.moonsmileh.nikesbcompendium.databinding.FragmentDunkDetailBinding
import com.moonsmileh.nikesbcompendium.ui.dunks.DunksState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DunkDetailFragment : Fragment() {

    private lateinit var binding: FragmentDunkDetailBinding
    private val viewModel: DunkDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDunkDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUIState()
        val dunkId = arguments?.getString(resources.getString(R.string.dunk_id_key))
            ?: getString(R.string.default_dunk_id)
        viewModel.getDunkById(dunkId)
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dunkDetailState.collect {
                    when (it) {
                        is DunkDetailState.Loading -> showLoader(it.isLoading)
                    }
                }
            }
        }
    }

    private fun showLoader(isLoading: Boolean) {
        binding.lottieAnimationView.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}