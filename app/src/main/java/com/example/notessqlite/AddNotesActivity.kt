package com.example.notessqlite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notessqlite.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.text.toString()
            val note=Note(id = 0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(
                this,
                "note Saved",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}