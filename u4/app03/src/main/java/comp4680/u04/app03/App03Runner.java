package comp4680.u04.app03;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;

@Component
public class App03Runner implements CommandLineRunner {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private CustomersRepo customerRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // 1. Create 2 customer records
        Customers cust01 = new Customers("Customer01", "cust01@comp4680.com");
        Customers cust02 = new Customers("Cust02", "customer02@comp4680.com");

        // 2. Save Customer records
        customerRepo.saveAll(List.of(cust01, cust02));

        // 2. Create 3 account records
        Account acct01 = new Account("01234567", 'S', 5000.0, cust02);
        Account acct02 = new Account("12312312", 'C', 0.0, cust01);
        Account acct03 = new Account(null, 'S', 120.0, cust01);

        // 3. Save records
        accountRepo.saveAll(List.of(acct01, acct02, acct03));
    }
}