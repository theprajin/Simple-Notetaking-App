package com.nepdire.realm

import android.content.Context
import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class NotesAdapter(private val context: Context?, private val notesList: RealmResults<Notes>): RecyclerView.Adapter<NotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_notes,parent,false)

        return NotesViewHolder(view)

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.titleText.text = notesList[position]!!.title
        holder.descText.text = notesList[position]!!.description
        holder.notesID.text = notesList[position]!!.id.toString()


    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}