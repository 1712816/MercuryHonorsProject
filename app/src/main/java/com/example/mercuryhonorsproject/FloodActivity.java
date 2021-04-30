package com.example.mercuryhonorsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class FloodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood2);
    }

    public void reportflood(View view) {
        Uri uri = Uri.parse("https://reportaflood.floodlinescotland.org.uk/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void backHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}