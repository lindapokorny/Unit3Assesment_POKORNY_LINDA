package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.model.Planets;


class PlanetsViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView numberTextView;
    private TextView imageTextView;
    private Intent intent;

    public PlanetsViewHolder(@NonNull View itemView){
        super(itemView);
    }
    public void onBind(final Planets planets){
        nameTextView.setText(planets.getName());
        numberTextView.setText(planets.getNumber());
        imageTextView.setText(planets.getImage());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(itemView.getContext(), DisplayActivity.class);
                intent.putExtra("name", planets.getName());
                intent.putExtra("number", planets.getNumber());
                intent.putExtra("image", planets.getImage());
                v.getContext().startActivity(intent);
            }
        });
    }
}
