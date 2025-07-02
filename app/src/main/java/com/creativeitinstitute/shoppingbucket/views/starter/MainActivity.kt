package com.creativeitinstitute.shoppingbucket.views.starter

import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.creativeitinstitute.shoppingbucket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
			val imeVisible = insets.isVisible(WindowInsetsCompat.Type.ime())
			val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

			view.setPadding(
				systemBars.left,
				systemBars.top,
				systemBars.right,
				if (imeVisible) imeInsets.bottom else systemBars.bottom
			)

			insets
		}
	}
	private fun hideKeyboard(view: View) {
		val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
		imm.hideSoftInputFromWindow(view.windowToken, 0)
	}

	override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
		if (ev.action == MotionEvent.ACTION_DOWN) {
			val v = currentFocus
			if (v is EditText) {
				val outRect = Rect()
				v.getGlobalVisibleRect(outRect)
				if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
					v.clearFocus()
					hideKeyboard(v)
				}
			}
		}
		return super.dispatchTouchEvent(ev)
	}
}