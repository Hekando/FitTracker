package com.example.fittracker;

public class ActividadModel {
    public String tipo;
    public String intensidad;
    public String rating ;
    public String aspectos;

    public ActividadModel(String _tipo, String _intensidad, String _rating, String _aspectos)
    {
        tipo = _tipo;
        intensidad = _intensidad;
        rating = _rating;
        aspectos = _aspectos;
    }
}
