package cover;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Naiwny extends Algorytm {


    @Override
    public List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow, int wielkoscZbioruDoPokrycia) {

        ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(wielkoscZbioruDoPokrycia);
//        Set<Integer> wspolneElementy = new HashSet<>();
        Set<Integer> dotychczasPokryty = new HashSet<>();
        List<Integer> indeksyZbiorowPokrywajacych = new LinkedList<>();

        for (int i = 0; i < rodzinaZbiorow.size(); i++) {
            Zbior zbiorZRodziny = rodzinaZbiorow.get(i);
            Set<Integer> wspolneElementy = zbiorZRodziny.wspolneElementyTegoZbioruIZbioruDoPokrycia(zbiorDoPokrycia);
            if (!dotychczasPokryty.containsAll(wspolneElementy)) {
                dotychczasPokryty.addAll(wspolneElementy);
                indeksyZbiorowPokrywajacych.add(i);
            }
        }

        return indeksyZbiorowPokrywajacych;
    }
}
