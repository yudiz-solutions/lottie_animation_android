package lottieanimationdemo

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import lottieanimationdemos.R

class SplashActivity : AppCompatActivity() {
    private var splashTimer: CountDownTimer? = null
    private val minute = 5L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash)
    }

    override fun onResume() {
        super.onResume()
        splashTimer = object : CountDownTimer(minute * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val mainIntent = Intent(applicationContext, MainActivity::class.java)
                startActivity(mainIntent)
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
                finish()
            }
        }.start()
    }

    override fun onStop() {
        super.onStop()
        cancelTimer()
    }

    private fun cancelTimer() {
        if (splashTimer != null)
            splashTimer!!.cancel()
    }
}