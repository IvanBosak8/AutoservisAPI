package com.Autoservis.Autoservis.controllers;

import com.Autoservis.Autoservis.entities.Recenzije;
import com.Autoservis.Autoservis.entities.User;
import com.Autoservis.Autoservis.services.RecenzijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecenzijeController {
    @Autowired
    RecenzijeService recenzijeService;


    @RequestMapping("/recenzija")
    public List<Recenzije> getAllRecenzija(){
        return recenzijeService.getAllRecenzija();

    }
    @RequestMapping("/user/{userID}recenzija")
    public Recenzije getRecenzijeByUser(@PathVariable int userID)
    {return recenzijeService.getRecenzijeByUser(userID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/{userID}/recenzije")
    public void addRecenzija(@PathVariable int userID, @RequestBody Recenzije recenzije){
        recenzije.setKorisnik(new User(userID,"","","","","",""));
        recenzijeService.addRecenzija(recenzije);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/recenzije/delete/{id}")
    public void deleteRecenzije(@PathVariable Integer id) {
        recenzijeService.deleteRecenzije(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/recenzije/update/{id}")
    public void updateRecenzije(@RequestBody Recenzije id) {
        recenzijeService.updateRecezije(id);
    }
}
