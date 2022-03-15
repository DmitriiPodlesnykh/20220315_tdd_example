import exception.NegativeNumberException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int sum(String expression) {
        if ("".equals(expression)) {
            return 0;
        }
        Character delimValue = ',';
        if (expression.startsWith("//")) {
            delimValue = expression.charAt(2);
            expression = expression.substring(4);
        }

        String oneDelimString = expression.replace("\n", String.valueOf(delimValue));
        validateStringIncorrectValues(oneDelimString);

        String[] array = oneDelimString.split(String.valueOf(delimValue));
        List<Integer> negativeValues = new ArrayList<>();
        for (String s : array) {
            int value = Integer.parseInt(s);
            if (value < 0 ) {
                negativeValues.add(value);
            }
        }
        if (!negativeValues.isEmpty()) {
            throw new NegativeNumberException(negativeValues.toString());
        }

        return calculateResult(oneDelimString, delimValue);
    }

    private int calculateResult(String oneDelimString, Character delimValue) {
        int result = 0;
        String[] array = oneDelimString.split(String.valueOf(delimValue));
        for (String s : array) {
            result = result + Integer.parseInt(s);
        }
        return result;
    }

    private void validateStringIncorrectValues(String oneDelimArray) {
        if (oneDelimArray.contains(",,")) {
            throw new UnsupportedOperationException();
        }


    }
}
