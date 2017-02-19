package io.github.sebastianschmidt.javafx_guice_example.controller;

import io.github.sebastianschmidt.javafx_guice_example.commons.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ResultController extends AbstractController {

    @FXML
    TextField resultTextField;

    public void showResult(final int result) {
        resultTextField.setText(result + "");
    }

    @FXML
    public void close(final ActionEvent event) {
        getStage().close();
    }

}
