package com.example.eco_proyectoparcial2_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterSaving extends ArrayAdapter {

    public AdapterSaving(Context context, ArrayList<Saving>savings) {
        super(context,0,savings);
    }

    //La UI beia
    @Override
    public View getView(int pos, View row, ViewGroup list) {
        //Clase que hace transfrmación
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.row, list, false);

        Saving saving = (Saving) getItem(pos);

        //Instancias de los elementos del row
        ImageView imageComp = rowView.findViewById(R.id.imageComp);
        TextView nameRow = rowView.findViewById(R.id.nameRow);
        TextView cantRow = rowView.findViewById(R.id.cantRow);
        TextView dateRow = rowView.findViewById(R.id.dateRow);
        TextView frecRow = rowView.findViewById(R.id.frecRow);
        Button progressBtn = rowView.findViewById(R.id.progressBtn);

        nameRow.setText(saving.getName());
        cantRow.setText(saving.getCant());
        dateRow.setText(saving.getDate());
        frecRow.setText(saving.getFreq());

        progressBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(list.getContext(), AddMoneyActivity.class);
                    list.getContext().startActivity(i);
                }
        );


        return rowView;
    }
}
