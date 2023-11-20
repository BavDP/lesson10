package com.dnipro.beldii.lesson10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dnipro.beldii.lesson10.adapters.FruitAdapter;
import com.dnipro.beldii.lesson10.helpers.JsonReader;
import com.dnipro.beldii.lesson10.model.Fruit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.fruitsList);
        createFruitRecycleList();
    }

    private ArrayList<Fruit> getFruits() {
        InputStream fruitJsonStream = getResources().openRawResource(R.raw.fruits);
        JsonReader jsonReader = new JsonReader(fruitJsonStream);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type fruitsType = new TypeToken<Collection<Fruit>>(){}.getType();
        Collection<Fruit> fruits = gson.fromJson(jsonReader.getAsString(), fruitsType);
        return new ArrayList<>(fruits);
    }

    private void createFruitRecycleList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FruitAdapter fruitAdapter = new FruitAdapter(getFruits());
        fruitAdapter.setClickListener(this::listItemClick);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void listItemClick(View view) {
        Fruit fruit = (Fruit)view.getTag();
        Intent intent = new Intent(this, FruitDetailsActivity.class);
        Bundle fruitBundle = new Bundle();
        fruitBundle.putSerializable("fruit", fruit);
        intent.putExtras(fruitBundle);
        startActivity(intent);
    }
}