package io.github.sebastianschmidt.javafx_guice_example.commons;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class CommonsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ControllerFactory.class).to(ControllerFactoryImpl.class).in(Singleton.class);
    }

}
