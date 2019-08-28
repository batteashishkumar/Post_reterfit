package com.example.post_reterfit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @POST("/retrofit/register.php")
    @FormUrlEncoded
    Call<ResponseBody> regis(@Field("name") String name,
                             @Field("email") String email,
                             @Field("password") String password,
                                @Field("logintype") String logintype);


}
