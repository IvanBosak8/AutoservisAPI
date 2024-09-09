package com.Autoservis.Autoservis.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;


public class MyUserDetails implements UserDetails {
    private int ID;
    private String broj;
    private String ime;
    private String prezime;
    private String Email;
    private String lozinka;
    private String Uloge;


    public MyUserDetails(User user){
        this.ID=user.getID();
        this.broj=user.getBroj();
        this.ime=user.getIme();
        this.prezime=user.getPrezime();
        this.Email=user.getEmail();
        this.lozinka=user.getLozinka();
        this.Uloge=user.getUloge();
    }

    @Override
    public Collection<?extends GrantedAuthority> getAuthorities(){
        return Arrays.asList(new SimpleGrantedAuthority("Uloge"));
    }
    @Override
    public String getPassword(){return lozinka;}
    @Override
    public String getUsername(){return Email;}
    @Override
    public boolean isAccountNonExpired(){return true;}
    @Override
    public boolean isAccountNonLocked(){return true;}
    public boolean isCredentialsNonExpired(){return true;}
    @Override
    public boolean isEnabled() {return true;}
    public int getID(){return ID;}
    public String getUloge(){return Uloge;}
    public String getIme(){return ime;}
    public String getPrezime(){return prezime;}
    public String getBroj(){return broj;}





}
