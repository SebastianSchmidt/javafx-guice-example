package io.github.sebastianschmidt.javafx_guice_example.model;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ModelModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CalculatorService.class).to(CalculatorServiceImpl.class).in(Singleton.class);
    }

}
