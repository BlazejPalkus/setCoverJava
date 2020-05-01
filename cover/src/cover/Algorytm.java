package cover;

import java.util.List;

abstract public class Algorytm {
//    private Zbior[] rodzinaZbiorow;
//    private ZbiorDoPokrycia zbiorDoPokrycia;


    public abstract List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow,
                                                                   int wielkoscZbioruDoPokrycia);
}
