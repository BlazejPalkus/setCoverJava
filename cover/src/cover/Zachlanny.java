package cover;

import java.util.*;

public class Zachlanny extends Algorytm
{

    @Override
    public List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia)
    {
        int najwiekszyAktualnyPodzbior = 0;
        Set<Integer> dotychczasPokryty;
        Set<Integer> pozostaloDoPokrycia = zbiorDoPokrycia.stworzZbiorDoPokrycia();
        List<Integer> indeksyZbiorowPokrywajacych = new LinkedList<>();
        int indeksNajwiekszego = -1;
        boolean nastapilaZmiana = true;

        while (!pozostaloDoPokrycia.isEmpty() && nastapilaZmiana)
        {
            najwiekszyAktualnyPodzbior = 0;
            nastapilaZmiana = false;
            for (int i = 0; i < rodzinaZbiorow.size(); i++)
            {
                int ileMaTenZbior = rodzinaZbiorow.get(i).
                        wspolneElementyTegoZbioruZInnymZbiorem(pozostaloDoPokrycia).size();
                if (ileMaTenZbior > najwiekszyAktualnyPodzbior)
                {
                    najwiekszyAktualnyPodzbior = ileMaTenZbior;
                    indeksNajwiekszego = i + 1;
                    nastapilaZmiana = true;
                }
            }
            if (indeksNajwiekszego > -1)
            {
                dotychczasPokryty = rodzinaZbiorow.get(indeksNajwiekszego - 1).
                        wspolneElementyTegoZbioruIZbioruDoPokrycia(zbiorDoPokrycia);
                pozostaloDoPokrycia.removeAll(dotychczasPokryty);
                indeksyZbiorowPokrywajacych.add(indeksNajwiekszego);
            }
            else
            {
                indeksyZbiorowPokrywajacych.add(0);
                return indeksyZbiorowPokrywajacych;
            }
        }
        if (!pozostaloDoPokrycia.isEmpty())
        {
            indeksyZbiorowPokrywajacych.clear();
            indeksyZbiorowPokrywajacych.add(0);
        }
        Collections.sort(indeksyZbiorowPokrywajacych);
        return indeksyZbiorowPokrywajacych;
    }
}
