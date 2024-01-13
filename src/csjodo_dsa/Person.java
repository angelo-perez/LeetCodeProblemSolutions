package csjodo_dsa;

public class Person {
    public String name;
    public String personality;
    public boolean isSitting;
    public Robot robotOwned;

    public Person(){

    }
    public Person(String name, String personality, boolean isSitting){
        this.name = name;
        this.personality = personality;
        this.isSitting = isSitting;
    }

    public void sitDown(){
        isSitting = true;
    }
    public void standUp(){
        isSitting = false;
    }

}
