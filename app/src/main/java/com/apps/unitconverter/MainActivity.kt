package com.apps.unitconverter

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    //  Temperature
    private val buttonCelcius by lazy { findViewById<MaterialButton>(R.id.btn_celcius) }
    private val buttonFahrenheit by lazy { findViewById<MaterialButton>(R.id.btn_fahrenheit) }
    private val inputCelcius by lazy { findViewById<TextView>(R.id.tv_input_celcius) }
    private val inputFahrenheit by lazy { findViewById<TextView>(R.id.tv_input_fahrenheit) }
    private val buttonSwap by lazy { findViewById<MaterialButton>(R.id.btn_swap) }

    // Number Group
    //    Row 1
    private val btn1 by lazy { findViewById<MaterialButton>(R.id.btn_1) }
    private val btn2 by lazy { findViewById<MaterialButton>(R.id.btn_2) }
    private val btn3 by lazy { findViewById<MaterialButton>(R.id.btn_3) }
    private val buttonClear by lazy { findViewById<MaterialButton>(R.id.btn_clear) }

    //    Row 2
    private val btn4 by lazy { findViewById<MaterialButton>(R.id.btn_4) }
    private val btn5 by lazy { findViewById<MaterialButton>(R.id.btn_5) }
    private val btn6 by lazy { findViewById<MaterialButton>(R.id.btn_6) }
    private val bottonPlus by lazy { findViewById<MaterialButton>(R.id.btn_plus) }

    //    Row 3
    private val btn7 by lazy { findViewById<MaterialButton>(R.id.btn_7) }
    private val btn8 by lazy { findViewById<MaterialButton>(R.id.btn_8) }
    private val btn9 by lazy { findViewById<MaterialButton>(R.id.btn_9) }
    private val bottonMinus by lazy { findViewById<MaterialButton>(R.id.btn_minus) }

    //    Row 4
    private val bottonZero by lazy { findViewById<MaterialButton>(R.id.btn_zero) }
    private val buttonDot by lazy { findViewById<MaterialButton>(R.id.btn_dot) }
    private val buttonEqual by lazy { findViewById<MaterialButton>(R.id.btn_equal) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeInput()
        observeOutput()

        btn1.setButtonClickListener("1")
        btn2.setButtonClickListener("2")
        btn3.setButtonClickListener("3")
        btn4.setButtonClickListener("4")
        btn5.setButtonClickListener("5")
        btn6.setButtonClickListener("6")
        btn7.setButtonClickListener("7")
        btn8.setButtonClickListener("8")
        btn9.setButtonClickListener("9")
        bottonZero.setButtonClickListener("0")
        bottonPlus.setButtonClickListener("+")
        bottonMinus.setButtonClickListener("-")
        buttonDot.setButtonClickListener(".")

        buttonSwap.setOnClickListener {
            animateInputIndicator()
            viewModel.switchInputUnit()
            viewModel.resetInputAndOutput()
        }

        buttonClear.setOnClickListener {
            viewModel.clearInput()
        }

        buttonEqual.setOnClickListener {
            viewModel.convertUnit()
        }
    }

    private fun observeInput() {
        viewModel.input.observe(this) { input ->
            inputCelcius.text = input
        }
    }

    private fun observeOutput() {
        viewModel.output.observe(this) { output ->
            inputFahrenheit.text = output
        }
    }

    private fun MaterialButton.setButtonClickListener(value: String) {
        setOnClickListener {
            viewModel.setInput(value)
        }
    }

    private fun animateInputIndicator() {
        // Get initial position
        val initialY1 = buttonCelcius.y
        val initialY2 = buttonFahrenheit.y

        // Animate button celcius
        buttonCelcius.animate().alpha(0f).y(initialY2).setDuration(350).withEndAction {
            buttonCelcius.y = initialY2
            buttonCelcius.alpha = 1f
        }

        // Animate button fahrenheit
        buttonFahrenheit.animate().alpha(0f).y(initialY1).setDuration(350).withEndAction {
            buttonFahrenheit.y = initialY1
            buttonFahrenheit.alpha = 1f
        }
    }
}
