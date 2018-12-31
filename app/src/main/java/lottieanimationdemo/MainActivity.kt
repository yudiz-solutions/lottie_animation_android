package lottieanimationdemo

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.act_main.*
import lottieanimationdemos.R

class MainActivity : AppCompatActivity() {
    private var doubleBackToExitPressedTwice: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        initLottieAnimation()
        clickListeners()
    }

    private fun initLottieAnimation() {
        lottie_checkedanimation.setAnimation("cycling.json")
        lottie_checkedanimation.loop(true)
    }

    private fun clickListeners() {
        lottie_checkedanimation!!.setOnClickListener { startCheckAnimation() }
    }

    private fun startCheckAnimation() {
        if (lottie_checkedanimation!!.isAnimating) {
            lottie_checkedanimation!!.pauseAnimation()
        } else {
            lottie_checkedanimation!!.playAnimation()
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedTwice) {
            finish()
            return
        }
        this.doubleBackToExitPressedTwice = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedTwice = false }, 2000)
    }
}
