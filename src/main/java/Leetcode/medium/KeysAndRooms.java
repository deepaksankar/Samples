package main.java.Leetcode.medium;

import java.util.*;

/**
 * Given a list of rooms and keys to the rooms, find if you can visit all the rooms.
 */
public class KeysAndRooms {
    public static void main(String[] args) {

    }

    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> isVisited = new LinkedHashSet<>();
        isVisited.add(0);
        Stack<Integer> room = new Stack<>();
        room.add(0);

        while(!room.isEmpty()) {
            List<Integer> keys = rooms.get(room.pop());
            for(int key : keys) {
                if(!isVisited.contains(key)) {
                    room.add(key);
                    isVisited.add(key);
                }
            }
        }
        return isVisited.size() == rooms.size();
    }
}
