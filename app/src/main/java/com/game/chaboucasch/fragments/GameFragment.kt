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
    var lastCard = 0
    private var card : MutableList<Int> = IntRange(1, 52).step(1).toList().toMutableList()
    private val heads: IntArray = intArrayOf(11, 12, 13, 24, 25, 26, 37, 38, 39, 50, 51, 52)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        view.findViewById<Button>(R.id.Tete_button).setOnClickListener {
            updateScore(view, 1, ::checkFace, true)
        }
        view.findViewById<Button>(R.id.Pastete_Button).setOnClickListener {
            updateScore(view, 1, ::checkFace, false)
        }
        view.findViewById<Button>(R.id.Plus_Button).setOnClickListener {
            updateScore(view, 2, ::checkPlus, true)
        }
        view.findViewById<Button>(R.id.Moins_Button).setOnClickListener {
            updateScore(view, 2, ::checkPlus, false)
        }
        view.findViewById<Button>(R.id.Rouge_Button).setOnClickListener {
            updateScore(view, 3, ::checkColor, true)
        }
        view.findViewById<Button>(R.id.Noir_Button).setOnClickListener {
            updateScore(view, 3, ::checkColor, false)
        }
        return view
    }
    private fun updateScore(view: View, nb: Int, check: (nbCard: Int) -> Boolean, res: Boolean) {
        val textview = view.findViewById<TextView>(R.id.score)
        val cardView = view.findViewById<ImageView>(R.id.card)
        val cardNb = getCard(cardView)
        if (check(cardNb) == res) {
            score += nb
            textview.text = "Score : $score"
        }
        else {
            score = 0
            textview.text = "Score: $score"
        }
        lastCard = cardNb
    }
    private fun getCard(cardView: ImageView): Int {
        if (card.isEmpty())
            card = IntRange(1, 52).step(1).toList().toMutableList()
        val index = (card.indices).random()
        val cardNb = card.removeAt(index)
        cardView.setImageResource(resources.getIdentifier("card_$cardNb", "drawable", "com.game.chaboucasch"))
        return cardNb
    }
    private fun checkFace(nbCard: Int) : Boolean {
        return nbCard in heads
    }
    private fun checkColor(nbCard: Int): Boolean {
        return nbCard <= 26
    }
    private fun checkPlus(nbCard: Int): Boolean {
        var tmpNbCard: Int = nbCard
        var tmpLastCard: Int = lastCard
        while (tmpNbCard > 13)
            tmpNbCard -= 13
        while (tmpLastCard > 13)
            tmpLastCard -= 13
        println(tmpNbCard)
        println(tmpLastCard)
        return tmpNbCard >= tmpLastCard
    }

}