package com.jacaranda.bloc;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;
import com.jacaranda.notas.NotaAlarmaException;

public class NotaMainApp {
	private static final String MENU_PRINCIPAL="Menú para crear notas (5 para Salir)\n"
			+ "1. Crear nota \n"
			+ "2. Crear nota alarma \n"
			+ "3. Modificar nota \n"
			+ "4. Ordenar Nota \n"
			+ "5. Salir\n";
	
	private static void imprimirMenuPrincipal() {
		System.out.println(MENU_PRINCIPAL);
	}
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		imprimirMenuPrincipal();
		int opcion= Integer.valueOf(sc.nextLine());
		Bloc bloc1 = new Bloc();
		while (opcion!=5) {
		try {
			if (opcion==1) {
				System.out.println("Introduzca el texto:");
				String texto =sc.nextLine();
				Nota n = new Nota(texto);
				bloc1.addNota(n);
				
			}else if (opcion==2) {
				System.out.println("Introduzca el texto");
				String texto=sc.nextLine();
				LocalDateTime fecha = crearFecha();

				NotaAlarma NA = new NotaAlarma(texto, fecha, true);
				
			}else if (opcion==3) {
				System.out.println("Introduzca el texto para actualizar la nota");
				String texto=sc.nextLine();
				System.out.println("Introduzca el numero para actualizar la nota");
				int posicion=Integer.valueOf(sc.nextLine());
				bloc1.updateNota(posicion, texto);
				
			}else if (opcion==4) {
				for(Nota n : bloc1.ordenarNota()) {
					System.out.println(n);
				}
			}
			imprimirMenuPrincipal();
			opcion=Integer.valueOf(sc.nextLine());
			
			
			
		}catch (Exception lanzable) {
			throw new BlockException("Error, se ha poducido una excepcion inesperada", lanzable);
		}
	
		}
		
		/*//Notas n1 = new Notas(null);
		Nota n4 = new Nota("hshshs");
		Nota n5 = new Nota ("Hola");
		//Notas n2 = new Notas("    ");
		NotaAlarma na1= new NotaAlarma("Hola", LocalDateTime.of(2022, 03, 11, 13, 0), false);
		na1.activar();
		//Notas n3 = new Notas("Hola me");
		Bloc bc1 = new Bloc("block 2");
		Bloc bc2 = new Bloc("Bloc 2");
		
		//bc1.desactiva(12);
		System.out.println(bc1.equals(bc2));
		try {
			Nota[] blocNotas = new Nota[5];
			for (int i=0;i<blocNotas.length;i++) {
				blocNotas[i]= crearNota();
			}
			
		}catch (Exception lanzable) {
			throw new NotaAlarmaException("Se ha producido una excepcion inesperada",lanzable);
			
		}*/
		
	}
	private static LocalDateTime crearFecha() {
		System.out.println("Introduzca el dia para programar su nota alarma");
		int dia = Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca el mes para programar su nota alarma");
		int mes = Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca el año para programar su nota alarma");
		int year = Integer.valueOf(sc.nextLine());
		
		System.out.println("Introduzca la hora para programar su nota alarma");
		int hour = Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca los minutos para programar su nota alarma");
		int min = Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca los segundos para programar su nota alarma");
		int sec = Integer.valueOf(sc.nextLine());

		LocalDateTime fecha = LocalDateTime.of(year, mes, dia, hour, min, sec);
		return fecha;
	}
	public static Nota crearNota() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el texto para la nota");
		String texto = String.valueOf(sc.nextLine());
		
		return new Nota(texto);
	}
}
