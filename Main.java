import OldValue.OldValue;
import Operations.OperationManager;
import Operations.OperationStrategy;
import Operations.Sum;

public class Main {
    public static void main(String[] args) {
//        OldValue oldValue = new OldValue("12p", "2s", "20d");
//        OldValue oldValue1 = new OldValue("4p", "5s", "20d");
//        System.out.printf(String.valueOf(oldValue.getValueInPence()));
//        OperationStrategy sum = new Sum();
//        System.out.printf(String.valueOf(sum.doOperation(oldValue1, oldValue)));
        OperationManager operationManager = new OperationManager();
        System.out.printf(operationManager.doArithmeticExpression("123231p 232s 2d + 123231p 232s 2d + 123231p 232s 2d").toString());
    }


}
