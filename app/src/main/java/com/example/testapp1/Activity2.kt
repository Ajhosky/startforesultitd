package com.example.testapp1
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        findViewById<Button>(R.id.button1).setOnClickListener {
            var inputText = findViewById<EditText>(R.id.editText1).text.toString()
            intent.putExtra("answer", inputText)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}