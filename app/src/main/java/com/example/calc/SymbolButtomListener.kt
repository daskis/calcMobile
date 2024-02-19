package com.example.calc

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SymbolButtomListener() : View.OnClickListener {
    override fun onClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        val resultEditText = view.rootView.findViewById<EditText>(R.id.Result)
        val previewView = view.rootView.findViewById<TextView>(R.id.Preview)



        if (resultEditText.text.isNotEmpty()) {
            val symbolText = view.rootView.findViewById<TextView>(R.id.Symbol)
            previewView.setText(resultEditText.text)
            resultEditText.setText(null)
            symbolText.setText(buttonText)
        }
    }
}
