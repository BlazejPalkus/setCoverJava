package cover;

import java.util.HashSet;
import java.util.Set;

public class Nieskonczony extends Skladnik {
    private int pierwszyElement;
    private int postepArytmetyczny;

    public Nieskonczony(int pierwszyElement, int postepArytmetyczny) {
        this.pierwszyElement = pierwszyElement;
        this.postepArytmetyczny = postepArytmetyczny;
    }


    @Override
    public Set<Integer> wspolneElementySkladnikaZeZbiorem(ZbiorDoPokrycia zbior) {

        Set<Integer> wspolneWartosci = new HashSet<>();
        for (int i = this.pierwszyElement; i <= zbior.wielkoscZbioruDoPokrycia(); i += this.postepArytmetyczny) {
            wspolneWartosci.add(i);
        }
        return wspolneWartosci;

    }
}
