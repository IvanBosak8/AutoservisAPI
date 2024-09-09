package com.Autoservis.Autoservis.repositories;

import com.Autoservis.Autoservis.entities.Recenzije;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface RecenzijeRepository extends CrudRepository<Recenzije, Integer> {

    List<Recenzije> findByKorisnikID(int userID);
}