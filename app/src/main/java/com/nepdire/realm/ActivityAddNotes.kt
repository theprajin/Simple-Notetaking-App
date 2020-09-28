package com.nepdire.realm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import java.lang.Exception

class ActivityAddNotes: AppCompatActivity() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveNotesBtn: Button
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
        realm = Realm.getDefaultInstance()

        //init views
        titleEditText = findViewById(R.id.title_edittext)
        descriptionEditText = findViewById(R.id.description_edittext)
        saveNotesBtn = findViewById(R.id.save_note_btn)

        saveNotesBtn.setOnClickListener {
            addNotesToDb()
        }
    }

    private fun addNotesToDb() {
        try {
            //Auto Increment ID
            realm.beginTransaction()
            val currentIDNumber: Number? = realm.where(Notes::class.java).max("id")
            val nextId: Int
            nextId = if (currentIDNumber == null) {
                1
            } else {
                currentIDNumber.toInt() + 1
            }

            val notes = Notes()
            notes.title = titleEditText.text.toString()
            notes.description = descriptionEditText.text.toString()
            notes.id = nextId

            //copy this transaction and commit
            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()

            Toast.makeText(this, "Succeed", Toast.LENGTH_LONG).show()

        } catch (e:Exception) {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }


}