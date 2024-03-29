package com.example.loginproject

import Retrofit.RetrofitManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.os.postDelayed
import androidx.databinding.DataBindingUtil
import com.example.loginproject.databinding.ActivityRegisterBinding
import retrofit2.HttpException

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        var dialogBuilder = AlertDialog.Builder(this@RegisterActivity)


        //중복되눈 아이디 찾기
        binding.overlapIdButton.setOnClickListener{

        }
        //회원가입하기
        binding.registerConformButton.setOnClickListener{
            val Rname: String = binding.nameInput.text.toString()
            val RPhoneNumber: String = binding.phoneInput.text.toString()
            val REmail:String = binding.emailInput.text.toString()
            val Rid:String = binding.idRegisterInput.text.toString()
            val RPassword: String = binding.passwordRegisterInput.text.toString()
            val RPasswordCon: String = binding.passwordRegisterConformInput.text.toString()
            registerRequest(Rname, RPhoneNumber, REmail, Rid,RPassword, RPasswordCon)

            RetrofitManager.instance.register(Rname=Rname,RPhoneNumber=RPhoneNumber,REmail=REmail,Rid = Rid,RPassword = RPassword,RPasswordCon = RPasswordCon, completion = {
                    RegisterResponse, response ->
                when(RegisterResponse){
                    Retrofit.RegisterResponse.FAIL -> {
                        dialogBuilder.setTitle("알림")
                        dialogBuilder.setMessage("회원가입 실패")
                        dialogBuilder.setPositiveButton("확인", null)
                        dialogBuilder.show()
                    }

                    Retrofit.RegisterResponse.OK -> {
                        dialogBuilder.setTitle("알림")
                        dialogBuilder.setMessage("회원가입 성공")

                        dialogBuilder.show()
                        Handler().postDelayed({
                            finish()
                        },1000L)

                    }
                }
            })
        }



    }
    fun registerRequest(Rname: String,RPhoneNumber: String,REmail:String,Rid:String,RPassword:String,RPasswordCon: String){
        var dialogBuilder = AlertDialog.Builder(this@RegisterActivity)
        if(Rname.isEmpty()){
            dialogBuilder.setTitle("알림")
            dialogBuilder.setMessage("이름을 입력해주세요")
            dialogBuilder.setPositiveButton("확인", null)
            dialogBuilder.show()
        }else if(RPhoneNumber.isEmpty()){
            dialogBuilder.setTitle("알림")
            dialogBuilder.setMessage("전화번호를 입력해주세요")
            dialogBuilder.setPositiveButton("확인", null)
            dialogBuilder.show()
        }else if(REmail.isEmpty()){
            dialogBuilder.setTitle("알림")
            dialogBuilder.setMessage("이메일 주소를 입력해주세요")
            dialogBuilder.setPositiveButton("확인", null)
            dialogBuilder.show()
        }else if(Rid.isEmpty()){
            dialogBuilder.setTitle("알림")
            dialogBuilder.setMessage("아이디를 입력해주세요")
            dialogBuilder.setPositiveButton("확인", null)
            dialogBuilder.show()
        }else if(RPassword.isEmpty()){
            dialogBuilder.setTitle("알림")
            dialogBuilder.setMessage("비밀번호를 입력해주세요")
            dialogBuilder.setPositiveButton("확인", null)
            dialogBuilder.show()
        }else if(RPasswordCon.isEmpty()){
            dialogBuilder.setTitle("알림")
            dialogBuilder.setMessage("비밀번화 확인란을 입력해주세요")
            dialogBuilder.setPositiveButton("확인", null)
            dialogBuilder.show()
        }
    }




}