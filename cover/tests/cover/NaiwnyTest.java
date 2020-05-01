package cover;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NaiwnyTest {

    @org.junit.jupiter.api.Test
    void znajdzNumeryZbiorowPokrywajacych() {
        List<Integer> listaWzorcowa = new LinkedList<>();
        listaWzorcowa.add(1);
        //listaWzorcowa.add(3);
        //listaWzorcowa.add(2);
        listaWzorcowa.add(6);

        Algorytm naiwny = new Naiwny();

        ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(5);
        Skladnik skladnik1 = new Element(1);
        Skladnik skladnik2 = new Nieskonczony(3, 2);
        Skladnik skladnik3 = new Element(6);
        Skladnik skladnik4 = new Skonczony(1, 5, 7);
        Skladnik skladnik5 = new Element(9);
        Skladnik skladnik6 = new Skonczony(9, 12, 1);
        Skladnik skladnik7 = new Nieskonczony(2, 2);

        List<Zbior> listaZbiorow = new LinkedList<>();

        Zbior zbior1 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik1);
        listaZbiorow.add(zbior1);
        Zbior zbior2 = new Zbior();
        zbior1.dodajSkladnikDoZbioru(skladnik2);
        listaZbiorow.add(zbior2);
        Zbior zbior3 = new Zbior();
        zbior3.dodajSkladnikDoZbioru(skladnik3);
        listaZbiorow.add(zbior3);
        Zbior zbior4 = new Zbior();
        zbior4.dodajSkladnikDoZbioru(skladnik4);
        listaZbiorow.add(zbior4);
        Zbior zbior5 = new Zbior();
        zbior5.dodajSkladnikDoZbioru(skladnik5);
        listaZbiorow.add(zbior5);
        Zbior zbior6 = new Zbior();
        zbior6.dodajSkladnikDoZbioru(skladnik6);
        zbior6.dodajSkladnikDoZbioru(skladnik5);
        zbior6.dodajSkladnikDoZbioru(skladnik7);
        listaZbiorow.add(zbior6);

        List<Integer> naiwna = new LinkedList<>();
        naiwna = naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia);

        assertArrayEquals(listaWzorcowa.toArray(), naiwna.toArray());
        assertTrue(naiwny.czyZostalPokrytyCalyZbior(listaZbiorow, zbiorDoPokrycia, naiwny.znajdzNumeryZbiorowPokrywajacych(listaZbiorow, zbiorDoPokrycia)));
    }
}