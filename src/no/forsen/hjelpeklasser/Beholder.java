package no.forsen.hjelpeklasser;

import java.util.Iterator;
public interface Beholder<T> extends Iterable<T> 
{
    public boolean leggInn(T t);
    public boolean inneholder(T t);
    public boolean fjern(T t);
    public int antall();
    public boolean tom();
    public void nullstill();
    public Iterator<T> iterator();
}