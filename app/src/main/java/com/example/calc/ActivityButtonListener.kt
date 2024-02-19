package com.example.calc

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivityButtonListener(private val context: Context) : View.OnClickListener {
    override fun onClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()


        val rootView = view.rootView
        val resultEditText = view.rootView.findViewById<EditText>(R.id.Result)
        val previewView = view.rootView.findViewById<TextView>(R.id.Preview)
        val symbolView = view.rootView.findViewById<TextView>(R.id.Symbol)


        if (buttonText == context.getString(R.string._del)) {
            val text = resultEditText.text.toString()

            if (text.isNotEmpty()) {
                val newText = text.dropLast(1)
                resultEditText.setText(newText)
            }
        }
        if (buttonText == context.getString(R.string._clear)) {
            resultEditText.setText(null)
            previewView.setText(null)
            symbolView.setText(null)

        }
        if (buttonText == context.getString(R.string._equals)) {
            val previewText = previewView.text.toString()
            val resultText = resultEditText.text.toString()
            val symbolText = symbolView.text.toString()


            if (previewText.isNotEmpty() && resultText.isNotEmpty() && symbolText.isNotEmpty()) {
                // Заменяем запятые на точки, если они есть в строках с числами
                val preview = previewText.replace(',', '.').toFloat()
                val result = resultText.replace(',', '.').toFloat()

                var answer: Float = 0f

                if (symbolText == context.getString(R.string._add)) {
                    answer = preview + result
                } else if (symbolText == context.getString(R.string._subtract)) {
                    answer = preview - result
                } else if (symbolText == context.getString(R.string._multiply)) {
                    answer = preview * result
                } else if (symbolText == context.getString(R.string._divide)) {
                    if (result != 0f) {
                        answer = preview / result
                    }
                } else if (symbolText == context.getString(R.string._percent)) {
                    if (result != 0f) {
                        answer = preview % result
                    }
                }

                resultEditText.setText(answer.toString().replace(".", ","))
                symbolView.text = null
                previewView.text = null
            }

        }

    }
}