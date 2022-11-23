package solucion;

public class Comanda {

	private String plato="";
	volatile int countComanda=0;
	
	public String getPlato() {
		return plato;
	}
	
	public void setPlato(String text) {
		this.plato = text;
	}

	public Comanda(String plato, int countComanda) {
		super();
		this.plato = plato;
		this.countComanda = countComanda;
	}
}
