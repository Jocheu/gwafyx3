package com.example.gwafyx3

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var INF = 9999999
        var a = arrayOf(findViewById<ImageButton>(R.id.img0),findViewById<ImageButton>(R.id.img1),findViewById<ImageButton>(R.id.img2), findViewById<ImageButton>(R.id.img3),findViewById<ImageButton>(R.id.img4))
        var b = arrayListOf<ImageButton>()
        var txt = findViewById<TextView>(R.id.textView)
        var tablica = Array(5) {Array (5){INF} }
        for(i in 0..tablica.size -1){
            tablica[i][i] = 0
        }
        for (elements in a){
            elements.setOnClickListener(){

                if (b.size<=1){
                    if(b.size==0) {
                        b.add(elements)
                    }else if(b[0]!=elements){
                        b.add(elements)
                    }
                    else{

                    }


                }
                else{
                    b = arrayListOf()
                    b.add(elements)
                }
                txt.text = Arrays.deepToString(arrayOf(b))
                /*dodaj system blokowania dwa razy tego samego przycisku */
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
                        tablica[resources.getResourceEntryName(b[0].id).removePrefix("img").toInt()][resources.getResourceEntryName(b[1].id).removePrefix("img").toInt()] = inputText.text.toString().toInt()
                        txt.text = Arrays.deepToString(tablica)
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