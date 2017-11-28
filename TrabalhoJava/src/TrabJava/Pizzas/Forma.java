/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabJava.Pizzas;

/**
 *
 * @author Jorge
 */
public abstract class Forma {

	private String sabor;

	private int quantidade;

	private String tipo;

	private int preco;

	private static int min;

	private static int max;

	public int area(int aresta) {
		return 0;
	}

	public int verifLimites(int param) {
		return 0;
	}

}
