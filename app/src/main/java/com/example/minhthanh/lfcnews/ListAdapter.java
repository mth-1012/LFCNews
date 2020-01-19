package com.example.minhthanh.lfcnews;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Minh Thanh on 18/3/2017.
 */

public class ListAdapter extends ArrayAdapter<String> {

    Context context;
    int resource;
    String[] titles;

    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull String[] titles) {
        super(context, resource, titles);
        this.context = context;
        this.resource = resource;
        this.titles = titles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_layout, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewNews);
        TextView textView = (TextView) view.findViewById(R.id.textViewNews);

        textView.setText(titles[position]);
        switch (position) {
            case 1:
                imageView.setImageResource(R.drawable.ic_chrome_reader_mode_black_24dp);
                break;
            case 2:
                imageView.setImageResource(R.drawable.ic_filter_list_black_24dp);
                break;
            case 3:
                imageView.setImageResource(R.drawable.ic_info_black_24dp);
                break;
            case 0:
                imageView.setImageResource(R.drawable.ic_home_black_24dp);
                break;
        }

        return view;
    }
}
