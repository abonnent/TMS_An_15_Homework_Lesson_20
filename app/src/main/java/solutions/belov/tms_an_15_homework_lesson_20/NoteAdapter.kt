package solutions.belov.tms_an_15_homework_lesson_20

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onItemClick: ((Note) -> Unit)? = null
    private val viewHolderFactory = NoteViewHolderFactory()

    fun setOnItemClickListener(listener: (Note) -> Unit) {
        onItemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolderFactory.createViewHolder(parent, viewType)
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
            onItemClick?.invoke(note)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (notes[position].important) VIEW_TYPE_IMPORTANT else VIEW_TYPE_NORMAL
    }

    companion object {
        const val VIEW_TYPE_NORMAL = 1
        const val VIEW_TYPE_IMPORTANT = 2
    }
}
