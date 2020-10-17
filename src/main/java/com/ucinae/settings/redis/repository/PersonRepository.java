package com.ucinae.settings.redis.repository;

import com.ucinae.settings.redis.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
