package com.example.tets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;


public class Skreen_sign_in extends AppCompatActivity {

    class ShowDialogAsyncTask extends AsyncTask<Void, Void, String> {
        private TextView resopnse;
        @Override
        protected String doInBackground(Void... urls) {
            String asd="";
            resopnse= findViewById(R.id.textView);
            try {
                asd =  Networc_conect.getPersonData();


            } catch (IOException e) {
                e.printStackTrace();
            }

            return asd;
        }
        protected void onPostExecute(String asd){resopnse.setText(asd);};
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skreen_sign_in);

    }
    public void Clic_button(View v){new ShowDialogAsyncTask().execute();}
    }
