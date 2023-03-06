package com.example.testapp1
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.example2.Constants


class MainActivity : AppCompatActivity() {
    var stateCounter:Byte = 0
    val pi:Float = 3.14f
    //val helloWorldTextView: TextView = findViewById<TextView>(R.id.textView1)
    //val helloWorldTextView: TextView? = null
    lateinit var helloWorldTextView: TextView
    lateinit var activityAnswerTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityAnswerTextView = findViewById<TextView>(R.id.textView3)
        Log.e("testMessage", (++stateCounter).toString() + " Create!!!")
        //pi = 10.5f
        var plainText1Text = ""
        val btn1:Button = findViewById<Button>(R.id.button1)
        btn1.setOnClickListener {
            val plainText1:EditText = findViewById<EditText>(R.id.editText1)
            val textView2:TextView = findViewById<TextView>(R.id.textView2)
            //textView2.text = "input = " + plainText1.text.toString()
            var plainText1Number = 0
            try {
                plainText1Text = plainText1.text.toString()
                plainText1Number = plainText1Text.toInt()
                when(plainText1Number) {
                    in 0..1000 -> {
                        //textView2.text = "Mala liczba"
                        textView2.text = Constants.SMALL_NUM_MESSAGE
                    }
                    in 0..1000000 -> {
                        //textView2.text = "Duza liczba"
                        textView2.text = Constants.BIG_NUM_MESSAGE
                    }
                    else -> {
                        textView2.text = "????????"
                    }
                }
            } catch (e:Exception) {
                textView2.text = plainText1Text + " nie jest liczba. Podaj liczbe"
            }
        }
        val btn3:Button = findViewById<Button>(R.id.button3)
        btn3.setOnClickListener {
            var intent1: Intent = Intent(this, Activity2::class.java)
            intent1.putExtra("slowo", "Hello FROM MAIN ACTIVITY")
            intent1.putExtra("inputValue", plainText1Text)
            startActivityForResult(intent1,101)
        }
        val btn4:Button = findViewById<Button>(R.id.button4)
        btn4.setOnClickListener {
            var intent1: Intent = Intent(this, Activity3::class.java)
            //startActivity(intent1)
            startActivityForResult(intent1, 102)
        }

    }

    fun onClickTest(view: View) {
        val textView2:TextView = findViewById<TextView>(R.id.textView2)
        textView2.text = "btn2 EVENT!!!!!!!"
    }
    override fun onStart() {
        super.onStart()
        Log.e("testMessage", (++stateCounter).toString() + " Start!!!")
    }
    override fun onResume() {
        super.onResume()
        Log.e("testMessage", (++stateCounter).toString() + " Resume!!!")
    }
    override fun onRestart() {
        super.onRestart()
        Log.e("testMessage", (++stateCounter).toString() + " Restart!!!")
    }
    override fun onPause() {
        super.onPause()
        Log.e("testMessage", (++stateCounter).toString() + " Pause!!!")
    }
    override fun onStop() {
        super.onStop()
        Log.e("testMessage", (++stateCounter).toString() + " Stop!!!")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("testMessage", (++stateCounter).toString() + " Destroy!!!")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var sender:String = "????"
        if(requestCode == 101){
            sender = "2"
        }else if(requestCode == 102){
            sender = "3"
        }
        var inputTextFrom =data?.getStringExtra("answer");
        activityAnswerTextView.text = "DOSTALEM ODPOWIEDZ!!!!!!!!!!!!!!"+inputTextFrom + " od activity"+sender

    }
}
