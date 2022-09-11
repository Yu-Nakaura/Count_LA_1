package app.nakaura.chloe.countla1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.countla1.databinding.ActivityMainBinding
import app.nakaura.chloe.countla1.databinding.ActivityTitleBinding

//reviewed by toppo 🧸: TitleActivityが初期起動のActivityに設定できていていいね！
class TitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.nextButton.setOnClickListener {
            //🧸: Intentの命名がわかりやすい！
            val toTitleActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(toTitleActivityIntent)
        }
    }
}