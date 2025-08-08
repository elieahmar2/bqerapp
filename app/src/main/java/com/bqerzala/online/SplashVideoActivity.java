package com.bqerzala.online;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SplashVideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // جرب تفتح MainActivity فورًا بدون أي فيديو
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
