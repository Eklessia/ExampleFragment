package cl.malditosnakamas.ejemplofragments.curso.domain.model;

public class Integrante {
    private String nombre;
    private String urlImagen;
    private String descripcion;

    public Integrante(String nombre, String urlImagen, String descripcion) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
