package models;

public class PontoRede {
	private String codigo;
	private String origem;
	private String destino;
	private String tipoOrigem; 
	private String tipoDestino;
	private double distancia;
	
	// construtor só com o codigo para excluir e alterar
	public PontoRede(String codigo ) {
		super();
		this.codigo = codigo;
	}

	// construtores cheio
	public PontoRede(String codigo, String origem, String destino, String tipoOrigem, String tipoDestino, Double distancia) {
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.tipoOrigem = tipoOrigem;
		this.tipoDestino = tipoDestino;
		this.distancia = distancia;
	}

	// construtores vazio
	public PontoRede() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTipoOrigem() {
		return tipoOrigem;
	}

	public void setTipoOrigem(String tipoOrigem) {
		this.tipoOrigem = tipoOrigem;
	}

	public String getTipoDestino() {
		return tipoDestino;
	}

	public void setTipoDestino(String tipoDestino) {
		this.tipoDestino = tipoDestino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoRede other = (PontoRede) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return codigo + "\t" + origem + "\t" + destino + "\t" + tipoOrigem + "\t" + tipoDestino + "\t" + distancia
				+ "\n";
	}
	
	public String toCSV() {
		return codigo + ";" + origem + ";" + destino + ";" + tipoOrigem + ";" + tipoDestino + ";" + distancia
				+ "\r\n";
	}
	
	public String [] toVetorTabel() {
		return new String [] {codigo, origem, destino, tipoOrigem, tipoDestino, ""+distancia};
				
	}

}