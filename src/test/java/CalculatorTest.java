import exception.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void emptyStringShouldBe0() {
        int expected = 0;

        int actual = calculator.sum("");

        assertEquals(expected, actual);
    }

    @Test
    void oneValueShouldReturnSameValue() {
        int expected = 10;

        int actual = calculator.sum("10");

        assertEquals(expected, actual);
    }

    @Test
    void twoValuesShouldReturnSum() {
        int expected = 3;

        int actual = calculator.sum("1,2");

        assertEquals(expected, actual);
    }


    @Test
    void fiveValuesShouldReturnSum() {
        int expected = 5;

        int actual = calculator.sum("1,1,1,1,1");

        assertEquals(expected, actual);
    }

    @Test
    void twoValuesNewLineShouldReturnSum() {
        int expected = 6;

        int actual = calculator.sum("1\n2,3");

        assertEquals(expected, actual);
    }

    @Test
    void oneValueNewLineShouldThrownException() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.sum("1,\n"));
    }

    @Test
    void anotherDelimShouldReturnSum() {
        int expected = 3;

        int actual = calculator.sum("//;\n1;2");

        assertEquals(expected, actual);
    }

    @Test
    void spaceDelimShouldReturnSum() {
        int expected = 3;

        int actual = calculator.sum("// \n1 2");

        assertEquals(expected, actual);
    }

    @Test
    void twoNegativeNumbersShouldThrownException() {
        NegativeNumberException exception = assertThrows(
            NegativeNumberException.class, () -> calculator.sum("-1,-100,1"));

        assertEquals("[-1, -100]", exception.getMessage());
    }

    @Test
    void oneCharDelimInSquareBracketsShouldReturnSum() {
        int expected = 6;

        int actual = calculator.sum("//[*]\n1*2*3");

        assertEquals(expected, actual);
    }

    @Test
    void multipleCharsDelimInSquareBracketsShouldReturnSum() {
        int expected = 6;

        int actual = calculator.sum("//[***]\n1***2***3");

        assertEquals(expected, actual);
    }

    @Test
    void multipleDelimitersShouldReturnSum() {
        int expected = 6;

        int actual = calculator.sum("//[*][%]\n1*2%3");

        assertEquals(expected, actual);
    }

    @Test
    void multipleDelimitersWithAnyLengthShouldReturnSum() {
        int expected = 6;

        int actual = calculator.sum("//[**][%%]\n1**2%%3");

        assertEquals(expected, actual);
    }

    @Test
    public void twoValuesMoreThan1000ShouldReturnOnlyOneValue() {
        int expected = 2;

        int actual = calculator.sum("2,1001");

        assertEquals(expected, actual);
    }



}
