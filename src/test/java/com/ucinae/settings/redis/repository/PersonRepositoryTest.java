package com.ucinae.settings.redis.repository;

import com.ucinae.settings.redis.model.Address;
import com.ucinae.settings.redis.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void saveTest() {
        Address seoul = Address.builder().city("seoul").country("korea").build();
        Address tokyo = Address.builder().city("tokyo").country("japan").build();

        Person person = Person.builder()
                .id("test-2")
                .name("foo")
                .email("foo@boo.com")
                .birthday(new Date())
                .nicknames(List.of("fo", "bo"))
                .age(20)
                .attributes(Map.of("attr1", "qwerty"))
                .addresses(List.of(seoul, tokyo))
                .addressMap(Map.of("korea", seoul, "tokyo", tokyo))
                .address(seoul)
                .build();

        personRepository.save(person);
    }

    @Test
    void findTest() {
        Optional<Person> optionalPerson = personRepository.findById("test-2");

        Person person = optionalPerson.orElseThrow();

        log.info("[redis] person result = {}", person);
    }
}