package com.example.server;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "Komentari")
public class Komentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    private int ocena;
    private String tekst;
    private String osoba;

    public Komentar() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public int getOcena() {
        return ocena;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public void setOsoba(String osoba) {
        this.osoba = osoba;
    }

    public String getOsoba() {
        return osoba;
    }

    public boolean equals(Object o) {
        if(o instanceof Komentar) {
            return id==((Komentar)o).id;
        }
        else
            return false;
    }

    public int hashCode() {return (int)id;}
}
