package com.nepdire.realm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where

class MainActivity : AppCompatActivity() {
    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var floatBtn: FloatingActionButton
    private lateinit var notesList: ArrayList<Notes>
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()

        //init views
        notesRecyclerView = findViewById(R.id.notes_rv)
        floatBtn = findViewById(R.id.floating_btn)

        //set onclick listener for floatBtn
        floatBtn.setOnClickListener {
            startActivity(Intent(this, ActivityAddNotes::class.java))
            finish()
        }

        notesRecyclerView.layoutManager = LinearLayoutManager(this)

        getAllNotes()
    }

    private fun getAllNotes() {
        //notesList.clear()
        //notesList = ArrayList()

        var results: RealmResults<Notes> = realm.where<Notes>(Notes::class.java).findAll()
        notesRecyclerView.adapter = NotesAdapter(this, results)
        notesRecyclerView.adapter!!.notifyDataSetChanged()
    }
}
