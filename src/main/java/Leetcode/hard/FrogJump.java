package main.java.Leetcode.hard;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canJump(stones));
    }

    static boolean canJump(int[] stones) {
        int numOfStones = stones.length;
        for (int i = 3; i < numOfStones; i++) {
            if (stones[i] > stones[i-1]*2) {
                return false;
            }
        }
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        Set<Integer> stoneSet = new HashSet<>();
        for(int stone : stones) {
            stoneSet.add(stone);
        }

        int lastStone = stones[numOfStones-1];

        positions.add(0);
        jumps.add(0);

        while(!positions.isEmpty()) {
            int position = positions.pop();
            int jump = jumps.pop();

            for (int i = jump - 1; i <= jump + 1; i++) {
                if (i <= 0) {
                    continue;
                }
                int nextPos = position + i;

                if (nextPos == lastStone) {
                    return true;
                } else if(stoneSet.contains(nextPos)) {
                    positions.add(nextPos);
                    jumps.add(i);
                }
            }
        }
        return false;
    }
}
