package com.biniyam.sqlitenote7423

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.biniyam.sqlitenote7423.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var noteDao: NoteDao
private lateinit var notesList: List<NoteModel>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteDao = NoteDao(this)

        binding.btnAdd.setOnClickListener {
         val  intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        binding.lvNotes.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent, view, position, id ->
            val selectedNote = parent.getItemAtPosition(position) as NoteModel
            val result = noteDao.deleteNote(selectedNote)
            showNotes()
            result
        }

    }

    //todo: create a retun button to return to MainActivity an arrow
    // or in-built into save button, save and list so to speak

    fun showNotes(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, noteDao.getAllNotes())
    }
}