package com.example.kotlinshop

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinshop.adapter.ScooterAdapter
import com.example.kotlinshop.model.Data
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mDataBase: DatabaseReference
    private lateinit var scooterList: ArrayList<Data>
    private lateinit var mAdapter: ScooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        scooterList = ArrayList()
        mAdapter = ScooterAdapter(this, scooterList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mAdapter

        getScooterData()

    }

    private fun getScooterData() {

        mDataBase = FirebaseDatabase.getInstance().getReference("Scooter")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    for (scooterSnapshot in snapshot.children) {
                        val scooter = scooterSnapshot.getValue(Data::class.java)
                        scooterList.add(scooter!!)
                    }
                    recyclerView.adapter = mAdapter
                }

            }


            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(this@MainActivity, error.message, Toast.LENGTH_SHORT).show()

            }

        })

    }


}