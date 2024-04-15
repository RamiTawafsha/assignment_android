package com.example.assignment_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.edtName);
        editTextPassword = findViewById(R.id.edtpassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        // Show welcome message
        showWelcomeMessage();

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Set click listener for login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Attempt login
                attemptLogin();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Any necessary initialization when the activity is about to become visible.
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume any paused UI updates, threads, or processes that were paused or stopped.
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Handle any operations that may pause or interrupt ongoing actions when the activity is no longer in focus.
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Handle clean-up of resources or tasks when the activity is no longer visible.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Perform any final clean-up before the activity is destroyed.
    }

    private void showWelcomeMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Welcome to the app! Enter the Name Rami and The Password 1234")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Close the dialog
                        dialog.dismiss();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void attemptLogin() {
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
}
