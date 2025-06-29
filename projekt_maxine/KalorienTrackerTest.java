package projekt_maxine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KalorienTrackerTest {
    @Test
    public void testberechneKalorien() {
        //bekannte Mahlzeiten
        assertEquals(203, KalorienTracker.berechneKalorien("Proteinshake"));
        assertEquals(415, KalorienTracker.berechneKalorien( "Hähnchen und Reis"));
        assertEquals(545, KalorienTracker.berechneKalorien("Ceasar Salat"));
        assertEquals(875, KalorienTracker.berechneKalorien("Pizza"));
        assertEquals(192, KalorienTracker.berechneKalorien("Cola"));
        assertEquals(187, KalorienTracker.berechneKalorien("Fanta"));


    }
}

