package no.forsen.hjelpeklasser; 
//å
public interface Stakk<T> 
{
	public void leggInn( T t );
	public T kikk();
	public T taUt(); 
	public int antall(); 
	public boolean tom();
	public void nullstill(); 
}