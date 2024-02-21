package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.models.Dispositivo;
import com.example.models.TipoDispositivo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DispositivoController {
  private Dispositivo dispositivo;

  // BOTONES
  @FXML
  private Button cancelarButton;

  @FXML
  private Button okButton;

  // TEXTFIELDS
  @FXML
  private TextField fechaCompraText;

  @FXML
  private TextField idText;

  @FXML
  private TextField marcaText;

  @FXML
  private TextField modeloText;

  @FXML
  private TextField precioText;

  @FXML
  private TextField tipoText;

  @FXML
  void handleCancelButton(ActionEvent event) {
    // limpiar campos
    idText.clear();
    marcaText.clear();
    modeloText.clear();
    tipoText.clear();
    fechaCompraText.clear();
    precioText.clear();

    // cerrar ventana
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  void handleOkButton(ActionEvent event) {
    // obtener datos de los campos
    String id = idText.getText();
    String marca = marcaText.getText();
    String modelo = modeloText.getText();
    String tipoStr = tipoText.getText();
    String fechaCompra = fechaCompraText.getText();
    String precioStr = precioText.getText();

    // convertir String a double
    double precio = Double.parseDouble(precioStr);

    // convertir String a TipoDispositivo
    TipoDispositivo tipo;
    try {
      tipo = TipoDispositivo.valueOf(tipoStr.toUpperCase());
    } catch (IllegalArgumentException e) {
      System.err.println("Tipo de dispositivo no válido: " + tipoStr);
      return; // Salir del método handleOkButton
    }

    // crear dispositivo
    this.dispositivo = new Dispositivo(id, fechaCompra, precio, tipo, marca, modelo);
    System.out.println(dispositivo);

    // cerrar la ventana
    ((Node) (event.getSource())).getScene().getWindow().hide();
  }

  public Dispositivo getDispositivo() {
    System.out.println(dispositivo);
    return dispositivo;
  }

}
