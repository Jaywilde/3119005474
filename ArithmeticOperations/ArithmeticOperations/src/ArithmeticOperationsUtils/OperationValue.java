package ArithmeticOperationsUtils;

public class OperationValue {
    //设置优先级
    public static int getValue(String operation) {
        int result = 0;
        int ADD = 1;
        int SUB = 1;
        int MUL = 2;
        int DIV = 2;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "×":
                result = MUL;
                break;
            case "÷":
                result = DIV;
                break;
            default:
                System.out.println("不存在");
                break;
        }
        return result;
    }

    public static boolean isOperator(String temp) {
        for (Operator o : Operator.values()) {
            if (o.value.equals(temp)) {
                return true;
            }
        }
        return false;
    }
    }

    enum Operator {
        ADD("+", 1), SUBTRACT("-", 1),
        MULTIPLY("×", 2), DIVIDE("÷", 2),
        LEFT_BRACKET("(", 3), RIGHT_BRACKET(")", 3); //括号优先级最高
        String value;
        int priority;

        Operator(String value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        /**
         * 比较两个符号的优先级
         *
         * @param s1
         * @param s2
         * @return c1的优先级是否比c2的高，高则返回正数，等于返回0，小于返回负数
         */
        public static int cmp(String s1, String s2) {
            int p1 = 0;
            int p2 = 0;
            for (Operator o : Operator.values()) {
                if (o.value.equals(s1)) {
                    p1 = o.priority;
                }
                if (o.value.equals(s2)) {
                    p2 = o.priority;
                }
            }
            return p1 - p2;
        }
}
