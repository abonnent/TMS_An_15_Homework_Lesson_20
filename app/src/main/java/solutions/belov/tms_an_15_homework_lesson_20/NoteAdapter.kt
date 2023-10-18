package solutions.belov.tms_an_15_homework_lesson_20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import solutions.belov.tms_an_15_homework_lesson_20.databinding.NoteItemBinding
import solutions.belov.tms_an_15_homework_lesson_20.databinding.NoteItemImportantBinding

class NoteAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemClickListener: OnNoteItemClickListener? = null

    fun setOnItemClickListener(listener: OnNoteItemClickListener) {
        itemClickListener = listener
    }

    private val VIEW_TYPE_NORMAL = 1
    private val VIEW_TYPE_IMPORTANT = 2

    inner class NoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = NoteItemBinding.bind(item)
        fun bind(note: Note) = with(binding) {
            noteTitle.text = note.title
            noteText.text = note.text
            noteDate.text = note.date
        }
    }

    inner class ImportantNoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = NoteItemImportantBinding.bind(item)
        fun bind(note: Note) = with(binding) {
            noteTitle.text = note.title
            noteText.text = note.text
            noteDate.text = note.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_IMPORTANT -> {
                val item = LayoutInflater.from(parent.context)
                    .inflate(R.layout.note_item_important, parent, false)
                ImportantNoteViewHolder(item)
            }

            else -> {
                val item =
                    LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
                NoteViewHolder(item)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val note = notes[position]
        when (holder) {
            is NoteViewHolder -> {
                holder.bind(note)
            }

            is ImportantNoteViewHolder -> {
                holder.bind(note)
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.important
                    )
                )
            }
        }

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(note)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (notes[position].important) VIEW_TYPE_IMPORTANT else VIEW_TYPE_NORMAL
    }
}