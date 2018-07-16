package com.homework.resident.repositories;

import com.homework.resident.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CapitalRepository extends JpaRepository<Capital,String> {
    @Query(value = "SELECT * FROM capitals as c ORDER by c.name ASC", nativeQuery = true)
    List<Capital> findAllCapitals();

    Capital findByName(String name);

}
