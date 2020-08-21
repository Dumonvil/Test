package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginView extends AppCompatActivity {

    private EditText pid;
    private EditText password;
    private Button button;
    private ProgressBar loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        pid = findViewById(R.id.pid);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);
        loading = findViewById(R.id.loading);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

       public void login(){

        StringRequest request = new StringRequest(Request.Method.POST, "Https//192.168.83.17/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.contains("1")){
                    startActivity(new Intent(getApplicationContext(), ScrollingActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),
                            "wrong username or password",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params= new HashMap<>();
                params.put("username",pid.getText().toString());
                params.put("password",password.getText().toString());

                return getParams();
            }
        };

           Volley.newRequestQueue(this).add(request);
       }
}
