package io.github.sebastianschmidt.javafx_guice_example.model;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int calculate(final int firstNumber, final int secondNumber) {
        return firstNumber + secondNumber;
    }

}
