package com.company;

import java.util.Arrays;

public class Excercise2 {

    public final static String REGEX = "([.,;/\\- ])";  //możliwe separatory: '.' ',' ';' '/' '-' ' '

    public static double stringSplitAndCalculations(String receivedString) {
        if (receivedString != null) {
            double result = 0;
            char lastCharacter = receivedString.charAt(receivedString.length() - 1);

            if (!Character.isDigit(lastCharacter)) {
                receivedString = receivedString.substring(0, receivedString.length() - 1); //jeśli ostatni znak nie jest liczbą to go odcinamy
            }

            String[] arrWithSeparatedNumbers = receivedString.split(REGEX);
            System.out.println("Numbers to calculations: " + Arrays.toString(arrWithSeparatedNumbers));

            switch (lastCharacter) {
                case '-':
                    result = subtraction(arrWithSeparatedNumbers);
                    break;
                case '*':
                    result = multiplication(arrWithSeparatedNumbers);
                    break;
                case '/':
                    result = division(arrWithSeparatedNumbers);
                    break;
                default: //jeśli ostatni znak jest czymkolwiek innym wykonujemy dodawanie
                    result = addition(arrWithSeparatedNumbers);
                    break;
            }
            return result;
        } else {
            throw new NullPointerException("String cannot be null here.");
        }
    }

    private static double subtraction(String[] arrWithSeparatedNumbers) {
        double result;
        result = Double.parseDouble(arrWithSeparatedNumbers[0]); //odejmowanie wszystkiego nastąpi od pierwszej liczby
        for (int i = 1; i < arrWithSeparatedNumbers.length; i++) {
            result -= Double.parseDouble(arrWithSeparatedNumbers[i]);
        }
        System.out.println("We will do subtraction on your numbers");
        return result;
    }

    private static double multiplication(String[] arrWithSeparatedNumbers) {
        double result;
        result = 1; //na potrzeby mnożenia wynik nie moze zaczynać się od zera
        for (String s : arrWithSeparatedNumbers) {
            result *= Double.parseDouble(s);
        }
        System.out.println("We will do multiplication on your numbers");
        return result;
    }

    private static double division(String[] arrWithSeparatedNumbers) {
        double result;
        result = Double.parseDouble(arrWithSeparatedNumbers[0]);
        for (int i = 1; i < arrWithSeparatedNumbers.length; i++) {
            if (Double.parseDouble(arrWithSeparatedNumbers[i]) != 0) {
                result /= Double.parseDouble(arrWithSeparatedNumbers[i]);
            } else {
                throw new ArithmeticException("You can't divide by 0!");
            }
        }
        System.out.println("We will do division on your numbers");
        return result;
    }

    private static double addition(String[] arrWithSeparatedNumbers) {
        Double result = 0.0;
        for (String s : arrWithSeparatedNumbers) {
            result += Double.parseDouble(s);
        }
        System.out.println("We will do addition on your numbers");
        return result;
    }
}
