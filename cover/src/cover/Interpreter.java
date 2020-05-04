package cover;


import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;


import static java.lang.Math.abs;

public class Interpreter {
    List<Integer> listaLiczbZWejscia;

    public Interpreter(List<Integer> listaLiczbZWejscia) {
        this.listaLiczbZWejscia = listaLiczbZWejscia;
    }


    public void zinterpretujWejscie() {

        Zbior nowyZbior = new Zbior();
        List<Zbior> listaZbiorow = new LinkedList<>();
        Dokladny dokladny = new Dokladny();
        Zachlanny zachlanny = new Zachlanny();
        Naiwny naiwny = new Naiwny();
        boolean czyPierwszyWyraz = true;

        for (int i = 0; i < listaLiczbZWejscia.size(); i++) {

            if (czyNastepneWejscieToZapytanie(i)) {
                ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(abs(listaLiczbZWejscia.get(i)));
                if (listaZbiorow.isEmpty()) {

                    if (!czyPierwszyWyraz) {
                        System.out.print("\n");
                    }
                    System.out.print(0);
                    czyPierwszyWyraz = false;
                    i++;
                    continue;
                }
                else {
                    i++;
                    if (czyWykonacAlgorytmDokladny(i)) {
                        List<Integer> listaZNumerami =
                                dokladny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);
                        wypiszAlgorytm(listaZNumerami, czyPierwszyWyraz);
                        czyPierwszyWyraz = false;

                    }
                    else if (czyWykonacAlgorytmZachlanny(i)) {
                        List<Integer> listaZNumerami =
                                zachlanny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);
                        wypiszAlgorytm(listaZNumerami, czyPierwszyWyraz);
                        czyPierwszyWyraz = false;

                    }
                    else if (czyWykonacAlgorytmNaiwny(i)) {
                        List<Integer> listaZNumerami =
                                naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);
                        wypiszAlgorytm(listaZNumerami, czyPierwszyWyraz);
                        czyPierwszyWyraz = false;
                    }
                    continue;
                }
            }

            if (czyNastepneWejscieToSkladnik(i)) {

                if (czyToKoniecZbioru(i)) {
                    if (nowyZbior.czyZbiorJestPusty()) {
                        Skladnik pustyElement = new Element(0); //TODO sprawdzic czy to potrzbene
                        nowyZbior.dodajSkladnikDoZbioru(pustyElement);
                    }
                    listaZbiorow.add(nowyZbior);
                    nowyZbior = new Zbior();
                    continue;
                }
                if (czyTenSkladnikToElement(i)) {

                    Skladnik element = new Element(listaLiczbZWejscia.get(i));
                    nowyZbior.dodajSkladnikDoZbioru(element);

                    continue;
                }

                if (czyTenSkladnikToSkonczony(i)) {
                    Skladnik skonczony = new Skonczony(listaLiczbZWejscia.get(i), abs(listaLiczbZWejscia.get(i + 1)),
                            abs(listaLiczbZWejscia.get(i + 2)));
                    nowyZbior.dodajSkladnikDoZbioru(skonczony);
                    i += 2;
                    continue;
                }

                if (czyTenSkladnikToNieskonczony(i)) {
                    Skladnik nieskonczony = new Nieskonczony(listaLiczbZWejscia.get(i), abs(listaLiczbZWejscia.get(i + 1)));
                    nowyZbior.dodajSkladnikDoZbioru(nieskonczony);
                    i++;
                }
            }

        }
    }


    boolean czyNastepneWejscieToSkladnik(int i) {
        return listaLiczbZWejscia.get(i) >= 0;
    }

    boolean czyNastepneWejscieToZapytanie(int i) {
        return listaLiczbZWejscia.get(i) < 0;
    }

    boolean czyTenSkladnikToElement(int i) {
        return listaLiczbZWejscia.get(i + 1) >= 0 & listaLiczbZWejscia.get(i) > 0;
    }

    boolean czyTenSkladnikToSkonczony(int i) {
        return listaLiczbZWejscia.get(i + 2) < 0 & listaLiczbZWejscia.get(i + 1) < 0 & listaLiczbZWejscia.get(i) > 0;
    }

    boolean czyTenSkladnikToNieskonczony(int i) {
        return listaLiczbZWejscia.get(i + 2) >= 0 & listaLiczbZWejscia.get(i + 1) < 0 & listaLiczbZWejscia.get(i) > 0;
    }

    boolean czyToKoniecZbioru(int i) {
        return listaLiczbZWejscia.get(i) == 0;
    }

    boolean czyWykonacAlgorytmDokladny(int i) {
        return listaLiczbZWejscia.get(i) == 1;
    }

    boolean czyWykonacAlgorytmNaiwny(int i) {
        return listaLiczbZWejscia.get(i) == 3;
    }

    boolean czyWykonacAlgorytmZachlanny(int i) {
        return listaLiczbZWejscia.get(i) == 2;
    }

    void wypiszAlgorytm(List<Integer> listaZNumerami, boolean czyPierwszyWyraz) {
        if (!czyPierwszyWyraz) {
            System.out.print("\n");
        }
        for (int numery = 0; numery < listaZNumerami.size(); numery++) {
            System.out.print(listaZNumerami.get(numery));
            if (numery != listaZNumerami.size() - 1) {
                System.out.print(" ");
            }
            else {
                System.out.print("");
            }
        }
    }
}
