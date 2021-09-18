package utils;

public class Hamming {

    public static int getHamDistance(String simHash1, String simHash2) {
        int ham_distance = 0;
        if (simHash1.length() != simHash2.length()) {
            ham_distance = -1;
        }
        else {
            for (int i = 0; i < simHash1.length(); i++) {
                // 每一位进行比较
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    ham_distance = ham_distance+1;
                }
            }
        }
        return ham_distance;
    }

    public static double getSimilarity(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        int distance = getHamDistance(simHash1, simHash2);
        double index_of_similarity = 0.01 * (100 - distance * 100 / 128);
        // 通过海明距离计算出相似度，并返回
        return index_of_similarity;
    }

}
