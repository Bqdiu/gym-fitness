package com.example.gymfitness.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymfitness.R;
import com.example.gymfitness.activities.intro.OnBroading_2a;
import com.example.gymfitness.activities.setup.SetUpStartActivity;
import com.example.gymfitness.data.database.FitnessDB;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LaunchActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private FirebaseAuth firebaseAuth;
    private ExecutorService executorService;

    private SharedPreferences setupPrefs;

    private void addControls() {
        sharedPreferences = getSharedPreferences("remember", MODE_PRIVATE);
        firebaseAuth = FirebaseAuth.getInstance();
        executorService = Executors.newSingleThreadExecutor();
        setupPrefs = getSharedPreferences("UserInformation", MODE_PRIVATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_launch);
        addControls();
        // create database
        executorService.execute(() -> {
            FitnessDB.getInstance(getApplicationContext()).userInformationDAO().getUserInformation();
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int onboarded = sharedPreferences.getInt("status", 0);
                int doneSetUp = setupPrefs.getInt("done", 0);
                if (onboarded == 1) {
                    if(doneSetUp == 1)
                    {
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Intent intent = new Intent(getApplicationContext(), SetUpStartActivity.class);
                        startActivity(intent);
                        finish();
                    }

                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("status", 1);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), OnBroading_2a.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (executorService != null)
            executorService.shutdown();
    }
}
