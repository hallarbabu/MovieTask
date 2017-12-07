package com.example.halla.movietask;



import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class
GetMovies extends AsyncTask<Void, Void, ArrayList<Movie>> {


    ArrayList<Movie> data = new ArrayList<>();

    String row = null;

    @Override
    protected ArrayList doInBackground(Void... params) {





        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body =  RequestBody.create(mediaType, "{}");


        Request request = new Request.Builder()


                .url("https://api.themoviedb.org/4/list/1?sort_by=release_date.desc&language=en&api_key=55fee95147a33585a1136fdaa1d2b536&page=1")
                .get()
                .addHeader("content-type", "application/json;charset=utf-8")
                .addHeader("authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1NWZlZTk1MTQ3YTMzNTg1YTExMzZmZGFhMWQyYjUzNiIsInN1YiI6IjVhMjk4MTE3MGUwYTI2NGNjZDExYWJkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.nI_f3bVPRvh5afnO2ncaB95gCNOlD4L187GtMgAuURY")
                .build();

        try {

            Response response = client.newCall(request).execute();

            String jsonData = response.body().string();
            // System.out.println("baap "+jsonData.toString());

            JSONObject Jobject = new JSONObject(jsonData);
            JSONArray jsonArray = Jobject.getJSONArray("results");
            for(int i=0 ;i<jsonArray.length();i++)
            {



                String id = jsonArray.getJSONObject(i).optString("id");
                String name = jsonArray.getJSONObject(i).optString("title");
                String vote_count = jsonArray.getJSONObject(i).optString("vote_count");
                String vote_average = jsonArray.getJSONObject(i).optString("vote_average");
                String release_date = jsonArray.getJSONObject(i).optString("release_date");
                String overview = jsonArray.getJSONObject(i).optString("overview");

                //  Log.d("HTTPjson","id = "+id+" name = "+name);


                data.add(new Movie(id,name,vote_count,vote_average,release_date,overview));

            }







        }

       catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data ;
    }
}


