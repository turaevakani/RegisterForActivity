package com.geektech.registerforactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.registerforactivity.MainActivity.Companion.ACCESS_MESSAGE
import com.geektech.registerforactivity.MainActivity.Companion.TEXT_KEY
import com.geektech.registerforactivity.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivitySecondBinding.inflate(layoutInflater)
     setContentView(binding.root)

        with(binding){
            etText2.setText(intent.getStringExtra(TEXT_KEY))
            btnBack.setOnClickListener {
                val message = etText2.text.toString().trim()
                if (message.isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.toast_empty),
                        Toast.LENGTH_SHORT
                    ).show()
            }else{
                    val data = Intent()
                    data.putExtra(ACCESS_MESSAGE, message)
                    setResult(RESULT_OK, data)
                    finish()
                }


        }
    }
}}
