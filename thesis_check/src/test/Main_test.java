package test;

import org.junit.jupiter.api.Test;
import utils.Hamming;
import utils.SimHash;
import utils.TxtIO;

public class Main_test {
    @Test
    public void Main_test1() {
        String str0 = TxtIO.readTxt("E:\\测试文本\\orig.txt");
        String str1 = TxtIO.readTxt("E:\\测试文本\\orig_0.8_add.txt");
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        System.out.println(similarity);
    }

    @Test
    public void Main_test2() {
        String str0 = TxtIO.readTxt("E:\\测试文本\\orig.txt");
        String str1 = TxtIO.readTxt("E:\\测试文本\\orig_0.8_del.txt");
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        System.out.println(similarity);
    }

    @Test
    public void Main_test3() {
        String str0 = TxtIO.readTxt("E:\\测试文本\\orig.txt");
        String str1 = TxtIO.readTxt("E:\\测试文本\\orig_0.8_dis_1.txt");
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        System.out.println(similarity);
    }

    @Test
    public void Main_test4() {
        String str0 = TxtIO.readTxt("E:\\测试文本\\orig.txt");
        String str1 = TxtIO.readTxt("E:\\测试文本\\orig_0.8_dis_10.txt");
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        System.out.println(similarity);
    }

    @Test
    public void Main_test5() {
        String str0 = TxtIO.readTxt("E:\\测试文本\\orig.txt");
        String str1 = TxtIO.readTxt("E:\\测试文本\\orig_0.8_dis_15.txt");
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        System.out.println(similarity);
    }
}
