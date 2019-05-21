package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        List<Integer> out = partitionLabels("abababacccdcdefefef");
        System.out.println(out);
    }

    static List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> partitions = new ArrayList<>();
        int[] lastIndexes = new int[26];

        for(int i = 0; i < S.length(); i++) {
            lastIndexes[S.charAt(i)-'a'] = i; //have the last end point for every character
        }

        int i = 0;

        while( i < S.length()) {
            int end = lastIndexes[S.charAt(i)-'a'];
            int j;
            for(j = i; j < end; j++) {
                end = Math.max(end, lastIndexes[S.charAt(j)-'a']);
            }
            partitions.add(j-i+1);
            i = j+1;
        }

        return partitions;
    }
}
