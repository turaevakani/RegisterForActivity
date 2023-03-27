package com.geektech.registerforactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.registerforactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var launcher =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
        if (result.resultCode == RESULT_OK){
            val textResult = result.data!!.getStringExtra(ACCESS_MESSAGE)
            binding.etText1.setText(textResult)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            // получаем введенный текст
            btnSubmit.setOnClickListener {
                val message = etText1.text.toString().trim()
                if (message.isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.toast_empty),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra(TEXT_KEY, message)
                    launcher.launch(intent)
                }
            }
        }
    }

    companion object {
        const val TEXT_KEY = "TEXT"
        const val ACCESS_MESSAGE = "ACCESS_MESSAGE"
    }
}