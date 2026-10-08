
# Simulador de Pàrquing en Java

Aquest projecte implementa una simulació d'un pàrquing automatitzat on els vehicles s'aparquen de forma automàtica dins d'una plaça lliure.

## 📌 Objectius del projecte
- Modelar el comportament d'un pàrquing utilitzant programació orientada a objectes.
- Implementar una aplicació en Java que permeti aparcar i desaparcar vehicles automàticament.
- Crear una interfície d'usuari basada en menú per interactuar amb el sistema.

---

## 🏗️ Estructura del projecte

El projecte està format per les següents classes:

### 1️⃣ `Vehicle`
Representa un vehicle amb els atributs:
- `matricula`: matrícula del vehicle.
- `dataHoraEntrada`: data i hora d'entrada al pàrquing.

🛠️ **Mètodes principals:**
- `calcularPreu()`: calcula el preu a pagar en funció del temps d'estacionament.
- `setDataHoraEntrada()`: estableix l'hora d'entrada del vehicle.

---

### 2️⃣ `Cotxe`, `Motocicleta`, `Furgoneta`
Són subclasses de `Vehicle`, amb modificacions en el càlcul del preu:
- **Cotxe**: té un descompte del 10%.
- **Motocicleta**: paga la meitat.
- **Furgoneta**: paga el doble.

🛠️ **Mètodes principals:**
- Sobreescriuen `calcularPreu()` per aplicar les tarifes específiques.

---

### 3️⃣ `Plaça`
Representa una plaça d'aparcament amb:
- `numero`: identificador de la plaça.
- `ubicacio`: ubicació dins del pàrquing (planta, sector).
- `vehicle`: vehicle aparcat (pot ser `null` si està lliure).

🛠️ **Mètodes principals:**
- `isOcupada()`: indica si la plaça està ocupada.
- `toString()`: mostra l'estat de la plaça.

---

### 4️⃣ `Parquing`
Gestiona l'aparcament i inclou:
- Un array de `Plaça` per gestionar l'espai.
- Un comptador `numPlacesOcupades`.
- Una constant `PREU_MINUT = 3`.

🛠️ **Mètodes principals:**
- `aparcar(Vehicle vehicle)`: aparca un vehicle en una plaça lliure.
- `desaparcar(String matricula)`: allibera la plaça d'un vehicle donat i calcula el preu a pagar.
- `desaparcar(int codi)`: allibera una plaça en funció del número.
- `llistat()`: mostra l'estat de totes les places del pàrquing.
- `isPle()`: retorna si el pàrquing està ple.
- `numPlacesLliures()`: retorna el nombre de places lliures.

---

## 🖥️ Interfície de l'aplicació

L'aplicació ofereix un menú WEB amb les opcions següents:

1️⃣ **Aparcar un vehicle**  
   - Es demana la matrícula i el tipus de vehicle (Cotxe, Motocicleta, Furgoneta).  
   - El vehicle es col·loca automàticament en una plaça lliure.  

2️⃣ **Desaparcar un vehicle**  
   - Es demana la matrícula del vehicle a desaparcar.  
   - Es calcula i mostra el preu a pagar.  


