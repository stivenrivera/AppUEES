package com.example.miapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import android.graphics.Color;

public class HorariosAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> recorridos;
    private HashMap<String, List<String>> horarios;

    public HorariosAdapter(Context context, List<String> recorridos, HashMap<String, List<String>> horarios) {
        this.context = context;
        this.recorridos = recorridos;
        this.horarios = horarios;
    }

    @Override
    public int getGroupCount() {
        return recorridos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return horarios.get(recorridos.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return recorridos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return horarios.get(recorridos.get(groupPosition)).get(childPosition);
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
        String tituloRecorrido = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(tituloRecorrido);
        textView.setTextSize(18);
        textView.setPadding(50, 10, 10, 10);

        // Cambio de fondo o estilo, si lo deseas
        if (isExpanded) {
            convertView.setBackgroundColor(Color.parseColor("#800000"));
        } else {
            convertView.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
            ViewGroup parent) {
        String horario = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(horario);
        textView.setPadding(80, 10, 10, 10);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true; // O false si no deseas permitir la selección de hijos
    }
}
