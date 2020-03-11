package com.example.androidbeginner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started...");

        TextView textView = findViewById(R.id.textView);
        textView.setText("This is my first app");

        //Extracting info from textview
        String txtView = textView.getText().toString();

        Log.d(TAG, "onCreate: " + txtView);

        Button buttonOne = findViewById(R.id.btnOne);
        Button buttonTwo = findViewById(R.id.btnTwo);

        Button btnNavToSecond = findViewById(R.id.btnGoToSecondScreen);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked Button One");
                toastMessage("Clicked Button One");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked Button Two");
                toastMessage("Clicked Button Two");
            }
        });

        ImageView imgView = findViewById(R.id.firstImage);
        int imageResource = getResources().getIdentifier("@drawable/male_profile", "@drawable/ic_launcher_background", this.getPackageName());
        imgView.setImageResource(imageResource);

        btnNavToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked Button Nav To Second...");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
