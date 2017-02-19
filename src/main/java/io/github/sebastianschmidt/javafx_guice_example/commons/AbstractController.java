package io.github.sebastianschmidt.javafx_guice_example.commons;

import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.Objects;

public abstract class AbstractController implements Controller {

    private Parent view;

    @Override
    public Parent getView() throws IllegalStateException {

        if (this.view == null) {
            throw new IllegalStateException("view has not been set yet.");
        }

        return view;

    }

    @Override
    public void setView(final Parent view) throws IllegalStateException {

        if (this.view != null) {
            throw new IllegalStateException("view already set.");
        }

        this.view = Objects.requireNonNull(view, "view must not be null.");

    }

    protected Stage getStage() {
        return (Stage) view.getScene().getWindow();
    }

}
