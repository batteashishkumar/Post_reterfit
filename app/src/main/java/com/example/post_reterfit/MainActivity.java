package com.example.post_reterfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3;
String se1,se2,se3;
    private static final String BASE_URL="http://mobileappdatabase.in/";
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        e3=findViewById(R.id.edit3);
    }
    public void ash(View v){
        se1=e1.getText().toString();
        se2=e2.getText().toString();
        se3=e3.getText().toString();

        retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
       Call<ResponseBody> call= retrofit.create(Api.class).regis(se1,se2,se3,"advanced");
       call.enqueue(new Callback<ResponseBody>() {
           @Override
           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
               Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_LONG).show();
           }

           @Override
           public void onFailure(Call<ResponseBody> call, Throwable t) {
Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
           }
       });
    }
}

//to see your result:-
//http://mobileappdatabase.in/retrofit/getuser.php