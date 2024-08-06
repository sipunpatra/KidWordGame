package education.world.kidsstudy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import education.world.kidsstudy.R
import kotlin.random.Random

class WordAdapter(private val context: Context,
                  private var letterList: Array<String>,
                  private val listener: LetterClickListener
): RecyclerView.Adapter<WordAdapter.LetterViewHolder>() {

    inner class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val letterTextView: TextView = itemView.findViewById(R.id.letterTextView)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val cardView1: CardView = itemView.findViewById(R.id.card)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val letter = letterList[position]
                listener.onClick(letter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return LetterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.letterTextView.text = letterList[position]
        holder.cardView.setCardBackgroundColor(holder.itemView.resources.getColor(getRandomColor(), null))
        holder.cardView1.setCardBackgroundColor(holder.itemView.resources.getColor(getRandomColor(), null))

    }

    override fun getItemCount(): Int {
        return letterList.size

    }
    interface LetterClickListener {
        fun onClick(letter: String)
    }
    fun getRandomColor(): Int {
        val listColor = listOf(
            R.color.note1,
            R.color.note2,
            R.color.note3,
            R.color.note4,
            R.color.note5,
            R.color.note6,
//            R.color.skyblue,
//            R.color.blue,
//            R.color.grey500,
//            R.color.card_blue
        )
        val randomIndex = Random.nextInt(listColor.size)
        return listColor[randomIndex]
    }

}