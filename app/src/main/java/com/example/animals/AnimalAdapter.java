package com.example.animals;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animals.model.Animal;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    private List<Animal> animalList;
    private Context context;

    public AnimalAdapter(List<Animal> animalList, Context context) {
        this.animalList = animalList;
        this.context = context;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.rptCountry.setText("縣市: " + animal.getRpt_country());
        holder.maxStayDogNum.setText("最大收容量 (狗): " + animal.getMax_stay_dog_num());
        holder.endDogMaxPercent.setText("狗的最大百分比: " + animal.getEnd_dog_max_percent());
        holder.endCatMaxPercent.setText("貓的最大百分比: " + animal.getEnd_cat_max_percent());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AnimalDetailActivity.class);
            intent.putExtra("animal", animal);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView rptCountry, maxStayDogNum, endDogMaxPercent, endCatMaxPercent;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            rptCountry = itemView.findViewById(R.id.rpt_country);
            maxStayDogNum = itemView.findViewById(R.id.max_stay_dog_num);
            endDogMaxPercent = itemView.findViewById(R.id.end_dog_max_percent);
            endCatMaxPercent = itemView.findViewById(R.id.end_cat_max_percent);
        }
    }
}
