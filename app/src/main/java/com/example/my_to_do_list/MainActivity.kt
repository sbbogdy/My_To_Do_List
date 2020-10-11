package com.example.my_to_do_list

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.view.View
    import android.widget.TextView
    import androidx.recyclerview.widget.LinearLayoutManager
    import kotlinx.android.synthetic.main.activity_main.*
    class MainActivity : AppCompatActivity() {
        val context = this
        var db = DatabaseHandler(context)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            var data =db.readData()
            val lstText : TextView = findViewById(R.id.lstTask) as TextView
            for (i in 0 .. ( data.size-1)){
                lstText.append(data.get(i).task)
            }
        }

        fun addItem(view: View): Unit {
            val intent = Intent(context, AddActivity::class.java)
            startActivity(intent)
        }

    }

