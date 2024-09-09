package com.Autoservis.Autoservis.repositories;

import com.Autoservis.Autoservis.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("select s from User s where s.Email=?1")
    Optional<User> findByEmail(String Email);
    @Query("select s from User  s where s.Uloge=?1")
    List<User> findByUloge(String Uloge);

}