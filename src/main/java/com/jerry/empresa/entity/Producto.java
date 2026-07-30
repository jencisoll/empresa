package com.jerry.empresa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.experimental.PackagePrivate;

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PackagePrivate
    private Long id;
    private String nombre;
    private String descripcion;

}
