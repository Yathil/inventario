package com.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.api.FxAssert;

public class DispositivoControllerTest extends ApplicationTest {

  private DispositivoController controller;

  @Override
  public void start(Stage stage) throws Exception {
    // Cargar la escena de "inventario"
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inventario.fxml"));
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();

    // Abrir la ventana de "add_dispositivo"
    FXMLLoader fxmlLoader2 = new FXMLLoader(App.class.getResource("add_dispositivo.fxml"));
    Parent root2 = (Parent) fxmlLoader2.load();
    Stage stage2 = new Stage();
    stage2.setScene(new Scene(root2));
    stage2.show();

    // Obtener el controlador de la nueva ventana
    controller = fxmlLoader2.getController();
  }

  @Test
  public void testHandleOkButton() {
    // Escribe en los campos de texto
    clickOn("#idText").write("123");
    clickOn("#marcaText").write("Marca");
    clickOn("#modeloText").write("Modelo");
    clickOn("#tipoText").write("Tipo");
    clickOn("#fechaCompraText").write("2021-01-01");
    clickOn("#precioText").write("1000");

    // Haz clic en el botón de OK
    clickOn("#okButton", MouseButton.PRIMARY);

    // Verifica que el dispositivo se haya creado correctamente

    // Esto dependerá de cómo hayas implementado tu controlador
  }
}