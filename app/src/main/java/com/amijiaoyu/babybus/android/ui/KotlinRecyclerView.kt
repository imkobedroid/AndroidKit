package com.amijiaoyu.babybus.android.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.amijiaoyu.babybus.android.R

/**
 *  Author:
 *  Date:2017/10/19 11:48
 *  Email:imkobedroid@gmail.com
 */
class KotlinRecyclerView : AppCompatActivity() {
  private lateinit var recyclerView: RecyclerView
  private var data = listOf("科比", "詹姆斯", "科比", "詹姆斯", "科比", "詹姆斯", "科比", "詹姆斯", "科比", "詹姆斯", "科比",
      "詹姆斯", "科比", "詹姆斯", "科比", "詹姆斯", "科比", "詹姆斯", "科比", "詹姆斯")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.kotlin_recyclerview)
    recyclerView = findViewById(R.id.recycler)
    recyclerView.layoutManager=LinearLayoutManager(this)
    recyclerView.adapter=Adapter(R.layout.item_adapter,data)
  }
}

