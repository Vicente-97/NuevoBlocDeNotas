package com.jacaranda.notas;

public class NotaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		Nota notita =new Nota("vicente");
		
		Nota notita2 =new Nota("");
		
		Nota notita3 = new Nota(" ");
		
		System.out.println(notita.isEmpty());
		System.out.println(notita2.isEmpty());
		System.out.println(notita3.isEmpty());
	}

}
