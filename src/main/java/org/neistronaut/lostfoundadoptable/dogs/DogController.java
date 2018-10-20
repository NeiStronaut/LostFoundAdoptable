package org.neistronaut.lostfoundadoptable.dogs;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import static org.neistronaut.lostfoundadoptable.dogs.DogRepository.DOG_INITIAL_DATABASE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/adoptables")
public class DogController {

    @RequestMapping(method = GET)
    @ResponseBody
    public Dog adoptableDogByParam(@RequestParam(value="dogId") final long dogId) {
        return DOG_INITIAL_DATABASE.stream().filter(d -> d.getId() == dogId).findFirst().orElse(null);
    }

    @RequestMapping(method = GET, value = "/dogs")
    @ResponseBody
    public List<Dog> adoptableAllDogs() {
        return DOG_INITIAL_DATABASE;
    }

    @RequestMapping(method = GET, value = "/dogs/{id}")
    @ResponseBody
    public Dog adoptableDogByPath(@PathVariable("id") long id) {
        return DOG_INITIAL_DATABASE.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public List<Dog> adoptableDog(@RequestBody Dog dogType) {
        DOG_INITIAL_DATABASE.add(dogType);
        return DOG_INITIAL_DATABASE;
    }

    @RequestMapping("*")
    @ResponseBody
    public String fallback() {
        return "Bad dog!";
    }
}