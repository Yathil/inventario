package com.example.models;

import java.util.Date;

import com.example.DispositivoController;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
    long temp;
    temp = Double.doubleToLongBits(precio);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
    result = prime * result + ((marca == null) ? 0 : marca.hashCode());
    result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Dispositivo other = (Dispositivo) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (fechaCompra == null) {
      if (other.fechaCompra != null)
        return false;
    } else if (!fechaCompra.equals(other.fechaCompra))
      return false;
    if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
      return false;
    if (tipo != other.tipo)
      return false;
    if (marca == null) {
      if (other.marca != null)
        return false;
    } else if (!marca.equals(other.marca))
      return false;
    if (modelo == null) {
      if (other.modelo != null)
        return false;
    } else if (!modelo.equals(other.modelo))
      return false;
    return true;
  }

}