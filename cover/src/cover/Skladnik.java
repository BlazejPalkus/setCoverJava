package cover;

import java.util.Set;

abstract public class Skladnik
{
    //Ta klasa istnieje tylko do grupowania rodzajow skladnikow

    public abstract Set<Integer> wspolneElementySkladnikaZeZbiorem(ZbiorDoPokrycia zbior);

    public abstract Set<Integer> wspolneElementyTegoSkladnikaZInnymZbiorem(Set<Integer> zbior);
}
