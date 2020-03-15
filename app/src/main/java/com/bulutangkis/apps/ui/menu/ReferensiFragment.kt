package com.bulutangkis.apps.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bulutangkis.apps.R

import com.bulutangkis.apps.databinding.FragmentReferensiBinding

/**
 * A simple [Fragment] subclass.
 */
class ReferensiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentReferensiBinding = FragmentReferensiBinding.inflate(layoutInflater)
        binding.referensiSatu.text = resources.getText(R.string.referensi_satu)
        binding.referensiDua.text = resources.getText(R.string.referensi_dua)
        binding.referensiTiga.text = resources.getText(R.string.referensi_tiga)
        binding.referensiEmpat.text = resources.getText(R.string.referensi_empat)
        binding.referensiLima.text = resources.getText(R.string.referensi_lima)
        return binding.root
    }

}
