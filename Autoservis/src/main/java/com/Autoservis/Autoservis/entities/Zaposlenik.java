package com.Autoservis.Autoservis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="zaposlenici")
public class Zaposlenik {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    private String  Broj;
    private String Ime;
    private String Prezime;
    private String Email;



    public Zaposlenik(int ID, String ime, String prezime, String Email, String  broj){
        this.ID=ID;
        Ime = ime;
        Prezime=prezime;
        this.Email=Email;
        this.Broj= broj;



    }

    public Zaposlenik(){

    }

}
