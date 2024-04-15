package com.example.assignment_android;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public Button btnLogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Welcome to the app! Enter the Name Rami and The Password 1234")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        // Close the dialog
                        dialog.dismiss();
                    }
                });

//rami
        AlertDialog alert = builder.create();
        alert.show();


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnLogin =findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the EditText fields
                EditText editTextName = findViewById(R.id.edtName);
                EditText editTextPassword = findViewById(R.id.edtpassword);

                // Get the text from the EditText fields
                String name = editTextName.getText().toString();
                String password = editTextPassword.getText().toString();

                // Check if the name and password match the expected values
                if (name.equals("Rami") && password.equals("1234")) {
                    // If the credentials are correct, open MainActivity2
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);

                } else {
                    // If the credentials are incorrect, display an alert
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Invalid credentials. Please try again.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // Close the dialog
                                    dialog.dismiss();
                                }
                            });
                    // Create and show the dialog
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });

    }
}