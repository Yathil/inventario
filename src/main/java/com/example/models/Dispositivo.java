package com.example.models;

import java.util.Date;

public class Dispositivo {
  private String id;
  private String fechaCompra;
  private double precio;
  private TipoDispositivo tipo;
  private String marca;
  private String modelo;

  public Dispositivo() {
  }

  public Dispositivo(String id, String fechaCompra, double precio, TipoDispositivo tipo, String marca,
      String modelo) {
    this.id = id;
    this.fechaCompra = fechaCompra;
    this.precio = precio;
    this.tipo = tipo;
    this.marca = marca;
    this.modelo = modelo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFechaCompra() {
    return fechaCompra;
  }

  public void setFechaCompra(String fechaCompra) {
    this.fechaCompra = fechaCompra;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public TipoDispositivo getTipo() {
    return tipo;
  }

  public void setTipo(TipoDispositivo tipo) {
    this.tipo = tipo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  @Override
  public String toString() {
    return "Dispositivo fechaCompra: " + fechaCompra + ", id: " + id + ", marca: " + marca + ", modelo: " + modelo
        + ", precio:" + precio + ", tipo:" + tipo;
  }

}