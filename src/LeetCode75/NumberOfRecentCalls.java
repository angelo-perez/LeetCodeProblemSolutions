package LeetCode75;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    public Queue<Integer> q;

    public NumberOfRecentCalls() {
        this.q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        int startTime = t - 3000; // [startTime, t]
        while(q.peek() < startTime){
            q.poll();
        }
        return q.size();
    }

    public static void testNumberOfRecentCalls(){
        NumberOfRecentCalls obj = new NumberOfRecentCalls();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}
