package com.example.lektion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    lateinit var answerTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val answer = intent.getBooleanExtra("correctAnswer", false)

        answerTextView = findViewById(R.id.textView)

        /*
        if (answer) {
            answerTextView.text = "Rätt svar"
        } else {
            answerTextView.text = "Fel svar"
        }*/

        answerTextView.text = if (answer) {
            "Rätt svar"
        } else {
            "Fel svar"
        }




        //  Log.d("!!!", "rätt svar? $answer")

    }
}