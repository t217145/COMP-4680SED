package com.cyrus822.demo.web01.Repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cyrus822.demo.web01.Models.DemoModel;

public interface DemoRepo extends JpaRepository<DemoModel, Integer> {
    Optional<DemoModel> findOneByValue1(String value1);   
}