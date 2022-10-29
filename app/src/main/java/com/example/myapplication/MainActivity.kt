package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.myapplication.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.myapplication.MainActivity2
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    private var btn: Button? = null
    private var tv_meal: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //連結畫面元件
        tv_meal = findViewById(R.id.tv_meal)
        //『選擇』按鈕點及監聽
        btn = findViewById(R.id.btn_choice)
        findViewById<Button>(R.id.btn_choice).setOnClickListener {
            //透過 Intent 切換至 SecActivity 並傳遞 requestCode 作為識別編號
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        //驗證發出的對象回傳狀態
        if (requestCode == 1) {
            if (resultCode == 101) {
                //讀取Bundle中的資料
                val b = data.extras
                val str1 = b!!.getString("drink")
                val str2 = b.getString("sugar")
                val str3 = b.getString("ice")
                tv_meal!!.text = String.format(
                    "飲料：%s\n\n甜度：%s\n\n冰塊：%s\n\n",
                    str1,
                    str2,
                    str3
                )
            }
        }
    }
}