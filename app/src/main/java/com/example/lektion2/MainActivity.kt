package com.example.lektion2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var questionText : TextView
    lateinit var answerTextView : EditText
    var firstNumber = 0
    var secondNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionText = findViewById(R.id.questionTextView)
        answerTextView = findViewById(R.id.answerEditView)

        val button = findViewById<Button>(R.id.answerButton)

        button.setOnClickListener {
            //checkAnswer()
            startAnswerActivity()
        }

        randomizeQuestion()
    }

    override fun onRestart() {
        super.onRestart()

        answerTextView.setText("")
        randomizeQuestion()
    }


    fun startAnswerActivity() {
        val rightAnswer = checkAnswer()
        val intent = Intent(this , AnswerActivity::class.java )

        intent.putExtra( "correctAnswer",rightAnswer)

        startActivity(intent)
    }

    fun checkAnswer() : Boolean{
        val answerText = answerTextView.text.toString()
        val answerInt = answerText.toIntOrNull()

        return firstNumber + secondNumber == answerInt

    }

    fun randomizeQuestion() {
        firstNumber = (1..20).random()
        secondNumber = (1..20).random()

        val question = "$firstNumber + $secondNumber"
        Log.d("!!!", question)

        questionText.text = question
    }



}