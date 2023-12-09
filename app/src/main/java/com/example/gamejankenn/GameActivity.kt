package com.example.gamejankenn

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity()  {
    private lateinit var computerImageView: ImageView
    private lateinit var batuImageButton: ImageButton
    private lateinit var guntingImageButton: ImageButton
    private lateinit var kertasImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        batuImageButton = findViewById(R.id.batuImageButton)
        guntingImageButton = findViewById(R.id.guntingImageButton)
        kertasImageButton = findViewById(R.id.kertasImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }
    private fun initListeners(){
        batuImageButton.setOnClickListener { starGame("Batu") }
        guntingImageButton.setOnClickListener { starGame("gunting") }
        kertasImageButton.setOnClickListener { starGame("kertas") }
    }

    private fun starGame(option: String) {
        val computerOption = game.pickRandomOption()
        computerImageView.setImageResource(game.pickDrawable(computerOption))

        when {
            game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.question)
            game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()
    }
}
