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
    /**
     * Metode for å sjekke om en verdi finnes i beholderen
     * @param t verdien som skal søkes etter
     * @return true dersom den finnes, false ellers
     */
    public boolean inneholder(T t);
    /**
     * Metode for å fjerne en verdi fra beholderen
     * @param t verdien som skal fjernes
     * @return true dersom verdien ble fjernet, false ellers
     */
    public boolean fjern(T t);
    /**
     * Metode for å finne antall elementer i beholderen
     * @return antall elementer i beholderen
     */ 
    public int antall();
    /**
     * Metode for å avgjøre om beholderen er tom
     * @return true dersom beholderen er tom, false ellers
     */
    public boolean tom();
    /**
     * Metode for å nullstille beholderen
     */
    public void nullstill();
    /**
     * En iterator for beholderen
     * @return et Iterator object
     */
    public Iterator<T> iterator();
}