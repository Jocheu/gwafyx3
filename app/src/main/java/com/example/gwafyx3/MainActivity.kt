package com.example.gwafyx3

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        var l1: Int
        var l2: Int
        var tempTextId: String
        var tempId: Int
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
                        tablica[resources.getResourceEntryName(b[0].id).removePrefix("img").toInt()][resources.getResourceEntryName(b[1].id).removePrefix("img").toInt()] = inputText.text.toString().toInt()
                        tempTextId = "t"+resources.getResourceEntryName(b[0].id).removePrefix("img")+"_"+resources.getResourceEntryName(b[1].id).removePrefix("img")
                        tempId = resources.getIdentifier(tempTextId, "id", packageName)
                        findViewById<TextView>(tempId).text = inputText.text.toString()
                        dialogInterface.cancel()
                    })
                    alert.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })
                    alert.show()


                }
            }
        }
        findViewById<Button>(R.id.btnAction).setOnClickListener {
            if(findViewById<EditText>(R.id.num1).text.toString() !="" && findViewById<EditText>(R.id.num2).text.toString() != ""){
                l1 = findViewById<EditText>(R.id.num1).text.toString().toInt()
                l2 = findViewById<EditText>(R.id.num2).text.toString().toInt()

                findViewById<TextView>(R.id.textView).text = FW(tablica,l1,l2).toString()
            }

        }


    }
    fun FW(array: Array<Array<Int>>, from:Int, to:Int): Int{
        for(k in 0 until  array.size){
            for(u in 0 until array.size){
                for(v in 0 until array.size){
                    array[u][v] = minOf(array[u][v], array[u][k] + array[k][v])
                }
            }
        }
        return array[from][to]
    }
}