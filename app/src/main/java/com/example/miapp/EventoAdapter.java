package com.example.miapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miapp.R;
import com.example.miapp.Evento;
import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {
    private List<Evento> listaEventos;

    public EventoAdapter(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Evento evento = listaEventos.get(position);
        holder.txtNombre.setText(evento.getNombre());
        holder.txtEvento.setText(evento.getTextoEvento());
        holder.imgPerfil.setImageResource(evento.getImagenPerfil());
        holder.imgEvento.setImageResource(evento.getImagenEvento());

        // Opciones "Comentar" y "Agendar" - Solo como elementos visuales
        holder.txtInteraccion.setText("Me gusta");
        holder.txtInsta.setText("Instagram");
        holder.txtFace.setText("Facebook");
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtEvento, txtInteraccion, txtInsta, txtFace;
        ImageView imgPerfil, imgEvento, iconoInteraccion, iconoInsta, iconoFace;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtEvento = itemView.findViewById(R.id.txtEvento);
            imgPerfil = itemView.findViewById(R.id.imgPerfil);
            imgEvento = itemView.findViewById(R.id.imgEvento);
            txtInteraccion = itemView.findViewById(R.id.txtInteraccion);
            iconoInteraccion = itemView.findViewById(R.id.iconoInteraccion);
            txtInsta = itemView.findViewById(R.id.txtInsta);
            iconoInsta = itemView.findViewById(R.id.iconoInsta);
            txtFace = itemView.findViewById(R.id.txtFace);
            iconoFace = itemView.findViewById(R.id.iconoFace);

        }
    }
}
