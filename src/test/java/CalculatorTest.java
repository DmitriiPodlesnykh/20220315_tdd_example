import static
        org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void ThreeValuesShouldThrownException() {
        int expected = 3;

        assertThrows(UnsupportedOperationException.class, () ->  calculator.sum("1,2, 3"));
    }

}
