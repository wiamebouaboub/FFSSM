/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author aboub
 */
public class TestMoniteur {
    private Moniteur moniteur;
    private Club club;
   
    
    @BeforeEach
    public void setUp() {
        moniteur = new Moniteur("1234","Bouaboub","Wiame","Toulouse","07-77-77-77-77",LocalDate.of(2001, 9, 14),001);
        club = new Club(moniteur, "club", "124356789");
    }
    
    @Test
    public void testEmployeurActuel(){
        moniteur.nouvelleEmbauche(club, LocalDate.now());
        assertEquals(club, moniteur.employeurActuel().get(), "Ce n'est pas l'employeur actuel.");
    }
}
