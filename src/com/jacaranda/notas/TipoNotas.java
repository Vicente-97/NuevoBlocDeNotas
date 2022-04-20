package com.jacaranda.notas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TipoNotas {

	
	private Map<Nota, Set<String>>tiponotas;
	
	public TipoNotas() {
		tiponotas= new HashMap<>();
	}
	
	public boolean annadirTipoNota(Nota titulo, String nota) {
		boolean SonIguales= false;
		if(!tiponotas.containsKey(titulo)) {
			Set<String>listaDeNotas = new HashSet<>();
			listaDeNotas.add(nota);
			tiponotas.put(titulo, listaDeNotas);
			SonIguales=true;
		}else {
			tiponotas.get(titulo).add(nota);
		}
		SonIguales=true;
		
		
		return SonIguales;
	}
	
	public void borrarNota(String titulo) {
		if(tiponotas.containsKey(titulo)) {
			tiponotas.get(titulo).clear();
			tiponotas.remove(titulo);
		}
	}
	
	private int ListaNotasNulas() {
		int contadorNulos=0;
		List<String> notasNulas = new ArrayList<>();
		for(Nota no: tiponotas.keySet()) {
			if(no.isEmpty()) {
				contadorNulos++;
			}
		}
			return contadorNulos;
		}
	

	public Map<Nota, Set<String>> getTiponotas() {
		return tiponotas;
	}

	public void setTiponotas(Map<Nota, Set<String>> tiponotas) {
		this.tiponotas = tiponotas;
	}
	
}
