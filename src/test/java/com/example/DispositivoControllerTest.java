package com.example;

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
    // Aquí debes inicializar tu escena y mostrarla en el stage
    controller = new DispositivoController();
    Scene scene = new Scene(controller, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

  @Test
  public void testHandleCancelButton() {
    // Haz clic en el botón de cancelar
    clickOn("#cancelarButton", MouseButton.PRIMARY);

    // Verifica que los campos estén vacíos
    FxAssert.verifyThat("#idText", LabeledMatchers.hasText(""));
    FxAssert.verifyThat("#marcaText", LabeledMatchers.hasText(""));
    FxAssert.verifyThat("#modeloText", LabeledMatchers.hasText(""));
    FxAssert.verifyThat("#serieText", LabeledMatchers.hasText(""));
    FxAssert.verifyThat("#tipoText", LabeledMatchers.hasText(""));
    FxAssert.verifyThat("#estadoText", LabeledMatchers.hasText(""));

    // Haz clic en el botón de OK
    clickOn("#okButton", MouseButton.PRIMARY);

  }

  @Test
  public void testHandleOkButton() {
    // Escribe en los campos de texto
    clickOn("#idText").write("123");
    clickOn("#marcaText").write("Marca");
    // Haz esto para todos los campos

    // Haz clic en el botón de OK
    clickOn("#okButton", MouseButton.PRIMARY);

    // Verifica que el dispositivo se haya creado correctamente
    // Esto dependerá de cómo hayas implementado tu controlador
  }
}