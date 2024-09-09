package com.Autoservis.Autoservis.repositories;

import com.Autoservis.Autoservis.entities.Rezervacija;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface RezervacijaRepository  extends CrudRepository <Rezervacija, Integer> {

//    @Query("select s from Rezervacija s where s.Radnik=?1")
    List<Rezervacija> findByKorisnikID(int userID);
    List<Rezervacija> findRezervacijaByID(int id);


}
