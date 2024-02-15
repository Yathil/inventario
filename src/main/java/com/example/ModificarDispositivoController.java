package com.example;

import com.example.models.Dispositivo;
import com.example.models.TipoDispositivo;
import com.example.models.OnOkClickedListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificarDispositivoController {
  private OnOkClickedListener listener;
  @FXML
  private Button cancelarButton;

  @FXML
  private TextField fechaCompraText;

  @FXML
  private TextField idText;

  @FXML
  private TextField marcaText;

  @FXML
  private TextField modeloText;

  @FXML
  private Button okButton;

  @FXML
  private TextField precioText;

  @FXML
  private TextField tipoText;

  private Dispositivo dispositivo;

  public void setDispositivo(Dispositivo dispositivo) {
    this.dispositivo = dispositivo;
    idText.setText(String.valueOf(dispositivo.getId()));
    marcaText.setText(dispositivo.getMarca());
    modeloText.setText(dispositivo.getModelo());
    precioText.setText(String.valueOf(dispositivo.getPrecio()));
    tipoText.setText(dispositivo.getTipo().toString()); // Convierte TipoDispositivo a String
    fechaCompraText.setText(dispositivo.getFechaCompra().toString());
  }

  @FXML
  void handleCancelButton(ActionEvent event) {
    // Cierra la ventana sin guardar los cambios
    ((Node) (event.getSource())).getScene().getWindow().hide();
  }

  public void setOnOkClickedListener(OnOkClickedListener listener) {
    this.listener = listener;
  }

  @FXML
  void handleOkButton(ActionEvent event) {
    // Modifica el dispositivo con los datos ingresados
    dispositivo.setId(idText.getText());
    dispositivo.setMarca(marcaText.getText());
    dispositivo.setModelo(modeloText.getText());
    dispositivo.setPrecio(Double.parseDouble(precioText.getText()));
    dispositivo.setTipo(TipoDispositivo.valueOf(tipoText.getText()));
    dispositivo.setFechaCompra(fechaCompraText.getText());

    // Notifica al listener de que se hizo clic en OK
    if (listener != null) {
      listener.onOkClicked(dispositivo);
    }

    // Cierra la ventana
    ((Node) (event.getSource())).getScene().getWindow().hide();
  }

}
