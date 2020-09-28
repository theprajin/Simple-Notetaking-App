package com.nepdire.realm

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleText = itemView.findViewById<TextView>(R.id.title_text) as TextView
    val descText = itemView.findViewById<TextView>(R.id.desc_text) as TextView
    val notesID = itemView.findViewById<TextView>(R.id.note_id) as TextView
}