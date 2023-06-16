package ro.usv;

import java.time.Year;

/**
 * @author Maciuc Simon-Gabriel
 * @grupa 3131A
 * @nr 2
 */
public class Locuinta extends Apartament{
    private int nrpersoane;
    public Locuinta(String tip, int id, double suprafata, int anConstructie, String strada, int nr, String scara, int etaj, int nrApartament,
                    int nrpersoane) {

        super(tip, id, suprafata, anConstructie, strada, nr, scara, etaj, nrApartament);
        try{
            if (nrpersoane < 0 ||
                    anConstructie > Year.now().getValue() || suprafata <= 0 || nr < 0 || nrApartament < 0) {
                throw new IllegalArgumentException("Valori incorecte pentru crearea unei locuinte!");
            }
            this.nrpersoane = nrpersoane;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "{" +
                "Tip='" + getTip() + '\'' +
                ", id=" + getId() +
                ", suprafata=" + getSuprafata() +
                ", anConstructie=" + getAnConstructie() +
                ", strada='" + getStrada() + '\'' +
                ", nr=" + getNr() +
                ", scara='" + getScara() + '\'' +
                ", etaj=" + getEtaj() +
                ", nrApt=" + getNrApartament() +
                ", nrPersoane=" + nrpersoane +
                '}';
    }

    public int getNrpersoane() {
        return nrpersoane;
    }

    public void setNrpersoane(int nrpersoane) {
        this.nrpersoane = nrpersoane;
    }
}
