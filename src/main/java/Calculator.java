import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public int sum(String expression) {
        if ("".equals(expression)) {
            return 0;
        }
        int result = 0;

        Character delimValue = ',';
        if (expression.startsWith("//")) {
            delimValue = expression.charAt(2);
            expression = expression.substring(4);
        }

        String oneDelimArray = expression.replace("\n", String.valueOf(delimValue));
        validateStringIncorrectValues(oneDelimArray);
        String[] array = oneDelimArray.split(String.valueOf(delimValue));

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
