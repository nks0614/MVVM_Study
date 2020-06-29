package study.kotlin.designpattern.rcview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import study.kotlin.designpattern.R
import study.kotlin.designpattern.model.Student

class RcViewAdapter : RecyclerView.Adapter<RcViewAdapter.Holder>() {

    private lateinit var list : ArrayList<Student>

    fun setList(itemList : ArrayList<Student>){
        if(::list.isInitialized) return
        else this.list = itemList
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val gender = itemView.findViewById<TextView>(R.id.gender)
        val age = itemView.findViewById<TextView>(R.id.age)

        fun bind (student : Student) {
            name.text = student.name
            gender.text = student.gender
            age.text = student.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return if(::list.isInitialized) list.size else 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }
}