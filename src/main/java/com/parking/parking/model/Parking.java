package com.parking.parking.model;

public class Parking {
	Plaza[] places;

    int numPlacesOcupades;
    static final double PREU_MINUT = 3;
    
    public Parking() {
	}

	public Parking(int maxPlaces) {
        places = new Plaza[maxPlaces];
        numPlacesOcupades = 0; 

        for (int i = 0; i < maxPlaces / 2; i++) {
            places[i] = new Plaza(i+1, "Planta 1");
        }

        for (int i = maxPlaces / 2; i < maxPlaces; i++) {
            places[i] = new Plaza(i+1, "Planta 2");
        }
    } 

	public Plaza[] getPlaces() {
		return places;
	}

	public void setPlaces(Plaza[] places) {
		this.places = places;
	}

	public int getNumPlacesOcupades() {
		return numPlacesOcupades;
	}

	public void setNumPlacesOcupades(int numPlacesOcupades) {
		this.numPlacesOcupades = numPlacesOcupades;
	}

	public static double getPreuMinut() {
		return PREU_MINUT;
	}

	public boolean aparcar(Vehicle vehicle) {
    	for (Plaza p : places) {
    		if (!p.isOcupada()) {
    			p.setVehicle(vehicle);
    			vehicle.setDataHoraEntrada();
    			numPlacesOcupades++;
    			return true;
    		}
    	}
    	return false;
    }
    
    public void llistat() {
    	for (Plaza p : places) {
    		System.out.println(p);
    	}
    }
    
    public double desaparcar(String matricula) {
    	for (Plaza p : places) {
    		if (p.isOcupada() && p.getVehicle().getMatricula().equals(matricula)) {
    			double preu = p.getVehicle().calcularPreu();
    			p.setVehicle(null);
    			numPlacesOcupades--;
    			return preu;
    		}
    	}
    	return -1; //si no troba el vehicle
    }
    
    public double desaparcar(int codi) {
    	if (codi >= 0 && codi < places.length && places[codi].isOcupada()) {
    		double preu = places[codi].getVehicle().calcularPreu();
    		places[codi].setVehicle(null);
    		numPlacesOcupades--;
    		return preu;
    	}
    	return -1; //codi no valid
    }
    
    public boolean isPle() {
    	return numPlacesOcupades == places.length;
    }
    
    public int numPlacesLliures() {
    	return places.length - numPlacesOcupades;
    }

}