package com.biniyam.sqlitenote7423

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.biniyam.sqlitenote7423.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var noteDao: NoteDao
    private lateinit var noteList: List<NoteModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etTitle.text.toString()
        binding.etNoteDetail.text.toString()

        binding.btnSave.setOnClickListener {
            val note = NoteModel (
                -1, binding.etTitle.text.toString(),
                binding.etNoteDetail.text.toString()
                    )
            Toast.makeText(this, note.toString(),Toast.LENGTH_LONG).show()
        }
    }
}