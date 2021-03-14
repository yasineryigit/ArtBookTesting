package com.ossovita.artbooktesting.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ossovita.artbooktesting.R
import com.ossovita.artbooktesting.databinding.FragmentArtsBinding

class ArtFragment : Fragment(R.layout.fragment_arts) {//layout ile contentView'ı bağlıyoruz, bu sayede onViewCreate altında inflate etmeye gerek kalmıyor

    private var fragmentBinding:FragmentArtsBinding? =null//onViewCreated dışında vb

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentArtsBinding.bind(view)//onViewCreated içinde vb
        fragmentBinding = binding

        binding.fab.setOnClickListener {
           findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }
    }

    override fun onDestroy() {//fragment kapatıldığında viewBinding'i null'a eşitle
        super.onDestroy()
        fragmentBinding=null
    }
}