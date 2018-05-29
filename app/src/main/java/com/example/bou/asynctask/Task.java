package com.example.bou.asynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Task extends AsyncTask<String,String,String> {

    ArrayList<MovieObject> arrayList;
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }

            String finalString =  stringBuffer.toString();
            JSONObject parent = new JSONObject(finalString);
            JSONArray parent_ = parent.getJSONArray("movies");
            String finalOne = "";
            arrayList = new ArrayList<>();
                for(int i=0;i<parent_.length();i++){

                    JSONObject parent__ = parent_.getJSONObject(i);
                    String movie = parent__.getString("movie");
                    int year = parent__.getInt("year");
                    double rating = parent__.getDouble("rating");
                    String duration = parent__.getString("duration");
                    String director = parent__.getString("director");
                    String tagline = parent__.getString("tagline");
                    String actor = "";

                    JSONArray cast = parent__.getJSONArray("cast");
                    for(int j = 0;j<cast.length();j++){
                        JSONObject name = cast.getJSONObject(j);
                        actor+=name.getString("name")+ "\n";
                    }

                    String image = parent__.getString("image");
                    String story = parent__.getString("story");

                   MovieObject movieObject = new MovieObject(movie,year,rating,duration,director,tagline,actor,image,story);
                   arrayList.add(movieObject);

                    //finalOne  += movie_name + " " + year + "\n";
                }

//            String finalOne  = movie_name + " " + year;

            return finalOne;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //MainActivity.textView.setText(s);
        MainActivity.listView.setAdapter(new customAdapter(MainActivity.mContext,arrayList));
        Toast.makeText(MainActivity.mContext, Integer.toString(arrayList.size()),Toast.LENGTH_LONG).show();
    }
}
