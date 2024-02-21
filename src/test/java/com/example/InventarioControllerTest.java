package com.example;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import com.example.models.Dispositivo;
import com.example.models.TipoDispositivo;

public class InventarioControllerTest extends ApplicationTest {

  private DispositivoController controller;
  private InventarioController controller2;

  @Override
  public void start(Stage stage) throws Exception {
    // Cargar la escena de "inventario"
    FXMLLoader Loader = new FXMLLoader(App.class.getResource("inventario.fxml"));
    Parent root = Loader.load();
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();

    // Obtener el controlador de la escena de "inventario"
    InventarioController controller = Loader.getController();

    // Abrir la ventana de "add_dispositivo"
    FXMLLoader Loader2 = new FXMLLoader(App.class.getResource("add_dispositivo.fxml"));
    Parent root2 = (Parent) Loader2.load(); // Aquí estaba el error
    Stage stage2 = new Stage();
    stage2.setScene(new Scene(root2));
    stage2.show();

    // Obtener el controlador de la nueva ventana
    DispositivoController controller2 = Loader2.getController();

    // Abrir la ventana de "modificar_dispositivo"
    FXMLLoader Loader3 = new FXMLLoader(App.class.getResource("modificar_dispositivo.fxml"));
    Parent root3 = (Parent) Loader3.load(); // Aquí estaba el error
    Stage stage3 = new Stage();
    stage3.setScene(new Scene(root3));
    stage3.show();

    // Obtener el controlador de la nueva ventana
    ModificarDispositivoController controller3 = Loader3.getController();
  }

  @BeforeEach
  public void setUp() {

    // Escribe en los campos de texto
    clickOn("#idText").write("123");
    clickOn("#marcaText").write("Marca");
    clickOn("#modeloText").write("Modelo");
    clickOn("#tipoText").write("ORDENADOR");
    clickOn("#fechaCompraText").write("2021-01-01");
    clickOn("#precioText").write("1000");

    // Hacer clic en el botón "Aceptar"
    clickOn("#okButton", MouseButton.PRIMARY);

    // Espera a que se procesen las tareas de la plataforma JavaFX
    WaitForAsyncUtils.waitForFxEvents();

    // Crea un nuevo dispositivo y lo agrega a la lista
    TipoDispositivo tipo = TipoDispositivo.ORDENADOR; // Usa un valor válido de tu enum TipoDispositivo
    Dispositivo dispositivo = new Dispositivo("123", "2021-01-01", 1000.0, tipo, "Marca", "Modelo");
    controller2.getDispositivos().add(dispositivo);
  }

  @Test
  public void testHandleOkButton() {
    // Asegúrate de que la lista de dispositivos no esté vacía
    assertFalse(controller2.getDispositivos().isEmpty());

    // Obtiene el dispositivo de la lista
    Dispositivo dispositivo = controller2.getDispositivos().get(0);

    // Verifica que el dispositivo no sea null
    assertNotNull(dispositivo);

    // Ahora puedes hacer tu afirmación
    assertEquals("123", dispositivo.getId());
    assertEquals("Marca", dispositivo.getMarca());
    assertEquals("Modelo", dispositivo.getModelo());
    assertEquals("ORDENADOR", dispositivo.getTipo().name());
    assertEquals("2021-01-01", dispositivo.getFechaCompra());
    assertEquals(1000, dispositivo.getPrecio());

  }

  @Test
  public void testModificarDispositivo() {
    // Asegúrate de que la lista de dispositivos no esté vacía
    assertFalse(controller2.getDispositivos().isEmpty());

    // Obtiene el dispositivo de la lista
    Dispositivo dispositivo = controller2.getDispositivos().get(0);

    // Verifica que el dispositivo no sea null
    assertNotNull(dispositivo);

    // Selecciona el dispositivo en la interfaz de usuario
    // Esto dependerá de cómo esté diseñada tu interfaz de usuario
    // Aquí hay un ejemplo genérico

    // Borra los campos de texto
    clickOn("#idText").write("");
    clickOn("#marcaText").write("");
    clickOn("#modeloText").write("");
    clickOn("#tipoText").write("");
    clickOn("#fechaCompraText").write("");
    clickOn("#precioText").write("");

    // Escribe en los campos de texto
    clickOn("#idText").write("123");
    clickOn("#marcaText").write("Marca2");
    clickOn("#modeloText").write("Modelo2");
    clickOn("#tipoText").write("ORDENADOR");
    clickOn("#fechaCompraText").write("2021-01-02");
    clickOn("#precioText").write("2000");

    // Hacer clic en el botón "Aceptar"
    clickOn("#okButton", MouseButton.PRIMARY);

    // Obtiene el dispositivo modificado de la lista
    Dispositivo dispositivoModificado = controller2.getDispositivos().get(0);

    // Verifica que el dispositivo modificado no sea null
    assertNotNull(dispositivoModificado);

    // Ahora puedes hacer tu afirmación
    assertEquals("123", dispositivoModificado.getId());
    assertEquals("Marca2", dispositivoModificado.getMarca());
    assertEquals("Modelo2", dispositivoModificado.getModelo());
    assertEquals("ORDENADOR", dispositivoModificado.getTipo());
    assertEquals("2021-01-02", dispositivoModificado.getFechaCompra());
    assertEquals(2000, dispositivoModificado.getPrecio());
  }
}
