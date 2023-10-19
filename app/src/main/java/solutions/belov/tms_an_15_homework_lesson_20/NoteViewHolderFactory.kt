package solutions.belov.tms_an_15_homework_lesson_20

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import solutions.belov.tms_an_15_homework_lesson_20.NoteAdapter.Companion.VIEW_TYPE_IMPORTANT

class NoteViewHolderFactory {
    fun createViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_IMPORTANT -> {
                val item = inflater.inflate(R.layout.note_item_important, parent, false)
                ImportantNoteViewHolder(item)
            }

            else -> {
                val item = inflater.inflate(R.layout.note_item, parent, false)
                NoteViewHolder(item)
            }
        }
    }
}
