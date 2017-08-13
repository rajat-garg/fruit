package hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fruit {

    @Id
    private int id;
    private String name;

    public Fruit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Fruit() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
