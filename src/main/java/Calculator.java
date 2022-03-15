import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public int sum(String expression) {
        if ("".equals(expression)) {
            return 0;
        }
        int result = 0;

        String oneDelimArray = expression.replace("\n", ",");

        String[] array = oneDelimArray.split(",");

        for (String s : array) {
            result = result + Integer.parseInt(s);
        }
        return result;

    }
}
