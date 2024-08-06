package education.world.kidsstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import education.world.kidsstudy.adapter.WordAdapter
import education.world.kidsstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),WordAdapter.LetterClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // Generate the alphabet list

        var alpha =Array(26){""}
        var j =65
        for(i in 0..25){
            alpha[i] = Char(j.toChar().code).toString()
            j++
        }

        // Set the adapter
        recyclerView.adapter = WordAdapter(this,alpha,this)

    }

    override fun onClick(letter: String) {
        val intent = Intent(this@MainActivity, ShowActivity::class.java)
        intent.putExtra("Letter",letter)
        startActivity(intent)
    }
}