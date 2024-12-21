package comp4680.u3.full_demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

}