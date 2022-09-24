public class CalculatorOperations {

    private double result = 0;
    public String returnValue;

    public String calculateResult(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                result = num1 + num2;
                returnValue = String.valueOf(result);
                break;
            case '-':
                result = num1 - num2;
                returnValue = String.valueOf(result);
                break;
            case '*':
                result = num1 * num2;
                returnValue = String.valueOf(result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    returnValue = String.valueOf(result);
                }
                break;
        }
        return returnValue;
    }
}
