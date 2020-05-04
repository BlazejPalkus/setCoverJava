package cover;

import java.io.PrintStream;
import java.util.*;

import static java.lang.Math.abs;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        obsluzDane(scanner, System.out);
    }

    public static void obsluzDane(Scanner stream, PrintStream out)
    {
        Lexer lexer = new Lexer(stream);
        List<Zbior> rodzinaZbiorow = new ArrayList<>();
        int wartosc;
        int postepArytmetyczny;
        int koniecZbioru;
        int wielkoscZbioruDoPokrycia;
        Dokladny dokladny = new Dokladny();
        Zachlanny zachlanny = new Zachlanny();
        Naiwny naiwny = new Naiwny();
        List<Integer> listaZNumerami = new ArrayList<>();

        while (lexer.czyJestNastepna())
        {
            if (lexer.czyNastepnyJestSkladnik())
            {
                Set<Skladnik> skladnikiDoDodania = new HashSet<>();
                while (!lexer.czyKoniecZbioru())
                {
                    if (lexer.czyTenSkladnikToElement())
                    {
                        wartosc = lexer.wezNastepnaLiczbe();
                        skladnikiDoDodania.add(new Element(wartosc));
                    }
                    else if (lexer.czyTenSkladnikToNieskonczony())
                    {
                        wartosc = lexer.wezNastepnaLiczbe();
                        postepArytmetyczny = abs(lexer.wezNastepnaLiczbe());
                        skladnikiDoDodania.add(new Nieskonczony(wartosc, postepArytmetyczny));
                    }
                    else if (lexer.czyTenSkladnikToSkonczony())
                    {
                        wartosc = lexer.wezNastepnaLiczbe();
                        postepArytmetyczny = abs(lexer.wezNastepnaLiczbe());
                        koniecZbioru = abs(lexer.wezNastepnaLiczbe());
                        skladnikiDoDodania.add(new Skonczony(wartosc, postepArytmetyczny, koniecZbioru));
                    }
                }
                Zbior nowyZbior = new Zbior(skladnikiDoDodania);
                rodzinaZbiorow.add(nowyZbior);
            }

            else if (lexer.czyNastepneJestZapytanie())
            {
                if (lexer.czyJestNastepna())
                {
                    wielkoscZbioruDoPokrycia = abs(lexer.wezNastepnaLiczbe());
                    ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(wielkoscZbioruDoPokrycia);

                    if (lexer.czyDokladny())
                    {
                        listaZNumerami = dokladny.znajdzNumeryZbiorowPokrywajacych(rodzinaZbiorow, zbiorDoPokrycia);

                    }

                    else if (lexer.czyZachlanny())
                    {
                        listaZNumerami = zachlanny.znajdzNumeryZbiorowPokrywajacych(rodzinaZbiorow, zbiorDoPokrycia);
                    }

                    else if (lexer.czyNaiwny())
                    {
                        listaZNumerami = naiwny.znajdzNumeryZbiorowPokrywajacych(rodzinaZbiorow, zbiorDoPokrycia);
                    }

                    lexer.wypiszAlgorytm(listaZNumerami, out);
                }
            }
        }
    }
}


