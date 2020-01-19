package com.example.minhthanh.lfcnews;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Minh Thanh on 12/3/2017.
 */

public class FragmentOne extends android.support.v4.app.Fragment {

    String link = "https://www.liverpoolfc.com/news.rss";
//    ArrayAdapter arrayAdapter;
    NewsAdapter newsAdapter;
    ListView listView;
    ArrayList<News> arrayListNews;
    TextView textView;
    int nodeListCounter = 0;

    public ArrayList<News> getArrayListNews() {
        return arrayListNews;
    }

    public void setArrayListNews(ArrayList<News> arrayListNews) {
        this.arrayListNews = arrayListNews;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.layout_one, container, false);

        textView = (TextView) view.findViewById(R.id.textView);

        arrayListNews = new ArrayList<News>();
        listView = (ListView)view.findViewById(R.id.listViewNews);
//        arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayListNews);
        newsAdapter = new NewsAdapter(getActivity(), R.layout.news_layout, arrayListNews);
        listView.setAdapter(newsAdapter);

        new ParseNewsXML().execute();

        int[] colors = {0, 0xFFFF0000, 0}; // red for the example
        listView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        listView.setDividerHeight(4);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("CONFIRM");
                builder.setMessage("Do you want to open this news by your default browser?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(arrayListNews.get(position).getLink().toString()));
                        startActivity(browserIntent);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return view;
    }

    class ParseNewsXML extends AsyncTask<Void, Void, ArrayList<News>> {

        ProgressDialog progressDialog = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(), "Wait!", "Loading feeds...");

        }

        @Override
        protected void onPostExecute(ArrayList<News> arrayList) {
            super.onPostExecute(arrayList);
            newsAdapter = new NewsAdapter(getActivity(), R.layout.news_layout, arrayList);
            listView.setAdapter(newsAdapter);
            arrayListNews = arrayList;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    progressDialog.dismiss();
                }
            }, 2000);
//            progressDialog.dismiss();
            Toast.makeText(getActivity(), "Successful!!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList doInBackground(Void... params) {
            ArrayList<News> arrayList = new ArrayList<>();
            try {
                URL url = new URL(link);
                URLConnection urlConnection = url.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                StringBuilder content = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }

                XMLParser xmlParser = new XMLParser();

                Document document = xmlParser.getDomElement(content.toString());

                NodeList nodeList = document.getElementsByTagName("item");

//                nodeListCounter = nodeList.getLength();
                nodeListCounter = 15;

                for(int i=0; i<nodeListCounter; i++) {
                    Element e = (Element) nodeList.item(i);
                    String id = xmlParser.getValue(e,"id");
                    String title = xmlParser.getValue(e,"title");
                    String link = xmlParser.getValue(e,"link");
                    String description = xmlParser.getValue(e, "description");
                    String pubDate = xmlParser.getValue(e, "pubDate");
                    String guid = xmlParser.getValue(e, "guid");
                    String thumb = xmlParser.getValue(e, "thumb");
                    arrayList.add(new News(id, title, thumb, link));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
    }

    public FragmentOne() {

    }
}
