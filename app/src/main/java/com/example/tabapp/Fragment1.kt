package com.example.tabapp

import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.os.SharedMemory
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Fragment1 : Fragment() {

    private var playMusic = false
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private var pref: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //считывание данных из бд

        listMusic.add(R.raw.zelda_botw_main)
        listMusic.add(R.raw.kakariko_village)
        listMusic.add(R.raw.the_grand_divine_beast)
        val view = inflater.inflate(R.layout.fragment1, container, false)
        val butMusic = view.findViewById<Button>(R.id.button)
        val tvTrek = view.findViewById<TextView>(R.id.tVTrek)
        tvTrek.text = "Играет трек № ${trek.toString()}"
        var mediaPlayer = MediaPlayer.create(context, listMusic[trek])
        butMusic.setOnClickListener{
                if(!playMusic){
                    mediaPlayer.start()
                    playMusic = true
                    trek += 1
                    if (trek > listMusic.size - 1) trek = 0
                }
                else {
                    mediaPlayer.stop()
                    playMusic = false
                    mediaPlayer = MediaPlayer.create(context, listMusic[trek])
                }
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}