package com.Autoservis.Autoservis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="recenzije")

public class Recenzije {

    @ManyToOne
    private User korisnik;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String recenzija;
    private float ocjena;

    public Recenzije(int id, int userID, String recenzija, float ocjena){
        this.id=id;
        this.korisnik=new User(userID,"","","","","","");
        this.recenzija=recenzija;
        this.ocjena=ocjena;
    }

    public Recenzije(){

    }
}
