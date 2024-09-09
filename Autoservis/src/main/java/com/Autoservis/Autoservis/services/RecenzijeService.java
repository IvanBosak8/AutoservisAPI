package com.Autoservis.Autoservis.services;

import com.Autoservis.Autoservis.entities.Recenzije;
import com.Autoservis.Autoservis.entities.User;
import com.Autoservis.Autoservis.repositories.RecenzijeRepository;
import com.Autoservis.Autoservis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class RecenzijeService {

    @Autowired
    RecenzijeRepository recenzijeRepository;

    @Autowired
    UserRepository userRepository;


    public List<Recenzije> getAllRecenzija(){
        List<Recenzije> recenzije =new ArrayList<>();
        recenzijeRepository.findAll().forEach(recenzije::add);
        return recenzije;
    }

    public Recenzije getRecenzijeByUser(int id){
        Recenzije recenzijeObj= new Recenzije();
        Optional<Recenzije> recenzije= recenzijeRepository.findById(id);
        if (recenzije.isPresent()){
            recenzijeObj=recenzije.get();
        }
        recenzije.orElseThrow(()-> new NoSuchElementException("Rezervacija ne postoji."));
        return  recenzijeObj;
    }

    public void addRecenzija(Recenzije recenzije){
        Optional<User> user = userRepository.findById(recenzije.getKorisnik().getID());

        if (user.isPresent()){
            recenzijeRepository.save(recenzije);
        }
        user.orElseThrow(()-> new NoSuchElementException("Recenzija ne postoji."));

    }

    public void deleteRecenzije(int id){
        boolean exists = recenzijeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Zaposlenik ne postoji!");

        }recenzijeRepository.deleteById(id);
    }

    public void updateRecezije(Recenzije recenzije){


        recenzijeRepository.save(recenzije);
    }
}
