package ru.mvlikhachev.chronometer

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.mvlikhachev.chronometer.R.layout.activity_main
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var chronometer: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        chronometer = findViewById(R.id.chronometer)
        chronometer.setOnChronometerTickListener {
            val elapsedMillis: Long = (SystemClock.elapsedRealtime() - chronometer.base)
            if (elapsedMillis > 5000 && elapsedMillis < 6000) {
                val strElapsedMillis = "Прошло больше 5 секунд"
                Toast.makeText(
                        this,
                        strElapsedMillis, Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun startButton(view: View) {
        chronometer.base = SystemClock.elapsedRealtime()
        chronometer.start()
    }

    fun stopButton(view: View) {
        chronometer.stop()
    }

    fun resetButton(view: View) {
        chronometer.base = SystemClock.elapsedRealtime()
    }
}