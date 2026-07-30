package com.jerry.empresa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String nombre;        // ← una sola 'm'

    @NotBlank
    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false)     // ← sin @NotBlank, es Double no String
    private Double precio;

    @Column(nullable = false)     // ← sin @NotBlank, es Integer no String
    private Integer stock;        // ← el campo se llamaba stock en el enunciado

    // Constructor vacío - OBLIGATORIO para JPA
    public Producto() { }

    // Constructor con parámetros - los mismos campos que la clase
    public Producto(Long id, String nombre, String descripcion,
                    Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

}