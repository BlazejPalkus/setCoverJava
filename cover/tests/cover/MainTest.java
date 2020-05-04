package cover;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import static cover.Main.zapiszWejscieNaListe;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void dobrzeZapisujeNaListeWejscie() {
        String wejscie = "2 0\n" +
                "\n" +
                "   1      0 1\n" +
                "\n" +
                "0 -3\n" +
                "1\n" +
                "0\n" +
                "2 3 2 0\n" +
                "-3 3\n" +
                "-3 2\n" +
                "-3 1\n" +
                "4 -1 -5 1000000000 0\n" +
                "2 -2 0\n" +
                "-6 3\n" +
                "-6 2\n" +
                "-6 1\n" +
                "1 6 0\n" +
                "-6 3\n" +
                "-6 2\n" +
                "-6 1\n";
        Scanner scanner = new Scanner(wejscie);

        List<Integer> listaZWejscia = zapiszWejscieNaListe(scanner);

        Integer oczekiwanyPierwszyElement = 2;
        Integer otrzymanyPierwszyElement = listaZWejscia.get(0);
        Integer oczekiwanyPrzedostatniElement = -6;
        Integer otrzymanyPrzedostatniElement = listaZWejscia.get(listaZWejscia.size() - 2);
        
        assertEquals(otrzymanyPierwszyElement, oczekiwanyPierwszyElement);
        assertEquals(oczekiwanyPrzedostatniElement, otrzymanyPrzedostatniElement);

    }

}
