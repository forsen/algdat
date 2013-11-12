/**
 * Et interface for stakker / køer o.l.
 * @author Erik Haider Forsén
 */

package no.forsen.hjelpeklasser;

import java.util.Iterator;
public interface Beholder<T> extends Iterable<T> 
{
	/**
	* Metode for å legge inn verdier i beholderen
	* @param t verdien som skal legges inn
	* @return resultatet av innleggingen
	*/
    public boolean leggInn(T t);
    public boolean inneholder(T t);
    public boolean fjern(T t);
    public int antall();
    public boolean tom();
    public void nullstill();
    public Iterator<T> iterator();
}