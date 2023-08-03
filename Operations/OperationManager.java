package Operations;

import OldValue.OldValue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationManager {
    String operation;
    String operationRegex = "[+-/*]";
    String operatorRegex = "(\\d+[p])\\s(\\d+[s])\\s(\\d+[d])";

    public OldValue doArithmeticExpression(String operation) {
        OldValue result = null;
        List<OldValue> values = createOperatorsList(operation);
        List<String> operators =createOperationsList(operation);
        for (int i = 0; i < operators.size(); i++) {
            if(result == null) {
                result = doArithmeticExpression(values.get(i), values.get(i + 1), operators.get(i));
            } else {
                result = doArithmeticExpression(result, values.get(i + 1), operators.get(i));
            }
        }
        return result;
    }

    private OldValue doArithmeticExpression(OldValue oldValue, OldValue oldValue1, String s) {
        switch (s){
            case "+":
                OperationStrategy sum = new Sum();
                return sum.doOperation(oldValue, oldValue1);
            case "-":
                OperationStrategy sub = new Sub();
                return sub.doOperation(oldValue, oldValue1);
            case "/":
                OperationStrategy div = new Div();
                return div.doOperation(oldValue, oldValue1);
            case "*":
                OperationStrategy mul = new Mul();
                return mul.doOperation(oldValue, oldValue1);
        }
        throw new IllegalArgumentException();
    }

    public List<String> createOperationsList(String operation) {
        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile(operationRegex)
                .matcher(operation);
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches;
    }

    public List<OldValue> createOperatorsList(String operation) {
        List<OldValue> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile(operatorRegex)
                .matcher(operation);
        while (m.find()) {
            allMatches.add(oldValueFromString(m.group()));
        }
        return allMatches;
    }

    public OldValue oldValueFromString(String value) {
        Pattern pattern = Pattern.compile(operatorRegex);
        Matcher valued = pattern.matcher(value);
        if (valued.matches()) {
            OldValue oldValue = new OldValue(valued.group(1), valued.group(2), valued.group(3));
            return oldValue;
        } else throw new IllegalArgumentException();
    }

}
