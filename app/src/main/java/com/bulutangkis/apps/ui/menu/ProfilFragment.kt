package com.bulutangkis.apps.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bulutangkis.apps.databinding.FragmentProfilBinding

/**
 * A simple [Fragment] subclass.
 */
class ProfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentProfilBinding = FragmentProfilBinding.inflate(layoutInflater)
        return binding.root
    }

}
