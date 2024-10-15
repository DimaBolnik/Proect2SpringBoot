package ru.bolnik.springboot.project2boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bolnik.springboot.project2boot.models.Book;
import ru.bolnik.springboot.project2boot.models.Person;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByPerson(Person person);

    List<Book> findByTitleStartingWith(String title);
}
