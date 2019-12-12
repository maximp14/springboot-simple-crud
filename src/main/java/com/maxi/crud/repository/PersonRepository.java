package com.maxi.crud.repository;

import com.maxi.crud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    Optional<Person> findById(@Param("id") Long aLong);
}
