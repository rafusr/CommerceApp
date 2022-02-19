package com.andikas.commerceapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andikas.commerceapp.databinding.FragmentOfferBinding

class OfferFragment : Fragment() {
    private var _binding: FragmentOfferBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOfferBinding.inflate(inflater, container, false)
        return binding.root
    }
}