package com.example.miapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miapp.R;
import com.example.miapp.Publicacion;
import java.util.List;

public class PublicacionAdapter extends RecyclerView.Adapter<PublicacionAdapter.ViewHolder> {
    private List<Publicacion> listaPublicaciones;

    public PublicacionAdapter(List<Publicacion> listaPublicaciones) {
        this.listaPublicaciones = listaPublicaciones;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publicacion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Publicacion publicacion = listaPublicaciones.get(position);
        holder.txtNombre.setText(publicacion.getNombre());
        holder.txtPublicacion.setText(publicacion.getTextoPublicacion());
        holder.imgPerfil.setImageResource(publicacion.getImagenPerfil());
        holder.imgPublicacion.setImageResource(publicacion.getImagenPublicacion());

        // Opciones "Comentar" y "Agendar" - Solo como elementos visuales
        holder.txtAgendar.setText("Agendar");
    }

    @Override
    public int getItemCount() {
        return listaPublicaciones.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtPublicacion, txtComentar, txtAgendar;
        ImageView imgPerfil, imgPublicacion, iconoComentar, iconoAgendar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPublicacion = itemView.findViewById(R.id.txtPublicacion);
            imgPerfil = itemView.findViewById(R.id.imgPerfil);
            imgPublicacion = itemView.findViewById(R.id.imgPublicacion);
            txtAgendar = itemView.findViewById(R.id.txtAgendar);
            iconoAgendar = itemView.findViewById(R.id.iconoAgendar);
        }
    }
}
