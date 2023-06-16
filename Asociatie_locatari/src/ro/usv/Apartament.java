package ro.usv;

import ro.usv.dao.Entitate;
import java.time.Year;

/**
 * @author Maciuc Simon-Gabriel
 * @grupa 3131A
 * @nr 2
 */
public abstract class Apartament extends Entitate {
    private int Id;
    private int anConstructie;
    private double suprafata;
    private String strada, scara, tip;
    private int nr, etaj, nrApartament;
    public Apartament(String tip, int id, double suprafata, int anConstructie, String strada, int nr, String scara , int etaj, int nrApartament){

        try {
            if (anConstructie > Year.now().getValue() ||
                    suprafata <= 0 || nr < 0 || nrApartament < 0) {
                throw new IllegalArgumentException();
            }
            this.tip=tip;
            this.Id = id;
            this.anConstructie = anConstructie;
            this.suprafata = suprafata;
            this.strada = strada;
            this.scara = scara;
            this.nr = nr;
            this.etaj = etaj;
            this.nrApartament = nrApartament;
        }
        catch (IllegalArgumentException ignored){

        }
    }

    public int getVechime(){
        return Year.now().getValue()-anConstructie;
    }
    @Override
    public Integer getId() {
        return Id;
    }

    public String getTip() {
        return tip;
    }

    public int getAnConstructie() {
        return anConstructie;
    }

    public double getSuprafata() {
        return suprafata;
    }

    public String getStrada() {
        return strada;
    }

    public String getScara() {
        return scara;
    }

    public int getNr() {
        return nr;
    }

    public int getEtaj() {
        return etaj;
    }

    public int getNrApartament() {
        return nrApartament;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setAnConstructie(int anConstructie) {
        this.anConstructie = anConstructie;
    }

    public void setSuprafata(double suprafata) {
        this.suprafata = suprafata;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public void setScara(String scara) {
        this.scara = scara;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public void setNrApartament(int nrApartament) {
        this.nrApartament = nrApartament;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
