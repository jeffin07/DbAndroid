package com.example.jeffin.dbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);



        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user,pass;
                user=username.getText().toString();
                pass=password.getText().toString();
                Toast.makeText(getApplicationContext(),"in click"+pass,Toast.LENGTH_LONG).show();
                Response.Listener<String> responseListner=new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),"in response",Toast.LENGTH_LONG).show();

                        try {
                            JSONObject jsonResponce =new JSONObject(response);
                            boolean success =jsonResponce.getBoolean("success");

                            if(success) {

                                String name=jsonResponce.getString("username");
                                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                            }
                            else{
                                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                LoginRequest loginRequest=new LoginRequest(user,pass,responseListner);
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
                Toast.makeText(getApplicationContext(),"queue",Toast.LENGTH_LONG).show();
                /*
                if(user.length()==0 || pass.length()==0){

                    Toast.makeText(getApplicationContext(),"Please enter username or password",Toast.LENGTH_LONG).show();
                }
                else {
                    LoginRequest loginRequest=new LoginRequest(user,pass,responseListner);

                    Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                }
                */
            }
        });

    }



}
