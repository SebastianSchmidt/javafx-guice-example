package io.github.sebastianschmidt.javafx_guice_example;

import com.google.inject.AbstractModule;
import io.github.sebastianschmidt.javafx_guice_example.commons.CommonsModule;
import io.github.sebastianschmidt.javafx_guice_example.model.ModelModule;

public class ExampleModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new CommonsModule());
        install(new ModelModule());
    }

}
