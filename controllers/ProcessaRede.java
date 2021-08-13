package controllers;

import java.util.ArrayList;

import dao.PontoRedeDAO;
import models.PontoRede;

public class ProcessaRede {
	public static ArrayList<PontoRede> redes = new ArrayList<>();
	public static PontoRedeDAO pd = new PontoRedeDAO(); 
	
	public static double totalDistancia() {
		int calculo = 0;
		for (PontoRede r : redes) {
			calculo += r.getDistancia();
		}
		return calculo;
	}
	
	public static void abrirDAO() {
	
	    redes = pd.abrir();
	}
	public static boolean salvarDAO() {
		return pd.salvar(redes);
	}
	
	public static void preencherTeste() {
		redes.add(new PontoRede("Eng1PT01","Engenharia", "Roteador", "Eng1","Laptop", 20.0));
		redes.add(new PontoRede("Eng01PT1", "Engenharia", "Switch", "Sala Eng01", "Laptop", 20.0));
		redes.add(new PontoRede("Eng02PT2", "Engenharia", "Switch", "Sala Eng02", "Pc", 16.0));
		redes.add(new PontoRede("RepPT3", "Rack", "Roteador", "Recepção", "Notebook", 10.0));
		redes.add(new PontoRede("TecPT4", "Rack", "Roteador", "S.Tecnicos", "Laptop", 30.0));
		redes.add(new PontoRede("TecPT5", "Rack", "Switch", "S.Tecnicos", "Laptop", 30.0));
		redes.add(new PontoRede("REPT5", "Rack", "Roteador", "S.Reunião", "Projetor", 23.0));
		redes.add(new PontoRede("ATPT6", "Rack", "Switch", "S.Atend.", "Projetor", 23.0));
		redes.add(new PontoRede("IMPPT7", "Rack", "Roteador", "Impressora", "Impressora", 23.0));
	}
}
