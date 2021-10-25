package ArithmeticOperationsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculateUtils {
    // public static void ExpressionChange(String Expression) {
    public static String ExpressionChange(String Expression,Stack<String> stack) {
        //表达式// 中缀表达式对应的List

//        System.out.println("中缀表达式对应的List");
        List<String> infixExpressionList = toInfixExpressionList(Expression);
//        System.out.println(infixExpressionList);
        //后缀表达式对应的List
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
//        System.out.println("后缀表达式对应的List");
//        System.out.println(suffixExpressionList);
        return String.valueOf(suffixExpressionList);
    }

    /**
     * 计算栈内结果，如果有(,需要将括号拿走
     * @param Stack1
     * @throws Exception
     */
    public static String doCalculation(Stack<String> Stack1) throws NumberFormatException {
        List<String> numList = new ArrayList<>();
        Stack<String> Stack2 = new Stack();
        String operator = "";
        String num1 = "";
        String num2 = "";
        String temp = "";

        for (int i = 0; i < Stack1.size();) {
            Stack2.push(Stack1.pop());
        }

        for (int i = 0; i < Stack2.size();) {
            temp = Stack2.pop();
            if(!OperationValue.isOperator(temp)){
                numList.add(temp);
            }else{
                operator = temp;
                num1 = numList.get(numList.size() - 2);
                num2 = numList.get(numList.size() - 1);
                numList.remove(numList.size() - 2);
                numList.remove(numList.size() - 1);
                String result = result(operator,num1,num2);
                Stack2.push(result);

            }
        }
        return temp;
    }

    //将中缀表达式转换成后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> Operator = new Stack<>();  //符号栈
        List<String> Formula = new ArrayList<>();  //定义用于储存字符的List

        for (String item : ls) {
            //如果是一个数
            if (item.matches("\\d+" + "/" + "\\d+" ) || item.matches("\\d+")) {
                Formula.add(item);
            } else if (item.equals("(")) {
                Operator.push(item);
            } else if (item.equals(")")) {
                while (!Operator.peek().equals( "(" )) {
                    Formula.add(Operator.pop());
                }
                Operator.pop();
            } else {
                while (Operator.size() != 0 && OperationValue.getValue(Operator.peek()) >= OperationValue.getValue(item)) {
                    Formula.add(Operator.pop());
                }
                Operator.push(item);
            }
        }
        while (Operator.size() != 0) {
            Formula.add(Operator.pop());
        }
        return Formula;
    }

    //将中缀表达式转换成list
    public static List<String> toInfixExpressionList(String s) {
        List<String> InfixList = new ArrayList<>();
        int i = 0;
        String str;  //多位数
        char c;
        do {
            //非数字,ASCII码48-57恰好对应数字0-9  47是/ 39是’
            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
            if(( (c = s.charAt(i)) < 47 || (c = s.charAt(i)) > 57) )  {
                InfixList.add("" + c);
                i++;
            } else { //数字，但是考虑到多位数
                str = "";
                while ((i < s.length() && s.charAt(i) >= 47 && (c = s.charAt(i)) <= 57)) {
                    str += c;
                    i++;
                }
                InfixList.add(str);
            }
        } while (i < s.length());
        return InfixList;
    }

    /**
     * 将分数转换成a/b形式并将a、b添加进array数组中
     *
     * @param num 分数
     * @return array 第一个array存储分子，第二个array存储分母
     */
    public static String[] change(String num) {
        String[] array = new String[2];
        if (num.contains("/")) {//是分数
            if (num.contains("'")) {//带真分数
                String[] tarray = num.split("/|'");//根据’/‘或者’进行划分
                int[] sarray = new int[3];
                for (int i = 0; i < 3; i++) {
                    sarray[i] = Integer.parseInt(tarray[i]);
                }
                array[0] = String.valueOf(sarray[0] * sarray[2] + sarray[1]);//a'b/c转化为整数
                array[1] = String.valueOf(sarray[2]);
            } else {
                array = num.split("/");
            }
        } else {
            array[0] = num;
            array[1] = "1";
        }
        return array;
    }

    /**
     * 计算结果
     *
     * @param nowOpera 运算符
     * @param nowNum_1 第一个数
     * @param nowNum_2 第二个数
     * @return 运算结果
     */
    public static String result(String nowOpera, String nowNum_1, String nowNum_2) throws NumberFormatException{
        String result = null;
        //将分子和分母拆开
        int mole_1, deno_1, mole_2, deno_2;
        String[] value_1 = change(nowNum_1);
        mole_1 = Integer.parseInt(value_1[0]);
        deno_1 = Integer.parseInt(value_1[1]);
        String[] value_2 = change(nowNum_2);
        mole_2 = Integer.parseInt(value_2[0]);
        deno_2 = Integer.parseInt(value_2[1]);

        switch (nowOpera) {
            case "+":
                result = CalculateRule.fracAdd(mole_1, deno_1, mole_2, deno_2);
                break;
            case "-":
                result = CalculateRule.fracSub(mole_1, deno_1, mole_2, deno_2);
                break;
            case "×":
                result = CalculateRule.fracMul(mole_1, deno_1, mole_2, deno_2);
                break;
            case "÷":
                result = CalculateRule.fractDiv(mole_1, deno_1, mole_2, deno_2);
                break;
            default:
                break;
        }
        return result;
    }

//    public static int getDenominator(String string){
//        String temp = "/";
//        //查询“/”所在位置
//        int i;
//        for (i = 0; i < string.length(); i++) {
//            if (i <= string.length() - temp.length()) {
//                if (string.indexOf(temp, i) > 0) {
//                    i = string.indexOf(temp, i);//i就是目标字符串的起始位置，末尾位置即为i+getString.length();
//                }
//            }
//        }   //将此步骤创建为新方法
//        return string.length()-i;
//    }
//
//    public static int getNumerator(String string){
//        String temp = "/";
//        //查询“/”所在位置
//        int i;
//        for (i = 0; i < string.length(); i++) {
//            if (i <= string.length() - temp.length()) {
//                if (string.indexOf(temp, i) > 0) {
//                    i = string.indexOf(temp, i);//i就是目标字符串的起始位置，末尾位置即为i+getString.length();
//                }
//            }
//        }   //将此步骤创建为新方法
//        return i;
//    }
}


