package cover;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZachlannyTest {

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
        listaWzorcowa4.add(2);
        listaWzorcowa4.add(5);
        listaWzorcowa4.add(6);
        listaWzorcowa4.add(7);


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


        Algorytm zach = new Zachlanny();

        List<Integer> zach1 = new LinkedList<>();
        List<Integer> zach2 = new LinkedList<>();
        List<Integer> zach3 = new LinkedList<>();
        List<Integer> zach4 = new LinkedList<>();

        zach1 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow1, zbiorDoPokrycia1);
        zach2 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow2, zbiorDoPokrycia2);
        zach3 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow3, zbiorDoPokrycia3);
        zach4 = zach.znajdzNumeryZbiorowPokrywajacych(listaZbiorow4, zbiorDoPokrycia4);


        assertEquals(listaWzorcowa1, zach1);
        assertEquals(listaWzorcowa2, zach2);
        assertEquals(listaWzorcowa3, zach3);
        assertEquals(listaWzorcowa4, zach4);

        //assertTrue(naiwny.czyZostalPokrytyCalyZbior(listaZbiorow, zbiorDoPokrycia, naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia)));

    }
}