package com.jacaranda.notas;
/**
 * Clase Nota de la creacion
 * de un Bloc de Notas
 */

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {

	//Atributos de la clase nota//
	private static int codigoSiguiente;
	private Integer codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	
	//constructores//
	public Nota(String nota) {
		this.texto=nota;
		this.codigo=codigoSiguiente++;
		this.fechaCreacion=LocalDateTime.now();
	}
	
	
	//metodos de la clase Nota//
	public boolean isModificacion() {
		
		if (fechaUltimaModificacion!=null) {
			return true;
		}
	
		return false;
	}
	
	
	public boolean isEmpty() {
		
		if (texto==null || texto.trim().isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public boolean isCreadoAnterior(Nota nota) {
		
		if (this.getFechaCreacion().isBefore(nota.getFechaUltimaModificacion())) {
			return true;
		}
		return false;
	}
	
	public boolean isModificadoAnterior (Nota nota) {
		boolean isAnterior=false;
		
		if (this.getFechaUltimaModificacion()==null && nota.getFechaUltimaModificacion()==null) {
			isAnterior=false;
		}else if (isModificacion() && nota.isModificacion()) {
			isAnterior= this.getFechaUltimaModificacion().isBefore(nota.getFechaUltimaModificacion());
		}else if (this.isModificacion()) {
			isAnterior=true;
		}
		
		return isAnterior;
	}
	
	
	
	//getters//
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		this.fechaUltimaModificacion=LocalDateTime.now();	}

	public Integer getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo, fechaCreacion, fechaUltimaModificacion, texto);
	}


	
	public boolean equals(Nota notaDesconocida) {
		boolean SonLoMismo = false;
		
		Nota convertida = (Nota) notaDesconocida;
		
		SonLoMismo= this.texto.equals(notaDesconocida.getTexto()) &&
				this.fechaCreacion.equals(notaDesconocida.getFechaCreacion());
		
		return SonLoMismo;
	}


	@Override
	public String toString() {
		return "Nota [texto=" + texto +  "]";
	}
	
	@Override
	public int compareTo(Nota otraNota) {
		int resultado=0;
		
		if (this.fechaCreacion.isBefore(otraNota.getFechaCreacion())) {
			resultado=-1;
		}else if (this.fechaCreacion.isAfter(otraNota.getFechaCreacion())) {
			resultado=1;
		}
		
		
		return resultado;
	}

}
