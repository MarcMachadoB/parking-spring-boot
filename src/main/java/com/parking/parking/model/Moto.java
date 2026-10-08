package com.parking.parking.model;

public class Moto extends Vehicle{
	private int cc;
	
	public Moto() {
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	@Override
    public double calcularPreu() {
        double preuNormal = super.calcularPreu(); // Calcular el preu base a la classe pare
        return preuNormal * 0.5; // Meitat del preu
    }

}
