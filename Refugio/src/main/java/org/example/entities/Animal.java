package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "especie", nullable = false)
    private String especie;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "familia_nombre", referencedColumnName = "nombre")
    private Familia familia;

    public Animal() {
    }

    public Animal(String nombre, String especie, int edad, String descripcion, String estado) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
