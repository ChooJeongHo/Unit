package com.example.unit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    /** **/
    // 1. xml 에서 리싸이클러뷰 만들기
    // 2. item 을 위한 xml 레이아웃 만들기
    // 3. item 을 위한 데이터 클래스 만들기
    // 4. [3번] 을 위한 ArrayList 만들기
    // 5. 커스텀 아답터를 만들기
    // 6. 아답터와 데이터를 연결
    // 7. 리싸이클러 뷰와 아답터를 연결

    var arr: ArrayList<MyData> = ArrayList()
    lateinit var adapter: MainRvAdapter
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        adapter = MainRvAdapter(this, arr)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
    }

    class MainRvAdapter(val context: Context, val arr: ArrayList<MyData>) :
        RecyclerView.Adapter<MainRvAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
            return Holder(view)
        }

        override fun getItemCount(): Int {
            return arr.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.tv1.setText(arr.get(position).name)
            holder.tv2.setText(arr.get(position).phone)

            holder.tv1.setOnClickListener {
                arr.get(position).name = "바보"
                notifyDataSetChanged()
            }

            holder.itemView.setOnClickListener{
                arr.get(position).phone = "바보"
                notifyDataSetChanged()
            }
        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var tv1: TextView = itemView!!.findViewById(R.id.tv1)
            val tv2: TextView = itemView!!.findViewById(R.id.tv2)
        }
    }
}