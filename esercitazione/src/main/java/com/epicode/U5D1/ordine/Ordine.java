package com.epicode.U5D1.ordine;

import com.epicode.U5D1.entities.Drink;
import com.epicode.U5D1.entities.Menu;
import com.epicode.U5D1.entities.Pizza;
import com.epicode.U5D1.entities.Topping;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Ordine {
    private int numeroOrdine;
    private Stato stato;
    private int coperti;
    private double totale;
    private LocalTime oraAcquisto;
    private List<Pizza> pizze = new ArrayList<>() ;
    private List<Drink> bevande = new ArrayList<>();
    private List<Topping> condimento = new ArrayList<>();

    public Ordine(int numeroOrdine, Stato stato, int coperti, double totale, LocalTime oraAcquisto) {
        this.numeroOrdine = numeroOrdine;
        this.stato = stato;
        this.coperti = coperti;
        this.totale = totale;
        this.oraAcquisto = oraAcquisto;
    }

    public void aggiungiPizza(Pizza pizza){
        pizze.add(pizza);
    }

    public void aggiungiBevande(Drink drink){
        bevande.add(drink);
    }

    public void aggiungiTopping(Topping topping){
        condimento.add(topping);
    }

    private void calcolaTotale() {
        this.totale = pizze.stream().mapToDouble(Pizza::getPrice).sum()
                + bevande.stream().mapToDouble(Drink::getPrice).sum()
                + condimento.stream().mapToDouble(Topping::getPrice).sum();
    }




}
