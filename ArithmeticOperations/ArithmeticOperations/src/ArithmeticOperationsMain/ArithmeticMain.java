package ArithmeticOperationsMain;

import ArithmeticOperationsUtils.*;

import java.util.*;

public class ArithmeticMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您想生成的四则运算数值的最大范围(1~？):");
        int ValueRange = sc.nextInt();
        System.out.println("请输入您想生成的四则运算题目的数量:");
        int QuestionNumber = sc.nextInt();

        int mark1 = 0;    //标记生成二元算式的个数
        int mark2 = 0;    //标记生成三元算式的个数
        int mark3 = 0;    //标记生成四元算式的个数

        String[] PolishExpressionSave1 = new String[QuestionNumber];//生成储存逆波兰表达式的数组
        String[] PolishExpressionSave2 = new String[QuestionNumber];
        String[] PolishExpressionSave3 = new String[QuestionNumber];
        String[] QuestionSave1 = new String[QuestionNumber];//生成储存题目的数组
        String[] QuestionSave2 = new String[QuestionNumber];
        String[] QuestionSave3 = new String[QuestionNumber];
        String[] KeySave1 = new String[QuestionNumber];//生成储存答案的数组
        String[] KeySave2 = new String[QuestionNumber];
        String[] KeySave3 = new String[QuestionNumber];

        Stack<String> stack = new Stack<>();
        String[] get = new String[20000];

        for (int i = 1; i <= QuestionNumber; i++) {
            int OperateNumber = RandomUtils.OperatorRandom();   //还原的时候删去 赋值;
            String checktemp = "";//用于检查是否为负数
            if (OperateNumber == 1) {
                Fraction Value1 = RandomUtils.FractionRandom(ValueRange);    //运算数值
                String OpChoose1 = RandomUtils.OpChooseRandom();   //运算符
                Fraction Value2 = RandomUtils.FractionRandom(ValueRange);
                mark1 = mark1 + 1;
                //计算生成的值,生成正则表达式后再计算?
                String Expression1 = Value1 + OpChoose1 + Value2;
                String PolishExpression1 = CalculateUtils.ExpressionChange(Expression1, stack);
                //下面可以达到预期的覆盖功能，但觉得效率不高，因为每遍历一个数组就要覆盖一次最后一位数组；但功能上来讲能够实现
                RepeatCheck.Check(QuestionNumber, mark1, PolishExpressionSave1, QuestionSave1, PolishExpression1, Expression1);
                //下面是消除字符串里面的'[' ']' 和空格
                PolishExpression1 = PolishExpression1.replace("[", "");
                PolishExpression1 = PolishExpression1.replace(" ", "");
                PolishExpression1 = PolishExpression1.replace("]", "");
                //先生成一个栈，然后将逆波兰压入栈，再调用docalculate方法
                List<String> list = Arrays.asList(PolishExpression1.split(","));
                for (int k = 0; k < list.size(); k++) {
                    get[k] = list.get(k);//压入栈
                    stack.push(get[k]);
                }
                //输出结果到答案数组
                String result = CalculateUtils.doCalculation(stack);
                KeySave1[mark1] = result;

                //检测结果是否为负数 如果为负数将舍去
                if(result.contains("-")){
                    mark1=mark1-1;
                    checktemp = result;
                }else{
                    System.out.print("(" + i + ")");
                    System.out.println(Expression1 + "=");
                    System.out.println(KeySave1[mark1]);
                }
            }

            if (OperateNumber == 2) {
                Fraction Value1 = RandomUtils.FractionRandom(ValueRange);    //运算数值
                String OpChoose1 = RandomUtils.OpChooseRandom();   //运算符
                Fraction Value2 = RandomUtils.FractionRandom(ValueRange);
                String OpChoose2 = RandomUtils.OpChooseRandom();
                Fraction Value3 = RandomUtils.FractionRandom(ValueRange);
                mark2 = mark2 + 1;
                String Expression2 = Value1 + OpChoose1 + Value2 + OpChoose2 + Value3;
                //下面可以达到预期的覆盖功能，但觉得效率不高，因为每遍历一个数组就要覆盖一次最后一位数组；但功能上来讲能够实现
                String PolishExpression2 = CalculateUtils.ExpressionChange(Expression2, stack);
                RepeatCheck.Check(QuestionNumber, mark2, PolishExpressionSave2, QuestionSave2, PolishExpression2, Expression2);

                //下面是消除字符串里面的'[' ']' 和空格
                PolishExpression2 = PolishExpression2.replace("[", "");
                PolishExpression2 = PolishExpression2.replace(" ", "");
                PolishExpression2 = PolishExpression2.replace("]", "");
                //先生成一个栈，然后将逆波兰压入栈，再调用docalculate方法
                List<String> list = Arrays.asList(PolishExpression2.split(","));
                for (int k = 0; k < list.size(); k++) {

                    get[k] = list.get(k);//压入栈
                    stack.push(get[k]);
                }
                String result = CalculateUtils.doCalculation(stack);
                KeySave2[mark2] = result;
                //检测结果是否为负数 如果为负数将舍去
                if(result.contains("-")){
                    mark2=mark2-1;
                    checktemp = result;
                }else{
                    System.out.print("(" + i + ")");
                    System.out.println(Expression2 + "=");
                    System.out.println(KeySave2[mark2]);
                }
            }

            if (OperateNumber == 3) {
                Fraction Value1 = RandomUtils.FractionRandom(ValueRange);    //运算数值
                String OpChoose1 = RandomUtils.OpChooseRandom();   //运算符
                Fraction Value2 = RandomUtils.FractionRandom(ValueRange);
                String OpChoose2 = RandomUtils.OpChooseRandom();
                Fraction Value3 = RandomUtils.FractionRandom(ValueRange);
                String OpChoose3 = RandomUtils.OpChooseRandom();
                Fraction Value4 = RandomUtils.FractionRandom(ValueRange);
                mark3 = mark3 + 1;
                String Expression3 = Value1 + OpChoose1 + Value2 + OpChoose2 + Value3 + OpChoose3 + Value4;
                //下面可以达到预期的覆盖功能，但觉得效率不高，因为每遍历一个数组就要覆盖一次最后一位数组；但功能上来讲能够实现
                String PolishExpression3 = CalculateUtils.ExpressionChange(Expression3, stack);
                RepeatCheck.Check(QuestionNumber, mark3, PolishExpressionSave3, QuestionSave3, PolishExpression3, Expression3);
                //下面是消除字符串里面的'[' ']' 和空格
                PolishExpression3 = PolishExpression3.replace("[", "");
                PolishExpression3 = PolishExpression3.replace(" ", "");
                PolishExpression3 = PolishExpression3.replace("]", "");
                //先生成一个栈，然后将逆波兰压入栈，再调用docalculate方法
                List<String> list = Arrays.asList(PolishExpression3.split(","));
                for (int k = 0; k < list.size(); k++) {
                    get[k] = list.get(k);//压入栈
                    stack.push(get[k]);
                }
                String result = CalculateUtils.doCalculation(stack);
                KeySave3[mark3] = result;
 //检测结果是否为负数 如果为负数将舍去
                if(result.contains("-")){
                    mark3=mark3-1;
                    checktemp = result;
                }else{
                    System.out.print("(" + i + ")");
                    System.out.println(Expression3 + "=");
                    System.out.println(KeySave3[mark3]);
                }


            }
            if(checktemp.contains("-")){
                i--;
            }
        }

//将生成的题目存入题目文档

        for (int i = 0; i < mark1; i++)
            ExpressionIOUtils.writeTxt("("+(i+1)+")"+QuestionSave1[i]  +"=", "F:\\桌面\\软件工程\\四则运算\\Questions.txt");
        for (int i = 0; i < mark2; i++)
            ExpressionIOUtils.writeTxt("("+(i+mark1+1)+")"+QuestionSave2[i] + "=", "F:\\桌面\\软件工程\\四则运算\\Questions.txt");
        for (int i = 0; i < mark3; i++)
            ExpressionIOUtils.writeTxt("("+(i+mark2+mark1+1)+")"+QuestionSave3[i] + "=", "F:\\桌面\\软件工程\\四则运算\\Questions.txt");


//将生成的答案存入答案文档

        for (int i = 1; i <=mark1; i++)
            ExpressionIOUtils.writeTxt("("+i+")"+KeySave1[i], "F:\\桌面\\软件工程\\四则运算\\Answers.txt");
        for (int i = 1; i <=mark2; i++)
            ExpressionIOUtils.writeTxt("("+(i+mark1)+")"+KeySave2[i], "F:\\桌面\\软件工程\\四则运算\\Answers.txt");
        for (int i = 1; i <=mark3; i++)
            ExpressionIOUtils.writeTxt("("+(i+mark2+mark1)+")"+KeySave3[i], "F:\\桌面\\软件工程\\四则运算\\Answers.txt");
    }

}