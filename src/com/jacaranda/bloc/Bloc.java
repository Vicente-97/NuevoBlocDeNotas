package com.jacaranda.bloc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;
import com.jacaranda.notas.NotaAlarmaException;

public class Bloc {
	private static final int NUMERO_NOTAS_MAXIMA=100;
	private int numNota;
	private String nombre;
	private Nota[] notas = new Nota[NUMERO_NOTAS_MAXIMA];
	private List<Nota> listasNotas = new ArrayList<Nota>();
	
	
	public Bloc() {
		
	}
	
	public Bloc(String nombre) {
		this.nombre=nombre;
		
	}
	
	
	
	//methods
	public void addNota(Nota nota) {
		if (numNota<NUMERO_NOTAS_MAXIMA) {
			this.notas[numNota]= nota;
			listasNotas.add(nota);
			numNota++;
			
		}
	}
	public void addNota (int posicion, Nota nota) {
		if (posicion<NUMERO_NOTAS_MAXIMA) {
			this.notas[numNota]=nota;
			listasNotas.add(posicion, nota);
		
		}
	}
	
	
	public String getNota(int numNota) {
		
		return null;
		}
	
	public void updateNota(int posicion,String texto) {
		if (posicion<NUMERO_NOTAS_MAXIMA && this.notas[posicion-1]!=null) {
			this.notas[posicion-1].setTexto(texto);
			if(listasNotas.contains(texto)) {
				listasNotas.get(posicion).setTexto(texto);
			}
		}else {
			throw new NotaAlarmaException("No se ha podido actualizar");
		}
		
		
		
	}
	
	public void activa(int posicion) {
		if (posicion < NUMERO_NOTAS_MAXIMA 
				&& this.notas[posicion-1] instanceof NotaAlarma 
				&& this.notas[posicion-1]!=null){
				NotaAlarma notaActivar = (NotaAlarma)this.notas[posicion-1];
				notaActivar.activar();
				
		}else {
			throw new NotaAlarmaException("No se ha podido activar la alarma");
		}
		
	}
	public void desactiva (int posicion) {
		if (posicion < NUMERO_NOTAS_MAXIMA 
				&& this.notas[posicion-1] instanceof NotaAlarma 
				&& this.notas[posicion-1]!=null){
				NotaAlarma notaActivar = (NotaAlarma)this.notas[posicion-1];
				notaActivar.desconectar();
		}else {
			throw new NotaAlarmaException("No se ha podido desactivar la alarma");
		}
	}
		
	
	public int ordenaBloc() {
		return numNota;
	}

	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}
	public void setNumNotas(int numNotas) {
		this.numNota = numNotas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(nombre, numNota);
	}
	
	//EQUALS
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=false;
		Bloc other = (Bloc) obj;
		if (this.nombre.equalsIgnoreCase(other.getNombre()))
			sonIguales = true;
	
		
		return sonIguales;
	}
	
	
	
		
	public Nota [] ordenarNota() {
		
		Nota[] ordenarNotas= new Nota[contadorNotasNonNulas()];
		int cNotasOrdenadas=0;
		for (int i=0; i<this.notas.length; i++) {
			if(this.notas[i]!=null) {
				ordenarNotas[cNotasOrdenadas++]=this.notas[i];
			}
		
	}

		Arrays.sort(ordenarNotas);
		return ordenarNotas;
	}
	
	
	private int contadorNotasNonNulas() {
		int contadorNotas=0;
		for (int i=0; i<this.notas.length; i++) {
			if(this.notas[i]!=null) {
				contadorNotas++;
			}
		}return contadorNotas;
	}
	
	

	public List<Nota> getListasNotas() {
		return listasNotas;
	}

	public void setListasNotas(List<Nota> listasNotas) {
		this.listasNotas = listasNotas;
	}
	
	
		
		
	
		
	}