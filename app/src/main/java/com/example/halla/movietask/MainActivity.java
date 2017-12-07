package com.example.halla.movietask;



import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

     List<Movie> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("msg","started");
        ListView lst  = (ListView) findViewById(R.id.listview_movies);
        SearchView srch = (SearchView) findViewById(R.id.search_bar);

        srch.setQueryHint("Search by Date..");
         list = new ArrayList<>();

        GetMovies getMovies = new GetMovies();
        getMovies.execute();
        try {
            list = getMovies.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        final MoviesAdapter moviesAdapter = new MoviesAdapter(list,this);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DialogFragment newFragment = DetailBox.newInstance(list.get(i));
                newFragment.show(getSupportFragmentManager(), "dialog");
            }
        });

        srch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                moviesAdapter.filter(s);
                return false;
            }
        });
        lst.setAdapter(moviesAdapter);
    }
}
