package com.magasin;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0)};
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }

    //TESTS PASS VIP CONCERT
    @Test
    // 1) SpellIn entre 50 et 10 == Quality +1
    void testPassVIPSellInIs12QualityIs20() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 12, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality(); // Output "Pass VIP Concert, 11, 21"
        for (int i = 0; i < 3; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("Pass VIP Concert, 8, 26", app.items[0].toString());
    }
    @Test
    // 2) SpellIn entre 10 et 6 == Quality +2
    void testPassVIPSellInIs10QualityIs20() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 9, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality(); // Output "Pass VIP Concert, 9, 22"

        for (int i = 0; i < 3; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("Pass VIP Concert, 5, 28", app.items[0].toString());
    }

    @Test
    // 3) SpellIn entre 5 et 0 == Quality +3 -> ici 5
    void testPassVIPSellInIs5QualityIs20() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 5, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality(); // Output "Pass VIP Concert, 4, 23"
        for (int i = 0; i < 3; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("Pass VIP Concert, 1, 32", app.items[0].toString());
    }

    @Test
    // 4) SpellIn après 0 (-1) == Quality = 0
    void testPassVIPSellInIs0QualityIs20() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 0, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality(); // Output "Pass VIP Concert, -1, 0"
        for (int i = 0; i < 3; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("Pass VIP Concert, -4, 0", app.items[0].toString());
    }

    @Test
    // Item se dégrade 2 fois plus vite après date de péremption
    void testClassicItemPeremptionPast0(){
        Item[] items = new Item[] {new Item("Patate", 0, 10)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        for (int i = 0; i < 3; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("Patate, -4, 2", app.items[0].toString());
    }

    @Test
    // Un produit ne peut pas avoir une qualité supérieur à 50
    // (ex : le Comté qui augmente sa qualité avec le temps ne peut dépasser 50 de qualité)
    void testClassicItemQualitySup50(){
        Item[] items = new Item[] {new Item("Comté", 10, 48)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 3; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("Comté, 7, 50", app.items[0].toString());
    }

    @Test
    void testItemComteQualityinferior0(){
        Item[] items = new Item[] {new Item("Comté", -1, 30)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 5; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("Comté, -6, 40", app.items[0].toString());
    }
    @Test
    void testKryptonitesup0(){
        Item[] items = new Item[] {new Item("kryptonite", -1, 30)};
        Magasin app = new Magasin(items);
        for (int i = 0; i < 5; i++){
            app.updateQuality();
            System.out.println(app.items[0]);
        }
        assertEquals("kryptonite, -6, 20", app.items[0].toString());
    }
    @Test
    void testpouvoirsup0(){
        Item[] items = new Item[] {new Item("pouvoir magique", 3, 30)};
        Magasin app = new Magasin(items);
            app.updateQuality();


        assertEquals("pouvoir magique, 2, 28", app.items[0].toString());
    }
    @Test
    void testpouvoirinf0(){
        Item[] items = new Item[] {new Item("pouvoir magique", 0, 30)};
        Magasin app = new Magasin(items);
        app.updateQuality();


        assertEquals("pouvoir magique, -1, 26", app.items[0].toString());
    }







}
