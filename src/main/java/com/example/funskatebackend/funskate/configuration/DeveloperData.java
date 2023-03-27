package com.example.funskatebackend.funskate.configuration;

import com.example.funskatebackend.funskate.entity.*;
import com.example.funskatebackend.funskate.repository.*;
import com.example.funskatebackend.funskate.service.EventParticipantService;
import com.example.funskatebackend.security.entity.Role;
import com.example.funskatebackend.security.entity.UserWithRoles;
import com.example.funskatebackend.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

  @Autowired
  AthleteRepository athleteRepository;
  @Autowired
  LocationRepository locationRepository;
  @Autowired
  ClubRepository clubRepository;
  @Autowired
  CompetitionRepository competitionRepository;
  @Autowired
  EventParticipantRepository eventParticipantRepository;
  @Autowired
  EventParticipantGroupRepository eventParticipantGroupRepository;
  @Autowired
  SkateGroupRepository skateGroupRepository;
  @Autowired
  EventParticipantService eventParticipantService;
  @Autowired
  UserWithRolesRepository userWithRolesRepository;

  @Override
  public void run(ApplicationArguments args) {
    createLocations();
    createAllClubs(locationRepository.findAll());
    createAthletes(clubRepository.findAll());
    createCompetitions();
    createElementGroups();
    attendAthletesToCompetitions(athleteRepository.findAll(), competitionRepository.findAll());
    sortEventParticipantsIntoGroups(skateGroupRepository.findAll(), eventParticipantRepository.findAll());
    createUser();
  }
  private void createUser() {
    String password = System.getenv("PASSWORD");
    UserWithRoles user1 = new UserWithRoles("admin", password, "admin@funskate.dk");
    user1.addRole(Role.ADMIN);
    userWithRolesRepository.save(user1);

  }



  public void createLocations() {
    Location loc1 = new Location("Røllikevej 1", "Kastrup", "2770", "Kastrup Skøjtehal");
    Location loc2 = new Location("Rødovre Parkvej 425", "Rødovre", "2610", "Rødovre Arena");
    Location loc3 = new Location("Willy Brandts Vej 31", "Aalborg", "9220", "Gigantium");
    Location loc4 = new Location("Gøteborg Allé 3", "Aarhus", "8200", "Aarhus Skøjtehal");
    Location loc5 = new Location("Gl Vardevej 82", "Esbjerg", "6700", "Granly Hockey Arena");
    Location loc6 = new Location("Skøjtealleen 4", "Frederikshavn", "9900", "Frederikshavn Isstadion");
    Location loc7 = new Location("Ved Stadion 6", "Gentofte", "2820", "Gentofte Skøjtehal");
    Location loc8 = new Location("Isbanevej 3", "Søborg", "2860", "Gladsaxe Skøjtehal");
    Location loc9 = new Location("Tvedvangen 204", "Herlev", "2730", "Herlev Skøjtehal");
    Location loc10 = new Location("Holingknuden 1", "Herning", "7400", "Kvik Hockey Arena");
    Location loc11 = new Location("Hvidovrevej 446", "Hvidovre", "2650", "Frihedens Idrætscenter");
    Location loc12 = new Location("Stadionallé 11", "Rungsted Kyst", "2960", "Hørsholm Idrætspark");
    Location loc13 = new Location("Møllemarksvej 75", "Odense", "5200", "Odense Isstadion");
    Location loc14 = new Location("Århusvej 45", "Silkeborg", "8600", "Silkeborg Sportscenter");
    Location loc15 = new Location("Svendborggade 34", "København Ø", "2100", "Østerbro Skøjtehal");
    Location loc16 = new Location("Stadion Parken 7", "Vojens", "6500", "Frøs Arena og Skøjtehal");
    Location loc17 = new Location("Hannemanns Alle 14A+B", "København S", "2300", "Ørestad Skøjtehal");


    locationRepository.save(loc1);
    locationRepository.save(loc2);
    locationRepository.save(loc3);
    locationRepository.save(loc4);
    locationRepository.save(loc5);
    locationRepository.save(loc6);
    locationRepository.save(loc7);
    locationRepository.save(loc8);
    locationRepository.save(loc9);
    locationRepository.save(loc10);
    locationRepository.save(loc11);
    locationRepository.save(loc12);
    locationRepository.save(loc13);
    locationRepository.save(loc14);
    locationRepository.save(loc15);
    locationRepository.save(loc16);
    locationRepository.save(loc17);


  }

  public void createAllClubs(List<Location> locations) {

    Club club1 = new Club("Aalborg Skøjteløberforening", "", "ASF", locations.get(2), CompetitionType.WEST);
    Club club2 = new Club("Aarhus Skøjteklub", "", "ASK", locations.get(3), CompetitionType.WEST);
    Club club3 = new Club("Esbjerg Skøjteklub", "", "ESK", locations.get(4), CompetitionType.WEST);
    Club club4 = new Club("Frederikshavn Skøjteforening", "", "FSF", locations.get(5), CompetitionType.WEST);
    Club club5 = new Club("Gentofte Kunstskøjteløber Forening", "", "GKF", locations.get(6), CompetitionType.EAST);
    Club club6 = new Club("Gladsaxe Skøjteløber-Forening", "", "GSF", locations.get(7), CompetitionType.EAST);
    Club club7 = new Club("Herlev Idrætsforenings Kunstskøjte Afdeling", "", "HI-KU", locations.get(8), CompetitionType.EAST);
    Club club8 = new Club("Herning Skøjteløber Forening", "", "HSF", locations.get(9), CompetitionType.WEST);
    Club club9 = new Club("Hvidovre Skøjte Klub", "", "HSK", locations.get(10), CompetitionType.EAST);
    Club club10 = new Club("Hørsholm Kunstskøjteløber Forening", "", "HKF", locations.get(11), CompetitionType.EAST);
    Club club11 = new Club("Odense Skøjteklub", "", "OSK", locations.get(12), CompetitionType.WEST);
    Club club12 = new Club("Rødovre Skøjte- og Ishockey Klub", "", "RSIK", locations.get(1), CompetitionType.EAST);
    Club club13 = new Club("Silkeborg Skøjteløberforening", "", "SSF", locations.get(13), CompetitionType.WEST);
    Club club14 = new Club("Skøjteklub København", "", "SKK", locations.get(14), CompetitionType.EAST);
    Club club15 = new Club("Skøjte og Sport Forening Nord", "", "SOS", locations.get(5), CompetitionType.WEST);
    Club club16 = new Club("Tårnby Skøjteklub", "", "TSK", locations.get(0), CompetitionType.EAST);
    Club club17 = new Club("Vojens Skøjteklub", "", "VSK", locations.get(15), CompetitionType.WEST);
    Club club18 = new Club("Ørestad Skøjteklub", "", "ØSK", locations.get(16), CompetitionType.EAST);


    clubRepository.save(club1);
    clubRepository.save(club2);
    clubRepository.save(club3);
    clubRepository.save(club4);
    clubRepository.save(club5);
    clubRepository.save(club6);
    clubRepository.save(club7);
    clubRepository.save(club8);
    clubRepository.save(club9);
    clubRepository.save(club10);
    clubRepository.save(club11);
    clubRepository.save(club12);
    clubRepository.save(club13);
    clubRepository.save(club14);
    clubRepository.save(club15);
    clubRepository.save(club16);
    clubRepository.save(club17);
    clubRepository.save(club18);


  }


  public void createAthletes(List<Club> clubs) {
    Athlete athlete1 = new Athlete("John", "Doe", LocalDate.of(1995, 5, 12), 1500, 1234, clubs.get(0));
    Athlete athlete2 = new Athlete("Jane", "Smith", LocalDate.of(1998, 9, 3), 1800, 5678, clubs.get(0));
    Athlete athlete3 = new Athlete("Bob", "Johnson", LocalDate.of(1990, 2, 22), 1200, 9012, clubs.get(1));

    athleteRepository.save(athlete1);
    athleteRepository.save(athlete2);
    athleteRepository.save(athlete3);
  }

  public void createCompetitions() {

    Competition competition1 = new Competition(LocalDate.of(2023, 7, 1),
        LocalDate.of(2023, 7, 10), LocalDate.of(2023, 6, 15),
        CompetitionType.FINALS, locationRepository.getReferenceById(1));

    competitionRepository.save(competition1);
  }

  public void createElementGroups() {

    // FunSkate Elements Groups

    // FunBubbles Groups
    SkateGroup funBubbles1 = new SkateGroup("FunBubbles 1", 2, 0, 8);
    SkateGroup funBubbles2 = new SkateGroup("FunBubbles 2", 2, 8, 10);
    SkateGroup funBubbles3 = new SkateGroup("FunBubbles 3", 2, 10, 18);
    SkateGroup funBubbles4 = new SkateGroup("FunBubbles 4", 2, 18, Integer.MAX_VALUE);

    /*
// FunFlakes Groups
    SkateGroup funFlakes1 = new SkateGroup("FunFlakes 1", 3, 0, 10);
    SkateGroup funFlakes2 = new SkateGroup("FunFlakes 2", 3, 10, 12);
    SkateGroup funFlakes3 = new SkateGroup("FunFlakes 3", 3, 12, 18);

// FunCubes Groups
    SkateGroup funCubes1 = new SkateGroup("FunCubes 1", 4, 0, 11);
    SkateGroup funCubes2 = new SkateGroup("FunCubes 2", 4, 11, 13);
    SkateGroup funCubes3 = new SkateGroup("FunCubes 3", 4, 13, 18);
    SkateGroup funCubes4 = new SkateGroup("FunCubes 4", 5, 18, Integer.MAX_VALUE);

// FunCrystals Groups
    SkateGroup funCrystals1 = new SkateGroup("FunCrystals 1", 6, 0, 11);
    SkateGroup funCrystals2 = new SkateGroup("FunCrystals 2", 6, 11, 13);
    SkateGroup funCrystals3 = new SkateGroup("FunCrystals 3", 6, 13, 18);

     */


    // FunSkate Free Groups
    // Bestået DSU klubmærke 4.

    SkateGroup group1 = new SkateGroup("FunSkate Free Tots 1", 4, 0, 8);
    SkateGroup group2 = new SkateGroup("FunSkate Free Tweens 1", 4, 0, 10);
    SkateGroup group3 = new SkateGroup("FunSkate Free Teens 1", 4, 11, 12);
    SkateGroup group4 = new SkateGroup("FunSkate Free Togs 1", 4, 13, 17);
    SkateGroup group5 = new SkateGroup("FunSkate Free Adults 1", 4, 18, Integer.MAX_VALUE);

    /*
    // Bestået DSU klubmærke 5-7

    SkateGroup group6 = new SkateGroup("FunSkate Free Tots 2", 5, 0, 8);
    SkateGroup group7 = new SkateGroup("FunSkate Free Tweens 2", 5, 0, 10);
    SkateGroup group8 = new SkateGroup("FunSkate Free Teens 2", 5, 11, 12);
    SkateGroup group9 = new SkateGroup("FunSkate Free Togs 2", 5, 13, 17);
    SkateGroup group10 = new SkateGroup("FunSkate Free Adults 2", 5, 18, Integer.MAX_VALUE);

     */

    skateGroupRepository.save(funBubbles1);
    skateGroupRepository.save(funBubbles2);
    skateGroupRepository.save(funBubbles3);
    skateGroupRepository.save(funBubbles4);
   /* skateGroupRepository.save(funFlakes1);
    skateGroupRepository.save(funFlakes2);
    skateGroupRepository.save(funFlakes3);
    skateGroupRepository.save(funCubes1);
    skateGroupRepository.save(funCubes2);
    skateGroupRepository.save(funCubes3);
    skateGroupRepository.save(funCubes4);
    skateGroupRepository.save(funCrystals1);
    skateGroupRepository.save(funCrystals2);
    skateGroupRepository.save(funCrystals3);

    */

    skateGroupRepository.save(group1);
    skateGroupRepository.save(group2);
    skateGroupRepository.save(group3);
    skateGroupRepository.save(group4);
    skateGroupRepository.save(group5);
    /*skateGroupRepository.save(group6);
    skateGroupRepository.save(group7);
    skateGroupRepository.save(group8);
    skateGroupRepository.save(group9);
    skateGroupRepository.save(group10);

     */

  }

  public void attendAthletesToCompetitions(List<Athlete> athletes, List<Competition> competitions) {
    EventParticipant eventParticipant1 = new EventParticipant(athletes.get(0), competitions.get(0));
    EventParticipant eventParticipant2 = new EventParticipant(athletes.get(1), competitions.get(0));
    EventParticipant eventParticipant3 = new EventParticipant(athletes.get(2), competitions.get(0));

    eventParticipantRepository.save(eventParticipant1);
    eventParticipantRepository.save(eventParticipant2);
    eventParticipantRepository.save(eventParticipant3);
  }

  public void sortEventParticipantsIntoGroups(List<SkateGroup> skateGroups, List<EventParticipant> eventParticipants) {
    EventParticipantGroup eventParticipantGroup1 = new EventParticipantGroup(eventParticipants.get(0), skateGroups.get(5), skateGroups.get(1), GroupType.SOLO);
    EventParticipantGroup eventParticipantGroup2 = new EventParticipantGroup(eventParticipants.get(1), skateGroups.get(3), null, GroupType.ELEMENT);
    EventParticipantGroup eventParticipantGroup3 = new EventParticipantGroup(eventParticipants.get(2), skateGroups.get(7), skateGroups.get(6), GroupType.DANCE);
    eventParticipantGroupRepository.save(eventParticipantGroup1);
    eventParticipantGroupRepository.save(eventParticipantGroup2);
    eventParticipantGroupRepository.save(eventParticipantGroup3);
  }

}