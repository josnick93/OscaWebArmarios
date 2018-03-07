package org.oscasistemas.vo;

public class Comando {

	private String orden;
	private int lanzadera;
	private int entablado;
	private String codigoAcesso;
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public int getLanzadera() {
		return lanzadera;
	}
	public void setLanzadera(int lanzadera) {
		this.lanzadera = lanzadera;
	}
	public int getEntablado() {
		return entablado;
	}
	public void setEntablado(int entablado) {
		this.entablado = entablado;
	}
	public String getCodigoAcesso() {
		return codigoAcesso;
	}
	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}
	@Override
	public String toString() {
		return "Comando [orden=" + orden + ", lanzadera=" + lanzadera
				+ ", entablado=" + entablado + ", codigoAcesso=" + codigoAcesso
				+ "]";
	}
	
	
	

}
