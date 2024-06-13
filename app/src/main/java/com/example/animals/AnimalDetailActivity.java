package com.example.animals;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.animals.model.Animal;

public class AnimalDetailActivity extends AppCompatActivity {
    private TextView rptCountry, maxStayDogNum, maxStayCatNum, endDogMaxPercent, endCatMaxPercent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        rptCountry = findViewById(R.id.rpt_country);
        maxStayDogNum = findViewById(R.id.max_stay_dog_num);
        maxStayCatNum = findViewById(R.id.max_stay_cat_num);
        endDogMaxPercent = findViewById(R.id.end_dog_max_percent);
        endCatMaxPercent = findViewById(R.id.end_cat_max_percent);

        Animal animal = (Animal) getIntent().getSerializableExtra("animal");
        if (animal != null) {
            rptCountry.setText(animal.getRpt_country());
            maxStayDogNum.setText("最大收容量 (狗): " + animal.getMax_stay_dog_num());
            maxStayCatNum.setText("最大收容量 (貓): " + animal.getMax_stay_cat_num());
            endDogMaxPercent.setText("狗的最大百分比: " + animal.getEnd_dog_max_percent());
            endCatMaxPercent.setText("貓的最大百分比: " + animal.getEnd_cat_max_percent());
        }
    }
}