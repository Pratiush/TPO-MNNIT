package com.wix.traitsoft.tpo_mnnit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
 * Created by saksham_ on 01-Oct-17.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {
    String login_url,reg_url,acad_url,personal_url,project_url;
    AlertDialog alertDialog;
    Context ctx;
    Dialog loadingDialog;
    String username;
    String title;
    String description;
    String intern;
    String organisation;
    String description1;
    String name;
    String course;
    String branch,gender;
    String dob;
    String email;
    String skype;
    String linked;
    String category;
    String physical;
    String resident;
    String guardian;
    String presentaddress;
    String permanentaddress;
    String maritalstatus;
    String state;
    String country;
    String school10,board10,year10,marks10,school12,board12,year12,marks12,sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;
    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        reg_url="https://one-eyed-rewards.000webhostapp.com/data/register.php";
        login_url="https://one-eyed-rewards.000webhostapp.com/data/login.php";
        project_url="https://one-eyed-rewards.000webhostapp.com/project_update.php";
        acad_url="https://one-eyed-rewards.000webhostapp.com/academic_update.php";
        personal_url="https://one-eyed-rewards.000webhostapp.com/personal_update.php";

        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("login information");
        loadingDialog = ProgressDialog.show(ctx, "Please wait", "Loading...");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        loadingDialog.dismiss();
        if(result.equals("Registration succesfull"))
        {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
            Intent i = new Intent(ctx, Login.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ctx.startActivity(i);
        }
        else if(result.equals("LOGIN SUCCESS"))
        {
            Intent i = new Intent(ctx, Home.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ctx.startActivity(i);
        }
        else if(result.equals("project update success"))
        {
            Toast.makeText(ctx,"UpdatedSuccessfully",Toast.LENGTH_LONG).show();
            Intent i = new Intent(ctx,Home.class);
            ctx.getApplicationContext().startActivity(i);
        }
        else if(result.equals("personal update success"))
        {
            Toast.makeText(ctx,"UpdatedSuccessfully",Toast.LENGTH_LONG).show();
            Intent i = new Intent(ctx,Home.class);
            ctx.getApplicationContext().startActivity(i);
        }
        else if(result.equals("academics updated"))
        {
            Toast.makeText(ctx,"UpdatedSuccessfully",Toast.LENGTH_LONG).show();
            Intent i = new Intent(ctx,Home.class);
            ctx.getApplicationContext().startActivity(i);
        }
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... params) {
        String method=params[0];

        if(method.equals("register"))
        {
            String user_regno=params[1];
            String user_pass=params[2];
            try {

                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter((new OutputStreamWriter(OS,"UTF-8")));
                String data= URLEncoder.encode("reg_no","UTF-8")+"="+URLEncoder.encode(user_regno,"UTF-8")+"&"+
                        URLEncoder.encode("passwd","UTF-8")+"="+URLEncoder.encode(user_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Registration succesfull";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login"))
        {
            String login_regno=params[1];
            String login_pass=params[2];
            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String data=URLEncoder.encode("login_regno","UTF-8")+"="+URLEncoder.encode(login_regno,"UTF-8")+"&"+
                        URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
                //System.out.println(response);
                /*if(response.equals("LOGIN SUCCESS\n"))
                {
                    return "Login Success";
                }
                else
                {
                    return "Invalid Credentials";
                }*/
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("academicupload"))
        {
            username=params[1];
            school10=params[2];
            board10=params[3];
            year10=params[4];
            marks10=params[5];
            school12=params[6];
            board12=params[7];
            year12=params[8];
            marks12=params[9];
            sem1=params[10];
            sem2=params[11];
            sem3=params[12];
            sem4=params[13];
            sem5=params[14];
            sem6=params[15];
            sem7=params[16];
            sem8=params[17];

            try {

                URL url=new URL(acad_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter((new OutputStreamWriter(OS,"UTF-8")));
                String data= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("school10","UTF-8")+"="+URLEncoder.encode(school10,"UTF-8")+"&"+
                        URLEncoder.encode("board10","UTF-8")+"="+URLEncoder.encode(board10,"UTF-8")+"&"+
                        URLEncoder.encode("year10","UTF-8")+"="+URLEncoder.encode(year10,"UTF-8")+"&"+
                        URLEncoder.encode("marks10","UTF-8")+"="+URLEncoder.encode(marks10,"UTF-8")+"&"+
                        URLEncoder.encode("school12","UTF-8")+"="+URLEncoder.encode(school12,"UTF-8")+"&"+
                        URLEncoder.encode("board12","UTF-8")+"="+URLEncoder.encode(board12,"UTF-8")+"&"+
                        URLEncoder.encode("year12","UTF-8")+"="+URLEncoder.encode(year12,"UTF-8")+"&"+
                        URLEncoder.encode("marks12","UTF-8")+"="+URLEncoder.encode(marks12,"UTF-8")+"&"+
                        URLEncoder.encode("sem1","UTF-8")+"="+URLEncoder.encode(sem1,"UTF-8")+"&"+
                        URLEncoder.encode("sem2","UTF-8")+"="+URLEncoder.encode(sem2,"UTF-8")+"&"+
                        URLEncoder.encode("sem3","UTF-8")+"="+URLEncoder.encode(sem3,"UTF-8")+"&"+
                        URLEncoder.encode("sem4","UTF-8")+"="+URLEncoder.encode(sem4,"UTF-8")+"&"+
                        URLEncoder.encode("sem5","UTF-8")+"="+URLEncoder.encode(sem5,"UTF-8")+"&"+
                        URLEncoder.encode("sem6","UTF-8")+"="+URLEncoder.encode(sem6,"UTF-8")+"&"+
                        URLEncoder.encode("sem7","UTF-8")+"="+URLEncoder.encode(sem7,"UTF-8")+"&"+
                        URLEncoder.encode("sem8","UTF-8")+"="+URLEncoder.encode(sem8,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "academics updated";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("personalupload"))
        {
            username=params[1];
            name=params[2];
            course=params[3];
            branch=params[4];
            dob=params[5];
            email=params[6];
            skype=params[7];
            linked=params[8];
            gender=params[9];
            if(gender.equals("Male")) {
                gender="1";
            }
            else
                gender="0";
            category=params[10];
            physical=params[11];
            if(physical.equals("yes"))
                physical="1";
            else
                physical="0";
            resident=params[12];
            if(resident.equals("hosteller"))
                resident="0";
            else
                resident="1";
            guardian=params[13];
            presentaddress=params[14];
            permanentaddress=params[15];
            maritalstatus=params[16];
            if(maritalstatus.equals("unmarried"))
                maritalstatus="0";
            else
                maritalstatus="1";
            state=params[17];
            country=params[18];
            try {

                URL url=new URL(personal_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter((new OutputStreamWriter(OS,"UTF-8")));
                String data= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("course","UTF-8")+"="+URLEncoder.encode(course,"UTF-8")+"&"+
                        URLEncoder.encode("branch","UTF-8")+"="+URLEncoder.encode(branch,"UTF-8")+"&"+
                        URLEncoder.encode("dob","UTF-8")+"="+URLEncoder.encode(dob,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("skypeid","UTF-8")+"="+URLEncoder.encode(skype,"UTF-8")+"&"+
                        URLEncoder.encode("linkedinid","UTF-8")+"="+URLEncoder.encode(linked,"UTF-8")+"&"+
                        URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(gender,"UTF-8")+"&"+
                        URLEncoder.encode("category","UTF-8")+"="+URLEncoder.encode(category,"UTF-8")+"&"+
                        URLEncoder.encode("physical","UTF-8")+"="+URLEncoder.encode(physical,"UTF-8")+"&"+
                        URLEncoder.encode("resident","UTF-8")+"="+URLEncoder.encode(resident,"UTF-8")+"&"+
                        URLEncoder.encode("guardian","UTF-8")+"="+URLEncoder.encode(guardian,"UTF-8")+"&"+
                        URLEncoder.encode("presentaddress","UTF-8")+"="+URLEncoder.encode(presentaddress,"UTF-8")+"&"+
                        URLEncoder.encode("permanentaddress","UTF-8")+"="+URLEncoder.encode(permanentaddress,"UTF-8")+"&"+
                        URLEncoder.encode("maritalstatus","UTF-8")+"="+URLEncoder.encode(maritalstatus,"UTF-8")+"&"+
                        URLEncoder.encode("state","UTF-8")+"="+URLEncoder.encode(state,"UTF-8")+"&"+
                        URLEncoder.encode("country","UTF-8")+"="+URLEncoder.encode(country,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                Log.i("gone","allok");
                OS.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "personal update success";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("projectupload"))
        {
            username=params[1];
            title=params[2];
            description=params[3];
            intern=params[4];
            organisation=params[5];
            description1=params[6];
            try {

                URL url=new URL(project_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter((new OutputStreamWriter(OS,"UTF-8")));
                String data= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("two","UTF-8")+"="+URLEncoder.encode(title,"UTF-8")+"&"+
                        URLEncoder.encode("three","UTF-8")+"="+URLEncoder.encode(description,"UTF-8")+"&"+
                        URLEncoder.encode("four","UTF-8")+"="+URLEncoder.encode(intern,"UTF-8")+"&"+
                        URLEncoder.encode("five","UTF-8")+"="+URLEncoder.encode(organisation,"UTF-8")+"&"+
                        URLEncoder.encode("six","UTF-8")+"="+URLEncoder.encode(description1,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                Log.i("gone","all ok");
                OS.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "project update success";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
