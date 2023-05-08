package com.example.calculator.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.calculator.R;

import java.util.ArrayList;

public class CalculationAdapter extends ArrayAdapter<CalculationClass> {
    public CalculationAdapter(Context context, ArrayList<CalculationClass> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_history, parent, false);
        }

        // Get the data item for this position
        CalculationClass solutionResult = getItem(position);

        // Lookup view for data population
        TextView solution = (TextView) convertView.findViewById(R.id.itemSolution);
        TextView result = (TextView) convertView.findViewById(R.id.itemResult);
        // Populate the data into the template view using the data object
        solution.setText(solutionResult.getSolution());
        result.setText(solutionResult.getResult());
        // Return the completed view to render on screen
        return convertView;
    }
}
