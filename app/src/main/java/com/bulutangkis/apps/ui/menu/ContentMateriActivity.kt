package com.bulutangkis.apps.ui.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bulutangkis.apps.databinding.ActivityContentMateriBinding
import com.bulutangkis.apps.utils.setWeb


class ContentMateriActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "TITLE"
        const val EXTRA_CONTENT = "CONTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityContentMateriBinding =
            ActivityContentMateriBinding.inflate(layoutInflater)
        val title: String? = intent?.getStringExtra(EXTRA_TITLE)
        val content: String? = intent?.getStringExtra(EXTRA_CONTENT)

        setSupportActionBar(binding.include.toolbar)

        supportActionBar?.title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.include.titleBar.text = title

        setWeb(binding.webView, "file:///android_asset/$content")

        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
