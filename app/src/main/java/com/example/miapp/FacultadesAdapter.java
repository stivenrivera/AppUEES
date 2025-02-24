package com.example.miapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class FacultadesAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> facultades;
    private HashMap<String, List<String>> carreras;
    private HashMap<String, Integer> valoresCarrera; // Nuevo campo

    public FacultadesAdapter(Context context, List<String> facultades, HashMap<String, List<String>> carreras,
            HashMap<String, Integer> valoresCarrera) {
        this.context = context;
        this.facultades = facultades;
        this.carreras = carreras;
        this.valoresCarrera = valoresCarrera;
    }

    @Override
    public int getGroupCount() {
        return facultades.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return carreras.get(facultades.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return facultades.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return carreras.get(facultades.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String facultadTitulo = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
        }
        TextView txtGroup = convertView.findViewById(android.R.id.text1);
        txtGroup.setText(facultadTitulo);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
            ViewGroup parent) {
        String carrera = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, null);
        }

        TextView txtChild = convertView.findViewById(android.R.id.text1);
        TextView txtValor = convertView.findViewById(android.R.id.text2);
        txtChild.setText(carrera);

        // Mostrar el valor de la carrera
        int valor = valoresCarrera.getOrDefault(carrera, 0);
        txtValor.setText("Valor: $" + valor);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
