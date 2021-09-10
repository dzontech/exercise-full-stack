package com.example.server;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Vesti")
public class Vest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    private String mesto;
    private String naslov;
    private int strana;
    private String autor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VEST_ID")
    private List<Komentar> komentari;

    public Vest() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getMesto() {
        return mesto;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setStrana(int strana) {
        this.strana = strana;
    }

    public int getStrana() {
        return strana;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setKomentari(List<Komentar> komentari) {
        this.komentari = komentari;
    }

    public List<Komentar> getKomentari() {
        return komentari;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Vest)
            return id==((Vest)o).id;
        else
            return false;
    }

    @Override
    public int hashCode() {return (int) id;}
}
