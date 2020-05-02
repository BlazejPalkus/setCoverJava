package cover;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DokladnyTest {

    @Test
    void znajdzNumeryZbiorowPokrywajacych() {


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
        List<Integer> listaWzorcowa2 = new LinkedList<>();
        listaWzorcowa2.add(2);
        listaWzorcowa2.add(5);

        Skladnik skladnik0 = new Element(0);


        Skladnik skladnik7 = new Skonczony(4, 1, 5);
        Skladnik skladnik8 = new Element(10000000);
        Skladnik skladnik9 = new Nieskonczony(2, 2);
        //zapytanie

        ZbiorDoPokrycia zbiorDoPokrycia3 = new ZbiorDoPokrycia(6);
        List<Integer> listaWzorcowa3 = new LinkedList<>();
        listaWzorcowa3.add(2);
        listaWzorcowa3.add(5);
        listaWzorcowa3.add(6);
        listaWzorcowa3.add(7);


        Skladnik skladnik10 = new Element(1);
        Skladnik skladnik11 = new Element(6);
        //zapytanie
        ZbiorDoPokrycia zbiorDoPokrycia4 = new ZbiorDoPokrycia(6);
        List<Integer> listaWzorcowa4 = new LinkedList<>();
        listaWzorcowa4.add(5);
        listaWzorcowa4.add(6);
        listaWzorcowa4.add(8);


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


        Algorytm zach = new Dokladny();

        List<Integer> zach1 = new LinkedList<>();
        List<Integer> zach2 = new LinkedList<>();
        List<Integer> zach3 = new LinkedList<>();
        List<Integer> zach4 = new LinkedList<>();

        zach1 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow1, zbiorDoPokrycia1);
        zach2 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow2, zbiorDoPokrycia2);
        zach3 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow3, zbiorDoPokrycia3);
        zach4 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow4, zbiorDoPokrycia4);


        assertArrayEquals(listaWzorcowa1.toArray(), zach1.toArray());
        assertArrayEquals(listaWzorcowa2.toArray(), zach2.toArray());
        assertArrayEquals(listaWzorcowa3.toArray(), zach3.toArray());
        assertArrayEquals(listaWzorcowa4.toArray(), zach4.toArray());
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
    void daSieZbiorPrzerobicNaListe() {
        Dokladny dokladny = new Dokladny();
        List<Integer> zbior = Arrays.asList(1, 2, 3);

        BigInteger x1 = BigInteger.valueOf(0);
        x1 = x1.setBit(0).setBit(1);
//        Set<Integer> otrzymany = dokladny.podzbiorZBigInteger(lista, x1);
//        Set<Integer> spodziewany = new HashSet<>();
//        spodziewany.add(1);
//        spodziewany.add(2);
//        assertEquals(otrzymany, spodziewany);
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

//
//    @Test
//    void bigInteger111DajeZbiorPelny() {
//        Dokladny dokladny = new Dokladny();
//        List<Integer> lista = Arrays.asList(1, 2, 3);
//
//        BigInteger x1 = BigInteger.valueOf(0);
//        x1 = x1.set;
//        Set<Integer> otrzymany = dokladny.podzbiorZBigInteger(lista, x1);
//        Set<Integer> spodziewany = new HashSet<>();
//        spodziewany.add(1);
//        spodziewany.add(2);
//        assertEquals(otrzymany, spodziewany);
//    }
}