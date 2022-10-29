package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.myapplication.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.myapplication.MainActivity2
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    //宣告元件
    private var send_btn: Button? = null
    private var set_drink: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var sugar = "無糖"
    private var ice_opt = "去冰"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //連接畫面元件
        val btn_send = findViewById<Button>(R.id.btn_send)
        val ed_drink = findViewById<EditText>(R.id.ed_drink)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)
        btn_send.setOnClickListener {
            if (ed_drink.length() < 1)
                Toast.makeText(this, "請輸入飲料名稱",
                    Toast.LENGTH_SHORT).show()
            else {
                //宣告 Bundle
                val b = Bundle()
                //取得 EditText 字串內容，把飲料名稱、甜度與冰塊資訊放入 Bundle
                b.putString("drink", ed_drink.text.toString())
                b.putString("sugar", radioGroup.findViewById<RadioButton>
                    (radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice", radioGroup2.findViewById<RadioButton>
                    (radioGroup2.checkedRadioButtonId).text.toString())
                //用 Activity.RESULT_OK 標記執行狀態並記錄 Intent
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }
    }
}