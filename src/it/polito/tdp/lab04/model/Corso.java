package it.polito.tdp.lab04.model;

public class Corso {
	
	private String condins;
	private int crediti;
	private String nome;
	private int pd;
	
	
	public Corso(String condins, int crediti, String nome, int pd) {
		this.condins = condins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}
	/**
	 * @return the condins
	 */
	public String getCondins() {
		return condins;
	}
	/**
	 * @param condins the condins to set
	 */
	public void setCondins(String condins) {
		this.condins = condins;
	}
	/**
	 * @return the crediti
	 */
	public int getCrediti() {
		return crediti;
	}
	/**
	 * @param crediti the crediti to set
	 */
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the pd
	 */
	public int getPd() {
		return pd;
	}
	/**
	 * @param pd the pd to set
	 */
	public void setPd(int pd) {
		this.pd = pd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condins == null) ? 0 : condins.hashCode());
		result = prime * result + crediti;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + pd;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (condins == null) {
			if (other.condins != null)
				return false;
		} else if (!condins.equals(other.condins))
			return false;
		if (crediti != other.crediti)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pd != other.pd)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Corso [condins=" + condins + ", crediti=" + crediti + ", nome=" + nome + ", pd=" + pd + "]";
	}
	
	
}
