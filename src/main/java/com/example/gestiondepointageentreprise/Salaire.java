package com.example.gestiondepointageentreprise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Salaire{
    private Double salaireBrut;
    private Double salaireNet;

    public Salaire(Double salaireBrut) {
        this.salaireBrut = salaireBrut;
        this.salaireNet = calculSalaireNet();
    }

    private Double calculSalaireNet(){
       return   salaireBrut - salaireBrut * 0.2;
    }
}
