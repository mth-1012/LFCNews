package com.example.minhthanh.lfcnews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Minh Thanh on 18/3/2017.
 */

public class FragmentMain extends Fragment {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<Players> playersList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.layout_main, container, false);

        listView = (ListView) view.findViewById(R.id.listViewPlayers);
        playersList = new ArrayList<Players>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                intent.putExtra("Player", playersList.get(position));
                startActivity(intent);
            }
        });

        new PlayersASyncTask().execute("http://api.football-data.org/v1/teams/64/players");

        return view;
    }

    class PlayersASyncTask extends AsyncTask<String, Void, ArrayList<Players>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Players> aVoid) {
            super.onPostExecute(aVoid);
            ArrayList<String> strings = new ArrayList<>();
            playersList = aVoid;
            for (Players p: playersList) {
                String s = p.getJerseyNumber()+"";
                if (p.getJerseyNumber()/10 != 0) s+="   ";
                        else s+="     ";
                s+= p.getName().toString();
                strings.add(s);
            }
            arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
            listView.setAdapter(arrayAdapter);
            Toast.makeText(getContext(), "Players List loaded!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Players> doInBackground(String... params) {
            ArrayList<Players> arrayList = new ArrayList<>();
            try {
                String link = params[0];
                URL url = new URL(link);
                HttpURLConnection mConnection = null;
                mConnection = (HttpURLConnection) url.openConnection();
                mConnection.setRequestMethod("GET");
                mConnection.addRequestProperty("X-Auth-Token", "ef5e9077c09d4b2a90886860eb79ec8c");
                mConnection.connect();
                InputStream inputStream = mConnection.getInputStream();
                ArrayListPlayers arrayListPlayers = new Gson().fromJson(new InputStreamReader(inputStream), ArrayListPlayers.class);
                arrayList = arrayListPlayers.getPlayers();

            } catch (Exception e) {

            }
            return arrayList;
        }
    }
}
