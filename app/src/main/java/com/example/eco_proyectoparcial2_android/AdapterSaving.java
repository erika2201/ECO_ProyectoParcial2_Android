package com.example.eco_proyectoparcial2_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class AdapterSaving extends BaseAdapter {

    //Data
    private ArrayList<Saving>savings;

    public AdapterSaving() {
        savings = new ArrayList<>();
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
        return null;
    }
}
