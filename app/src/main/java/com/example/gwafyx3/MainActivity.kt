package com.example.gwafyx3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a = arrayOf(findViewById<ImageButton>(R.id.imageButton),findViewById<ImageButton>(R.id.imageButton2),findViewById<ImageButton>(R.id.imageButton3), findViewById<ImageButton>(R.id.imageButton4),findViewById<ImageButton>(R.id.imageButton5))
        var b = arrayListOf<ImageButton>()
        for (elements in a){
            elements.setOnClickListener(){
                if (b.size<=1){
                    b.add(elements)
                }
                else{
                    b = arrayListOf()
                    b.add(elements)
                }

                if(b.size<=1){
                    findViewById<TextView>(R.id.txtBtn1).text=elements.toString()
                }
                else{
                    findViewById<TextView>(R.id.txtBtn2).text = elements.toString()
                }
            }
        }

    }
}