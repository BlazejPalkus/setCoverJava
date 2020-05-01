package cover;

import java.util.Set;

abstract public class Skladnik {


    abstract public Set<Integer> wspolneElementySkladnikaZeZbiorem(ZbiorDoPokrycia zbior);

    public abstract Set<Integer> wspolneElementyTegoSkladnikaZInnymZbiorem(Set<Integer> zbior);
}
