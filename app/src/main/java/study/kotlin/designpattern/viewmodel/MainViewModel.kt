package study.kotlin.designpattern.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import study.kotlin.designpattern.model.Student
import study.kotlin.designpattern.rcview.RcViewAdapter

class MainViewModel : ViewModel(){
    val adapter = RcViewAdapter()
    val list : ArrayList<Student> = ArrayList()

    init {
        adapter.setList(list)
        addData()
    }

    private fun addData(){
        list.add(Student("박진", 18, "남성"))
        list.add(Student("남규석", 18, "남성"))
        list.add(Student("이상윤", 18, "남성"))
        list.add(Student("최우석", 18, "남성"))
        list.add(Student("박영훈", 18, "남성"))
        adapter.notifyDataSetChanged()
    }

}