package cl.malditosnakamas.ejemplofragments.curso.domain.model;

import java.util.List;

public class Curso {
    private String nombre;
    private List<Integrante> integrantes;

    public Curso(String nombre, List<Integrante> integrantes) {
        this.nombre = nombre;
        this.integrantes = integrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
}
