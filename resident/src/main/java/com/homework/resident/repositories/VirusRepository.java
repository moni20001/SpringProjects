package com.homework.resident.repositories;

import com.homework.resident.entities.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VirusRepository extends JpaRepository<Virus,String> {
    @Query(value = "SELECT * FROM viruses as v ORDER by v.id ASC", nativeQuery = true)
    List<Virus> findAllViruses();

    @Modifying
    @Query(value = "Update viruses as v Set v.creator = ?1, v.description = ?2, v.hours_until_mutation = ?3, v.is_curable = ?4, v.is_deadly = ?5, v.magnitude = ?6, v.mutation = ?7, v.name=?8, v.released_on = ?9, v.side_effects = ?10, v.turnover_rate = ?11 Where v.id = ?12;", nativeQuery = true)
    void updateVirus(String creator, String description, Integer hours, Boolean isCurable , Boolean isDeadly, String magnitude, String mutation, String name, LocalDate time,String side,Integer turn,String id);

   // @Query("update viruses v set v.creator =:creator , v.description =: description,v.hours_until_mutation =: hours, v.is_curable =: isCurable, v.is_deadly =: isDeadly, v.magnitude =: magnitude, v.mutation =: mut, v.name=: name, v.released_on =: date, v.side_effects =: side, v.turnover_rate =: turn where id =:upId")
   // void update(@Param("upId") String id, @Param("creator") String creator,@Param("description") String description, @Param("hours") Integer hours, @Param("isCurable") Boolean isCurable,@Param("isDeadly") Boolean isDeadly,@Param("magnitude") String magnitude,@Param("mut") String mutation,@Param("name") String name, @Param("date") LocalDate date,@Param("side") String side,@Param("turn") Integer turn);

    Optional<Virus> findById(String id);



    void deleteById(String id);
}
