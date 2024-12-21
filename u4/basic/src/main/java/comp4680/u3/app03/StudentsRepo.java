package comp4680.u3.app03;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

    List<Students> findByStdNames(String stdNames);

    Optional<Students> findByStdCode(String stdCode);

    // Q1 : Create a custom query with name MyQuery to execute following JPQL and
    // return a List
    // select s from Students s where s.programme = :abc and s.stdNames like
    // '%:name%'
    @Query("select s from Students s where s.programme = ?1 and s.stdNames like %?2%")
    List<Students> customQuery(String sProg, String name);
}