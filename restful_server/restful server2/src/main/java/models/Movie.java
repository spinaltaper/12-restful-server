package models;

public class Movie {
    public static int ID_COUNT = 12_345;
    public int id;
    public String name;
    public int length;

    public Movie(String name, int length){
        this.name = name;
        this.id=ID_COUNT++;
        this.length=length;
    }

    public String toString(){
        return this.name + " @ " + this.length +" minutes";
    }
}
