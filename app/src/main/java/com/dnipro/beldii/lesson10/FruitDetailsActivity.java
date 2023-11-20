package com.dnipro.beldii.lesson10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.dnipro.beldii.lesson10.databinding.ActivityFruitDetailsBinding;
import com.dnipro.beldii.lesson10.model.Fruit;

public class FruitDetailsActivity extends AppCompatActivity {
    private ActivityFruitDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFruitDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showFruitDetails();
    }

    private void showFruitDetails() {
        Bundle fruitBundle = getIntent().getExtras();
        if (fruitBundle == null) return;
        Fruit fruit = (Fruit)fruitBundle.getSerializable("fruit");
        if (fruit != null) {
            binding.fruitNameTextView.setText(fruit.getName());
            binding.fatTextView.setText(Double.toString(fruit.getNutritions().getFat()));
            binding.sugarTextView.setText(Double.toString(fruit.getNutritions().getSugar()));
            binding.caloriesTextView.setText(Double.toString(fruit.getNutritions().getCalories()));
            binding.carbohydratesTextView.setText(Double.toString(fruit.getNutritions().getCarbohydrates()));
            binding.proteinTextView.setText(Double.toString(fruit.getNutritions().getProtein()));
        }
    }
}