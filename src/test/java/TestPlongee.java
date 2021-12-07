
import FFSSM.Club;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aboub
 */
public class TestPlongee {
    private Moniteur moniteur;
    private Club club;
    private Plongeur plongeur;
    private Plongee plongee;
    private Site site;
    
    
    @BeforeEach
    public void setUp() {
        moniteur = new Moniteur("1234","Bouaboub","Wiame","Toulouse","07-77-77-77-77",LocalDate.of(2001, 9, 14),001);
        club = new Club(moniteur, "club", "124356789");      
        plongeur= new Plongeur("1234","Bouaboub","Wiame","Toulouse","07-77-77-77-77",LocalDate.of(2001, 9, 14));
        plongee= new Plongee(site, moniteur, LocalDate.of(2021, 12, 5), 50, 3);
        site = new Site("Toulouse", "Ramée");
    }
 @Test
    public void testEstConformeTrue() {
        plongeur.ajouteLicence("1", LocalDate.now(), club);
        club.organisePlongee(plongee);
        assertFalse(club.lesPlongees.isEmpty());
        
        plongee.ajouteParticipant(plongeur);
        assertFalse(plongee.lesPlongeurs.isEmpty());
         
        assertTrue(plongee.estConforme());
    }
    
    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConformeFalse() {
        plongeur.ajouteLicence("2", LocalDate.of(2011, 12, 5), club);
        club.organisePlongee(plongee);
        assertFalse(club.lesPlongees.isEmpty());
         
        plongee.ajouteParticipant(plongeur);
        assertFalse(plongee.lesPlongeurs.isEmpty());
         
        assertFalse(plongee.estConforme());
    }
}
