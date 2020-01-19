package com.example.minhthanh.lfcnews;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.koushikdutta.ion.builder.Builders;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Minh Thanh on 12/3/2017.
 */

public class FragmentTwo extends android.support.v4.app.Fragment{

    ListView listViewMatch;
    MatchAdapter matchAdapter;
    ArrayList<Match> matchArrayList;

    public ArrayList<Match> getMatchArrayList() {
        return matchArrayList;
    }

    public void setMatchArrayList(ArrayList<Match> matchArrayList) {
        this.matchArrayList = matchArrayList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_two, container, false);

        listViewMatch = (ListView) view.findViewById(R.id.listViewMatch);
        matchArrayList = new ArrayList<>();
        matchAdapter = new MatchAdapter(getActivity(), R.layout.match_layout, matchArrayList);
        listViewMatch.setAdapter(matchAdapter);

        new GSonArrayMatches().execute("http://api.football-data.org/v1/teams/64/fixtures");

        return view;

    }

    class GSonArrayMatches extends AsyncTask<String, Void, ArrayList<Match>> {

        ProgressDialog progressDialog = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(), "Wait!", "Loading Liverpool's Matches...");
        }

        @Override
        protected void onPostExecute(ArrayList<Match> matches) {
            super.onPostExecute(matches);
            matchArrayList = matches;
            matchAdapter = new MatchAdapter(getActivity(), R.layout.result_layout, matchArrayList);
            listViewMatch.setAdapter(matchAdapter);
            Toast.makeText(getActivity(), "Successful!", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Match> doInBackground(String... params) {
            ArrayList<Match> matches = new ArrayList<>();
            try {
                String link = params[0];

                URL url = new URL(link);
                HttpURLConnection mConnection = null;
                mConnection = (HttpURLConnection) url.openConnection();
                mConnection.setRequestMethod("GET");
                mConnection.addRequestProperty("X-Auth-Token", "ef5e9077c09d4b2a90886860eb79ec8c");
                mConnection.connect();
                InputStream inputStream = mConnection.getInputStream();
                ArrayListMatches arrayListMatches = new Gson().fromJson(new InputStreamReader(inputStream), ArrayListMatches.class);
                Object _links = arrayListMatches.get_links();
                int count = arrayListMatches.getCount();
                matches = arrayListMatches.getFixtures();
            } catch (Exception e) {

            }
            return matches;
        }
    }
}
