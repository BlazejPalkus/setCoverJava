package cover;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Naiwny extends Algorytm
{


    @Override
    public List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia)
    {
        Set<Integer> dotychczasPokryty = new HashSet<>();
        List<Integer> indeksyZbiorowPokrywajacych = new LinkedList<>();
        Set<Integer> wzorDoPokrycia = zbiorDoPokrycia.stworzZbiorDoPokrycia();

        for (int i = 0; i < rodzinaZbiorow.size(); i++)
        {
            Zbior zbiorZRodziny = rodzinaZbiorow.get(i);
            Set<Integer> wspolneElementy = zbiorZRodziny.wspolneElementyTegoZbioruIZbioruDoPokrycia(zbiorDoPokrycia);
            if (!dotychczasPokryty.containsAll(wspolneElementy))
            {
                dotychczasPokryty.addAll(wspolneElementy);
                indeksyZbiorowPokrywajacych.add(i + 1);
            }
        }


        if (!dotychczasPokryty.containsAll(wzorDoPokrycia))
        {
            List<Integer> indeksyNowe = new LinkedList<>();
            indeksyNowe.add(0);
            return indeksyNowe;
        }
        if (indeksyZbiorowPokrywajacych.size() > 0)
        {
            return indeksyZbiorowPokrywajacych; //zawsze i tak jest uporzadkowany, wiec zwraca liste posortowana rosnaco
        }
        indeksyZbiorowPokrywajacych.add(0);
        return indeksyZbiorowPokrywajacych;
    }
}
