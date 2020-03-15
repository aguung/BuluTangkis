package com.bulutangkis.apps.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.bulutangkis.apps.adapter.ItemAdapter
import com.bulutangkis.apps.databinding.FragmentProgramLatihanBinding

/**
 * A simple [Fragment] subclass.
 */
class ProgramLatihanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentProgramLatihanBinding = FragmentProgramLatihanBinding.inflate(layoutInflater)
        val item:List<String> = listOf("1. Drilling Lob", "2. Drilling Dropshot", "3. Drilling Smash", "4. Drilling Netting", "5. Underarm","6. Drilling Drive","7. Stroke Lob","8. Stroke Underarm & Dropshot","9. Stroke Smash & Drive","10. Stroke Dropshot, Netting, & Underarm")
        val itemAdapter = ItemAdapter(item)
        binding.rvProgramLatihan.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        binding.rvProgramLatihan.adapter = itemAdapter

        itemAdapter.itemClick(object:ItemAdapter.OnItemClick{
            override fun onItemClicked(item: String, posisi: Int) {
                val intent = Intent(activity!!, ContentProgramLatihanActivity::class.java)
                when (posisi) {
                    0 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 1.html")
                    1 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 2.html")
                    2 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 3.html")
                    3 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 4.html")
                    4 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 5.html")
                    5 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 6.html")
                    6 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 7.html")
                    7 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 8.html")
                    8 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 9.html")
                    9 -> intent.putExtra(ContentProgramLatihanActivity.EXTRA_CONTENT,"Program 10.html")
                }
                intent.putExtra(ContentProgramLatihanActivity.EXTRA_TITLE,item)
                startActivity(intent)
            }
        })

        return binding.root
    }

}
