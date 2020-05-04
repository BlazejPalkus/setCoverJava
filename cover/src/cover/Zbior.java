package cover;

import java.util.*;

public class Zbior
{
    private final Set<Skladnik> skladnikiZbioru;

    public Zbior(Set<Skladnik> skladnikiZbioru)
    {
        this.skladnikiZbioru = skladnikiZbioru;
    }

    public Set<Integer> wspolneElementyTegoZbioruIZbioruDoPokrycia(ZbiorDoPokrycia zbiorDoPokrycia)
    {
        Set<Integer> wspolneElementy = new HashSet<>();
        for (Skladnik skladnik : skladnikiZbioru)
        {
            wspolneElementy.addAll(skladnik.wspolneElementySkladnikaZeZbiorem(zbiorDoPokrycia));
        }
        return wspolneElementy;
    }

    public Set<Integer> wspolneElementyTegoZbioruZInnymZbiorem(Set<Integer> zbior)
    {
        Set<Integer> wspolneElementy = new HashSet<>();
        for (Skladnik skladnik : skladnikiZbioru)
        {
            wspolneElementy.addAll(skladnik.wspolneElementyTegoSkladnikaZInnymZbiorem(zbior));
        }
        return wspolneElementy;
    }


}
