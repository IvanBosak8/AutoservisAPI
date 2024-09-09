package com.Autoservis.Autoservis.services;

import com.Autoservis.Autoservis.entities.Zaposlenik;
import com.Autoservis.Autoservis.repositories.ZaposlenikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZaposlenikService {

    @Autowired
    ZaposlenikRepository zaposlenikRepository;


    public List<Zaposlenik> getAllZaposlenik(){
        List<Zaposlenik> zaposlenik =new ArrayList<>();
        zaposlenikRepository.findAll().forEach(zaposlenik::add);
        return zaposlenik;

    }

    public Zaposlenik getZaposlenik(int ID){
        Zaposlenik zaposlenikobj =new Zaposlenik();
        return zaposlenikobj;
    }
    public void registerZaposlenik(Zaposlenik zaposlenik){
        Optional<Zaposlenik> zaposleniki = zaposlenikRepository.findByEmail(zaposlenik.getEmail());
        if (zaposleniki.isEmpty()){
            zaposlenikRepository.save(zaposlenik);
        }else {
            throw new IllegalStateException("Zaposlenik sa ovom email adresom već postoji!");
        }
    }

    public void deleteZaposlenik(int id){
        boolean exists = zaposlenikRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Zaposlenik ne postoji!");

        }
        zaposlenikRepository.deleteById(id);
    }

    public void updateZaposlenik(Zaposlenik zaposlenik){
        Optional<Zaposlenik> zaposl= Optional.ofNullable(zaposlenikRepository.findById(zaposlenik.getID())
                .orElseThrow(() -> new IllegalStateException("Zaposlenik ne postoji!")));

        zaposlenikRepository.save(zaposlenik);
    }
}
