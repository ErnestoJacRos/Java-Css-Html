package com.jacros.app.jardin;

import com.jacros.app.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    String jugar (Persona persona){
        return persona.lanzarPelota();
    }
}
