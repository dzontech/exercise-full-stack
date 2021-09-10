package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {

    @Autowired
    JdbcTemplate template;

    @PostConstruct
    public void init() {

        template.update("insert into VESTI(mesto, naslov, strana, autor) values(?,?,?,?)", new Object[]{
           "Cacak", "Folklor", 3, "Bojan"
        });
        template.update("insert into VESTI(mesto, naslov, strana, autor) values(?,?,?,?)", new Object[]{
                "Kraljevo", "Vaterpolo", 2, "Jovan"
        });
        template.update("insert into VESTI(mesto, naslov, strana, autor) values(?,?,?,?)", new Object[]{
                "Beograd", "Biblioteka", 1, "Sanja"
        });
        template.update("insert into KOMENTARI(vest_id, ocena, tekst, osoba) values(?,?,?,?)", new Object[]{
           1, 4, "Super", "Mika"
        });
        template.update("insert into KOMENTARI(vest_id, ocena, tekst, osoba) values(?,?,?,?)", new Object[]{
                2, 4, "Sjajno", "Zika"
        });
        template.update("insert into KOMENTARI(vest_id, ocena, tekst, osoba) values(?,?,?,?)", new Object[]{
                3, 4, "Odlicno", "Tika"
        });

    }
}
