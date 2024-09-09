package com.Autoservis.Autoservis.controllers;

import com.Autoservis.Autoservis.entities.Rezervacija;
import com.Autoservis.Autoservis.entities.User;
import com.Autoservis.Autoservis.services.EmailService;
import com.Autoservis.Autoservis.services.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RezervacijaController {

    @Autowired
    RezervacijaService rezervacijaService;

    @Autowired
    EmailService emailService;

    @RequestMapping("/rezervacija")
    public List<Rezervacija> getAllRezervacija(){
        return rezervacijaService.getAllRezervacija();

    }

    @RequestMapping("/user/{userID}rezervacija")
    public List<Rezervacija> getRezervacijeByUser(@PathVariable int userID)
    {return rezervacijaService.getRezervacijeByUser(userID);
    }

    @RequestMapping("/user/{userID}rezervacija/{id}")
    public Rezervacija getRezervacijaByUser(@PathVariable int id){
        return rezervacijaService.getRezervacijaByUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/{userID}/rezervacija")
    public void addRezervacija(@PathVariable int userID, @RequestBody Rezervacija rezervacija){
        rezervacija.setKorisnik(new User(userID,"","","","","",""));
        rezervacijaService.addRezervacija(rezervacija);

    }
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{userID}/rezervacija{id}")
    public void updateRezervacija(@PathVariable int userID, @RequestBody Rezervacija rezervacija) {
        rezervacija.setKorisnik(new User(userID, "", "", "", "", "", ""));
        rezervacijaService.updateRezervacija(rezervacija);

    }
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{userID}/rezervacijas{id}}")
    public void updateRezervacija1(@PathVariable int userID,@RequestBody Rezervacija rezervacija) {
        rezervacija.setKorisnik(new User(userID, "", "", "", "", "", ""));
        rezervacijaService.updateRezervacija1(rezervacija);

    }
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{userID}/rezervacijak{id}")
    public void deleteRezervacija(@PathVariable int userID, @RequestBody Rezervacija rezervacija) {
        rezervacija.setKorisnik(new User(userID, "", "", "", "", "", ""));
        rezervacijaService.deleteRezervacija(rezervacija);

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/rezervacija{id}")
    public void izbrisiRezervaciju(@PathVariable int id){
        rezervacijaService.izbrisiRezervaciju(id);
    }

    @RequestMapping("/rezervacija/broj")
    public int brojRezervacije(){
      return rezervacijaService.brojRezervacije();
    }

    @RequestMapping("/rezervacija/nedefinirano")
    public List<Rezervacija> getNedovrseneRezervacije(){
        return rezervacijaService.getNedovrseneRezervacije();
    }

    @RequestMapping("/user/{userID}/rezervacija/nedovrseno")
    public List<Rezervacija> getNedovrseneRezervacijeByUser(@PathVariable int userID){return rezervacijaService.getNedovrseneRezervacijeByUser(userID);}

    @RequestMapping("/servis")
    public List<Rezervacija> getServis(){return  rezervacijaService.getServis();}
}
