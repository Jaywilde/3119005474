package ArithmeticOperationsUtils;

public class RandomUtils {

    //OperatorRandom生成的是运算字符（加减乘除号）的个数
    public static int OperatorRandom(){
        int operator_ran = (int)(Math.random()*(3-1+1)+1);     //生成1~3中的随机数
        //System.out.println(ran);
        return operator_ran;
    }

    //User输入一个数值作为max，通过ValueRandom生成的是参与运算数值的范围
    public static int ValueRandom(int max){
        int value_ran = (int)(Math.random()*(max)+1);     //生成的是1~max中的随机数
        //System.out.println(ran);
        return value_ran;
    }

    //OpChooseRandom生成的是运算字符的代号
    //1=dec(43)→加+ 2=dec(45)→减- 3=dec(42)→乘× 4=dec(47)→除÷
    public static String OpChooseRandom(){
        int choose_ran = (int)(Math.random()*(4-1+1)+1);     //生成1~4中的随机数
        //System.out.println(ran);
        //在输出语句中用 (char)RandomUtils.OpChooseRandom() 可把ascii转换为对应的字符输出
        String operate;
        if (choose_ran == 1){operate = "+";}        //不能使用ascii码，因为无法区分除号与分数，所以选择将int改为string，直接输出字符
        else if(choose_ran == 2){operate = "-";}
        else if(choose_ran == 3){operate = "×";}
        else {operate = "÷";}
        return operate;
    }

    public static Fraction FractionRandom(int x){
        int numerator = (int)(Math.random()*(x-1+1)+1);   //分子
        int denominator = (int)(Math.random()*(x-1+1)+1);     //分母
        Fraction fraction=new Fraction(numerator,denominator);
        return fraction;
    }

}
