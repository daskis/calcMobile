package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val numberButtonListener = NumberButtonListener()
        val symbolButtonListener = SymbolButtomListener()
        val activityButtonListener = ActivityButtonListener(this)


        val numberButtons = arrayOf(
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9),
            findViewById<Button>(R.id.button00),
            findViewById<Button>(R.id.buttonComma),
        )

        val symbolButtons = arrayOf(
            findViewById<Button>(R.id.buttonPercent),
            findViewById<Button>(R.id.buttonSeparate),
            findViewById<Button>(R.id.buttonMultipy),
            findViewById<Button>(R.id.minus),
            findViewById<Button>(R.id.buttonPlus),
        )


        val activityButtons = arrayOf(
            findViewById<Button>(R.id.buttonDel),
            findViewById<Button>(R.id.buttonAnswer),
            findViewById<Button>(R.id.buttonClear),
        )


        for (button in activityButtons) {
            button.setOnClickListener(activityButtonListener)
        }


        for (button in symbolButtons) {
            button.setOnClickListener(symbolButtonListener)
        }

        // Назначаем один и тот же обработчик событий для всех кнопок цифр
        for (button in numberButtons) {
            button.setOnClickListener(numberButtonListener)
        }

    }
}