package com.ossovita.artbooktesting.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ossovita.artbooktesting.R
import com.ossovita.artbooktesting.adapter.ArtRecyclerAdapter
import com.ossovita.artbooktesting.databinding.FragmentArtsBinding
import com.ossovita.artbooktesting.viewmodel.ArtViewModel
import javax.inject.Inject

class ArtFragment @Inject constructor(
    val artRecyclerAdapter: ArtRecyclerAdapter
): Fragment(R.layout.fragment_arts) {//layout ile contentView'ı bağlıyoruz, bu sayede onViewCreate altında inflate etmeye gerek kalmıyor

    private var fragmentBinding:FragmentArtsBinding? =null//onViewCreated dışında vb
    lateinit var viewModel: ArtViewModel

    private val swipeCallBack = object:ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT ){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder


        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectedArt = artRecyclerAdapter.arts[layoutPosition]
            viewModel.deleteArt(selectedArt)
        }

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(requireActivity()).get( ArtViewModel::class.java)
        val binding = FragmentArtsBinding.bind(view)//onViewCreated içinde vb
        fragmentBinding = binding

        subsribeToObservers()
        binding.recyclerViewArt.adapter=artRecyclerAdapter
        binding.recyclerViewArt.layoutManager=LinearLayoutManager(requireContext())
        ItemTouchHelper(swipeCallBack).attachToRecyclerView(binding.recyclerViewArt)

        binding.fab.setOnClickListener {
           findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }
    }

    private fun subsribeToObservers(){
        viewModel.artList.observe(viewLifecycleOwner, Observer{
            artRecyclerAdapter.arts=it
        })
    }

    override fun onDestroy() {//fragment kapatıldığında viewBinding'i null'a eşitle
        super.onDestroy()
        fragmentBinding=null
    }
}