package com.example.mercuryhonorsproject;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }
        FirebaseMessaging.getInstance().subscribeToTopic("CMB_Updates");

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("TOKEN101", "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        Log.d("TOKEN101", token);
                        //Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void lol(View view) {

    Intent intent = new Intent(this, FloodActivity.class);
    startActivity(intent);

    }

    public void unvailableToast(View view) {
        Toast.makeText(MainActivity.this, "UNAVAILABLE STILL IN BETA", Toast.LENGTH_SHORT).show();
    }

    public void sendToContact(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}