package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey;
    private MenuView dotmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String username = sharedPreferences.getString(usernameKey, "");
            goToActivity2(username);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View view) {
        // Getting username and password from EditText objects
        EditText usernameTextField = (EditText) findViewById(R.id.username);
        String username = usernameTextField.getText().toString();
        EditText passwordTextField = (EditText) findViewById(R.id.password);
        String password = passwordTextField.getText().toString();

        // Creating SharedPreferences object
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);

        // Adding username to SharedPreferences object
        sharedPreferences.edit().putString("username", username).apply();

        // Starting second activity
        goToActivity2(username);
    }

    public void goToActivity2(String s) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }
}