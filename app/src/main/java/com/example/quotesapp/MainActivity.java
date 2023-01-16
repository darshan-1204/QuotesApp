package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] quote = new String[]{"You only live once, but if you do it right, once is enough.",
            "In three words I can sum up everything I've learned about life: It goes on.",
            "As a well-spent day brings happy sleep, so a life well spent brings happy death.",
            "Remember no one can make you feel inferior without your consent.",
            "Your worth consists in what you are and not in what you have.",
            "Be who you are and say what you feel, because those who mind don’t matter and those who matter don’t mind.",
            "Two roads diverged in a wood, and I took the one less traveled by, And that has made all the difference.",
            "What you do speaks so loudly that I cannot hear what you say."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        RecycleAdapter adapter = new RecycleAdapter(MainActivity.this, quote);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}