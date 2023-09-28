package com.example.gwafyx3

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Range
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a = arrayOf(findViewById<ImageButton>(R.id.img1),findViewById<ImageButton>(R.id.img2),findViewById<ImageButton>(R.id.img3), findViewById<ImageButton>(R.id.img4),findViewById<ImageButton>(R.id.img5))
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
                    findViewById<TextView>(R.id.txtBtn1).text= resources.getResourceEntryName(elements.id).removePrefix("img")
                    findViewById<TextView>(R.id.txtBtn2).text = ""
                }
                else{
                    findViewById<TextView>(R.id.txtBtn2).text = resources.getResourceEntryName(elements.id).removePrefix("img")

                    var alert =  AlertDialog.Builder(this)
                    alert.setTitle("Podaj wartosc")
                    alert.setMessage(resources.getResourceEntryName(b[0].id).removePrefix("img")+" : "+ resources.getResourceEntryName(b[1].id).removePrefix("img"))
                    var inputText = EditText(this)
                    alert.setView(inputText)
                    alert.setPositiveButton("Confirm", DialogInterface.OnClickListener { dialogInterface, i ->
                        findViewById<TextView>(R.id.textView).text = inputText.text
                        dialogInterface.cancel()
                    })
                    alert.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })
                    alert.show()

                }
            }
        }

    }
}