package com.example.recyclerview2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> wordList;
    private WordListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Button addButton = findViewById(R.id.addButton);

        // Data
        wordList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            wordList.add("Word " + i);
        }

        // Call Adapter
        adapter = new WordListAdapter(wordList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Click Handle
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newWord = "Word " + wordList.size();
                wordList.add(newWord);
                adapter.notifyItemInserted(wordList.size() - 1);
                recyclerView.scrollToPosition(wordList.size() - 1);
            }
        });
    }
}
