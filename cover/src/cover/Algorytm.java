package cover;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

abstract public class Algorytm {
//    private Zbior[] rodzinaZbiorow;
//    private ZbiorDoPokrycia zbiorDoPokrycia;


    public abstract List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow,
                                                                   ZbiorDoPokrycia zbiorDoPokrycia);


    boolean czyZostalPokrytyCalyZbior(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia,
                                      List<Integer> indeksyZbiorowPokrywajacych) {
        Set<Integer> zbioryPokrywajace = new HashSet<>();
        Set<Integer> zbiorDoPokryciaObjekt = zbiorDoPokrycia.stworzZbiorDoPokrycia();
        for (int i : indeksyZbiorowPokrywajacych) {
            Set<Integer> wspolne = rodzinaZbiorow.get(i - 1).wspolneElementyTegoZbioruIZbioruDoPokrycia(zbiorDoPokrycia);
            zbioryPokrywajace.addAll(wspolne);
        }
        if (!zbioryPokrywajace.containsAll(zbiorDoPokryciaObjekt)) {
            return false;
        }
        return true;
    }
}
