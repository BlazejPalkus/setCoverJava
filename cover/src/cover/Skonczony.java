package cover;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Skonczony extends Skladnik
{
    private final int pierwszyElement;
    private final int ograniczenieCiagu;
    private final int postepArytmetyczny;

    public Skonczony(int pierwszyElement, int postepArytmetyczny, int ograniczenieCiagu)
    {
        this.pierwszyElement = pierwszyElement;
        this.postepArytmetyczny = postepArytmetyczny;
        this.ograniczenieCiagu = ograniczenieCiagu;
    }


    @Override
    public Set<Integer> wspolneElementySkladnikaZeZbiorem(ZbiorDoPokrycia zbior)
    {
        Set<Integer> wspolneWartosci = new HashSet<>();
        for (int i = this.pierwszyElement; i <= zbior.wielkoscZbioruDoPokrycia() && i <= this.ograniczenieCiagu;
             i += this.postepArytmetyczny)
        {
            wspolneWartosci.add(i);
        }
        return wspolneWartosci;
    }


    @Override
    public Set<Integer> wspolneElementyTegoSkladnikaZInnymZbiorem(Set<Integer> zbior)
    {
        Set<Integer> wspolneWartosci = new HashSet<>();
        int max = Collections.max(zbior);
        for (int i = this.pierwszyElement; i <= max && i <= this.ograniczenieCiagu;
             i += this.postepArytmetyczny)
        {
            if (zbior.contains(i))
            {
                wspolneWartosci.add(i);
            }
        }
        return wspolneWartosci;
    }
}
