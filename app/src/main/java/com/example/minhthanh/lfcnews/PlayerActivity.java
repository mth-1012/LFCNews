package com.example.minhthanh.lfcnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

public class PlayerActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        imageView = (ImageView) findViewById(R.id.imageViewPlayer);
        textView = (TextView) findViewById(R.id.textViewPlayer);

        Intent intent = getIntent();
        Players player = (Players) intent.getSerializableExtra("Player");
        textView.setText("Name: " + player.getName() + "\n \n" +
                            "Position: " + player.getPosition() + "\n\n" +
                            "Jersey Number: " + player.getJerseyNumber() + "\n\n" +
                            "D.O.B: " + player.getDateOfBirth() + "\n\n" +
                            "Nationaltiy: " + player.getNationality() + "\n\n" +
                            "Contract Valid Until: " + player.getContractUntil() + "\n\n" +
                            "Market Value: " + player.getMarketValue());
//        String firstName = player.getName().substring(0, player.getName().indexOf(" ")).trim();
//        String lastName = player.getName().substring(player.getName().indexOf(" ")+1).trim();
//        Ion.with(this).load("http://liverpoolfc.wikia.com/wiki/"+firstName+"_"+lastName+"?file="+firstName.charAt(0)+lastName+"2016.jpeg")
//                .withBitmap().intoImageView(imageView);
    }
}
