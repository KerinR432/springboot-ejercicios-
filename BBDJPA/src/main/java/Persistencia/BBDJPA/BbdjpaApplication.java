package Persistencia.BBDJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BbdjpaApplication {

    private static final Logger logger = LoggerFactory.getLogger(BbdjpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BbdjpaApplication.class,args);
    }

    @Bean
    public CommandLineRunner demo(RepositorioCliente repositorio) {
        return (args) -> {
            // save a few customers
            repositorio.save(new Cliente("Jack", "Bauer"));
            repositorio.save(new Cliente("Chloe", "O'Brian"));
            repositorio.save(new Cliente("Kim", "Bauer"));
            repositorio.save(new Cliente("David", "Palmer"));
            repositorio.save(new Cliente("Michelle", "Dessler"));

            // fetch all customers
            logger.info("Customers found with findAll():");
            logger.info("-------------------------------");
            repositorio.findAll().forEach(customer -> {
                logger.info(customer.toString());
            });
            logger.info("");

            // fetch an individual customer by ID
            Cliente cliente = repositorio.findById(1L);
            logger.info("Customer found with findById(1L):");
            logger.info("--------------------------------");
            logger.info(cliente.toString());
            logger.info("");

            // fetch customers by last name
            logger.info("Customer found with findByLastName('Bauer'):");
            logger.info("--------------------------------------------");
            repositorio.findByApellido("Bauer").forEach(bauer -> {
                logger.info(bauer.toString());
            });
            logger.info("");
        };
    }

}
