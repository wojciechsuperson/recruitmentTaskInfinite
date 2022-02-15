package com.company.test;
import com.company.Excercise2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Exercise2Test {

    @ParameterizedTest
    @CsvSource(value = {"2.2;3/4|11.0", "2/2.2|6.0", "2;2.2|6.0", "3;4;5/6.7|25.0"}, delimiter = '|')
    public void stringSplitAndCalculations_stringWithoutOperationCharAtEnd_resultGiveAdditionResult(String input, double expected){

        //given - input

        //when
        double result = Excercise2.stringSplitAndCalculations(input);

        //then
        Assertions.assertEquals(expected,result);

    }

    @ParameterizedTest
    @CsvSource(value = {"2.2;3/4$|11.0", "2/2.2&|6.0", "2;2.2}|6.0", "3;4;5/6.7f|25.0"}, delimiter = '|')
    public void stringSplitAndCalculations_stringWithRandomCharAtEnd_resultGiveAdditionResult(String input, double expected){

        //given - input

        //when
        double result = Excercise2.stringSplitAndCalculations(input);

        //then
        Assertions.assertEquals(expected, result);

    }

    @ParameterizedTest
    @NullSource
    public void stringSplitAndCalculations_argumentIsNULL_throwsNullPointerException(String input){

        //given - input

        //when

        //then
        Assertions.assertThrows(NullPointerException.class, () -> Excercise2.stringSplitAndCalculations(input));

    }
    @ParameterizedTest
    @ValueSource(strings = {"1,0.4;5/","1,2.4;0/","1,0.4;5/","1,2.0;5/"})
    public void stringSplitAndCalculations_argumentToDivideByIs0_throwsArithmeticException(String input){

        //given - input

        //when

        //then
        Assertions.assertThrows(ArithmeticException.class, () -> Excercise2.stringSplitAndCalculations(input));

    }
    @ParameterizedTest
    @ValueSource(strings = {"1,a.4;5+","1,2.4;y-","1,&.4;5/","1,2.3a;5*"})
    public void stringSplitAndCalculations_betweenSeparatorsSmthElseThanNumbers_throwsNumberFormatException(String input){

        //given - intput

        //when

        //then
        Assertions.assertThrows(NumberFormatException.class, () -> Excercise2.stringSplitAndCalculations(input));

    }

    @ParameterizedTest
    @CsvSource(value = {"2.2;3/4*|48.0", "2/2.2-|-2.0", "2;2.2/|0.5", "3;4;5/6.7+|25.0"}, delimiter = '|')
    public void stringSplitAndCalculations_stringOk_resultOk(String input, double expected){

        //given - input

        //when
        double result = Excercise2.stringSplitAndCalculations(input);

        //then
        Assertions.assertEquals(expected,result);

    }


}
