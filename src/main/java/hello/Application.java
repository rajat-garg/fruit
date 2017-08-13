package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo (FruitRepository repository){
        return (args) -> {
            //Save fruits in db
            repository.save(new Fruit(1,"Mango"));
            repository.save(new Fruit(2,"Apple"));
            repository.save(new Fruit(3,"Guava"));
            repository.save(new Fruit(4,"Litchi"));
            repository.save(new Fruit(5,"Banana"));

            //fetch all fruits
            log.info("Find all fruits");
            log.info("====================================");
            for(Fruit fruit: repository.findAll()){
                log.info("Fruit is: " + fruit.getName());
            }
            log.info(" ");

            //fetch a fruit By Id
            Fruit fruit = repository.findOne(1);
            log.info("Fruit found with id: (1)");
            log.info("=====================================");
            log.info(fruit.getName());
            log.info(" ");
        };
    }
}
