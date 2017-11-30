/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabJava;

import TrabJava.Pizzas.Circular;
import TrabJava.Pizzas.Forma;
import TrabJava.Pizzas.Quadrado;
import TrabJava.Pizzas.Triangulo;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author Jorge
 */
public class Pedido {
    
	private int numero;

	private String nome;

	private String status;
        
        public static void main(String[] args) {
        //Teste polimorfia
            Forma f;
            System.out.println("Escolha uma pizza:\n1- Pizza Quadrada\n2- Pizza Circular\n3- Pizza Triangulo");
            Scanner sc = new Scanner(System.in);
            int escolha =sc.nextInt();
            if(escolha==1){
                f = new Quadrado();
                System.out.println("Pizza escolhida: Quadrada ");
            }
            else if(escolha==2){
                f = new Circular();
                System.out.println("Pizza escolhida: Circular");
            }
            else
            {
                f = new Triangulo();
                System.out.println("Pizza escolhida: Triangulo");
            }
    }

}