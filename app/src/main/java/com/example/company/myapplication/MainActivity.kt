package com.example.company.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var REQUEST_CONSTANT = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA) , REQUEST_CONSTANT)

        }
    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CONSTANT -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    textView.text = "Granted"
                } else {textView.text = "Denied"
                    // Разрешение не выдано, необходимо использовать другой способ
                }
                return
            }
            else -> {
                // id запроса не совпадает с ожидаемым, игнорируем
            }
        }
    }
}
