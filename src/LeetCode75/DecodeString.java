package LeetCode75;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    int i = 0; // global variable
    public String decodeStringUsingRecursion(String s) {
        int n = 0;
        StringBuilder resultSB = new StringBuilder();
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) n = n * 10 + s.charAt(i++) - '0';
                i++;	// '['
                String nestedS = decodeStringUsingRecursion(s);
                while (n > 0) {
                    resultSB.append(nestedS);
                    n--;
                }
            } else if (Character.isLetter(s.charAt(i))) resultSB.append(s.charAt(i++));
            else if (s.charAt(i++) == ']') return resultSB.toString();
        }
        return resultSB.toString();
    }

    public String decodeStringUsingRecursionAndDeque(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return helper(queue);
    }

    public String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c= queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) sb.append(sub);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
