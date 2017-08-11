package hello;

import java.util.ArrayList;
import java.util.List;

public class FruitDAO {
    private static List fruits;

    {
        fruits = new ArrayList();
        fruits.add(new Fruit(1, "Apple"));
        fruits.add(new Fruit(2, "Mango"));
        fruits.add(new Fruit(3, "Orange"));
        fruits.add(new Fruit(4, "Guava"));
    }

    public static List getFruits() {
        return fruits;
    }

    public Fruit get(int id){
        for (Object fruit : fruits) {
            if (((Fruit) fruit).getId() == id) {
                return (Fruit) fruit;
            }
        }
        return null;
    }

    public Fruit create(Fruit fruit) {
        fruits.add(fruit);
        return fruit;
    }

    public int delete(int id) {
        for (Object fruit : fruits) {
            if (((Fruit) fruit).getId() == id) {
                fruits.remove(fruit);
                return id;
            }
        }
        return 0;
    }

    public Fruit update(int id, String name) {
        for (Object fruit : fruits) {
            if (((Fruit) fruit).getId() == id){
                ((Fruit) fruit).setName(name);
                return (Fruit) fruit;
            }
        }
        return null;
    }
}
