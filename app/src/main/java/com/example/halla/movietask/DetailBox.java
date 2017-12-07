package com.example.halla.movietask;

/**
 * Created by Jalal on 7/31/2016.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class DetailBox extends DialogFragment {


   private  Movie movie;

    public static DetailBox newInstance(Movie m) {
        DetailBox detailBox = new DetailBox();
        detailBox.setMovie(m);
        return  detailBox;
    }

     public  void setMovie(Movie obj)
     {
         this.movie = obj;
     }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.detailbox, null);

        TextView id =  v.findViewById(R.id.id);
        TextView name =  v.findViewById(R.id.name);
        TextView vote_count =  v.findViewById(R.id.vote_count);
        TextView vote_average =  v.findViewById(R.id.vote_average);
        TextView rdate =  v.findViewById(R.id.release_date);
        TextView overview =  v.findViewById(R.id.overview);


        id.setText(movie.getId());
        name.setText(movie.getName());
        vote_count.setText(movie.getVote_count());
        vote_average.setText(movie.getVote_average());
        rdate.setText(movie.getRelease_date());
        overview.setText(movie.getOverview());
   build.setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //this is message 

                    }
                }
        );

        build.setView(v);
        return build.create();
    }
}
