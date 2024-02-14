package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InventarioController {

  @FXML
  private Button addButon;

  @FXML
  private TableColumn<?, ?> fechaCompraDispositivo;

  @FXML
  private TableColumn<?, ?> idDispositivo;

  @FXML
  private Button imprimirButton;

  @FXML
  private TableColumn<?, ?> marcaDispositivo;

  @FXML
  private Button midificarButton;

  @FXML
  private TableColumn<?, ?> modeloDispositivo;

  @FXML
  private SplitMenuButton ordenarMenuButton;

  @FXML
  private TableView<?> tablaDispositivos;

  @FXML
  private TableColumn<?, ?> tipoDispositivo;

  @FXML
  void addDispositivo(ActionEvent event) {

  }

  @FXML
  void imprimirDispositivos(ActionEvent event) {

  }

  @FXML
  void modificarDispositivo(ActionEvent event) {

  }

  @FXML
  void ordenarDispositivos(ActionEvent event) {

  }

}
