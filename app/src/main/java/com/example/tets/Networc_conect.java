package com.example.tets;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;





public class Networc_conect {


    public static String getPersonData() throws IOException {

        URL githubEndpoint = new URL("http://localhost:3000/login");
        HttpsURLConnection connection =(HttpsURLConnection) githubEndpoint.openConnection();

        connection.setRequestMethod("GET");
//304
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNextLine()){
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();

            connection.disconnect();
            return response;
        }

        // an error happened
        connection.disconnect();
        return null;

    }
}
