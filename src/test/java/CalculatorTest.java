import static
        org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void EmptyStringShouldBe0() {
        int expected = 0;

        int actual = calculator.sum("");

        assertEquals(expected, actual);
    }

    @Test
    public void oneValueShouldReturnSameValue() {
        int expected = 10;

        int actual = calculator.sum("10");

        assertEquals(expected, actual);
    }

    @Test
    public void TwoValuesShouldReturnSum() {
        int expected = 3;

        int actual = calculator.sum("1,2");

        assertEquals(expected, actual);
    }


    @Test
    public void FiveValuesShouldReturnSum() {
        int expected = 5;

        int actual = calculator.sum("1,1,1,1,1");

        assertEquals(expected, actual);
    }

    @Test
    public void TwoValuesNewLineShouldReturnSum() {
        int expected = 6;

        int actual = calculator.sum("1\n2,3");

        assertEquals(expected, actual);
    }
}
