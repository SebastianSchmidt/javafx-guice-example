package io.github.sebastianschmidt.javafx_guice_example.commons;

import javafx.scene.Parent;

public interface Controller {

    Parent getView() throws IllegalStateException;

    void setView(Parent view) throws IllegalStateException;

}
