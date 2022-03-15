public class Calculator {

    public int sum(String expression) {
        if ("".equals(expression)) {
            return 0;
        }
        int result = 0;
        String[] array = expression.split(",");
        if (array.length > 2) {
            throw new UnsupportedOperationException();
        }
        for (String s : array) {
            result = result + Integer.parseInt(s);
        }
        return result;

    }
}
