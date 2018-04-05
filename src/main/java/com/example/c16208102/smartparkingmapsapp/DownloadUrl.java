package com.example.c16208102.smartparkingmapsapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by c16208102 on 04/04/2018.
 */

public class DownloadUrl {

    public String readUrl(String myUrl) throws IOException {

        String data="";
        InputStream inputStream = null;
        HttpsURLConnection urlConnection = null;
        try {
            URL url = new URL(myUrl);
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            while((line = br.readLine()) != null) {

                sb.append(line);
            }
            data=sb.toString();
            br.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            urlConnection.disconnect();
        }
        return data;

    }
}

