package canard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import canard.TypeCanard;

public class TestTypeCanard {

    @Test
    public void testGetMultiplicateur() {
        // Tests pour vérifier que les multiplicateurs sont corrects

        // Super efficace (1.5x)
        assertEquals(1.5, TypeCanard.getMultiplicateur(TypeCanard.EAU, TypeCanard.FEU), "EAU -> FEU devrait être 1.5");
        assertEquals(1.5, TypeCanard.getMultiplicateur(TypeCanard.FEU, TypeCanard.GLACE), "FEU -> GLACE devrait être 1.5");
        assertEquals(1.5, TypeCanard.getMultiplicateur(TypeCanard.GLACE, TypeCanard.VENT), "GLACE -> VENT devrait être 1.5");
        assertEquals(1.5, TypeCanard.getMultiplicateur(TypeCanard.VENT, TypeCanard.EAU), "VENT -> EAU devrait être 1.5");

        // Attaque normale (1.0x)
        assertEquals(1.0, TypeCanard.getMultiplicateur(TypeCanard.EAU, TypeCanard.EAU), "EAU -> EAU devrait être 1.0");
        assertEquals(1.0, TypeCanard.getMultiplicateur(TypeCanard.FEU, TypeCanard.FEU), "FEU -> FEU devrait être 1.0");
        assertEquals(1.0, TypeCanard.getMultiplicateur(TypeCanard.GLACE, TypeCanard.GLACE), "GLACE -> GLACE devrait être 1.0");
        assertEquals(1.0, TypeCanard.getMultiplicateur(TypeCanard.VENT, TypeCanard.VENT), "VENT -> VENT devrait être 1.0");

        // Pas très efficace (0.5x)
        assertEquals(0.5, TypeCanard.getMultiplicateur(TypeCanard.EAU, TypeCanard.GLACE), "EAU -> GLACE devrait être 0.5");
        assertEquals(0.5, TypeCanard.getMultiplicateur(TypeCanard.FEU, TypeCanard.EAU), "FEU -> EAU devrait être 0.5");
        assertEquals(0.5, TypeCanard.getMultiplicateur(TypeCanard.GLACE, TypeCanard.FEU), "GLACE -> FEU devrait être 0.5");
        assertEquals(0.5, TypeCanard.getMultiplicateur(TypeCanard.VENT, TypeCanard.GLACE), "VENT -> GLACE devrait être 0.5");
    }
}
