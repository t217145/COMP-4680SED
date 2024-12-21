package comp4680.u04.app02;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App02Runner implements CommandLineRunner {
    @Autowired
    private CustomersRepo repo;

    @Override
    public void run(String... args) throws Exception {
        // 1. Create 2 records
        Customers newCustomer01 = new Customers(
                0,
                "Cust01",
                "cust01@comp4680.com");
        repo.save(newCustomer01);

        Customers newCustomer02 = new Customers(
                0,
                "Cust02",
                "customer02@comp4680.com");
        repo.save(newCustomer02);

        // 2. Query records
        System.out.println("Result of findByCustomDeclaredQuery()");
        repo.findByCustomDeclaredQuery("Cus%", "%02%").forEach(System.out::println);

        System.out.println("Result of findByCustName()");
        Optional<Customers> custA = repo.findByCustName("Cust01");
        if (custA.isPresent()) {
            System.out.println(custA.get().toString());
        }

        System.out.println("Result of findByCustEmailLike()");
        repo.findByCustEmailLike("%comp4680.com").forEach(System.out::println);
    }
}
// // 2. Read all records
// List<Customers> allCustomers = repo.findAll();
// allCustomers.forEach(System.out::println);

// // 3. Update records
// Customers cust01 = repo.findById(1).get();
// cust01.setCustName("Customer01");
// repo.save(cust01);
// // Pause and check DB
// System.out.println("Go to H2 Console and check the record");
// System.in.read();

// // 4. Delete records
// repo.deleteById(1);
// allCustomers = repo.findAll();
// allCustomers.forEach(System.out::println);
// }
// }