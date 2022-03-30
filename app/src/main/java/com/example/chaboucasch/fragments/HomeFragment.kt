package com.example.chaboucasch.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.chaboucasch.MainActivity
import com.example.chaboucasch.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.rules_button).setOnClickListener(){
            (context as MainActivity).replaceFragment(RulesFragment())
        }
        view.findViewById<Button>(R.id.settings_button).setOnClickListener(){
            (context as MainActivity).replaceFragment(SettingsFragment())
        }
        view.findViewById<Button>(R.id.play_button).setOnClickListener(){
            (context as MainActivity).replaceFragment(GameFragment())
        }
    }
}