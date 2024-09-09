package com.Autoservis.Autoservis.controllers;

import com.Autoservis.Autoservis.entities.Zaposlenik;
import com.Autoservis.Autoservis.services.ZaposlenikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZaposlenikController {
    @Autowired
    ZaposlenikService zaposlenikService;

    @RequestMapping("/zaposlenik")
    public List<Zaposlenik> getAllZaposlenik() {

        return zaposlenikService.getAllZaposlenik();
    }

    @RequestMapping("/zaposlenik/{id}")
    public Zaposlenik getZaposlenik(@PathVariable int id) {return zaposlenikService.getZaposlenik(id);}

    @RequestMapping(method = RequestMethod.POST, value = "/zaposlenik/add")
    public void registerZaposlenik(@RequestBody Zaposlenik zaposlenik) {

        zaposlenikService.registerZaposlenik(zaposlenik);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/zaposlenik/delete/{id}")
    public void deleteZaposlenik(@PathVariable Integer id) {
        zaposlenikService.deleteZaposlenik(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/zaposlenik/update/{id}")
    public void updateZaposlenik(@RequestBody Zaposlenik id) {
        zaposlenikService.updateZaposlenik(id);
    }

}
