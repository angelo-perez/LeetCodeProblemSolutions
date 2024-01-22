import LeetCode75.*;
import LeetcodeProblems.FindFirstPalindromicStringInTheArray;
import LeetcodeProblems.OnlineElection;
import LeetcodeProblems.TwoSum;
import csjodo_dsa.*;
import other_algo.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        FindFirstPalindromicStringInTheArray.testFirstPalindrome();
    }

//

    public static void testRobot(){
        Robot r1 = new Robot();
        r1.setName("Tom");
        r1.setColor("red");
        r1.setWeight(30);
        r1.introduceSelf();
        System.out.println("My color is " + r1.getColor());
        System.out.println("I weigh " + r1.getWeight() + "kg");

        System.out.println("\n");

        Robot r2 = new Robot();
        r2.setName("Jerry");
        r2.setColor("blue");
        r2.setWeight(40);
        r2.introduceSelf();
        System.out.println("My color is " + r2.getColor());
        System.out.println("I weigh " + r2.getWeight() + "kg");

        System.out.println("\n");

        Robot r3 = new Robot("Bumblebee", "yellow", 300);
        r3.introduceSelf();
        System.out.println("My color is " + r3.getColor());
        System.out.println("I weigh " + r3.getWeight() + "kg");
    }

    public static void testRobotAndPerson(){
        Robot r1 = new Robot("Tom", "red", 30);
        Robot r2 = new Robot("Jerry", "blue", 40);

        r1.introduceSelf();
        r2.introduceSelf();

        r1.lookingAt = r2;
        r2.lookingAt = r1;

        Person p1 = new Person("Alice", "aggressive", false);
        Person p2 = new Person("Becky", "talkative", true);

        p1.robotOwned = r2;
        p2.robotOwned = r1;

        System.out.println("\n");

        p1.robotOwned.introduceSelf();
        p2.robotOwned.introduceSelf();

        System.out.println("\n");

        String p1_sitting = p1.isSitting ? "I am sitting" : "I am not sitting";
        System.out.println("My name is " + p1.name + ", and " + p1_sitting);
        System.out.println("I owned the robot named " + p1.robotOwned.getName() + ", and he looks at " + p1.robotOwned.lookingAt.getName());

        System.out.println("\n");

        String p2_sitting = p2.isSitting ? "I am sitting" : "I am not sitting";
        System.out.println("My name is " + p2.name + ", and " + p2_sitting);
        System.out.println("I owned the robot named " + p2.robotOwned.getName() + ", and he looks at " + p2.robotOwned.lookingAt.getName());
    }

    public static void testNode(){
        Node head = new Node(4);
        Node nodeB = new Node(2);
        Node nodeC = new Node(3);
        Node nodeD = new Node(10);
        Node nodeE = new Node(2);

        head.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        System.out.println("No. of nodes: " + countNodes(head));
    }

    public static int countNodes(Node head){
        int nodeCount = 0;
        Node current = head;
        while(current != null){
            nodeCount++;
            System.out.println("Data: " + current.data);
            current = current.next;
        }
        return nodeCount;
    }


    public static void createTree(){
        TreeNode root = new TreeNode(2,
                new TreeNode(3,
                        new TreeNode(5),
                        new TreeNode(6)),
                new TreeNode(4));

        System.out.println(findTreeSum(root));
    }

    public static int findTreeSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.data + findTreeSum(root.left ) + findTreeSum(root.right);
    }

}
