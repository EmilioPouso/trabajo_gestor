package controller;

import DAO.CopiaDAO;
import model.Copia;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AppController {

    @FXML
    private TableView<Copia> tablaCopias;

    private final CopiaDAO copiaDAO = new CopiaDAO();

    public void agregarCopia() {
        Copia nuevaCopia = new Copia();
        // Setear datos de la copia
        copiaDAO.agregarCopia(nuevaCopia);
        mostrarAlerta("Copia agregada con éxito");
    }

    public void eliminarCopia() {
        Copia seleccionada = tablaCopias.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            copiaDAO.eliminarCopia(seleccionada.getId());
            mostrarAlerta("Copia eliminada con éxito");
        }
    }

    public void actualizarCopia() {
        Copia seleccionada = tablaCopias.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            copiaDAO.actualizarCopia(seleccionada);
            mostrarAlerta("Copia actualizada con éxito");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}