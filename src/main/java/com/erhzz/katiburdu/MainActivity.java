package com.erhzz.katiburdu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText editText;
    String read_notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("  Katib Urdu");
        getSupportActionBar().setLogo(R.drawable.ic_actionbarku_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        // setting our main edit text
        editText = findViewById(R.id.editTextTextMultiLine);
        editText.setBackgroundResource(android.R.color.transparent);

        // calling the readData() method
        readData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }
    // Save data inside phone
    public void saveData(){
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        read_notes = editText.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", read_notes);
        editor.apply(); // stores the data
    }
    // callback saved data
    public void readData(){
        sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
        String data = sharedPreferences.getString("key", null);
        editText.setText(data);
    }
}