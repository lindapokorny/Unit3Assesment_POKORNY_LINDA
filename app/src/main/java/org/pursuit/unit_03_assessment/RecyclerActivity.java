package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.NameList;
import org.pursuit.unit_03_assessment.network.PlanetsService;
import org.pursuit.unit_03_assessment.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerActivity extends AppCompatActivity {

RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        recyclerView = findViewById(R.id.activity_recycler);

        Call<NameList> call = retrofit.create(PlanetsService.class).getPlanetsList();
        call.enqueue(new Callback<NameList>() {
            @Override
            public void onResponse(Call<NameList> call, Response<NameList> response) {
                recyclerView.setAdapter(new NameListAdapter(response.body().getNameList());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<NameList> call, Throwable t) {

            }
        });


    }
}
