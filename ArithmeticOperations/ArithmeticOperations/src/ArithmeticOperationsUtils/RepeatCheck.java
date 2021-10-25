package ArithmeticOperationsUtils;

import java.beans.Expression;

public class RepeatCheck {
    public static void Check(int QuestionNumber, int mark, String[] PolishExpressionSave, String[] QuestionSave, String PolishExpression,String Expression){
        //标记生成mark个二元类型的算式
        for(int k=0;k<QuestionNumber;k++){
            if(PolishExpressionSave[k] == null){
                QuestionSave[mark] = Expression;
                PolishExpressionSave[mark] = PolishExpression;
            } else if(PolishExpressionSave[k].equals(PolishExpression)){
                //if(Objects.equals(ExpressionSave1[k], CalculateUtils.ExpressionChange(Expression1))){
                mark=mark-1;  //若发现相等，则序号减一，这样子生成下一个的时候，字符数组的序号就可以覆盖
            }else{
                QuestionSave[mark] = Expression;
                PolishExpressionSave[mark] = PolishExpression;
            }
        }
    }
}
