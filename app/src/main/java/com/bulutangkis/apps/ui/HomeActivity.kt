package com.bulutangkis.apps.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bulutangkis.apps.R
import com.bulutangkis.apps.data.PreferenceProvider
import com.bulutangkis.apps.databinding.ActivityHomeBinding
import com.bulutangkis.apps.ui.menu.*
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var doubleBackToExitPressedOnce = false
    private lateinit var fragment: Fragment
    private lateinit var beranda: TextView
    private lateinit var materi: TextView
    private lateinit var program: TextView
    private lateinit var evaluasi: TextView
    private lateinit var referensi: TextView
    private lateinit var profil: TextView
    private lateinit var menu: LinearLayout
    private lateinit var prefs: PreferenceProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.top.toolbar)
        supportActionBar?.title = null

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.include.top.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = binding.navView
        val headerView: View = navigationView.getHeaderView(0)

        binding.include.top.titleBar.text = resources.getString(R.string.beranda)
        fragment = HomeFragment()
        displaySelected(fragment)

        prefs = PreferenceProvider(this@HomeActivity)


        beranda = headerView.findViewById(R.id.btn_beranda)
        materi = headerView.findViewById(R.id.btn_materi)
        program = headerView.findViewById(R.id.btn_program)
        evaluasi = headerView.findViewById(R.id.btn_evaluasi)
        referensi = headerView.findViewById(R.id.btn_referensi)
        profil = headerView.findViewById(R.id.btn_profil)
        menu = headerView.findViewById(R.id.menu)

        if (!prefs.getGuideStatus()) {
            binding.drawerLayout.openDrawer(GravityCompat.START)
            setGuide(
                menu,
                1,
                "Halaman Menu",
                "Berisikan menu-menu yang terdapat aplikasi, geser ke kanan pada bagian kiri layar untuk membuka"
            )
        }

        beranda.setOnClickListener {
            binding.include.top.titleBar.text = resources.getString(R.string.beranda)
            fragment = HomeFragment()
            displaySelected(fragment)
        }
        materi.setOnClickListener {
            binding.include.top.titleBar.text = resources.getString(R.string.materi)
            fragment = MateriFragment()
            displaySelected(fragment)
        }
        program.setOnClickListener {
            binding.include.top.titleBar.text = resources.getString(R.string.program_latihan)
            fragment = ProgramLatihanFragment()
            displaySelected(fragment)
        }
        evaluasi.setOnClickListener {
            binding.include.top.titleBar.text = resources.getString(R.string.evaluasi)
            fragment = EvaluasiFragment()
            displaySelected(fragment)
        }
        referensi.setOnClickListener {
            binding.include.top.titleBar.text = resources.getString(R.string.referensi)
            fragment = ReferensiFragment()
            displaySelected(fragment)
        }
        profil.setOnClickListener {
            binding.include.top.titleBar.text = resources.getString(R.string.profil)
            fragment = ProfilFragment()
            displaySelected(fragment)
        }


    }

    private fun displaySelected(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.include.content.frame.id, fragment)
        fragmentTransaction.commitAllowingStateLoss()
        binding.drawerLayout.closeDrawers()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Tekan Lagi Untuk Keluar", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
    }

    private fun setGuide(view: View, posisi: Int, title: String, description: String) {
        GuideView.Builder(this@HomeActivity)
            .setTitle(title)
            .setContentText(description)
            .setContentTextSize(12)//optional
            .setTitleTextSize(14)
            .setGravity(Gravity.center)
            .setTargetView(view)
            .setDismissType(DismissType.anywhere)
            .setGuideListener {
                when (posisi) {
                    1 -> setGuide(
                        beranda,
                        2,
                        resources.getString(R.string.beranda),
                        "Berisikan tampilan awal aplikasi"
                    )
                    2 -> setGuide(
                        materi,
                        3,
                        resources.getString(R.string.materi),
                        "Berisikan materi-materi latihan dasar teknik bulutangkis"
                    )
                    3 -> setGuide(
                        program,
                        4,
                        resources.getString(R.string.program_latihan),
                        "Berisikan program latihan dasar teknik bulutangkis"
                    )
                    4 -> setGuide(
                        evaluasi,
                        5,
                        resources.getString(R.string.evaluasi),
                        "Berisikan halaman untuk mengevaluasi hasil latihan teknik dasar bulutangkis"
                    )
                    5 -> setGuide(
                        referensi,
                        6,
                        resources.getString(R.string.referensi),
                        "Berisikan halaman sumber materi latihan teknik dasar bulutangkis"
                    )
                    6 -> setGuide(
                        profil,
                        0,
                        resources.getString(R.string.profil),
                        "Berisikan halaman profil pengembang aplikasi"
                    )
                    else -> {
                        binding.drawerLayout.closeDrawers()
                        prefs.setGuideStatus(true)
                    }
                }
            }
            .build()
            .show()
    }
}
