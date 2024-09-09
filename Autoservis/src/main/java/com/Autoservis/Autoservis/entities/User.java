package com.Autoservis.Autoservis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="korisnici")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    private String  Broj;
    private String Ime;
    private String Prezime;
    private String Email;
    private String Lozinka;
    @Column(name="uloge")
    private String Uloge;

    public User(int ID, String ime, String prezime, String Email, String  broj, String lozinka, String Uloge){
        this.ID=ID;
        Ime = ime;
        Prezime=prezime;
        this.Email=Email;
        this.Broj= broj;
        Lozinka=lozinka;
        this.Uloge=Uloge;

    }

    public User(){

    }



}
