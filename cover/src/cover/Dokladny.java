package cover;

import java.math.BigInteger;
import java.util.*;

public class Dokladny extends Algorytm
{

    @Override
    public List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia)
    {
        int rozmiar = rodzinaZbiorow.size();
        List<Integer> zbior = new ArrayList<>(rozmiar);
        for (int i = 0; i < rozmiar; i++)
        {
            zbior.add(i + 1);
        }
        BigInteger podniesioneOJeden = BigInteger.ONE.shiftLeft(rozmiar);
        Set<Integer> aktualnyKandydat = new HashSet<>();
        for (BigInteger i = BigInteger.ONE; i.compareTo(podniesioneOJeden) < 0; i = i.add(BigInteger.ONE))
        {
            Set<Integer> podzbior = podzbiorZBigInteger(zbior, i);
            if (czyZbioryOPodanychNumerachPokrywajaZbior(podzbior, rodzinaZbiorow, zbiorDoPokrycia))
            {
                if (aktualnyKandydat.isEmpty())
                {
                    aktualnyKandydat = podzbior;
                }
                else if (podzbior.size() < aktualnyKandydat.size()) //mniejszy, bo sa w porzadku leksykograficznym juz
                {
                    aktualnyKandydat = podzbior;

                }
            }
        }

        if (!aktualnyKandydat.isEmpty())
        {
            List<Integer> najlepszyKandydat = new ArrayList<>(aktualnyKandydat.size());
            najlepszyKandydat.addAll(aktualnyKandydat);
            return najlepszyKandydat;
        }
        else
        {
            List<Integer> najlepszyKandydat = new ArrayList<>(1);
            najlepszyKandydat.add(0);
            return najlepszyKandydat;
        }
    }

    public static Set<Integer> podzbiorZBigInteger(List<Integer> zbior, BigInteger subset)
    {
        //Podzbiory tutaj produkowane są w porzadku leksykograficznym jesli wybrac te o konkretnej dlugosci,
        //czyli zawsze [1 2] bedzie wystepowalo przed [1 3], ale miedzy nimi moze byc cos innego, ale to nam nie
        // przeszkadza, bo liczy sie tylko najkrotszy, wiec jesli z danej dlugosci sa uporzadkowane leksykograficznie to mamy to co potrzebujemy
        Set<Integer> podzbior = new HashSet<>();
        int i = 0;
        for (Integer element : zbior)
        {
            if (subset.testBit(i))
            {
                podzbior.add(element);
            }
            i++;
        }
        return podzbior;
    }


    boolean czyZbioryOPodanychNumerachPokrywajaZbior(Set<Integer> numery, List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia)
    {
        Integer[] numeryZbiorow = new Integer[numery.size()];
        numery.toArray(numeryZbiorow);
        Set<Integer> kopiaZbioruDoPokrycia = zbiorDoPokrycia.stworzZbiorDoPokrycia();

        Set<Integer> wspolneElementyZbiorowOPodanychNumerach = new HashSet<>();

        for (Integer i : numeryZbiorow)
        {
            if (i != 0)
            {
                Set<Integer> wspolne = rodzinaZbiorow.get(i - 1).wspolneElementyTegoZbioruIZbioruDoPokrycia(zbiorDoPokrycia);
                wspolneElementyZbiorowOPodanychNumerach.addAll(wspolne);

            }
        }
        return wspolneElementyZbiorowOPodanychNumerach.containsAll(kopiaZbioruDoPokrycia);
    }
}