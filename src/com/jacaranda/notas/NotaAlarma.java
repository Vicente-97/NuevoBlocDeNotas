package com.jacaranda.notas;

import java.time.LocalDateTime;

public class NotaAlarma  extends Nota implements Activable {

	//atributos//
	
	private LocalDateTime fechaAlarma;
	
	private static final Integer MinutosRepetirPorDefecto=5;
	
	private Integer minutosRepetir;
	
	private boolean active=false;
	
	
	
	//constructor//
	public NotaAlarma(String nota, LocalDateTime fecha, boolean igual) {
		super(nota);
		
	}
	
	public NotaAlarma(String nota, LocalDateTime fecha, int codigo) {
		super(nota);
	}



	
	public boolean isActivado() {
		
		if (this.active==true) {
			return true;
		}
		
		return false;
	}
	@Override
	public void desconectar() {
		if (this.active==true) {
			this.active=false;
		}
		
	}
	@Override
	public void activar() {
		this.active=true;
		
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) {
		this.fechaAlarma = fechaAlarma;
	}

	public static Integer getMinutosrepetirpordefecto() {
		return MinutosRepetirPorDefecto;
	}

	@Override
	public String toString() {
		return "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", active=" + active
				+ "]";
	}
	
}
