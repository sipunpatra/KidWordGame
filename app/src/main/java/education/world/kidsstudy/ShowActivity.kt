package education.world.kidsstudy

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import education.world.kidsstudy.databinding.ActivityShowBinding

class ShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra("Letter")?.toLowerCase()

        val letterTextView: TextView = findViewById(R.id.tv_letter)
        name?.let {
            letterTextView.text = it
        }

        var id =resources.getIdentifier(name,"drawable",packageName)
        binding.imageView.setImageResource(id)

        var music = resources.getIdentifier(name,"raw",packageName)
        var mp =MediaPlayer.create(applicationContext,music)
        mp.start()


    }
}