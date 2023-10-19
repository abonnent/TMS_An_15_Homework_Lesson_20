package solutions.belov.tms_an_15_homework_lesson_20

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import solutions.belov.tms_an_15_homework_lesson_20.databinding.NoteItemImportantBinding

class ImportantNoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val binding = NoteItemImportantBinding.bind(item)

    fun bind(note: Note) = with(binding) {
        noteTitle.text = note.title
        noteText.text = note.text
        noteDate.text = note.date
    }
}
