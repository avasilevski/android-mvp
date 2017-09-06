package com.aleksandarvasilevski.android_mvp.network;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RegisterTask extends AsyncTask<String, Void, String> {

    public IOnTaskComplete delegate = null;

    public RegisterTask(){}

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String register_url = "http://192.168.1.108/register.php";
        if (type.equals("register")){
            try {
                String email = params[1];
                String password = params [2];
                String firstname = params [3];
                String lastname = params [4];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        +URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")+"&"
                        +URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstname, "UTF-8")+"&"
                        +URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            }catch (Exception e){
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.result(result);
    }
}
