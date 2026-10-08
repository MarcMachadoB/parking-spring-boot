package com.parking.parking.model;

public class Cotxe extends Vehicle{
	private double descompte = 0.9;
	
	public Cotxe() {
	}

	public double getDescompte() {
		return descompte;
	}

	public void setDescompte(double descompte) {
		this.descompte = descompte;
	}

	@Override
    public double calcularPreu() {
        return super.calcularPreu() * (1- descompte * this.descompte/100); 
    }

}