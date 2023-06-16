package ro.usv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * @author Maciuc Simon-Gabriel
 * @grupa 3131A
 * @nr 2
 */
public class AsociatieProprietariClient {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scnr;

        if (args.length==0)
            scnr = new Scanner(new File("in2.txt"));
        else
        {
            scnr = new Scanner(new File(args[0]));
            System.setOut(new PrintStream("out2.txt"));
            System.setErr(new PrintStream("out2.txt"));
        }

        String[] argumente;
        IAsociatieProprietariServ2 asociatieProprietari = new AsociatieProprietariServ();

        while (scnr.hasNextLine()) {

            argumente = scnr.nextLine().split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (int i=0;i<argumente.length;i++)
                argumente[i]=argumente[i].replace("\"","");

            switch(argumente[0]) {

                case "file":
                    if (argumente.length != 2)
                        System.err.println("Eroare. Numarul parametrilor nu este corect -> file");
                    else
                        asociatieProprietari.setStocare(argumente[1]);
                    break;


                case "add":
                    if (argumente[1].equals("L")) {
                        if (argumente.length != 11)
                            System.err.println("Eroare. Numarul parametrilor nu este corect -> add");
                        else
                            asociatieProprietari.saveApartament(new Locuinta(argumente[1],
                                    Integer.parseInt(argumente[2]), Double.parseDouble(argumente[3]),
                                    Integer.parseInt(argumente[4]), argumente[5], Integer.parseInt(argumente[6]),
                                    argumente[7], Integer.parseInt(argumente[8]), Integer.parseInt(argumente[9]),
                                    Integer.parseInt(argumente[10])));
                    } else if (argumente[1].equals("SF")) {
                        if (argumente.length != 12)
                            System.err.println("Eroare. Numarul parametrilor nu este corect -> add");
                        else
                            asociatieProprietari.saveApartament(new SediuFirma(argumente[1],
                                    Integer.parseInt(argumente[2]), Double.parseDouble(argumente[3]),
                                    Integer.parseInt(argumente[4]), argumente[5], Integer.parseInt(argumente[6]),
                                    argumente[7], Integer.parseInt(argumente[8]), Integer.parseInt(argumente[9]),
                                    argumente[10], argumente[11]));
                    } else
                        System.err.println("Eroare. Nu exista tipul de apartament -> add");

                    break;


                case "list":
                    if (argumente.length == 1)
                        for (Apartament ap : asociatieProprietari.getApartamente())
                            System.out.println(ap);
                    else {
                        if (argumente.length == 2)
                            System.out.println(asociatieProprietari.getApartamentById(Integer.parseInt(argumente[1])));
                        else
                            System.err.println("Eroare. Numarul parametrilor nu este corect -> list");
                    }
                    break;


                case "clear":
                    if (argumente.length == 1)
                        asociatieProprietari.deleteAllApartments();
                    else
                        System.err.println("Eroare. Numarul parametrilor nu este corect -> clear");
                    break;


                case "delete":
                    if (argumente.length == 2)
                        asociatieProprietari.deleteApartment(Integer.parseInt(argumente[1]));
                    else
                        System.err.println("Eroare. Numarul parametrilor nu este corect -> delete");
                    break;


                case "rem":
                    for (String cuvant : argumente)
                        System.out.print(cuvant + " ");
                    System.out.println();
                    break;


                case "stop":
                    System.out.println("La revedere!");
                    System.exit(1);
                    break;


                case "avgsurf":
                    if (argumente.length == 1) {
                        System.out.println("Suprafata medie a apartamentelor: " +
                                asociatieProprietari.getAverageSurface(""));
                    } else {
                        if (argumente.length == 2) {
                            if (argumente[1].equals("L"))
                                System.out.println("Suprafata medie a locuintelor: " +
                                        asociatieProprietari.getAverageSurface("L"));
                            else if (argumente[1].equals("SF"))
                                System.out.println("Suprafata medie a sediilor de firme: " +
                                        asociatieProprietari.getAverageSurface("SF"));
                            else
                                System.err.println("Eroare. Nu exista tipul respectiv");

                        } else
                            System.err.println("Eroare. Numarul parametrilor nu este corect -> avgsurf");
                    }
                    break;


                case "surfgt":
                    if (argumente.length != 2)
                        System.err.println("Eroare. Numarul parametrilor nu este corect -> surfgt");
                    else

                        System.out.println("Ap. cu suprafata cel putin egala cu " + argumente[1] + ": " +
                                asociatieProprietari.findIDsSurfaceGreaterThan(Double.parseDouble(argumente[1])));
                    break;


                case "mostrecent":
                    if (argumente.length != 1)
                        System.err.println("Eroare. Numarul parametrilor nu este corect -> mostrecent");
                    else
                        System.out.println("Ap. cele mai recente sunt: " +
                                asociatieProprietari.findIdsMostRecentDate());
                    break;

                case "keep":
                    if (argumente.length !=3)
                        System.err.println("Eroare. Numarul parametrilor nu este corect -> keep");
                    else
                    {
                        if (argumente[1].equals("f"))
                            asociatieProprietari.keepFirst(Integer.parseInt(argumente[2]));
                        if (argumente[1].equals("l"))
                            asociatieProprietari.keepLasts(Integer.parseInt(argumente[2]));
                    }
                    break;


                default:
                    if (!argumente[0].equals(""))
                        System.err.println("Eroare. Comanda neimplementata");
            }
        }
    }
}
