package cover;

import java.util.HashSet;
import java.util.Set;

public class Element extends Skladnik
{
    private final int wartosc;

    public Element(int wartosc)
    {
        this.wartosc = wartosc;
    }


    @Override
    public Set<Integer> wspolneElementySkladnikaZeZbiorem(ZbiorDoPokrycia zbior)
    {
        Set<Integer> wartosc = new HashSet<>();

        if (this.wartosc <= zbior.wielkoscZbioruDoPokrycia() && this.wartosc != 0)
        {
            wartosc.add(this.wartosc);
        }

        return wartosc;
    }


    @Override
    public Set<Integer> wspolneElementyTegoSkladnikaZInnymZbiorem(Set<Integer> zbior)
    {
        Set<Integer> wartosc = new HashSet<>();

        if (this.wartosc != 0 && zbior.contains(this.wartosc))
        {
            wartosc.add(this.wartosc);
        }

        return wartosc;
    }
}
