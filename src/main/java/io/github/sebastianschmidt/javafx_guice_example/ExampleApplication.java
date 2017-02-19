package io.github.sebastianschmidt.javafx_guice_example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.sebastianschmidt.javafx_guice_example.commons.Controller;
import io.github.sebastianschmidt.javafx_guice_example.commons.ControllerFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExampleApplication extends Application {

    private final ControllerFactory controllerFactory;

    public ExampleApplication() {
        final Injector injector = Guice.createInjector(new ExampleModule());
        controllerFactory = injector.getInstance(ControllerFactory.class);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        final Controller controller = controllerFactory.loadController("calculator.fxml");

        stage.setTitle("JavaFX Guice Example");
        stage.setScene(new Scene(controller.getView()));
        stage.show();

    }

    public static void main(final String... args) {
        ExampleApplication.launch(args);
    }

}
