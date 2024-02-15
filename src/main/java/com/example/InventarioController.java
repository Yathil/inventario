package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.example.models.Dispositivo;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InventarioController {

  // TABLA DE DISPOSITIVOS
  @FXML
  private TableColumn<Dispositivo, Double> precioDispositivo;

  @FXML
  private TableView<Dispositivo> tablaDispositivos;

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

  // lista de dispositivos
  private ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList();

  public ObservableList<Dispositivo> getDispositivos() {
    return dispositivos;
  }

  @FXML
  public void initialize() {
    // vincular la lista a la tabla
    tablaDispositivos.setItems(dispositivos);

    // configurar las columnas
    idDispositivo.setCellValueFactory(new PropertyValueFactory<>("id"));
    marcaDispositivo.setCellValueFactory(new PropertyValueFactory<>("marca"));
    modeloDispositivo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
    tipoDispositivo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

    fechaCompraDispositivo.setCellValueFactory(cellData -> {
      SimpleObjectProperty<Date> property = new SimpleObjectProperty<>();
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      try {
        if (cellData.getValue().getFechaCompra() != null) {
          property.setValue(dateFormat.parse(cellData.getValue().getFechaCompra()));
        }
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return property;
    });
    precioDispositivo.setCellValueFactory(new PropertyValueFactory<>("precio"));
  }

  @FXML
  void addDispositivo(ActionEvent event) {
    // Llamar a la ventana de añadir dispositivo
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_dispositivo.fxml"));
      Parent root = (Parent) fxmlLoader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();

      // obtener el controlador de la nueva ventana
      DispositivoController controller = fxmlLoader.getController();

      // agregar un listener para cuando la ventana se cierre
      stage.setOnHidden(e -> {
        // obtener el nuevo dispositivo del controlador
        Dispositivo nuevoDispositivo = controller.getDispositivo();

        // agregar el nuevo dispositivo a la lista
        if (nuevoDispositivo != null) {
          dispositivos.add(nuevoDispositivo);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  void imprimirDispositivos(ActionEvent event) {
    File file = new File("src/main/java/com/example/informes/dispositivos.txt");
    try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
      for (Dispositivo dispositivo : tablaDispositivos.getItems()) {
        writer.println(dispositivo.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void modificarDispositivo(ActionEvent event) {
    try {
      // Obtén el dispositivo seleccionado
      Dispositivo dispositivoSeleccionado = tablaDispositivos.getSelectionModel().getSelectedItem();

      if (dispositivoSeleccionado != null) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modificar_dispositivo.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        // Obtén el controlador de la nueva ventana y pasa el dispositivo seleccionado
        ModificarDispositivoController controller = fxmlLoader.getController();
        controller.setDispositivo(dispositivoSeleccionado);
        controller.setOnOkClickedListener(dispositivo -> {
          // Actualiza la tabla con el dispositivo modificado
          actualizarTabla(dispositivo);
        });

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
      } else {
        // Muestra un mensaje si no se seleccionó ningún dispositivo
        System.out.println("No se seleccionó ningún dispositivo");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void actualizarTabla(Dispositivo dispositivoModificado) {
    // Encuentra el índice del dispositivo modificado en la lista de dispositivos
    int index = dispositivos.indexOf(dispositivoModificado);

    // Reemplaza el dispositivo en la lista con la versión modificada
    dispositivos.set(index, dispositivoModificado);

    // Refresca la tabla para mostrar los cambios
    tablaDispositivos.refresh();
  }

  @FXML
  void ordenarFechaAsc(ActionEvent event) {
    fechaCompraDispositivo.setComparator(Comparator.naturalOrder());
    tablaDispositivos.getSortOrder().setAll(fechaCompraDispositivo);
  }

  @FXML
  void ordenarFechaDesc(ActionEvent event) {
    fechaCompraDispositivo.setComparator(Comparator.reverseOrder());
    tablaDispositivos.getSortOrder().setAll(fechaCompraDispositivo);

  }

}
