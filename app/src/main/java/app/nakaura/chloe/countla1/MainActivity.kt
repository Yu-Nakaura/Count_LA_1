package app.nakaura.chloe.countla1

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.nakaura.chloe.countla1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mSoundPool: SoundPool
    private var Sound = 0
    var number: Int = 0

    //define sharedPreferences
    private lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //お題５
        //Initialize sharedPreferences
        //get sharedPreferences
        sharedPref = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        //get number as saveNumber with the key "COUNT"
        val savedNumber: String? = sharedPref.getString("COUNT", "")
        binding.textView.text = savedNumber


        //お題１
        binding.plusButton.setOnClickListener {
            number = number + 1
            binding.numberTextView.text = number.toString()
            changeColor()
            changeSound()
        }

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(1)
            .build()

        Sound = mSoundPool.load(this, R.raw.system39new, 0)
    }

    //お題５
    override fun onStop() {
        super.onStop()
        sharedPref = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val countNumber: String = number.toString()
        editor.putString("COUNT", countNumber)
        editor.apply()
    }

    //お題２
    fun changeColor() {
        when (number % 2) {
            0 -> binding.numberTextView.setTextColor(Color.BLUE)
            1 -> binding.numberTextView.setTextColor(Color.RED)
        }
    }

    //お題４
    fun changeSound() {
        if (number % 2 == 1) {
            mSoundPool.play(Sound, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }
}

