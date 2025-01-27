package ru.bolnik.springboot.project2boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bolnik.springboot.project2boot.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByFullName(String fullName);

    List<Person> findByEmail(String email);

    List<Person> findByFullNameStartingWith(String startingWith);

    List<Person> findByFullNameOrEmail(String fullName, String email);



}
