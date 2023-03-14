package com.example.tabapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tabapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    private val listFrag = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance(),
    )
    private val listText = listOf(
        "Плеер",
        "Мои треки",
        "Видео",
    )

    private val iconList = listOf(
        R.drawable.baseline_play_circle_24,
        R.drawable.baseline_library_music_24,
        R.drawable.baseline_ondemand_video_24,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val adapter = ViewPagerAdapter(this, listFrag)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.tabLayout, bind.vp2){
            tab, position ->
//            tab.text = listText[position]
            tab.icon = ContextCompat.getDrawable(this, iconList[position])
        }.attach()

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.tabLayout (вместо vp2), listFrag[0]).commit()
//        bind.tabLayout.addOnTabSelectedListener(
//            object : TabLayout.OnTabSelectedListener{
//                override fun onTabSelected(tab: TabLayout.Tab?) {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.vp2, listFrag[tab?.position!!]).commit()
//                    Toast.makeText(this@MainActivity, "Выбран раздец ${tab?.text} ID " +
//                            "${tab?.position}", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//                }
//
//                override fun onTabReselected(tab: TabLayout.Tab?) {
//                    Toast.makeText(this@MainActivity, "Повторно выбран раздец ${tab?.text} ID " +
//                            "${tab?.position}", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//        )
    }
}