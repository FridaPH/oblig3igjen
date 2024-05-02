package com.example.oblig3igjen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BillettController {

    @Autowired
    BillettRepository rep;


    @PostMapping("/lagre")
    public void lagreBillett(Billett billetter) {
        System.out.println("Vi er på backend /lage");
        System.out.println(billetter.getAntall());
        System.out.println(billetter.getFornavn());
        System.out.println(billetter.getFilm());
        System.out.println(billetter.getEtternavn());
        System.out.println(billetter.getEpost());
        System.out.println(billetter.getTelefon());

        rep.lagreBillett(billetter);
    }

    @GetMapping("/hentAlle")
    public List<Billett> hentAlle() {
        return rep.hentAlle();
    }

    @GetMapping("/slettAlle")
    public void slettAlle() {
        rep.slettAlle();
    }
}
