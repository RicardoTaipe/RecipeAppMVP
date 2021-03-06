package com.example.recipeappmvp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recipeappmvp.R;
import com.example.recipeappmvp.home.MainActivity;


public class SplashScreenActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
    new Handler(Looper.getMainLooper())
        .postDelayed(() -> {
          startActivity(new Intent(getApplicationContext(), MainActivity.class));
          finish();
        }, 2000);
  }
}