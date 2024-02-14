package com.example.models;

import java.util.*;

public class Dispositivo {
  private String identificador;
  private Date fechaCompra;
  private double precio;
  private String tipoAtributo;
  private String marca;
  private String modelo;

  public Dispositivo(String identificador, Date fechaCompra, double precio, String tipoAtributo, String marca,
      String modelo) {
    this.identificador = identificador;
    this.fechaCompra = fechaCompra;
    this.precio = precio;
    this.tipoAtributo = tipoAtributo;
    this.marca = marca;
    this.modelo = modelo;
  }

  public void altaDispositivo() {
    // Implement the logic here
  }

  public void bajaDispositivo() {
    // Implement the logic here
  }

  public void modificarDispositivo() {
    // Implement the logic here
  }

  // Getters and Setters for the attributes
}