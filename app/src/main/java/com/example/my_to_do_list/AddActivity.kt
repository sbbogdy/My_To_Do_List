package com.example.my_to_do_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val context = this

        btnAdd.setOnClickListener(){
            if(etvTask.text.toString().length > 0){
                var task = Task(etvTask.text.toString(),etvDesc.text.toString())
                var db = DatabaseHandler(context)
                db.insertData(task)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
                else {
                Toast.makeText(context,"Please enter a task",Toast.LENGTH_SHORT).show()
            }
        }
    }

}