/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import FFSSM.Club;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author aboub
 */
public class TestClub {
    private Moniteur moniteur;
    private Club club;
    private Plongeur plongeurN1, plongeurN2;
    private Plongee plongee1, plongee2;
    private Site site;
    
    
    @BeforeEach
    public void setUp() {
        moniteur = new Moniteur("1234","Bouaboub","Wiame","Toulouse","07-77-77-77-77",LocalDate.of(2001, 9, 14),001);
        club = new Club(moniteur, "club", "124356789");      
        plongeurN1= new Plongeur("1234","Bouaboub","Wiame","Toulouse","07-77-77-77-77",LocalDate.of(2001, 9, 14));
        plongeurN2= new Plongeur ("1234","Bouaboub","Wiame","Toulouse","07-77-77-77-77",LocalDate.of(2001, 9, 14));
        plongee1= new Plongee(site, moniteur, LocalDate.of(2011, 12, 5), 50, 3);
        plongee2= new Plongee(site, moniteur, LocalDate.of(2021, 12, 5), 50, 3);
        site = new Site("Toulouse", "Ramée");
    }
    
     @Test
    public void testPlongeesNonConformes() {
        plongeurN1.ajouteLicence("1", LocalDate.now(), club);
        plongeurN2.ajouteLicence("2", LocalDate.now(), club);
         
        plongee1.ajouteParticipant(plongeurN1);
        club.organisePlongee(plongee1);
        plongee2.ajouteParticipant(plongeurN2);
        club.organisePlongee(plongee2);
         
        assertTrue(club.plongeesNonConformes().contains(plongee2) && !club.plongeesNonConformes().contains(plongee1));
    }
    
}
