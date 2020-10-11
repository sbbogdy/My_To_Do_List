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


            val exampleList = generateList(500)

            recycler_view.adapter = ExampleAdapter(exampleList)
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.setHasFixedSize(false)
            }
        private  fun generateList(size : Int): List<ExampleItem>
        {
            var data =db.readData()
            val list = ArrayList<ExampleItem>()

            for ( i in 0 until (data.size) ){
                val lstText : String = data.get(i).task
                val item = ExampleItem (R.drawable.ic_android, lstText, null.toString())
                list +=item
            }
            return list
        }

        fun addItem(view: View): Unit {
            val intent = Intent(context, AddActivity::class.java)
            startActivity(intent)
        }


    }

