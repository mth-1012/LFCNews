package com.example.minhthanh.lfcnews;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Minh Thanh on 12/3/2017.
 */

public class FragmentThree extends android.support.v4.app.Fragment{

    ListView listView;
    TextView textView;
    ArrayAdapter arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_three, container, false);

        listView = (ListView) view.findViewById(R.id.listSources);
        textView = (TextView) view.findViewById(R.id.textAbout);

        String[] sources = {"Home Page: http://www.liverpoolfc.com/",
                            "Match API: http://api.football-data.org/",
                            "Helped by:",
                            "           https://github.com\n" +
                            "           http://stackoverflow.com/ \n" +
                            "           http://blog.teamtreehouse.com/",
                            "Icons: http://www.flaticon.com/"};
        arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, sources);
        listView.setAdapter(arrayAdapter);

        textView.setText("Created by Minh Thanh\n" +
                "Studied at T3H\n" +
                "2016-17");


        return view;
    }
}
