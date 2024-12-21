package comp4680.u04.app02;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface CustomersRepo extends JpaRepository<Customers, Integer> {
    Optional<Customers> findByCustName(String custName);

    List<Customers> findByCustEmailLike(String custEmail);

    @Query("select c from Customers c where c.custName like :custName and c.custEmail like :custEmail")
    List<Customers> findByCustomDeclaredQuery(@Param("custName") String cName, @Param("custEmail") String email);
}