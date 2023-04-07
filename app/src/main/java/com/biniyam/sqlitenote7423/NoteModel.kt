package com.biniyam.sqlitenote7423

data class NoteModel (val id: Int, val title: String, val detail: String) {

    override fun toString(): String {
        return "NoteModel(id=$id, title='$title', noteDetail='$detail')"
    }
}