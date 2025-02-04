package com.epicode.U5D1;

import com.epicode.U5D1.config.AppConfig;
import com.epicode.U5D1.entities.Menu;
import com.epicode.U5D1.ordine.Ordine;
import com.epicode.U5D1.ordine.Stato;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OrdineRunner implements CommandLineRunner {
    @Autowired
    private Menu menu;
    private final AppConfig appConfig;

    @Override
    public void run(String... args)  throws Exception{
        System.out.println("\n🔥 Benvenuto nel ristorante! 🔥\n");

        menu.printMenu();

        Ordine ordine = new Ordine(1, Stato.in_corso, 2, 0, null);
        ordine.aggiungiPizza(menu.getPizzaList().get(0));
        ordine.aggiungiBevande(menu.getDrinkList().get(1));
        ordine.aggiungiTopping(menu.getToppingList().get(2));

        ordine.printOrdine();

    }
}
