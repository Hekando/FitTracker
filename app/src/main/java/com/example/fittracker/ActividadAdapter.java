package com.example.fittracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class ActividadAdapter extends RecyclerView.Adapter<ActividadAdapter.ActividadViewHolder> {

    ArrayList<ActividadModel> datos;

    static class ActividadViewHolder extends RecyclerView.ViewHolder
    {
        final TextView txtTipo ;
        final TextView txtIntensidad ;
        final RatingBar txtRating;
        final TextView txtAspectos;

        ActividadViewHolder (@NonNull View itemView)
        {
            super(itemView);

            txtTipo = itemView.findViewById(R.id.txt_tipo);
            txtIntensidad = itemView.findViewById(R.id.txt_intensidad);
            txtRating = itemView.findViewById(R.id.txt_rating);
            txtAspectos = itemView.findViewById(R.id.txt_aspectos);
        }
    }

    public ActividadAdapter (ArrayList<ActividadModel> datos_actividad)
    {
        datos = datos_actividad;
    }

    @Override
    public ActividadViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType )
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_actividad, viewGroup, false);
        return new ActividadViewHolder(view);
    }

    public void onBindViewHolder(ActividadViewHolder viewHolder, int posicion_actual)
    {
        ActividadModel dato_actual = datos.get(posicion_actual);

        viewHolder.txtTipo.setText(dato_actual.tipo);
        viewHolder.txtIntensidad.setText(dato_actual.intensidad);
        viewHolder.txtRating.setRating(Float.parseFloat(dato_actual.rating));
        viewHolder.txtAspectos.setText(dato_actual.aspectos);
    }

    @Override
    public int getItemCount()
    {
        return datos.toArray().length;
    }

}
