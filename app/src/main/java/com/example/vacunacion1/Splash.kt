package com.example.vacunacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.vacunacion1.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fullPantalla()
        CuentaRegrsiva()

    }

    private fun CuentaRegrsiva() {
        object : CountDownTimer(3000, 1000) {
            var time = 3
            override fun onTick(millisUntilFinished: Long) {
//                binding.txttiempo.text = time.toString() + "s"
//                time -= 1
            }

            override fun onFinish() {
                startActivity(Intent(this@Splash, MainActivity::class.java))
            }
        }.start()
    }

    fun fullPantalla() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}