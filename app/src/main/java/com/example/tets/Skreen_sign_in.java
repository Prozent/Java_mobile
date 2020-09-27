package com.example.tets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class Skreen_sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skreen_sign_in);
    }

    public void klic_json(View v) {
        try {
            String asd = Networc_conect.getPersonData();
            JSONObject jsonObject = new JSONObject(asd);
            String title = jsonObject.getString("title");
            Toast.makeText(this, title, Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();

//            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}