package com.example.loginproject

import Retrofit.LoginResponse
import Retrofit.RetrofitManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.loginproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
    fun loginRequest(username: String, password: String){
        var dialogBuilder = AlertDialog.Builder(this@MainActivity)
        if(username.isEmpty() || password.isEmpty()){
            dialogBuilder.setTitle("알림")
            dialogBuilder.setMessage("빈 칸을 전부 채워주세요.")
            dialogBuilder.setPositiveButton("확인", null)
            dialogBuilder.show()
        }else{
            RetrofitManager.instance.login(username=username, password=password, completion = {
                    loginResponse, response ->
                when(loginResponse){
                    LoginResponse.FAIL -> {
                        dialogBuilder.setTitle("알림")
                        dialogBuilder.setMessage("로그인 실패")
                        dialogBuilder.setPositiveButton("확인", null)
                        dialogBuilder.show()
                    }

                    LoginResponse.OK -> {
                        dialogBuilder.setTitle("알림")
                        dialogBuilder.setMessage("로그인 성공")
                        dialogBuilder.setPositiveButton("확인", null)
                        dialogBuilder.show()
                    }
                }
            })
        }
    }
}