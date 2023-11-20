package com.dnipro.beldii.lesson10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.fruitsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FruitAdapter fruitAdapter = new FruitAdapter(getFruits());
        recyclerView.setAdapter(fruitAdapter);
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
}