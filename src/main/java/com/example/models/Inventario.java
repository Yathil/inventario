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

}