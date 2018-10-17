package org.neistronaut.lostfoundadoptable;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/adoptable")
    public Dog adoptableDog(@RequestParam(value="dogId", defaultValue="10") final Long dogId) {
        return DogRepository.dogsDatabase.stream().filter(d -> d.getId() == dogId).findFirst().orElse(null);
    }
}