package canard;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import canard.TypeCanard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import combat.Statut;

public class TestCanard {

    @Test
    public void testGetNom() {
        Canard canardEau = new CanardEau("CanardEau");
        assertEquals("CanardEau", canardEau.getNom(), "Le nom du canard doit être 'CanardEau'");
    }

    @Test
    public void testGetPV() {
        Canard canardEau = new CanardEau("CanardEau");
        assertEquals(100, canardEau.getPV(), "Le PV du canard doit être 100");
    }

    @Test
    public void getType() {
        Canard canardEau = new CanardEau("CanardEau");
        assertEquals(TypeCanard.EAU, canardEau.getType(), "Le type du canard doit être EAU");
    }

    @Test
    public void testGetATK() {
        Canard canardEau = new CanardEau("CanardEau");
        assertEquals(20, canardEau.getATK(), "L'ATK du canard doit être 20");
    }

    @Test
    public void testgetPE() {
        Canard canardEau = new CanardEau("CanardEau");
        assertEquals(20, canardEau.getPE(), "Le PE du canard doit être 20");
    }

    @Test
    public void testGetStatut() {
        Canard canardEau = new CanardEau("CanardEau");
        assertEquals(null, canardEau.getStatut(), "Le statut du canard doit être null");
    }

    @Test
    public void testGetCountTimeStatut() {
        Canard canardEau = new CanardEau("CanardEau");
        assertEquals(0, canardEau.getCountTimeStatut(), "Le countTimeStatut du canard doit être 0");
    }

    @Test
    public void testSetStatut() {
        Canard canardEau = new CanardEau("CanardEau");
        canardEau.setStatut(Statut.BRULURE);
        assertEquals(Statut.BRULURE, canardEau.getStatut(), "Le statut du canard doit être 'StatutTest'");
    }

    @Test
    public void testSetPV() {
        Canard canardEau = new CanardEau("CanardEau");
        canardEau.setPV(80);
        assertEquals(80, canardEau.getPV(), "Le PV du canard doit être 80");
    }

    @Test
    public void testSetPE() {
        Canard canardEau = new CanardEau("CanardEau");
        canardEau.setPE(15);
        assertEquals(15, canardEau.getPE(), "Le PE du canard doit être 15");
    }

    @Test
    public void testSetAS() {
        Canard canardEau = new CanardEau("CanardEau");
        canardEau.setAS(10);
        assertEquals(10, canardEau.getAS(), "L'AS du canard doit être 10");
    }

    @Test
    public void testSetCountTimeStatut() {
        Canard canardEau = new CanardEau("CanardEau");
        canardEau.setCountTimeStatut(3);
        assertEquals(3, canardEau.getCountTimeStatut(), "Le countTimeStatut du canard doit être 3");
    }

    @Test
    public void testActiverCapaciteSpeciale() {
        Canard canardEau = new CanardEau("CanardEau");
        canardEau.activerCapaciteSpeciale();
        assertEquals(100, canardEau.getPV(), "Le PV du canard doit être 100 après l'activation de la capacité spéciale");
        canardEau.setPV(80);
        canardEau.activerCapaciteSpeciale();
        assertEquals(100, canardEau.getPV(), "Le PV du canard doit être 100 après l'activation de la capacité spéciale");
    }

}