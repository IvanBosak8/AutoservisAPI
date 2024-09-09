package com.Autoservis.Autoservis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="rezervacija")
public class Rezervacija {

    @ManyToOne
    private User korisnik;

    @ManyToOne
    private Zaposlenik radnici;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private double cijena;
    private String datumPrimanja;
    private String datumZavrsetka;
    private int radniSati;
    private String auto;
    private int godinaProizvodnje;
    private String brojSasije;
    private String popravak;
    private String dan;
    private int brojRezervacije;
    private double cijenaDijelova;
    private double cijenaRada;
    private String razlog;



    public Rezervacija(int ID, int userID, double cijena, String datumPrimanja, String datumZavrsetka, int radnikID, int radnisati, String auto, int godinaProizvodnje, String brojSasije, String popravak, String dan, int brojRezervacije, double cijenaDijelova, double cijenaRada, String razlog) {
        this.korisnik = new User(userID, "", "", "", "", "", "");
        this.radnici = new Zaposlenik(radnikID,"","","","");
        this.ID = ID;
        this.cijena = cijena;
        this.datumPrimanja = datumPrimanja;
        this.datumZavrsetka = datumZavrsetka;
        this.radniSati = radnisati;
        this.auto = auto;
        this.godinaProizvodnje = godinaProizvodnje;
        this.brojSasije = brojSasije;
        this.popravak = popravak;
        this.dan = dan;
        this.brojRezervacije = brojRezervacije;
        this.cijenaDijelova = cijenaDijelova;
        this.cijenaRada = cijenaRada;
        this.razlog = razlog;


    }


    public Rezervacija() {

    }

}
    

