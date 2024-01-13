package csjodo_dsa;

public class Robot {
    private String name;
    private String color;
    private int weight;

    public Robot lookingAt;

    public Robot(){

    }
    public Robot(String name, String color, int weight){
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }
    public void introduceSelf(){
        System.out.println("My name is " + name);
    }

}
