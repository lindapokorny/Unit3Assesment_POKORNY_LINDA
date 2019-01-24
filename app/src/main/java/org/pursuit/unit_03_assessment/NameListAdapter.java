package org.pursuit.unit_03_assessment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_03_assessment.model.NameList;
import org.pursuit.unit_03_assessment.model.Planets;

import java.util.List;

public class NameListAdapter extends RecyclerView.Adapter<PlanetsViewHolder> {
    private List<NameList> nameLists;
    public NameListAdapter(List<NameList> nameList) {
        this.nameLists = nameList;
    }

    @NonNull
    @Override
    public PlanetsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_display, viewGroup, false);
        return new PlanetsViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsViewHolder planetsViewHolder, int i) {
    planetsViewHolder.onBind(Planets.get(i));
    }

    @Override
    public int getItemCount() {
        return nameLists.size();
    }
}
