import exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int sum(String expression) {
        if ("".equals(expression)) {
            return 0;
        }

        String delimiter = String.valueOf(',');

        if (expression.startsWith("//[")) {
            if (expression.indexOf('[', 3) > -1) {
                String[] delimiters = expression.substring(3, expression.indexOf('\n') - 1).split("\\]\\[");
                expression = expression.substring(expression.indexOf('\n') + 1);
                String oneDelimiterExpression = expression.replace(delimiters[0], delimiters[1]);
                return validateAndSumNumbers(oneDelimiterExpression, delimiters[1]);
            }
            delimiter = expression.substring(3, expression.indexOf(']'));
            expression = expression.substring(expression.indexOf('\n') + 1);
        } else if (expression.startsWith("//")) {
            delimiter = String.valueOf(expression.charAt(2));
            expression = expression.substring(4);
        }

        if (delimiter.contains("*")) {
            delimiter = delimiter.replace("*", "\\*");
        }
        String oneDelimiterExpression = expression.replace("\n", delimiter);
        return validateAndSumNumbers(oneDelimiterExpression, delimiter);
    }

    private int validateAndSumNumbers(String oneDelimiterExpression, String delimiter) {
        validate(oneDelimiterExpression);
        String[] numbers = oneDelimiterExpression.split(delimiter);
        validateNegativeNumbers(numbers);
        return sum(numbers);
    }

    private void validateNegativeNumbers(String[] numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            if (value < 0 ) {
                negativeNumbers.add(value);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException(negativeNumbers.toString());
        }
    }

    private int sum(String[] array) {
        int result = 0;
        for (String s : array) {
            int value = Integer.parseInt(s);
            if (value < 1000) {
                result = result + value;
            }
        }
        return result;
    }

    private void validate(String expression) {
        if (expression.contains(",,")) {
            throw new UnsupportedOperationException();
        }
    }
}
