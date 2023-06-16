package ro.usv;

import java.util.List;

/**
 * @author Maciuc Simon-Gabriel
 * @grupa 3131A
 * @nr 2
 */
public interface IAsociatieProprietariServ2 {

    void setStocare(String nume);
    Apartament getApartamentById(int id);
    List<Apartament> getApartamente();
    void saveApartament(Apartament ap);
    void deleteApartment(int id);
    void deleteAllApartments();
    double getAverageSurface(String tip);
    List<Integer> findIdsMostRecentDate();
    List<Integer> findIDsSurfaceGreaterThan(double smin);
    public void keepFirst(int numar);
    public void keepLasts(int numar);


}