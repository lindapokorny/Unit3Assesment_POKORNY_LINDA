package org.pursuit.unit_03_assessment.network;

import org.pursuit.unit_03_assessment.model.NameList;

import org.pursuit.unit_03_assessment.model.Planets;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetsService {
    @GET("JDVila/storybook/master/planets.json")
    Call<Planets> getPlanetsList();


}
