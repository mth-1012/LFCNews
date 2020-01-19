package com.example.minhthanh.lfcnews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.koushikdutta.ion.Ion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Minh Thanh on 20/3/2017.
 */

public class MatchAdapter extends ArrayAdapter {

    Context context;
    TextView textViewHome, textViewAway, resultHome, resultAway, result;
    ImageView imageViewHome, imageViewAway;
    int resource;
    String logoURL = null;
    ArrayList<Match> matchArrayList;

    public MatchAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Match> matchArrayList) {
        super(context, resource, matchArrayList);
        this.resource = resource;
        this.context = context;
        this.matchArrayList = matchArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.result_layout, null);
        Match _match = matchArrayList.get(position);

//        result = (TextView) view.findViewById(R.id.textResult);
        textViewHome = (TextView)view.findViewById(R.id.textHome);
        textViewAway = (TextView)view.findViewById(R.id.textAway);
        imageViewAway = (ImageView) view.findViewById(R.id.imageAway);
        imageViewHome = (ImageView) view.findViewById(R.id.imageHome);
        resultAway = (TextView) view.findViewById(R.id.awayResult);
        resultHome = (TextView) view.findViewById(R.id.homeResult);


        String status = _match.getStatus().toString();
        String home = _match.getHomeTeamName().toString();
        String away = _match.getAwayTeamName().toString();

        textViewHome.setText(_match.getHomeTeamName().toString());
        textViewAway.setText(_match.getAwayTeamName().toString());

        if (status.equalsIgnoreCase("FINISHED")) {
//            result.setText(_match.getResult().getGoalsHomeTeam()+"-"+_match.getResult().getGoalsAwayTeam());
            resultHome.setText(_match.getResult().getGoalsHomeTeam()+"");
            resultAway.setText(_match.getResult().getGoalsAwayTeam()+"");
        } else {
            resultHome.setText("?");
            resultAway.setText("?");
//            result.setText("?-?");
        }
        // Bournemouth
        if (home.equalsIgnoreCase("AFC Bournemouth"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/afc-bournemouth-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("AFC Bournemouth"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/afc-bournemouth-logo.png").withBitmap().intoImageView(imageViewAway);
        // Arsenal
        if (home.equalsIgnoreCase("Arsenal FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/arsenal-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Arsenal FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/arsenal-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Burnley
        if (home.equalsIgnoreCase("Burnley FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/burnley-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Burnley FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/burnley-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Chelsea
        if (home.equalsIgnoreCase("Chelsea FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/chelsea-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Chelsea FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/chelsea-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Palace
        if (home.equalsIgnoreCase("Crystal Palace FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/crystal-palace-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Crystal Palace FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/crystal-palace-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Everton
        if (home.equalsIgnoreCase("Everton FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/everton-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Everton FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/everton-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Hull
        if (home.equalsIgnoreCase("Hull City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/hull-city-afc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Hull City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/hull-city-afc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Leicester
        if (home.equalsIgnoreCase("Leicester City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/leicester-city-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Leicester City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/leicester-city-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // LIVERPOOL
        if (home.equalsIgnoreCase("Liverpool FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/liverpool-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Liverpool FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/liverpool-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // City
        if (home.equalsIgnoreCase("Manchester City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/manchester-city-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Manchester City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/manchester-city-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // United
        if (home.equalsIgnoreCase("Manchester United FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/manchester-united-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Manchester United FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/manchester-united-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Middlesbrough
        if (home.equalsIgnoreCase("Middlesbrough FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/middlesbrough-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Middlesbrough FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/middlesbrough-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Southampton
        if (home.equalsIgnoreCase("Southampton FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/southampton-fc-logo.png?w=700&h=").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Southampton FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/southampton-fc-logo.png?w=700&h=").withBitmap().intoImageView(imageViewAway);
        // Stoke
        if (home.equalsIgnoreCase("Stoke City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/stoke-city-fc-logo1.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Stoke City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/stoke-city-fc-logo1.png").withBitmap().intoImageView(imageViewAway);
        // Sunderland
        if (home.equalsIgnoreCase("Sunderland AFC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/sunderland-afc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Sunderland AFC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/sunderland-afc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Swansea
        if (home.equalsIgnoreCase("Swansea City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/swansea-city-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Swansea City FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/swansea-city-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Tottenham
        if (home.equalsIgnoreCase("Tottenham Hotspur FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/tottenham-hotspur-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Tottenham Hotspur FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/tottenham-hotspur-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // Watford
        if (home.equalsIgnoreCase("Watford FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/watford-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("Watford FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/watford-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // West Brom
        if (home.equalsIgnoreCase("West Bromwich Albion FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/west-bromwich-albion-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("West Bromwich Albion FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/west-bromwich-albion-fc-logo.png").withBitmap().intoImageView(imageViewAway);
        // West Ham
        if (home.equalsIgnoreCase("West Ham United FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/west-ham-united-fc-logo.png").withBitmap().intoImageView(imageViewHome);
        if (away.equalsIgnoreCase("West Ham United FC"))
            Ion.with(context).load("https://hdlogo.files.wordpress.com/2016/08/west-ham-united-fc-logo.png").withBitmap().intoImageView(imageViewAway);

        return view;
    }

//    private static class logo {
//        String link;
//        ImageView imagelogo;
//
//        public logo(String link, ImageView imagelogo) {
//            this.link = link;
//            this.imagelogo = imagelogo;
//        }
//
//        public String getLink() {
//            return link;
//        }
//
//        public void setLink(String link) {
//            this.link = link;
//        }
//
//        public ImageView getImagelogo() {
//            return imagelogo;
//        }
//
//        public void setImagelogo(ImageView imagelogo) {
//            this.imagelogo = imagelogo;
//        }
//    }

    class TeamLogoASyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String logoLink = null;
            try {
                String link = params[0];

                URL url = new URL(link);
                HttpURLConnection mConnection = null;
                mConnection = (HttpURLConnection) url.openConnection();
                mConnection.setRequestMethod("GET");
                mConnection.addRequestProperty("X-Auth-Token", "963dd623752f499884fbb06c321392bc");
                mConnection.connect();
                InputStream inputStream = mConnection.getInputStream();
//                URL url = new URL(link);
//                InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(), "UTF-8");
                Team team = new Gson().fromJson(new InputStreamReader(inputStream), Team.class);
                logoLink = team.getCrestUrl().toString();
            } catch (Exception e) {

            }
            return logoLink;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Picasso.with(getContext()).load(s).resize(75,75).into(imageViewHome);
//            Ion.with(getContext())
//                    .load(s)
//                    .withBitmap()
//                    .intoImageView(imageViewHome);
            Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }
    class TeamLogoASyncTask1 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String logoLink = null;
            try {
                String link = params[0];

                URL url = new URL(link);
                HttpURLConnection mConnection = null;
                mConnection = (HttpURLConnection) url.openConnection();
                mConnection.setRequestMethod("GET");
                mConnection.addRequestProperty("X-Auth-Token", "963dd623752f499884fbb06c321392bc");
                mConnection.connect();
                InputStream inputStream = mConnection.getInputStream();
//                URL url = new URL(link);
//                InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(), "UTF-8");
                Team team = new Gson().fromJson(new InputStreamReader(inputStream), Team.class);
                logoLink = team.getCrestUrl().toString();
            } catch (Exception e) {

            }
            return logoLink;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Picasso.with(getContext()).load(s).resize(75,75).into(imageViewAway);
//            Ion.with(getContext())
//                    .load(s)
//                    .withBitmap()
//                    .intoImageView(imageViewAway);
//            Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }
}
