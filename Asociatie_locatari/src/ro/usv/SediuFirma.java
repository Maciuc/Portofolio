package ro.usv;

import java.time.Year;

/**
 * @author Maciuc Simon-Gabriel
 * @grupa 3131A
 * @nr 2
 */
public class SediuFirma extends Apartament {
    private String denumire;
    private String CUI;

    public SediuFirma(String tip, int id, double suprafata, int anConstructie, String strada, int nr, String scara, int etaj, int nrApartament,
                      String denumire, String CUI) {

        super(tip, id, suprafata, anConstructie, strada, nr, scara, etaj, nrApartament);

        try{
            if (!CUI.matches("[0-9]+") ||
                    anConstructie > Year.now().getValue() || suprafata <= 0 || nr < 0 || nrApartament < 0) {
                throw new IllegalArgumentException("Eroare. Valori incorecte pentru crearea unui sediu de firma!");
            }
            this.denumire=denumire;
            this.CUI=CUI;

        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "{" +
                "Tip='" + getTip() + '\'' +
                ", Id=" + getId() +
                ", suprafata=" + getSuprafata() +
                ", anConstructie=" + getAnConstructie() +
                ", strada='" + getStrada() + '\'' +
                ", nr=" + getNr() +
                ", scara='" + getScara() + '\'' +
                ", etaj=" + getEtaj() +
                ", nrApt=" + getNrApartament() +
                ", denumire='" + denumire + '\'' +
                ", CUI='" + CUI + '\'' +
                '}';
    }

    public String getDenumire() {
        return denumire;
    }

    public String getCUI() {
        return CUI;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }
}
