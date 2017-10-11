package com.freightsol.freightsol.db.repositories;

import com.freightsol.freightsol.db.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by probal on 10/11/17.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    Page<Person> findAll(Pageable pageReguest);

}
