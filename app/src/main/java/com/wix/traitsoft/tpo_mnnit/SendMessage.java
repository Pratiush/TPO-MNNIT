package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by Dell on 10/12/2017.
 */

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by shiva on 12-10-2017.
 */

public class SendMessage extends AsyncTask<String,Void,String>{

    private String username;
    private String message;
    private  Context context;

    SendMessage(Context context){this.context=context;}

    @Override
    protected String doInBackground(String...args) {

        username=args[0];
        message=args[1];
        URL url;

        String str="https://one-eyed-rewards.000webhostapp.com/sendmessage.php";

        try {
            url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode("3000000", "UTF-8") + "&" + URLEncoder.encode("message", "UTF-8") + "=" + URLEncoder.encode("kiiiiiiillll", "UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

