package com.Autoservis.Autoservis.services;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final SimpleMailMessage simpleMailMasage = new SimpleMailMessage();


    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender= javaMailSender;
    }

    public void posaljiEmailZaIzbrisanuRezervaciju(String email,String razlog){
        simpleMailMasage.setTo(email);
        simpleMailMasage.setFrom("danas.autoservis@gmail.com");
        simpleMailMasage.setSubject("ODBIJENO!");
        simpleMailMasage.setText("Vaša rezervacija je odbijena "+razlog +".");

        javaMailSender.send(simpleMailMasage);
    }

    public void posaljiEmailZaDodatnuRezervaciju(String email){
        simpleMailMasage.setTo(email);
        simpleMailMasage.setFrom("danas.autoservis@gmail.com");
        simpleMailMasage.setSubject("Nova rezervacija za pregledati");
        simpleMailMasage.setText("Imate novu rezervaciju za pregledat.");

        javaMailSender.send(simpleMailMasage);
    }
    public void posaljiLozinku(String email, String lozinka) {
        simpleMailMasage.setTo(email);
        simpleMailMasage.setFrom("danas.autoservis@gmail.com");
        simpleMailMasage.setSubject("VAŠA LOZINKA");
        simpleMailMasage.setText("Vaša lozinka je: " + lozinka);

        javaMailSender.send(simpleMailMasage);

    }

    public void posaljiEmailZaGotovuRezervaciju(String email){
        simpleMailMasage.setTo(email);
        simpleMailMasage.setFrom("danas.autoservis@gmail.com");
        simpleMailMasage.setSubject("GOTOVO!");
        simpleMailMasage.setText("Vaš servis je gotov! Molimo Vas dođite podignut auto. Sve detalje servisa možete pogledati u aplikaciji.");

        javaMailSender.send(simpleMailMasage);
    }

    public void posaljiEmailZaOdobrenu(String email, String datumPrimanja, String datumZavrsetka){
        simpleMailMasage.setTo(email);
        simpleMailMasage.setFrom("danas.autoservis@gmail.com");
        simpleMailMasage.setSubject("Odobreno!");
        simpleMailMasage.setText("Vaša rezervacija je odobrena!"+" Molimo Vas dostavite auto "+datumPrimanja + ". "+ "Vaš servis će biti gotov do "+datumZavrsetka+".");

        javaMailSender.send(simpleMailMasage);
    }


}
