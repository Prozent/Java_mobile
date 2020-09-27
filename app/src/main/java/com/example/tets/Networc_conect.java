package com.example.tets;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Scanner;

public class Networc_conect {
    public static String getPersonData() throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL("http://jsonplaceholder.typicode.com/posts").openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNextLine()){
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();

            return response;
        }

        // an error happened
        return null;
    }
}
