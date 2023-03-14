package com.example.tabapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.MediaController
import android.widget.Toast
import com.example.tabapp.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    lateinit var bind: Fragment2Binding
    private var playMusic = false
    private var pause = true
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private val listNameMusic = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listMusic.add(R.raw.zelda_botw_main)
        listMusic.add(R.raw.kakariko_village)
        listMusic.add(R.raw.the_grand_divine_beast)

        listNameMusic.add("The Legend Of Zelda Breath of the Wild: Main Theme")
        listNameMusic.add("The Legend Of Zelda Breath of the Wild: Kakaroko Village Theme")
        listNameMusic.add("The Legend Of Zelda Breath of the Wild: The Grand Divine Beast")
        // Inflate the layout for this fragment
        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(context, listMusic[0])
        bind = Fragment2Binding.inflate(inflater, container, false)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,
            listNameMusic)
        bind.listVF2.adapter = adapter
        bind.listVF2.setOnItemClickListener { parent, view, position, id ->
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context, listMusic[position])
            mediaPlayer.start()
            playMusic = true
            listNameMusic[position] = listNameMusic[position] + "|>"
            Toast.makeText(requireContext(), "Играет ${listNameMusic[position]}",
                Toast.LENGTH_LONG).show()
        }
        bind.buttonF2.setOnClickListener{
            if (!playMusic){
                mediaPlayer.start()
                playMusic = true
            } else{
                mediaPlayer.pause()
                playMusic = false
            }
        }


        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}