package main.java.GFG;

import java.util.*;

public class LRUCache {
    private Deque<Integer> q;
    private Set<Integer> set;
    private int size;

    public LRUCache(int n) {
        q = new LinkedList<>();
        set = new HashSet<>();
        size = n;
    }

    void refer(int x) {
        if(!set.contains(x)) {
            if(q.size() == size) {
                int temp = q.removeLast();
                set.remove(temp);
            }
        } else {
            int index = 0, i = 0;
            Iterator<Integer> it = q.iterator();
            while(it.hasNext()) {
                if(it.next() == x) {
                    index = i;
                    break;
                }
                i++;
            }
            q.remove(index);
        }
        q.push(x);
        set.add(x);
    }
}
