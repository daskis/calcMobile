package com.example.calc

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class NumberButtonListener : View.OnClickListener {
    override fun onClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        // Получаем ссылку на EditText, где отображается результат
        val resultEditText = view.rootView.findViewById<EditText>(R.id.Result)

        // Получаем текущий текст из EditText
        var currentResult = resultEditText.text.toString()

        // Добавляем текст с нажатой кнопки к текущему результату
        currentResult += buttonText

        // Устанавливаем новый результат в EditText
        resultEditText.setText(currentResult)
        // Выполняйте необходимые действия при нажатии на кнопку с цифрой
    }
}