package com.jacaranda.bloc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TipoBloc {

	
	private Map<Bloc, Set<String>>tipoBloc;
	
	public TipoBloc() {
		tipoBloc= new HashMap<>();
	}
	
	public boolean annadirTipoNota(Bloc titulo, String nota) {
		boolean SonIguales= false;
		if(!tipoBloc.containsKey(titulo)) {
			Set<String>listaDeNotas = new HashSet<>();
			listaDeNotas.add(nota);
			tipoBloc.put(titulo, listaDeNotas);
			SonIguales=true;
		}else {
			tipoBloc.get(titulo).add(nota);
		}
		SonIguales=true;
		
		
		return SonIguales;
	}
	
	public void borrarNota(String titulo) {
		if(tipoBloc.containsKey(titulo)) {
			tipoBloc.get(titulo).clear();
			tipoBloc.remove(titulo);
		}
	}
	
	private int ListaNotasNulas() {
		int contadorNulos=0;
		List<String> notasNulas = new ArrayList<>();
		for(Bloc bloc: tipoBloc.keySet()) {
			if(bloc.getNombre().isEmpty()) {
				contadorNulos++;
			}
		}
			return contadorNulos;
		}
	

	public Map<Bloc, Set<String>> getTiponotas() {
		return tipoBloc;
	}

	public void setTiponotas(Map<Bloc, Set<String>> tiponotas) {
		this.tipoBloc = tiponotas;
	}
	
}
