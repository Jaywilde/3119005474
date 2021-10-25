package ArithmeticOperationsUtils;

public class Fraction {
    public int sign;           // 符号
    public int numerator;      // 分子
    public int denominator;    // 分母

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            try {
                throw new Exception("Denominator cannot be zero.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        sign = numerator * denominator > 0 ? 1 : -1;
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
        simplify();
    }

    //化简分数至最简形式
    public void simplify() {
        if(numerator == 0)
            return;
        int gcd = getGreatestCommonDivider(numerator, denominator); //获得最大公因数
        numerator /= gcd;
        denominator /= gcd;
    }

    //此处用于求分子分母的最大公因数
    public int getGreatestCommonDivider(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        int gcd = (Math.min(a, b));
        for (; gcd >= 1; gcd--)
            if (a % gcd == 0 && b % gcd == 0)
                break;
        return gcd;     //返回最大公因数
    }

    @Override
    //这里我们将随机生成的数值全部视作分数，根据分数化简的结果分为整数和真分数、带分数
    public String toString() {
        int remainder;  //定义一个余数
        remainder = numerator % denominator;    //求分子除以分母的余数
        int naturer = (numerator-remainder) / denominator;  //减去余数后求出整数部分

        if (numerator == 0) //如果分子为0
            return "0";

        if(denominator == 1)    //如果分母为1
            return String.valueOf(numerator);

        if(numerator <= denominator) {  //如果分子小于等于分母，即真分数
            return  numerator + "/" + denominator;
        } else{
            //若分子能给整除分母，则直接返回整数；否则以带分数的形式返回
            if(remainder==0){
                return String.valueOf(naturer);
            }else {
                return numerator + "/" + denominator;
            }
        }
    }

}

