package solucion;

import java.util.Random;

public class Cocina {

	public Cocina() {
		
	}
	
	static synchronized public String cocinaPlato() {
		Random azar= new Random();

		String PlatoAzar[]={"huevos","patatas","macarrones","spaguetti","judias verdes","chorizo","jamon","coliflor","brocoli",
				"cebolla","calabacin","aceitunas","panceta","pimiento","chamiñones","tofu","bacalao","merluza","salmon","gazpacho","pepino",
				"atun","tomate","remolacha","pollo","ternera","ternasco","leche","patatas a lo pobre","lechuga","albondigas","jamon york",
				"sanjacobos","salchichas","arroz","platano","piña","pizza","oregano","tomillo","guisantes"};

		return PlatoAzar[azar.nextInt(PlatoAzar.length)];
	}
}
