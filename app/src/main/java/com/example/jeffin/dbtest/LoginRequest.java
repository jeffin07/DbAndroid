package com.example.jeffin.dbtest;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeffin on 12-09-2017.
 */

public class LoginRequest extends StringRequest {

private  static  final String LOGIN_REQUEST_URL="http://192.168.43.147/projects/Login.php";

    private Map<String,String> parms;

    public LoginRequest(String username, String password, Response.Listener<String> listener){

        super(Request.Method.POST,LOGIN_REQUEST_URL, listener,null);
        parms=new HashMap<>();
        parms.put("username",username);
        parms.put("password",password);


    }

    public Map<String, String> getParms() {
        return parms;
    }
}
