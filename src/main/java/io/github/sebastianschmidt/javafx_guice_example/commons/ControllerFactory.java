package io.github.sebastianschmidt.javafx_guice_example.commons;

import java.io.IOException;

public interface ControllerFactory {

    Controller loadController(String fxmlFile) throws IOException;

}
