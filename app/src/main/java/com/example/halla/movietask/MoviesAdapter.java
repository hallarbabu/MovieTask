package com.example.halla.movietask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MoviesAdapter extends BaseAdapter {

    private List<Movie> _data;
    private ArrayList<Movie> arraylist;

   private    Context _c;
    private ViewHolder v;


    public MoviesAdapter(List<Movie> Movie, Context context) {
        _data = Movie;
        _c = context;
        this.arraylist = new ArrayList<Movie>();
        this.arraylist.addAll(_data);
    }

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public Object getItem(int i) {
        return _data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        //final int ii=i;

        if (view == null) {
            LayoutInflater li = (LayoutInflater) _c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.movie_row, null);

        } else {
            view = convertView;

        }

        v = new ViewHolder();

        v.title = (TextView) view.findViewById(R.id.moviename);


        final Movie data = (Movie) _data.get(i);
        v.title.setText(data.getName());

        view.setTag(data);
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        _data.clear();
        if (charText.length() == 0) {
            _data.addAll(arraylist);
        } else {
            for (Movie wp : arraylist) {
                if (wp.getRelease_date().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    _data.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
    static class ViewHolder {

        TextView title;

    }

}
