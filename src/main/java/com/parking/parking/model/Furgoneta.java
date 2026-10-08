package com.parking.parking.model;

public class Furgoneta extends Vehicle{
	private int tara;
	
	public Furgoneta() {
	}

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}



	@Override
    public double calcularPreu() {
        double preuNormal = super.calcularPreu(); // Calcular el preu base a la classe pare
        return preuNormal * 2; // Les furgonetes paguen el doble
	}

}