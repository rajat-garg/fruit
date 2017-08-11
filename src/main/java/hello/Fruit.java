package hello;

public class Fruit {

    private  int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    private  String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Fruit(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Fruit(){

    }
}
