package com.wix.traitsoft.tpo_mnnit;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by shiva on 29-09-2017.
 */

/*
public class JsonFetch {

    Dialog waiting;
    private Context c;
    JsonFetch(Context c) {
        this.c = c;
    }

    public static String json1;

    public void getJSON(final String urlWebService) {


        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                waiting = ProgressDialog.show(c, "Please wait", "Fetching data...");
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(c, s, Toast.LENGTH_SHORT).show();
                json1 =s;
                waiting.dismiss();

            }

            @Override
            protected String doInBackground(Void... voids) {
                try {

                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                 start here   HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close(); end here
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
        //return json1;

    }


}
*/



/*
public class JsonFetch {



    public void getJSON(final String urlWebService) {
*/

class JsonFetch extends AsyncTask<String, Void, String> {

    String urlWebService;
    private Dialog waiting;
    public static String json1="";
    private Context c;

    JsonFetch(Context c,String str) {
        this.c = c;
        urlWebService=str;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        waiting = ProgressDialog.show(c, "Please wait", "Fetching data...");
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
           Toast.makeText(c, s, Toast.LENGTH_SHORT).show();
        //json1 =s;
        Log.d("post",json1);
        waiting.dismiss();


    }

    @Override
    protected String doInBackground(String... voids) {
        try {

            URL url = new URL(urlWebService);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
                    /*HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();*/
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String json;
            while ((json = bufferedReader.readLine()) != null) {
                sb.append(json + "\n");
            }
            Log.d("CMS",sb.toString());
            json1 = sb.toString();
            return sb.toString().trim();
        } catch (Exception e) {
            return null;
        }
    }
}
