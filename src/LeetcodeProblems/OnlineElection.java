package LeetcodeProblems;

import java.util.HashMap;

public class OnlineElection {

    public int[] persons;
    public int[] times;
    public HashMap<Integer, Integer> timeLeadingPersonMap;

    public OnlineElection(int[] persons, int[] times){
        this.persons = persons;
        this.times = times;
        this.timeLeadingPersonMap = new HashMap<>();

        HashMap<Integer,Integer> votesCountMap = new HashMap<>();
        int maxVoteCount = Integer.MIN_VALUE;
        int maxVotePerson = 0;

        for(int i = 0; i < times.length; i++){
            votesCountMap.put(persons[i], votesCountMap.getOrDefault(persons[i], 0) + 1);
            if(votesCountMap.get(persons[i]) > maxVoteCount){
                timeLeadingPersonMap.put(times[i], persons[i]);
                maxVoteCount = votesCountMap.get(persons[i]);
                maxVotePerson = persons[i];
            }
            else if(votesCountMap.get(persons[i]) == maxVoteCount){
                timeLeadingPersonMap.put(times[i], persons[i]);
                maxVotePerson = persons[i];
            }
            else{ // votesCountMap.get(persons[i]) < maxVoteCount){
                timeLeadingPersonMap.put(times[i], maxVotePerson);
            }
        }
    }

    public int q(int t) { // conventional binary search
        return binarySearchTimesIndex(t);
    }

    public int binarySearchTimesIndex(int t){
        int n = times.length;
        int left = 0;
        int right = n-1;

        while(right >= left){

            int mid = (left + right)/2;

            if(t == times[mid]){
                return timeLeadingPersonMap.get(times[mid]);
            }
            else if(t < times[mid]){
                right = mid - 1;
            }
            else if(t > times[mid]){
                left = mid + 1;
            }
        }

        return timeLeadingPersonMap.get(times[right]);
    }

    public static void testOnlineElection(){
        int[] persons = {0,1,1,0,0,1,0};
        int[] times = {0,5,10,15,20,25,30};
        OnlineElection obj = new OnlineElection(persons, times);
        System.out.println(obj.q(3));
        System.out.println(obj.q(12));
        System.out.println(obj.q(25));
        System.out.println(obj.q(15));
        System.out.println(obj.q(24));
        System.out.println(obj.q(8));
    }

}
