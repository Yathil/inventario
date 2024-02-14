package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
  private List<Dispositivo> listaDispositivos;
  private int ordenacion;
  private String rutaImpresion;

  public Inventario() {
    this.listaDispositivos = new ArrayList<>();
    this.ordenacion = 0;
    this.rutaImpresion = "";
  }

  public void mostrarDispositivos() {
    // Implement the logic to display devices
  }

  public void ordenarDispositivosFecha(int tipoOrdenacion) {
    // Implement the logic to sort devices by date
  }

  public void imprimirDispositivos() {
    // Implement the logic to print devices to a txt file
  }
}