package com.Autoservis.Autoservis.services;

import com.Autoservis.Autoservis.entities.Rezervacija;
import com.Autoservis.Autoservis.entities.User;
import com.Autoservis.Autoservis.repositories.RezervacijaRepository;
import com.Autoservis.Autoservis.repositories.UserRepository;
import com.Autoservis.Autoservis.repositories.ZaposlenikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RezervacijaService {
    @Autowired
    RezervacijaRepository rezervacijaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ZaposlenikRepository zaposlenikRepository;

    @Autowired
    EmailService emailService;




    public List<Rezervacija> getAllRezervacija(){
        List<Rezervacija> rezervacija =new ArrayList<>();
        rezervacijaRepository.findAll().forEach(rezervacija::add);
        rezervacija.removeIf(rezervaCija -> rezervaCija.getRazlog().equals("nema"));
        rezervacija.removeIf(ser -> ser.getRazlog().equals("nema1"));

        return rezervacija;
    }

    public int brojRezervacije(){
        List<Rezervacija> rezervacija = new ArrayList<>();
        rezervacijaRepository.findAll().forEach(rezervacija::add);
        return rezervacija.size();
    }

    public List<Rezervacija> getRezervacijeByUser(int userID) {
        List<Rezervacija> rezervacijaList =new ArrayList<>(rezervacijaRepository.findByKorisnikID(userID));
        rezervacijaList.removeIf(rezervacija -> rezervacija.getRazlog().equals("nema"));
        rezervacijaList.removeIf(rezu-> rezu.getRazlog().equals("nema1"));
        return rezervacijaList;
    }

    public Rezervacija getRezervacijaByUser(int id){
        Rezervacija rezervacijaObj= new Rezervacija();
        Optional<Rezervacija> rezervacija= rezervacijaRepository.findById(id);
        if (rezervacija.isPresent()){
            rezervacija.filter(rezerVacija ->!rezerVacija.getRazlog().equals("nema"));
            rezervacijaObj=rezervacija.get();
        }
        rezervacija.orElseThrow(()-> new NoSuchElementException("Rezervacija ne postoji."));
        return  rezervacijaObj;
    }
    public void addRezervacija(Rezervacija rezervacija){
        Optional<User> user = userRepository.findById(rezervacija.getKorisnik().getID());
        if (user.isPresent()){
            if (user.get().getUloge().equals("USER")){
                List<User> adminList= new ArrayList<>(userRepository.findByUloge("ADMIN"));
                for (User admin:adminList){
                    emailService.posaljiEmailZaDodatnuRezervaciju(admin.getEmail());
                }
            }
        }
        user.orElseThrow(()-> new NoSuchElementException("Korisnik ne postoji."));
        rezervacijaRepository.save(rezervacija);
    }

    public void updateRezervacija(Rezervacija rezervacija){
        Optional<Rezervacija> rez = rezervacijaRepository.findById(rezervacija.getID());
        if(rez.isPresent()){
            User korisnik = rez.get().getKorisnik();
            emailService.posaljiEmailZaGotovuRezervaciju(korisnik.getEmail());
        }
            rez.orElseThrow(() -> new NoSuchElementException("Rezervacija ne postoji."));
        rezervacijaRepository.save(rezervacija);
    }
    public void updateRezervacija1(Rezervacija rezervacija){

        Optional<Rezervacija> rezervacija7 = rezervacijaRepository.findById(rezervacija.getID());

        if (rezervacija7.isPresent()){
            User korisnik = rezervacija7.get().getKorisnik();

                    emailService.posaljiEmailZaOdobrenu(korisnik.getEmail(),rezervacija.getDatumPrimanja(),rezervacija.getDatumZavrsetka());


        }
        rezervacija7.orElseThrow(()-> new NoSuchElementException("Rezervacija ne postoji."));
        rezervacijaRepository.save(rezervacija);}
    public void deleteRezervacija(Rezervacija rezervacija){

        Optional<Rezervacija> rezervacija8 = rezervacijaRepository.findById(rezervacija.getID());

        if (rezervacija8.isPresent()){
            User korisnik = rezervacija8.get().getKorisnik();

            emailService.posaljiEmailZaIzbrisanuRezervaciju(korisnik.getEmail(),rezervacija.getRazlog());
            rezervacijaRepository.save(rezervacija);

        }
            rezervacija8.orElseThrow(() -> new NoSuchElementException("Rezervacija ne postoji."));

        rezervacijaRepository.deleteById(rezervacija.getID());
    }
    public void izbrisiRezervaciju(int id){
        Optional<Rezervacija> rezervacija= rezervacijaRepository.findById(id);
        boolean exists = rezervacijaRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Rezervacija ne postoji!");

        }

//        if (rezervacija.isPresent()){
//            User korisnik= rezervacija.get().getKorisnik();
//
//            emailService.posaljiEmailZaIzbrisanuRezervaciju(korisnik.getEmail());
//        }

        rezervacijaRepository.deleteById(id);
    }

    public List<Rezervacija> getNedovrseneRezervacije(){
        List<Rezervacija> nedefiniranaRezervacija=new ArrayList<>();
        rezervacijaRepository.findAll().forEach(nedefiniranaRezervacija::add);
        nedefiniranaRezervacija.removeIf(rezervacija -> !rezervacija.getRazlog().equals("nema"));
        return nedefiniranaRezervacija;
    }
    public List<Rezervacija> getNedovrseneRezervacijeByUser(int userID){
        List<Rezervacija> nedovrsenaRezervacija=new ArrayList<>(rezervacijaRepository.findByKorisnikID(userID));
        nedovrsenaRezervacija.removeIf(rEzervacija -> !rEzervacija.getRazlog().equals("nema1"));
        return nedovrsenaRezervacija;
    }
    public List<Rezervacija> getServis() {
        List<Rezervacija> servisList = new ArrayList<>();
        rezervacijaRepository.findAll().forEach(servisList::add);
        servisList.removeIf(servis-> !servis.getRazlog().equals("nema1"));
        return servisList;
    }


}
