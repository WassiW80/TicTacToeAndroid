package com.example.startup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    protected fun buClick(view: View){
        val buSelected=view as Button
        var cellId=0
        when(buSelected.id)
        {
            R.id.bu1-> cellId=1
            R.id.bu2-> cellId=2
            R.id.bu3-> cellId=3
            R.id.bu4-> cellId=4
            R.id.bu5-> cellId=5
            R.id.bu6-> cellId=6
            R.id.bu7-> cellId=7
            R.id.bu8-> cellId=8
            R.id.bu9-> cellId=9

        }
       // Toast.makeText(this,"Id: $cellId",Toast.LENGTH_LONG).show()
        playGame(cellId,buSelected)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1

    fun playGame(cellId:Int,buSelected:Button){

        if (activePlayer==1)
        {
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer=2
            //autoPlay()
        }
        else{
            buSelected.text="0"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellId)
            activePlayer=1
        }
        buSelected.isEnabled=false
        checkWinner()

    }
    fun checkWinner(){
            var winner=-1
        //row1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3))
        {
            winner=1
        }
        else if(player2.contains(1)&&player2.contains(2)&&player2.contains(3))
        {
            winner=2
        }
        //row2
        else if(player1.contains(4)&&player1.contains(5)&&player1.contains(6))
        {
            winner=1
        }
        else if(player2.contains(4)&&player2.contains(5)&&player2.contains(6))
        {
            winner=2
        } //row3
        else if(player1.contains(7)&&player1.contains(8)&&player1.contains(9))
        {
            winner=1
        }
        else if(player2.contains(7)&&player2.contains(8)&&player2.contains(9))
        {
            winner=2
        }
        //col1
        else if(player1.contains(1)&&player1.contains(4)&&player1.contains(7))
        {
            winner=1
        }
        else if(player2.contains(1)&&player2.contains(4)&&player2.contains(7))
        {
            winner=2
        } //col2
        else if(player1.contains(2)&&player1.contains(5)&&player1.contains(8))
        {
            winner=1
        }
        else if(player2.contains(2)&&player2.contains(5)&&player2.contains(8))
        {
            winner=2
        } //col3
        else if(player1.contains(3)&&player1.contains(6)&&player1.contains(9))
        {
            winner=1
        }
        else if(player2.contains(3)&&player2.contains(6)&&player2.contains(9))
        {
            winner=2
        }
        //diagonal 1
        else if(player1.contains(1)&&player1.contains(5)&&player1.contains(9))
        {
            winner=1
        }
        else if(player2.contains(1)&&player2.contains(5)&&player2.contains(9))
        {
            winner=2
        }

        //diagonal 2
        else if(player1.contains(3)&&player1.contains(5)&&player1.contains(7))
        {
            winner=1
        }
        else if(player2.contains(3)&&player2.contains(5)&&player2.contains(7))
        {
            winner=2
        }
        if (winner!=-1){
            if (winner==1) {
                Toast.makeText(this, "Player 1 win the Game", Toast.LENGTH_SHORT).show()

            }
            else
                Toast.makeText(this,"Player 2 win the Game",Toast.LENGTH_SHORT).show()
        }

    }
    fun autoPlay(){
        var emptyCells=ArrayList<Int>()
        for(cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        val random=Random()
        val randIndex=random.nextInt(emptyCells.size-0)+0
        val cellId=emptyCells.get(randIndex)
        var buSelect:Button?
        when(cellId){
            1->buSelect=bu1
            2->buSelect=bu2
            3->buSelect=bu3
            4->buSelect=bu4
            5->buSelect=bu5
            6->buSelect=bu6
            7->buSelect=bu7
            8->buSelect=bu8
            9->buSelect=bu9
            else->{
                buSelect=bu1
            }

        }
        playGame(cellId,buSelect)
    }
}
