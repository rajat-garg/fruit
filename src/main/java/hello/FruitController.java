package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class
FruitController {

    @ResponseBody
    @RequestMapping(value = "/rest/fruits", method = RequestMethod.GET)
    public List getFruits() {
        return FruitDAO.getFruits();
    }

    @ResponseBody
    @RequestMapping(value = "/rest/fruits/{id}", method = RequestMethod.GET)
    public ResponseEntity getFruit(@PathVariable("id") int id) {
        FruitDAO fruitDAO = new FruitDAO();
        Fruit fruit = fruitDAO.get(id);
        return new ResponseEntity(fruit, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/rest/fruits", method = RequestMethod.POST)
    public ResponseEntity createFruit(@RequestBody Fruit fruit) {
        FruitDAO fruitDAO = new FruitDAO();
        fruitDAO.create(fruit);
        return new ResponseEntity(fruit, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/rest/fruits/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateFruit(@PathVariable("id") int id, @RequestBody String name) {
        FruitDAO fruitDAO = new FruitDAO();
        fruitDAO.update(id, name);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/fruits/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteFruit(@PathVariable("id") int id) {
        FruitDAO fruitDAO = new FruitDAO();
        fruitDAO.delete(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

}
