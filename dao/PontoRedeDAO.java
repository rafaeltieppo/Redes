package dao;

import models.PontoRede;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PontoRedeDAO {
	private ArrayList<PontoRede> redes;
	private PontoRede rede; 
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "./bd/rede.csv";
	
	public ArrayList<PontoRede> abrir() {
		redes = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				rede = new PontoRede(campos[0], campos[1], campos[2], campos[3], campos[4], Double.valueOf(campos[5]));
				redes.add(rede);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo: " + e);
		}
		return redes;
	
	}
	
	public boolean salvar(ArrayList<PontoRede> ps) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for(PontoRede pd: ps) {
				bw.write(pd.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo: " + e);
			return false;
		}
		
	
	}
}
