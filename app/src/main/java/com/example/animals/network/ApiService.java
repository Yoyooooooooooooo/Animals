package com.example.animals.network;

import com.example.animals.model.Animal;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("Service/OpenData/TransService.aspx?UnitId=p9yPwrCs2OtC&IsTransData=1")
    Call<List<Animal>> getAnimals();
}
