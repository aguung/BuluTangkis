package com.bulutangkis.apps.ui.menu

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bulutangkis.apps.R
import com.bulutangkis.apps.databinding.DialogNilaiBinding
import com.bulutangkis.apps.databinding.FragmentEvaluasiBinding


/**
 * A simple [Fragment] subclass.
 */
class EvaluasiFragment : Fragment() {
    private lateinit var binding: FragmentEvaluasiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEvaluasiBinding.inflate(layoutInflater)
        dataSoal()
        dataPilihan()

        binding.btnSubmit.setOnClickListener { dialogNilai(context!!,nilai())}
        return binding.root
    }

    private fun dataSoal() {
        binding.soalSatu.text = resources.getString(R.string.soal_1)
        binding.soalDua.text = resources.getString(R.string.soal_2)
        binding.soalTiga.text = resources.getString(R.string.soal_3)
        binding.soalEmpat.text = resources.getString(R.string.soal_4)
        binding.soalLima.text = resources.getString(R.string.soal_5)
    }

    private fun dataPilihan() {
        binding.rbPil1A.text = resources.getString(R.string._1a)
        binding.rbPil1B.text = resources.getString(R.string._1b)
        binding.rbPil1C.text = resources.getString(R.string._1c)
        binding.rbPil1D.text = resources.getString(R.string._1d)

        binding.rbPil2A.text = resources.getString(R.string._2a)
        binding.rbPil2B.text = resources.getString(R.string._2b)
        binding.rbPil2C.text = resources.getString(R.string._2c)
        binding.rbPil2D.text = resources.getString(R.string._2d)

        binding.rbPil3A.text = resources.getString(R.string._3a)
        binding.rbPil3B.text = resources.getString(R.string._3b)
        binding.rbPil3C.text = resources.getString(R.string._3c)
        binding.rbPil3D.text = resources.getString(R.string._3d)

        binding.rbPil4A.text = resources.getString(R.string._4a)
        binding.rbPil4B.text = resources.getString(R.string._4b)
        binding.rbPil4C.text = resources.getString(R.string._4c)
        binding.rbPil4D.text = resources.getString(R.string._4d)

        binding.rbPil5A.text = resources.getString(R.string._5a)
        binding.rbPil5B.text = resources.getString(R.string._5b)
        binding.rbPil5C.text = resources.getString(R.string._5c)
        binding.rbPil5D.text = resources.getString(R.string._5d)

    }

    private fun nilai(): Int {
        val score: Int
        var nilai = 0
        if (binding.rbPil1A.isChecked) nilai++
        if (binding.rbPil2A.isChecked) nilai++
        if (binding.rbPil3C.isChecked) nilai++
        if (binding.rbPil4B.isChecked) nilai++
        if (binding.rbPil5D.isChecked) nilai++

        score = nilai * 20

        return score
    }

    private fun dialogNilai(context: Context, score: Int) {
        val dialog = Dialog(context)
        val bindDialog: DialogNilaiBinding = DialogNilaiBinding.inflate(layoutInflater)
        dialog.setContentView(bindDialog.root)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)

        bindDialog.tvNilai.text = score.toString()
        dialog.show()
        bindDialog.btnOk.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

}
