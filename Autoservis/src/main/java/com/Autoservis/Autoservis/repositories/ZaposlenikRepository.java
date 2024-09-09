package com.Autoservis.Autoservis.repositories;

import com.Autoservis.Autoservis.entities.Zaposlenik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ZaposlenikRepository extends CrudRepository<Zaposlenik,Integer> {

    @Query("select s from Zaposlenik s where s.Email=?1")
    Optional<Zaposlenik> findByEmail(String Email);

    List<Zaposlenik> findByID(int id);
}
