package ro.usv;

import ro.usv.dao.Dao;
import ro.usv.dao.SerializareDaoComplet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maciuc Simon-Gabriel
 * @grupa 3131A
 * @nr 2
 */
public class AsociatieProprietariServ implements IAsociatieProprietariServ2{

    private Dao<Apartament, Integer> asociatie;

    public AsociatieProprietariServ() {

        asociatie = new SerializareDaoComplet<>();
    }

    public AsociatieProprietariServ(String numeFisier) {

        asociatie = new SerializareDaoComplet<>(numeFisier);

    }

    public void setStocare(String nume) {
        if (nume == null || nume.equals("")) {
            asociatie = new SerializareDaoComplet<>();
        } else {
            asociatie = new SerializareDaoComplet<>(nume);
        }

    }

    public Apartament getApartamentById(int id) {
        return asociatie.get(id);
    }

    public List<Apartament> getApartamente() {
        return asociatie.getAll();
    }

    public void saveApartament(Apartament apartament){
        asociatie.save(apartament);
    }

    public void deleteApartment(int id){asociatie.delete(id);}

    public void deleteAllApartments(){
        asociatie.deleteAll();
    }

    public List<Integer> findIDsSurfaceGreaterThan(double smin){

        List <Integer> Id_uri=new ArrayList<>();
        List<Apartament> apartamente = asociatie.getAll();

        for (Apartament ap : apartamente) {
            if (ap.getSuprafata() >= smin) {
                Id_uri.add(ap.getId());
            }
        }
        return Id_uri;
    }

    public List<Integer> findIdsMostRecentDate(){

        int anRecent=0;
        List <Integer> Id_uri=new ArrayList<>();
        List<Apartament> apartamente = asociatie.getAll();

        for (Apartament ap: apartamente){
            if (anRecent<ap.getAnConstructie()) {
                anRecent = ap.getAnConstructie();
            }
        }

        for (Apartament ap: apartamente){
            if (anRecent==ap.getAnConstructie()) {
                Id_uri.add(ap.getId());
            }
        }

        return Id_uri;
    }

    public double getAverageSurface(String tip){

        List<Apartament> apartamente = asociatie.getAll();

        double sumaSuprafata=0, nr=0, suprafataMedie;


        for (Apartament ap: apartamente) {
            if (ap.getTip().equals(tip) || tip.equals("")) {
                sumaSuprafata += ap.getSuprafata();
                nr++;
            }
        }
        if (nr!=0)
            suprafataMedie=sumaSuprafata/nr;
        else
            return -1;

        return suprafataMedie;
    }

    public void keepFirst(int numar){

        List<Apartament> aparatamente = asociatie.getAll();
        int contor = 0;

        for (Apartament ap: aparatamente) {
            if (contor >= numar)
                asociatie.delete(ap.getId());
            contor++;
        }
    }

    public void keepLasts(int numar){

        List<Apartament> aparatamente = asociatie.getAll();
        int contor = aparatamente.size()-numar;

        for (Apartament ap: aparatamente) {
            if (contor >= numar)
                asociatie.delete(ap.getId());
            contor++;
        }
    }
}

