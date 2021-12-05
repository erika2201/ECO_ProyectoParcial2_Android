package com.example.eco_proyectoparcial2_android;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterSaving extends BaseAdapter {

    //Data
    private ArrayList<Saving>savings;

    public AdapterSaving() {
        savings = new ArrayList<>();
    }

    public void addSaving(Saving saving){
        savings.add(saving);
        notifyDataSetChanged();
    }

    public void clear(){
        savings.clear();
        notifyDataSetChanged();
    }

    @Override //Cuantos ahorros hay
    public int getCount() {
        return 0;
    }

    @Override //Posicion de un ahorro dentro de la lista
    public Object getItem(int pos) {
        return savings.get(pos);
    }

    @Override //El adaptador diferencia entre los elementos
    public long getItemId(int pos) {
        return pos;
    }

    //La UI beia
    @Override
    public View getView(int pos, View row, ViewGroup list) {
        LayoutInflater inflater = LayoutInflater.from(list.getContext());
        View rowView = inflater.inflate(R.layout.row, null);

        Saving saving = savings.get(pos);

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
       // frecRow.setText(saving.getFreq());

        progressBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(list.getContext(), AddMoneyActivity.class);
                    list.getContext().startActivity(i);
                }
        );


        return rowView;
    }
}
