package org.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "familia")
public class Familia {

    @Id
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Animal> animales;

    public Familia() {
    }

    public Familia(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(Set<Animal> animales) {
        this.animales = animales;
    }
}
