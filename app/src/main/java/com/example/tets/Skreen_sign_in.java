package com.example.tets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;






public class Skreen_sign_in extends AppCompatActivity {







    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skreen_sign_in);

    }

       public void authorization(View v){
           TextView login=findViewById(R.id.textView2);
           String URL= "https://jsonplaceholder.typicode.com/todos";
           login.setText(URL);
           RequestQueue requestQueue= Volley.newRequestQueue(this);
           JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                   new Response.Listener<JSONArray>()
                   {
                       @Override
                       public void onResponse(JSONArray response) {
                           // display response
                           Log.d("Response", response.toString());
                           TextView login=findViewById(R.id.textView);
                           TextView pasord=findViewById(R.id.textView2);

                           //login.setText(response.toString());
                           //response.length() - это если мы едём по всему масиву
                           for (int x = 0; x < 1; x++) {
                               JSONObject JO = null;
                               try {
                                   JO = response.getJSONObject(x);
                                   String firstname = JO.getString("title");
                                   String id = JO.getString("id");
                                   login.setText(firstname.toString());
                                   pasord.setText(id.toString());

                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }
                           }
                       }
                   },
                   new Response.ErrorListener()
                   {
                       @Override
                       public void onErrorResponse(VolleyError error) {
                           Log.d("Error.Response", error.toString());
                       }
                   }
           );
           requestQueue.add(getRequest);
       }
    public void authorization_json_convert(View v){
        EditText login_1 = findViewById(R.id.editTextTextPersonName_login);
        EditText pass = findViewById(R.id.editTextTextPersonName_passord);
        TextView login=findViewById(R.id.textView2);

        JSONArray list = new JSONArray();
        String URL= "http://httpbin.org/post";
        JSONObject obj = new JSONObject();
        try {
            obj.put("username",login_1.getText());
            obj.put("password",pass.getText());
            list.put(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest getReqst = new JsonObjectRequest(1, URL, obj,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String firstname = null;
                        TextView login=findViewById(R.id.textView2);
                        //login.setText(response.toString());
                        try {
                            firstname = response.getString("data");
                            login.setText(firstname.split(",")[0].split(":")[1]);
                            //firstname.split(",");



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );


        requestQueue.add(getReqst);

        }





public void asd(View v){
    EditText login_1 = findViewById(R.id.editTextTextPersonName_login);
    EditText pass = findViewById(R.id.editTextTextPersonName_passord);
    TextView login=findViewById(R.id.textView2);
    JSONObject obj = new JSONObject();
    try {
        obj.put("username",login_1.getText());
        obj.put("password",pass.getText());
        login.setText(obj.toString());
        //list.put(obj);
    } catch (JSONException e) {
        e.printStackTrace();
    }
}
    }
