package com.virgo.mvvmlist.view.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.virgo.mvvmlist.databinding.ActivityMainBinding
import com.virgo.mvvmlist.model.User
import com.virgo.mvvmlist.view.adapter.MainAdapter
import com.virgo.mvvmlist.view.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    val viewModel: MyViewModel by viewModels()
    lateinit var viewBind : ActivityMainBinding
    lateinit var adapter : MainAdapter
    lateinit var dataList : ArrayList<User>
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityMainBinding.inflate(layoutInflater)
        context = this
        setContentView(viewBind.root)
        setupUi()
        setObserver()
    }

    private fun setupUi(){
        dataList = ArrayList<User>()
        viewBind.recycleView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(dataList)
        viewBind.recycleView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        viewBind.recycleView.adapter = adapter
    }

    private fun setObserver(){
        viewModel.getUser()?.observe(this, Observer {
            dataList.clear()
            dataList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}