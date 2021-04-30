package com.example.mercuryhonorsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }

    public void backHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void callEmergency(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:999"));
        startActivity(intent);
    }

    public void callSwitchboard(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:101"));
        startActivity(intent);
    }

    public void callAberdeenEmergency(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01224241500"));
        startActivity(intent);
    }

    public void callAberdeenCityCare(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01224693936"));
        startActivity(intent);
    }

    public void callCMBCCResilience(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01224864925"));
        startActivity(intent);
    }

    public void callAberdeenSevereWeather(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:08456080919"));
        startActivity(intent);
    }

    public void callGasEmergency(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0800111999"));
        startActivity(intent);
    }

    public void callScottishElectricEmergency(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0800300999"));
        startActivity(intent);
    }

    public void callScottishWater(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:08000778778"));
        startActivity(intent);
    }

    public void callSEPA(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:03459881188"));
        startActivity(intent);
    }

    public void callAPHA(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01467626610"));
        startActivity(intent);
    }
}