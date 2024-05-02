package com.example.oblig3igjen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(BillettRepository.class);

    public void lagreBillett(Billett billetter) {
        String sql = "INSERT INTO Billett(film, antall, fornavn, etternavn, telefon, epost) VALUES (?, ?, ?, ?, ?, ?)";
        db.update(sql, billetter.getFilm(), billetter.getAntall(), billetter.getFornavn(), billetter.getEtternavn(), billetter.getTelefon(), billetter.getEpost());
    }

    public List<Billett> hentAlle() {
        String sql = "SELECT film, antall, fornavn, etternavn, telefon, epost FROM Billett ORDER BY etternavn";
        try {
            List<Billett> billetter = db.query(sql, new BeanPropertyRowMapper<Billett>(Billett.class));
            return billetter;
        } catch (Exception e) {
            logger.error("Kan ikke hente billetter nå " + e);
            return null;
        }
    }

    public boolean slettAlle() {
        String sql = "DELETE FROM Billett;";
        try {
            db.update(sql);
            return true;
        } catch (Exception e) {
            logger.error("Kan ikke slette billetter nå " + e);
            return false;
        }
    }
}