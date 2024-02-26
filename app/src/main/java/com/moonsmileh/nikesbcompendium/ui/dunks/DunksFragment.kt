package com.moonsmileh.nikesbcompendium.ui.dunks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.moonsmileh.nikesbcompendium.R
import com.moonsmileh.nikesbcompendium.databinding.FragmentDunksBinding
import com.moonsmileh.nikesbcompendium.domain.model.Dunk
import com.moonsmileh.nikesbcompendium.ui.dunks.adapter.DunksAdapter
import com.moonsmileh.nikesbcompendium.ui.dunkdetail.DunkDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DunksFragment : Fragment() {

    private lateinit var _binding: FragmentDunksBinding
    private val binding get() = _binding

    private val viewModel: DunksViewModel by viewModels()

    private lateinit var dunksAdapter: DunksAdapter

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
        dunksAdapter = DunksAdapter(onItemSelected = {

            val bundle = Bundle()
            bundle.putString(resources.getString(R.string.dunk_id_key), it.id)
            findNavController().navigate(R.id.action_dunksFragment_to_dunkDetailFragment, bundle)

        })

        binding.recyclerViewDunks.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = dunksAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dunksState.collect { uiState ->
                    when (uiState) {
                        is DunksState.Success -> showDunks(uiState.dunks)
                        is DunksState.Loading -> showLoader(uiState.isLoading)
                        is DunksState.Error -> showErrorMessage(resources.getString(R.string.error_message_request))
                    }
                }
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun showLoader(isLoading: Boolean) {
        binding.lottieAnimationView.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showDunks(dunks: List<Dunk>) {
        dunksAdapter.updateList(dunks)
    }
}