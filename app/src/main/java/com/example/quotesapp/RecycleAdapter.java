package com.example.quotesapp;

import android.annotation.SuppressLint;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.DataHolder>{

    MainActivity mainActivity;
    String[] quote;
    TextToSpeech textToSpeech;

    public RecycleAdapter(MainActivity mainActivity, String[] quote) {
        this.mainActivity = mainActivity;
        this.quote = quote;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.quote_layout,parent,false);

        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, @SuppressLint("RecyclerView") int position) {

        textToSpeech = new TextToSpeech(mainActivity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        holder.textView.setText(quote[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech.speak(quote[position],TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    @Override
    public int getItemCount() {

        return quote.length;
    }

    class DataHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public DataHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
        }
    }
}