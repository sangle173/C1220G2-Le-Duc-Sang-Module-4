package service;

import org.springframework.stereotype.Service;

@Service
public class MyCalculatorImpl implements ICalService{
    @Override
    public double calculation(double num1, double num2, String operator) {
        double result=0;
        switch (operator) {
            case "Addition":
                result = num1 + num2;
                break;
            case "Subtraction":
                result = num1 - num2;
                break;
            case "Multiplication":
                result = num1 * num2;
                break;
            case "Division":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Please don't devise for zero");
                }
        }
        return result;
    }
}
