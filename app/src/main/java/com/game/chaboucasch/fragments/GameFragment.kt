package com.game.chaboucasch.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.game.chaboucasch.R


class GameFragment : Fragment() {
    var score = 0
    private var card : MutableList<Int> = IntRange(1, 52).step(1).toList().toMutableList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        view.findViewById<Button>(R.id.Tete_button).setOnClickListener {
            updateScore(view, 1)
        }
        view.findViewById<Button>(R.id.Pastete_Button).setOnClickListener {
            updateScore(view, 1)
        }
        view.findViewById<Button>(R.id.Rouge_Button).setOnClickListener {
            updateScore(view, 2)
        }
        view.findViewById<Button>(R.id.Noir_Button).setOnClickListener {
            updateScore(view, 2)
        }
        return view
    }
    private fun updateScore(view: View, nb: Int) {
        val textview = view.findViewById<TextView>(R.id.score)
        val cardView = view.findViewById<ImageView>(R.id.card)
        getCard(cardView)
        if (nb > 0) {
            score += nb
            textview.text = "Score : $score"
        }
        else {
            score = 0
        }
    }
    private fun getCard(cardView: ImageView) {
        if (card.isEmpty())
            card = IntRange(1, 52).step(1).toList().toMutableList()
        val index = (card.indices).random()
        val cardNb = card.removeAt(index)
        val dispCard = "card_$cardNb"
        cardView.setImageResource(resources.getIdentifier(dispCard, "drawable", "com.game.chaboucasch"))
    }
}