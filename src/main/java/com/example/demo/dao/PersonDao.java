package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("sql")
public interface PersonDao extends JpaRepository<Person, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Person (name) VALUES (:name)", nativeQuery = true)
    void insertPerson(@Param("name") String name);

//    default void insertPerson(String name) {
//        insertPerson( name);
//    }

    @Query("SELECT p FROM Person p")
    public List<Person> selectAllPeople();

    @Query("SELECT p FROM Person p where p.id = :id")
    Optional<Person> selectPersonById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("DELETE from Person p where p.id = :id")
    int deletePersonById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value=  "UPDATE Person SET name = :name WHERE id = :id", nativeQuery = true)
    int updatePersonById(@Param("id") Integer id, @Param("name") String name);

}
