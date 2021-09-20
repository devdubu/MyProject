package Retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IRetrofit {
    @FormUrlEncoded
    @POST("/login")
    fun loginRequest(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<JsonElement>
    //이 부분을 수정할라고 합니당
    @FormUrlEncoded
    @POST("/Register")
    fun registerRequest(
        @Field("name") Rname: String,
        @Field("PhoneNumber") RPhoneNumber: String,
        @Field("Email") REmail: String,
        @Field("ID") RId: String,
        @Field("Password") RPassword: String,
        @Field("PasswordCon") RPasswordCon: String
    ): Call<JsonElement>

}