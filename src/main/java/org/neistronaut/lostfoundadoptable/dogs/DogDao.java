package org.neistronaut.lostfoundadoptable.dogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DogDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<Dog> getDogById(long dogId) {
        Object[] data = new String[]{Long.toString(dogId)};

        List<Dog> result = jdbcTemplate.query("SELECT id, name, age, size, breed, description FROM dogs WHERE id = ? ", data,
                (resultSet, rowNum) ->
                        new Dog(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("age"),
                                resultSet.getString("size"),
                                resultSet.getString("breed"),
                                resultSet.getString("description"))
        );
        return result.stream().findFirst();
    }

    public void initializeDogsTable() {
        jdbcTemplate.execute("DROP TABLE dogs IF EXISTS");
        jdbcTemplate.execute(
                "CREATE TABLE dogs( " +
                        "id INT NOT NULL, " +
                        "name VARCHAR(15) NOT NULL, " +
                        "age INT NOT NULL, " +
                        "size VARCHAR(10), " +
                        "breed VARCHAR(30), " +
                        "description VARCHAR(30));");

        jdbcTemplate.batchUpdate(
                "INSERT INTO dogs(id, name, age, size, breed, description)" +
                        " VALUES (?, ?, ?, ?, ?, ?)",
                DogRepository.DOG_INITIAL_DATABASE.stream()
                        .map(dog -> dog.serializeForDb()).collect(Collectors.toList()));
    }
}
