package com.example.assignment_android;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private ListView lsv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lsv = findViewById(R.id.lsv);
        ArrayList<String> arrayList = getList();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity3.this, android.R.layout.simple_list_item_multiple_choice, arrayList);
        lsv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lsv.setAdapter(arrayAdapter);

        lsv.setOnItemClickListener((adapterView, view, i, l) -> {
            String item = (String) adapterView.getItemAtPosition(i);
            showItemDetails(item);
        });
    }

    private ArrayList<String> getList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java" );
        arrayList.add("Ai" );
        arrayList.add("Android" );
        arrayList.add("Algorithm" );
        arrayList.add("Software" );
        arrayList.add("Data Structure" );
        return arrayList;
    }

    private void showItemDetails(String item) {
        // Define the details based on the clicked item
        String details = "";
        switch (item) {
            case "Java":
                details = "Java is a high-level, class-based, object-oriented programming language.";
                break;
            case "Ai":
                details = "AI stands for Artificial Intelligence, it's the simulation of human intelligence processes by machines.";
                break;
            case "Android":
                details = "Android is an open-source mobile operating system developed by Google.";
                break;
            case "Algorithm":
                details = "Algorithms are step-by-step procedures for solving problems.";
                break;
            case "Software":
                details = "Software refers to computer programs and applications.";
                break;
            case "Data Structure":
                details = "Data structures organize and store data efficiently.";
                break;
            default:
                details = "Details not available.";
        }

        // Show details in a dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
        builder.setTitle(item);
        builder.setMessage(details);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
