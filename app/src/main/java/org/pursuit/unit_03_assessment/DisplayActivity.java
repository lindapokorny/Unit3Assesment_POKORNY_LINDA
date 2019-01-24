package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.model.Planets;
import org.pursuit.unit_03_assessment.network.PlanetsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameTextView = findViewById(R.id.name_text_view);
    private TextView numberTextView = findViewById(R.id.number_text_view);
    private ImageView imageView = findViewById(R.id.planet_image_view);
    private PlanetsService planetsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra("name"));
        numberTextView.setText(intent.getStringExtra("number"));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.go-astronomy.com/images/planets/planet-mercury.jpg")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        planetsService = retrofit.create(PlanetsService.class);
        imageView = (ImageView) retrofit.create(PlanetsService.class);

    }
    public void onClick(View view){
        Call<Planets> planetsCall = planetsService.getPlanetsList();
        planetsCall.enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {

            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {

            }
        });
    }
}

        /*
         * TODO: Add logic that will:
         * TODO 1. Receive values from sending intent
         * TODO 2. Create a TextView instance for the Planet Name
         * TODO 3. Create a TextView instance for the Planet Number count
         * TODO 4. Create an ImageView for the image url
         * TODO 5. Display each value in views - Strings for TextViews, and Picasso for the ImageView
         */

