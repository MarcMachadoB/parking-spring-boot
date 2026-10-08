package com.parking.parking.model;

public class Plaza {
	private int numero;
	private String ubicacio;
	private Vehicle vehicle;
	
	public Plaza(int numero, String ubicacio) {
		this.numero = numero;
		this.ubicacio = ubicacio;
		this.vehicle = null;
	}

	public Plaza() {
	}



	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getUbicacio() {
		return ubicacio;
	}
	public void setUbicacio(String ubicacio) {
		this.ubicacio = ubicacio;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isOcupada() {
		return (this.vehicle != null);
	}
	
	@Override
    public String toString() {
        if(this.isOcupada())
            return numero+" "+ this.vehicle.getMatricula();
        else return numero+" lliure";
    }
	
	

}
