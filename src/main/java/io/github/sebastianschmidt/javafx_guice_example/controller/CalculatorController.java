package io.github.sebastianschmidt.javafx_guice_example.controller;

import io.github.sebastianschmidt.javafx_guice_example.commons.AbstractController;
import io.github.sebastianschmidt.javafx_guice_example.commons.ControllerFactory;
import io.github.sebastianschmidt.javafx_guice_example.model.CalculatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Objects;

public class CalculatorController extends AbstractController {

    private final ControllerFactory controllerFactory;
    private final CalculatorService calculatorService;

    @FXML
    TextField firstNumberTextField;

    @FXML
    TextField secondNumberTextField;

    @Inject
    public CalculatorController(final ControllerFactory controllerFactory, final CalculatorService calculatorService) {
        this.controllerFactory = Objects.requireNonNull(controllerFactory, "controllerFactory must not be null.");
        this.calculatorService = Objects.requireNonNull(calculatorService, "calculatorService must not be null.");
    }

    @FXML
    public void calculate(final ActionEvent event) {
        try {
            final int result = calculate();
            showResult(result);
        } catch (final Exception ex) {
            showError(ex);
        }
    }

    private int calculate() {
        final int firstNumber = Integer.parseInt(firstNumberTextField.getText());
        final int secondNumber = Integer.parseInt(secondNumberTextField.getText());
        return calculatorService.calculate(firstNumber, secondNumber);
    }

    private void showResult(final int result) throws IOException {

        final ResultController resultController = (ResultController) controllerFactory.loadController("result.fxml");
        resultController.showResult(result);

        final Stage stage = new Stage();
        stage.setTitle("Result");
        stage.initOwner(getStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(resultController.getView()));
        stage.show();

    }

    private void showError(final Exception ex) {

        final Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Result Error");
        alert.setHeaderText("Could not calculate result.");
        alert.setContentText(ex.getClass().getSimpleName() + ": " + ex.getMessage());

        alert.showAndWait();


    }

}
