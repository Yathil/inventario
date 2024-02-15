package com.example;

import java.util.Date;

import com.example.models.Dispositivo;
import com.example.models.Inventario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class InventarioController {

  // TABLA DE DISPOSITIVOS
  @FXML
  private TableColumn<Dispositivo, Double> precioDispositivo;

  @FXML
  private TableView<Inventario> tablaDispositivos;

  @FXML
  private TableColumn<Dispositivo, String> tipoDispositivo;
  @FXML
  private TableColumn<Dispositivo, Date> fechaCompraDispositivo;

  @FXML
  private TableColumn<Dispositivo, String> idDispositivo;
  @FXML
  private TableColumn<Dispositivo, String> marcaDispositivo;
  @FXML
  private TableColumn<Dispositivo, String> modeloDispositivo;

  // BOTONES
  @FXML
  private Button addButon;

  @FXML
  private Button imprimirButton;

  @FXML
  private Button midificarButton;

  @FXML
  private MenuItem ordenarFechaAsc;

  @FXML
  private MenuItem ordenarFechaDesc;

  @FXML
  private SplitMenuButton ordenarMenuButton;

  @FXML
  void addDispositivo(ActionEvent event) {
    // Llamar a la ventana de añadir dispositivo
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_dispositivo.fxml"));
      Parent root = (Parent) fxmlLoader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @FXML
  void imprimirDispositivos(ActionEvent event) {
    // Hacer que se imprima la tabla de dispositivos en un archivo txt en:
    // src\main\java\com\example\informes\dispositivos.txt

  }

  @FXML
  void modificarDispositivo(ActionEvent event) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modificar_dispositivo.fxml"));
      Parent root = (Parent) fxmlLoader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  void ordenarFechaAsc(ActionEvent event) {

  }

  @FXML
  void ordenarFechaDesc(ActionEvent event) {

  }

}
