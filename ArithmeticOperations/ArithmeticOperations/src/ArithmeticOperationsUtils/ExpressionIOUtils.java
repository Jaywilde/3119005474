package ArithmeticOperationsUtils;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ExpressionIOUtils {

    public static String readTxt(String Path) {

        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        StringBuilder inputStringBuilder = null;

        try {
            fileInputStream = new FileInputStream(Path);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));

            inputStringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {                                                                                      //进行字符串的拼接
                inputStringBuilder.append(line);
                line = bufferedReader.readLine();
                if (line != null) {
                    inputStringBuilder.append("\n");
                }
            }
            bufferedReader.close();                                                                                     //关闭资源
            fileInputStream.close();
        } catch (NullPointerException | FileNotFoundException | UnsupportedEncodingException e) {                       //进行简易的异常处理，当文件名不存在时输出相应提示
            System.out.println("路径不存在，请重新检查文件路径");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();                                                                                 //关闭资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assert inputStringBuilder != null;
        return inputStringBuilder.toString();
    }

    public static void writeTxt(String Expression,String txt_WritePath){
        File file = new File(txt_WritePath);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(Expression, 0, Expression.length());
            fileWriter.write("\r\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}