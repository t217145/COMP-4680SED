package comp4680sed.unit5.app05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomRestaurantsValidator implements Validator {

    @Autowired
    private RestaurantsRepo repo;

    private static final Logger logger = LogManager.getLogger(CustomRestaurantsValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Restaurants.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Restaurants restaurants = (Restaurants) target;
        boolean isExists = repo.findAll().stream().anyMatch(r -> r.getName().equals(restaurants.getName()));

        if (isExists) {
            String errMsg = String.format("Restaurant with Name [%s] already exists", restaurants.getName());
            logger.error(errMsg);
            errors.rejectValue("name", "duplicate", errMsg);
        }

        if ((restaurants.getPhone() == null || restaurants.getPhone().trim().isBlank()) &&
                (restaurants.getAddr() == null || restaurants.getAddr().trim().isBlank())) {
            errors.rejectValue("phone", "invalid", "Either Phone or Address must be provided");
            errors.rejectValue("addr", "invalid", "Either Phone or Address must be provided");
        }
    }
}