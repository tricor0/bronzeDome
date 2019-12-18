package com.example.android.pasiruosimasegzui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    final int min = 0;
    final int max = 100;
    TextView text;
    boolean isStopped = false;

    private View.OnClickListener generatorPositive = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isStopped = false;
            final Handler handler = new Handler();
            final int delay = 500; //milliseconds

            handler.postDelayed(new Runnable() {
                public void run() {

                    //do something
                    if (isStopped) return;
                    else {
                        generatePositive();

                        handler.postDelayed(this, delay);
                    }

                }
            }, delay);
        }


    };
    private View.OnClickListener generatorNegative = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isStopped = false;
            final Handler handler = new Handler();
            final int delay = 500; //milliseconds

            handler.postDelayed(new Runnable() {
                public void run() {

                    //do something
                    if (isStopped) return;
                    else {
                        generateNegative();

                        handler.postDelayed(this, delay);
                    }

                }
            }, delay);
        }


    };
    private View.OnClickListener generatorStopper = new View.OnClickListener() {
        public void onClick(View v) {
            isStopped = true;

        }
    };
    private View.OnClickListener generatorStopperAndSearch = new View.OnClickListener() {
        public void onClick(View v) {
            isStopped = true;

            String q = text.getText().toString();
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, q);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textViewsas);

        Button pirmas = (Button) findViewById(R.id.pirmas);
        pirmas.setOnClickListener(generatorNegative);

        Button antras = (Button) findViewById(R.id.antras);
        antras.setOnClickListener(generatorStopper);

        Button trecias = (Button) findViewById(R.id.trecias);
        trecias.setOnClickListener(generatorPositive);

        Button ketvirtas = (Button) findViewById(R.id.ketvirtas);
        ketvirtas.setOnClickListener(generatorStopperAndSearch);

    }

    private void generateNegative() {

        int random = new Random().nextInt((max - min) + 1) + min - 100;
        String randomString = "" + random;
        text.setText(randomString);

    }

    private void generatePositive() {

        int random = new Random().nextInt((max - min) + 1) + min;
        String randomString = "" + random;
        text.setText(randomString);

    }


}
