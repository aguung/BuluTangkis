package com.bulutangkis.apps.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.bulutangkis.apps.adapter.ItemAdapter
import com.bulutangkis.apps.databinding.FragmentMateriBinding

/**
 * A simple [Fragment] subclass.
 */
class MateriFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMateriBinding = FragmentMateriBinding.inflate(layoutInflater)
        val item: List<String> = listOf(
            "1. Sikap Berdiri (Stance)",
            "2. Teknik Memegang Raket (Grip)",
            "3. Teknik Memukul Kok",
            "4. Teknik Langkah Kaki (Footwork)",
            "5. Kelincahan Footwork Bulutangkis",
            "6. Latihan Kelincahan Footwork Bulutangkis"
        )
        val itemAdapter = ItemAdapter(item)
        binding.rvMateri.layoutManager =
            LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        binding.rvMateri.adapter = itemAdapter

        itemAdapter.itemClick(object : ItemAdapter.OnItemClick {
            override fun onItemClicked(item: String, posisi: Int) {
                val intent = Intent(activity!!, ContentMateriActivity::class.java)
                when (posisi) {
                    0 -> intent.putExtra(ContentMateriActivity.EXTRA_CONTENT,"Materi 1.html")
                    1 -> intent.putExtra(ContentMateriActivity.EXTRA_CONTENT,"Materi 2.html")
                    2 -> intent.putExtra(ContentMateriActivity.EXTRA_CONTENT,"Materi 3.html")
                    3 -> intent.putExtra(ContentMateriActivity.EXTRA_CONTENT,"Materi 4.html")
                    4 -> intent.putExtra(ContentMateriActivity.EXTRA_CONTENT,"Materi 5.html")
                    5 -> intent.putExtra(ContentMateriActivity.EXTRA_CONTENT,"Materi 6.html")
                }
                intent.putExtra(ContentMateriActivity.EXTRA_TITLE,item)
                startActivity(intent)
            }
        })

        return binding.root
    }

}
