package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByLogin(String login);


    @Modifying
    @Query(value = "UPDATE person SET role = 'ROLE_USER' WHERE id=?1", nativeQuery = true)
    void SetRoleUser(int Id);

    @Modifying
    @Query(value = "UPDATE person SET role = 'ROLE_ADMIN' WHERE id=?1", nativeQuery = true)
    void SetRoleAdmin(int Id);

}
