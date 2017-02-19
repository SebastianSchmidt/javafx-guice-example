package io.github.sebastianschmidt.javafx_guice_example.commons;

import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ControllerFactoryImpl implements ControllerFactory {

    private static final String RESOURCE_PREFIX = "/io/github/sebastianschmidt/javafx_guice_example/";

    private final Injector injector;

    @Inject
    public ControllerFactoryImpl(final Injector injector) {
        this.injector = Objects.requireNonNull(injector, "injector must not be null.");
    }

    @Override
    public Controller loadController(final String fxmlFile) throws IOException {

        Objects.requireNonNull(fxmlFile, "fxmlFile must not be null.");

        final URL fxmlFileUrl = getClass().getResource(RESOURCE_PREFIX + fxmlFile);

        final FXMLLoader loader = new FXMLLoader(fxmlFileUrl);
        loader.setControllerFactory(injector::getInstance);

        final Parent view = loader.load();
        final Controller controller = loader.getController();
        controller.setView(view);

        return controller;

    }

}
