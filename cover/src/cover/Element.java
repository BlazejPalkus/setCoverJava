package cover;

import java.util.HashSet;
import java.util.Set;

public class Element extends Skladnik {
    private int wartosc;

    public Element(int wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public Set<Integer> wspolneElementySkladnikaZeZbiorem(ZbiorDoPokrycia zbior) {
        Set<Integer> wartosc = new HashSet<>();

        if (this.wartosc <= zbior.wielkoscZbioruDoPokrycia()) {
            wartosc.add(this.wartosc);
        }

        return wartosc;
    }
}
