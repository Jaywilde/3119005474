package ArithmeticOperationsUtils;

public class CalculateRule {
    public static String fracAdd(int first_numerator,int first_denominator,int second_numrator,int second_denominator){
        //以下代码能够在控制台上显示结果
        //需要调用求最大公约数的函数
        //需要调用求最小公倍数的函数
        int denominator;
        int numerator;

        if(first_denominator==second_denominator)  //分母相同时加分子
        {
            denominator=first_denominator;
            numerator=first_numerator+second_numrator;
        }
        else  //否则同分比较分子
        {
            denominator=first_denominator*second_denominator;
            numerator=first_numerator*second_denominator+first_denominator*second_numrator;
        }
        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        String r = numerator+"/"+denominator;
        return r;

    }
    public static String fracSub(int first_numerator,int first_denominator,int second_numrator,int second_denominator){
        //以下代码能够在控制台上显示结果
        //需要调用求最大公约数的函数

        int denominator;
        int numerator;

        if(first_denominator==second_denominator)  //分母相同时加分子
        {
            denominator=first_denominator;
            numerator=first_numerator-second_numrator;
        }
        else  //否则同分比较分子
        {
            denominator=first_denominator*second_denominator;
            numerator=first_numerator*second_denominator-first_denominator*second_numrator;
        }
        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        String r = numerator+"/"+denominator;
        return r;

    }
    public static String fracMul(int first_numerator,int first_denominator,int second_numerator,int second_denominator){
        //以下代码能够在控制台上显示结果
        //需要调用求最大公约数的函数

        int denominator;
        int numerator;


        denominator=first_denominator*second_denominator;
        numerator=first_numerator*second_numerator;

        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        String r = numerator+"/"+denominator;
        return r;

    }
    public static String fractDiv(int first_numerator,int first_denominator,int second_numerator,int second_denominator){
        //以下代码能够在控制台上显示结果
        //需要调用求最大公约数的函数

        int denominator;
        int numerator;

        numerator = first_numerator*second_denominator;
        denominator = first_denominator*second_numerator;



        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        String r = numerator+"/"+denominator;
        return r;

    }
    static int gcd(int x,int y){
        int r;
        while( y!= 0)
        {
            r = x%y;
            x = y;
            y = r;
        }

        return x;

    }

}
