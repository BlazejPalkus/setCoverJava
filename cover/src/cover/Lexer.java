package cover;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Lexer
{

    private Scanner stream;
    private Stack<Integer> buffor = new Stack<>();

    public Lexer(Scanner stream)
    {
        this.stream = stream;
    }


    public boolean czyJestNastepna()
    {
        return stream.hasNext() || !buffor.empty();
    }

    public int wezNastepnaLiczbe()
    {
        int nastepna;
        if (buffor.empty())
        {
            nastepna = stream.nextInt();
        }
        else
        {
            nastepna = buffor.pop();
        }
        return nastepna;
    }


    public void odlozLiczbe(int liczba)
    {
        buffor.add(liczba);
    }

    //Jesli nie ma funkcja czyJestNastepna zwroci false, nic nie bedzie sie juz wydarzalo i wszystkie funkcje zwrocą
    // false - na wypadek gdyby dane byly poprawne ale niekompletne

    public boolean czyNastepnyJestSkladnik()
    {
        if (czyJestNastepna())
        {
            int nastepny = wezNastepnaLiczbe();
            odlozLiczbe(nastepny);
            return nastepny >= 0;
        }
        return false;
    }

    public boolean czyNastepneJestZapytanie()
    {
        if (czyJestNastepna())
        {
            int nastepny = wezNastepnaLiczbe();
            odlozLiczbe(nastepny);
            return nastepny < 0;
        }
        return false;
    }


    //W nastepnych trzech funkcjach nie sprawdzamy pierwszego napotkanego elementu, bo funkcja oddala go do buffora i
    // skoro możemy rozwazać takiego ifa, to znaczy, że element na szczycie stosu jest poprawny
    public boolean czyTenSkladnikToElement()
    {
        if (czyJestNastepna())
        {
            int nastepna = wezNastepnaLiczbe();

            if (czyJestNastepna())
            {
                int jeszczeNastepna = wezNastepnaLiczbe();
                odlozLiczbe(jeszczeNastepna);
                odlozLiczbe(nastepna);
                return jeszczeNastepna >= 0;
            }
            odlozLiczbe(nastepna);
        }
        return false;

    }

    public boolean czyTenSkladnikToSkonczony()
    {
        if (czyJestNastepna())
        {
            int nastepna = wezNastepnaLiczbe();
            if (czyJestNastepna())
            {
                int jeszczeNastepna = wezNastepnaLiczbe();
                if (jeszczeNastepna < 0 && czyJestNastepna())
                {
                    int jeszczeBardziejNastepna = wezNastepnaLiczbe();
                    odlozLiczbe(jeszczeBardziejNastepna);
                    odlozLiczbe(jeszczeNastepna);
                    odlozLiczbe(nastepna);
                    return jeszczeBardziejNastepna < 0;
                }
                odlozLiczbe(jeszczeNastepna);
                odlozLiczbe(nastepna);
                return false;
            }
            odlozLiczbe(nastepna);
        }
        return false;
    }


    public boolean czyTenSkladnikToNieskonczony()
    {
        if (czyJestNastepna())
        {
            int nastepna = wezNastepnaLiczbe();
            if (czyJestNastepna())
            {
                int jeszczeNastepna = wezNastepnaLiczbe();
                if (jeszczeNastepna < 0 && czyJestNastepna())
                {
                    int jeszczeBardziejNastepna = wezNastepnaLiczbe();
                    odlozLiczbe(jeszczeBardziejNastepna);
                    odlozLiczbe(jeszczeNastepna);
                    odlozLiczbe(nastepna);
                    return (jeszczeBardziejNastepna >= 0);
                }
                odlozLiczbe(jeszczeNastepna);
                odlozLiczbe(nastepna);
                return false;
            }
            odlozLiczbe(nastepna);
        }
        return false;
    }


    public boolean czyKoniecZbioru()
    {
        if (czyJestNastepna())
        {
            int nastepna = wezNastepnaLiczbe();
            if (nastepna == 0)
            {
                return true;
            }
            odlozLiczbe(nastepna);
        }
        return false;
    }


    public boolean czyDokladny()
    {
        if (czyJestNastepna())
        {
            int nastepna = wezNastepnaLiczbe();
            if (nastepna == 1)
            {
                return true;
            }

            else
            {
                odlozLiczbe(nastepna);
            }
        }
        return false;
    }

    public boolean czyZachlanny()
    {
        if (czyJestNastepna())
        {
            int nastepna = wezNastepnaLiczbe();
            if (nastepna == 2)
            {
                return true;
            }

            else
            {
                odlozLiczbe(nastepna);
            }
        }
        return false;
    }

    public boolean czyNaiwny()
    {
        if (czyJestNastepna())
        {
            int nastepna = wezNastepnaLiczbe();
            if (nastepna == 3)
            {
                return true;
            }

            else
            {
                odlozLiczbe(nastepna);
            }
        }
        return false;
    }

    //Ostatnia linijka również konczy sie znakiem nowej linii
    void wypiszAlgorytm(List<Integer> listaZNumerami, PrintStream out)
    {
        for (int numery = 0; numery < listaZNumerami.size(); numery++)
        {
            out.print(listaZNumerami.get(numery));
            if (numery != listaZNumerami.size() - 1)
            {
                out.print(" ");
            }
            else
            {
                out.print("\n");
            }
        }
    }

}
