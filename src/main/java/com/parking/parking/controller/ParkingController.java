package com.parking.parking.controller;

import org.springframework.ui.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parking.parking.model.Cotxe;
import com.parking.parking.model.Furgoneta;
import com.parking.parking.model.Moto;
import com.parking.parking.model.Parking;
import com.parking.parking.model.Vehicle;
import com.parking.parking.model.Noticia;



@Controller
public class ParkingController {

    private final Parking parking;
    private ArrayList<Noticia> noticies;

    public ParkingController(){
        this.parking = new Parking(10);
        this.noticies = carregarNoticies();
    }

    @GetMapping("/prova")
    public String prova(Model model) {
        String missatge = "patata";
        model.addAttribute("missatge", missatge);
        return "prova";
    }

    @GetMapping("/")
    public String mostrarParking(Model model) {
        // double preuminut = parking.getPreuMinut();
       // int numplaces = parking.getNumPlacesOcupades();
       // model.addAttribute("preuminut", preuminut);
       // model.addAttribute("numplaces", numplaces);
       model.addAttribute("parking", parking);
       model.addAttribute("noticies", noticies);
        return "parking";
    }

    @PostMapping("/aparcar")
    public String aparcar(@RequestParam String matricula, @RequestParam String tipus){
        System.out.println(matricula);
        switch (tipus){
            case "Cotxe":
                Cotxe c = new Cotxe();
                c.setMatricula(matricula);
                parking.aparcar(c);
                break;
            case "Moto":
                Moto m = new Moto();
                m.setMatricula(matricula);
                parking.aparcar(m);
                break;
            case "Furgoneta":
                Furgoneta f = new Furgoneta();
                f.setMatricula(matricula);
                parking.aparcar(f);
                break;
        }
        return "redirect:/";
    }

    @PostMapping("/desaparcar")
    public String desaparcar(@RequestParam String matricula, Model model){
       // double preuminut = parking.getPreuMinut();
        // Vehicle v = new Vehicle();
        // System.out.println(matricula);
        double preutotal = parking.desaparcar(matricula);
        model.addAttribute("preutotal", preutotal);
        //parking.desaparcar(matricula);
       // v.setMatricula(null);

        // int numplaces = parking.getNumPlacesOcupades();
        // model.addAttribute("preuminut", preuminut);
        // model.addAttribute("numplaces", numplaces);
        model.addAttribute("parking", parking);
        model.addAttribute("noticies", noticies);
        return "parking";
    }

    @GetMapping("/desaparcar/{posicio}")
    public String desaparcar2(@PathVariable int posicio, Model model){
        double preutotal = parking.desaparcar(posicio - 1);
        model.addAttribute("preutotal", preutotal);
        model.addAttribute("parking", parking);
        model.addAttribute("noticies", noticies);

        return "parking";
    }


    private ArrayList <Noticia> carregarNoticies(){
        ArrayList<Noticia> noticies = new ArrayList<>();

        try{
        File f = new File("src/main/resources/static/noticies.txt");
        if (f.exists()){
        Scanner lectorfitxer = new Scanner(f);
        String linia;
        while (lectorfitxer.hasNextLine()){
            linia = lectorfitxer.nextLine();
            String[] camps = linia.split(":");
            Noticia noticia = new Noticia(camps[0], camps[1]);
            noticies.add(noticia);

            System.out.println(linia);
        }
        } else {
            System.out.println("No existeix el fitxer");
    }


        } catch(Exception e){
            System.out.println("Error accedir al fitxer");

        }


        return noticies;
    }
}
