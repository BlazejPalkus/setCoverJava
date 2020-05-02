package cover;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DokladnyTest {

    @Test
    void zwrocZeroGdyZadenPodzbiorNiePokrywa() {
        ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(6);

        List<Integer> listaWzorcowa = new LinkedList<>();
        listaWzorcowa.add(0);

        List<Zbior> listaZbiorow = new LinkedList<>();

        Skladnik skladnik1 = new Element(2);
        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);
        listaZbiorow.add(zbior1);

        Skladnik skladnik2 = new Element(1);
        Zbior zbior2 = new Zbior();
        zbior2.dodajSkladnikDoZbioru(skladnik2);
        listaZbiorow.add(zbior2);

        Skladnik skladnik3 = new Element(1);
        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik3);
        listaZbiorow.add(zbior3);

        Algorytm dokladny = new Dokladny();
        List<Integer> otrzymany = dokladny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);
        List<Integer> oczekiwany = listaWzorcowa;

        assertEquals(otrzymany, oczekiwany);
    }

    @Test
    void zwrocWszystkieZbioryGdyIchSumaPokrywa() {
        ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(6);

        List<Integer> listaWzorcowa = Arrays.asList(1, 2, 3);

        List<Zbior> listaZbiorow = new LinkedList<>();

        Skladnik skladnik1 = new Element(2);
        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);
        listaZbiorow.add(zbior1);

        Skladnik skladnik2 = new Element(1);
        Zbior zbior2 = new Zbior();
        zbior2.dodajSkladnikDoZbioru(skladnik2);
        listaZbiorow.add(zbior2);

        Skladnik skladnik3 = new Nieskonczony(3, 1);
        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik3);
        listaZbiorow.add(zbior3);

        Algorytm dokladny = new Dokladny();
        List<Integer> otrzymany = dokladny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);
        List<Integer> oczekiwany = listaWzorcowa;

        assertEquals(oczekiwany, otrzymany);
    }


    @Test
    void zwrocJedenDobryZbiorBoZawieraZbiorDoPokrycia() {
        ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(6);

        List<Integer> listaWzorcowa = Arrays.asList(4);

        List<Zbior> listaZbiorow = new LinkedList<>();

        Skladnik skladnik1 = new Element(2);
        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);
        listaZbiorow.add(zbior1);

        Skladnik skladnik2 = new Element(1);
        Zbior zbior2 = new Zbior();
        zbior2.dodajSkladnikDoZbioru(skladnik2);
        listaZbiorow.add(zbior2);

        Skladnik skladnik3 = new Nieskonczony(9, 5);
        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik3);
        listaZbiorow.add(zbior3);

        Skladnik skladnik4 = new Skonczony(1, 1, 10);
        Zbior zbior4 = new Zbior();
        zbior4.dodajSkladnikDoZbioru(skladnik4);
        listaZbiorow.add(zbior4);


        Algorytm dokladny = new Dokladny();
        List<Integer> otrzymany = dokladny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);
        List<Integer> oczekiwany = listaWzorcowa;

        assertEquals(oczekiwany, otrzymany);
    }

    @Test
    void zwrocDobrzeWPorzadkuLeksykograficznym() {
        ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(6);

        List<Integer> listaWzorcowa = Arrays.asList(1, 3);

        List<Zbior> listaZbiorow = new LinkedList<>();

        Skladnik skladnik1 = new Element(2);
        Skladnik skladnik2 = new Element(1);
        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);
        zbior1.dodajSkladnikDoZbioru(skladnik2);
        listaZbiorow.add(zbior1);


        Zbior zbior2 = new Zbior();
        zbior2.dodajSkladnikDoZbioru(skladnik1);
        zbior2.dodajSkladnikDoZbioru(skladnik2);
        listaZbiorow.add(zbior2);

        Skladnik skladnik3 = new Nieskonczony(3, 1);
        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik3);
        listaZbiorow.add(zbior3);

        Skladnik skladnik4 = new Skonczony(1, 9, 10);
        Zbior zbior4 = new Zbior();
        zbior4.dodajSkladnikDoZbioru(skladnik4);
        listaZbiorow.add(zbior4);


        Algorytm dokladny = new Dokladny();
        List<Integer> otrzymany = dokladny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);
        List<Integer> oczekiwany = listaWzorcowa;

        assertEquals(oczekiwany, otrzymany);
    }

    @Test
    void sprawdzPrzykladyZTresciZadania() {


        ZbiorDoPokrycia zbiorDoPokrycia1 = new ZbiorDoPokrycia(3);
        Skladnik skladnik1 = new Element(2);
        Skladnik skladnik2 = new Element(1);
        Skladnik skladnik3 = new Element(1);
        //zapytanie 0
        List<Integer> listaWzorcowa1 = new LinkedList<>();
        listaWzorcowa1.add(0);

        Skladnik skladnik4 = new Element(2);
        Skladnik skladnik5 = new Element(3);
        Skladnik skladnik6 = new Element(2);
        //zapytanie
        ZbiorDoPokrycia zbiorDoPokrycia2 = new ZbiorDoPokrycia(3);
        List<Integer> listaWzorcowa2 = Arrays.asList(2, 5);


        Skladnik skladnik0 = new Element(0);


        Skladnik skladnik7 = new Skonczony(4, 1, 5);
        Skladnik skladnik8 = new Element(10000000);
        Skladnik skladnik9 = new Nieskonczony(2, 2);
        //zapytanie

        ZbiorDoPokrycia zbiorDoPokrycia3 = new ZbiorDoPokrycia(6);
        List<Integer> listaWzorcowa3 = Arrays.asList(2, 5, 6, 7);


        Skladnik skladnik10 = new Element(1);
        Skladnik skladnik11 = new Element(6);
        //zapytanie
        ZbiorDoPokrycia zbiorDoPokrycia4 = new ZbiorDoPokrycia(6);
        List<Integer> listaWzorcowa4 = Arrays.asList(5, 6, 8);


        List<Zbior> listaZbiorow1 = new LinkedList<>();
        List<Zbior> listaZbiorow2 = new LinkedList<>();
        List<Zbior> listaZbiorow3 = new LinkedList<>();
        List<Zbior> listaZbiorow4 = new LinkedList<>();
        List<Zbior> listaZbiorow5 = new LinkedList<>();


        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);
        listaZbiorow1.add(zbior1);
        listaZbiorow2.add(zbior1);
        listaZbiorow3.add(zbior1);
        listaZbiorow4.add(zbior1);

        Zbior zbior2 = new Zbior();
        zbior2.dodajSkladnikDoZbioru(skladnik2);
        listaZbiorow1.add(zbior2);
        listaZbiorow2.add(zbior2);
        listaZbiorow3.add(zbior2);
        listaZbiorow4.add(zbior2);

        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik3);
        listaZbiorow1.add(zbior3);
        listaZbiorow2.add(zbior3);
        listaZbiorow3.add(zbior3);
        listaZbiorow4.add(zbior3);

        Zbior zbior4 = new Zbior();
        zbior4.dodajSkladnikDoZbioru(skladnik0);
        listaZbiorow2.add(zbior4);
        listaZbiorow3.add(zbior4);
        listaZbiorow4.add(zbior4);

        Zbior zbior5 = new Zbior();
        zbior5.dodajSkladnikDoZbioru(skladnik4);
        zbior5.dodajSkladnikDoZbioru(skladnik5);
        zbior5.dodajSkladnikDoZbioru(skladnik6);
        listaZbiorow2.add(zbior5);
        listaZbiorow3.add(zbior5);
        listaZbiorow4.add(zbior5);

        Zbior zbior6 = new Zbior();
        zbior6.dodajSkladnikDoZbioru(skladnik7);
        zbior6.dodajSkladnikDoZbioru(skladnik8);
        listaZbiorow3.add(zbior6);
        listaZbiorow4.add(zbior6);

        Zbior zbior7 = new Zbior();
        zbior7.dodajSkladnikDoZbioru(skladnik9);
        listaZbiorow3.add(zbior7);
        listaZbiorow4.add(zbior7);

        Zbior zbior8 = new Zbior();
        zbior8.dodajSkladnikDoZbioru(skladnik10);
        zbior8.dodajSkladnikDoZbioru(skladnik11);
        listaZbiorow4.add(zbior8);


        Algorytm naiwny = new Dokladny();

        List<Integer> naiwna1 = new LinkedList<>();
        List<Integer> naiwna2 = new LinkedList<>();
        List<Integer> naiwna3 = new LinkedList<>();
        List<Integer> naiwna4 = new LinkedList<>();

        naiwna1 = naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow1, zbiorDoPokrycia1);
        naiwna2 = naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow2, zbiorDoPokrycia2);
        naiwna3 = naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow3, zbiorDoPokrycia3);
        naiwna4 = naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow4, zbiorDoPokrycia4);


        assertEquals(listaWzorcowa1, naiwna1);
        assertEquals(listaWzorcowa2, naiwna2);
        assertEquals(listaWzorcowa3, naiwna3);
        assertEquals(listaWzorcowa4, naiwna4);


    }

    @Test
    void bigIntegerZeroDajeZbiorPusty() {
        Dokladny dokladny = new Dokladny();
        List<Integer> lista = Arrays.asList(1, 2, 3);

        BigInteger x0 = BigInteger.valueOf(0);
        Set<Integer> otrzymany1 = dokladny.podzbiorZBigInteger(lista, x0);
        Set<Integer> spodziewany1 = new HashSet<>();
        assertEquals(otrzymany1, spodziewany1);

        BigInteger x2 = BigInteger.valueOf(2);
    }

    @Test
    void bigIntegerO01DajeZbiorZPierwszymElementem() {
        Dokladny dokladny = new Dokladny();
        List<Integer> lista = Arrays.asList(1, 2, 3);

        BigInteger x1 = BigInteger.valueOf(1);
        Set<Integer> otrzymany = dokladny.podzbiorZBigInteger(lista, x1);
        Set<Integer> spodziewany = new HashSet<>();
        spodziewany.add(1);
        assertEquals(otrzymany, spodziewany);
    }


    @Test
    void bigInteger011DajeDwaPierwszeElementy() {
        Dokladny dokladny = new Dokladny();
        List<Integer> lista = Arrays.asList(1, 2, 3);

        BigInteger x1 = BigInteger.valueOf(0);
        x1 = x1.setBit(0).setBit(1);
        Set<Integer> otrzymany = dokladny.podzbiorZBigInteger(lista, x1);
        Set<Integer> spodziewany = new HashSet<>();
        spodziewany.add(1);
        spodziewany.add(2);
        assertEquals(otrzymany, spodziewany);
    }

    @Test
    void bigInteger111DajeZbiorPelny() {
        Dokladny dokladny = new Dokladny();
        List<Integer> lista = Arrays.asList(1, 2, 3);

        BigInteger x1 = BigInteger.valueOf(0).setBit(0).setBit(1).setBit(2);
        Set<Integer> otrzymany = dokladny.podzbiorZBigInteger(lista, x1);
        Set<Integer> spodziewany = new HashSet<>();
        spodziewany.add(1);
        spodziewany.add(2);
        spodziewany.add(3);
        assertEquals(spodziewany, otrzymany);
    }


    @Test
    void daSieZbiorPrzerobicNaListe() {
        Dokladny dokladny = new Dokladny();
        List<Integer> zbior = Arrays.asList(1, 2, 3);

        BigInteger x1 = BigInteger.valueOf(0);
        x1 = x1.setBit(0).setBit(1);
        Set<Integer> podzbior = dokladny.podzbiorZBigInteger(zbior, x1);
        List<Integer> podzbiorJakoLista = new ArrayList<Integer>(podzbior.size());
        podzbiorJakoLista.addAll(podzbior);
        System.out.println(podzbior.toString());
        System.out.println(podzbiorJakoLista.toString());
    }

    @Test
    void zbiory211NiePokrywajaZbioru123() {
        ZbiorDoPokrycia zbiorDoPokrycia1 = new ZbiorDoPokrycia(3);
        Skladnik skladnik1 = new Element(2);
        Skladnik skladnik2 = new Element(1);
        Skladnik skladnik3 = new Element(1);
        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);

        Zbior zbior2 = new Zbior();
        zbior2.dodajSkladnikDoZbioru(skladnik2);

        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik3);

        List<Zbior> lista = new LinkedList<>();
        lista.add(zbior1);
        lista.add(zbior2);
        lista.add(zbior3);

        Set<Integer> numery = new HashSet<>();
        numery.add(1);
        numery.add(2);
        numery.add(3);
        Dokladny dokladny = new Dokladny();
        boolean oczekiwany = false;
        boolean otrzymany = dokladny.czyZbioryOPodanychNumerachPokrywajaZbior(numery, lista, zbiorDoPokrycia1);
        assertEquals(otrzymany, oczekiwany);

    }

    @Test
    void zbioryRoznePokrywajaZbior123456() {
        ZbiorDoPokrycia zbiorDoPokrycia1 = new ZbiorDoPokrycia(6);
        Skladnik skladnik1 = new Element(1);
        Skladnik skladnik2 = new Skonczony(1, 1, 2);
        Skladnik skladnik3 = new Skonczony(1, 1, 3);
        Skladnik skladnik4 = new Skonczony(1, 3, 5);
        Skladnik skladnik5 = new Nieskonczony(5, 1);
        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);
        zbior1.dodajSkladnikDoZbioru(skladnik2);

        Zbior zbior2 = new Zbior();
        zbior2.dodajSkladnikDoZbioru(skladnik3);
        zbior2.dodajSkladnikDoZbioru(skladnik4);

        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik5);

        List<Zbior> lista = new LinkedList<>();
        lista.add(zbior1);
        lista.add(zbior2);
        lista.add(zbior3);

        Set<Integer> numery = new HashSet<>();
        numery.add(1);
        numery.add(2);
        numery.add(3);
        Dokladny dokladny = new Dokladny();
        boolean oczekiwany = true;
        boolean otrzymany = dokladny.czyZbioryOPodanychNumerachPokrywajaZbior(numery, lista, zbiorDoPokrycia1);
        assertEquals(otrzymany, oczekiwany);

    }

//    @Test
//    void wielkoscZbioruPustegoTo0() {
//
//        Dokladny dokladny = new Dokladny();
//        List<Set<Integer>> listaZPustymSkladnikiem = new LinkedList<>();
//        int otrzymany = dokladny.wielkoscNajmniejszegoZbioru(listaZPustymSkladnikiem);
//        int spodziewany = 0;
//        assertEquals(spodziewany, otrzymany);
//    }
//
//    @Test
//    void listaZMalejacoPosegregowanymiZbioramiZwrociOstatni() {
//
//        Dokladny dokladny = new Dokladny();
//        List<Set<Integer>> lista = new LinkedList<>();
//
//        Set<Integer> zbior1 = new HashSet<>();
//        zbior1.addAll(Arrays.asList(1, 2, 3, 4, 5));
//        lista.add(zbior1);
//
//        Set<Integer> zbior2 = new HashSet<>();
//        zbior2.addAll(Arrays.asList(1, 2, 3));
//        lista.add(zbior2);
//
//        Set<Integer> zbior3 = new HashSet<>();
//        zbior3.addAll(Arrays.asList(1, 2));
//        lista.add(zbior3);
//
//
//        int otrzymany = dokladny.wielkoscNajmniejszegoZbioru(lista);
//        int spodziewany = 2;
//        assertEquals(spodziewany, otrzymany);
//    }
//
//    @Test
//    void listaZPustymNaKoncuIMalejacoPosegregowanymiZbioramiZwrociNajmnijeszy() {
//
//        Dokladny dokladny = new Dokladny();
//        List<Set<Integer>> lista = new LinkedList<>();
//
//        Set<Integer> zbior1 = new HashSet<>();
//        zbior1.addAll(Arrays.asList(1, 2, 3, 4, 5));
//        lista.add(zbior1);
//
//        Set<Integer> zbior2 = new HashSet<>();
//        zbior2.addAll(Arrays.asList(1, 2, 3));
//        lista.add(zbior2);
//
//        Set<Integer> zbior3 = new HashSet<>();
//        zbior3.addAll(Arrays.asList(1, 2));
//        lista.add(zbior3);
//        Set<Integer> zbior4 = new HashSet<>();
//        lista.add(zbior4);
//
//
//        int otrzymany = dokladny.wielkoscNajmniejszegoZbioru(lista);
//        int spodziewany = 2;
//        assertEquals(spodziewany, otrzymany);
//    }
//
//    @Test
//    void listaZPustymNaPoczatkuIMalejacoPosegregowanymiZbioramiZwrociNajmnijeszy() {
//
//        Dokladny dokladny = new Dokladny();
//        List<Set<Integer>> lista = new LinkedList<>();
//
//        Set<Integer> zbior1 = new HashSet<>();
//        lista.add(zbior1);
//
//        Set<Integer> zbior2 = new HashSet<>();
//        zbior2.addAll(Arrays.asList(1, 2, 3, 4, 5));
//        lista.add(zbior2);
//
//        Set<Integer> zbior3 = new HashSet<>();
//        zbior3.addAll(Arrays.asList(1, 2, 3));
//        lista.add(zbior3);
//
//        Set<Integer> zbior4 = new HashSet<>();
//        zbior4.addAll(Arrays.asList(1, 2));
//        lista.add(zbior4);
//
//
//        int otrzymany = dokladny.wielkoscNajmniejszegoZbioru(lista);
//        int spodziewany = 2;
//        assertEquals(spodziewany, otrzymany);
//    }
}