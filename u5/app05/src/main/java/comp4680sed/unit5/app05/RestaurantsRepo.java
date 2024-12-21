package comp4680sed.unit5.app05;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantsRepo extends JpaRepository<Restaurants, Integer> {
}