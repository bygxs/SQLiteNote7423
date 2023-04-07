package com.biniyam.sqlitenote7423

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
         val  intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }


    }
}