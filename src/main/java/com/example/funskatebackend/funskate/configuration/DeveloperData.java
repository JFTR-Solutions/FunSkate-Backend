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


import java.util.Arrays;
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
    //createLocations();
    //createAllClubs(locationRepository.findAll());
    //createAthletes(clubRepository.findAll());
    //createCompetitions();
    //createElementGroups();
    //attendAthletesToCompetitions(athleteRepository.findAll(), competitionRepository.findAll());
    //sortEventParticipantsIntoGroups(skateGroupRepository.findAll(), eventParticipantRepository.findAll());
    //createUser();
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
    Club club18 = new Club("Ørestad Skøjteklub", "", "OESK", locations.get(16), CompetitionType.EAST);


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


    // Define the email domain
    String emailDomain = "@funskate.dk";

// Generate a random clubPassword for all users

    String clubPassword = "";

// Create a UserWithRoles account for each club
    UserWithRoles club1User = new UserWithRoles("ASF", clubPassword, "ASF" + emailDomain, club1);
    UserWithRoles club2User = new UserWithRoles("ASK", clubPassword, "ASK" + emailDomain, club2);
    UserWithRoles club3User = new UserWithRoles("ESK", clubPassword, "ESK" + emailDomain, club3);
    UserWithRoles club4User = new UserWithRoles("FSF", clubPassword, "FSF" + emailDomain, club4);
    UserWithRoles club5User = new UserWithRoles("GKF", clubPassword, "GKF" + emailDomain, club5);
    UserWithRoles club6User = new UserWithRoles("GSF", clubPassword, "GSF" + emailDomain, club6);
    UserWithRoles club7User = new UserWithRoles("HI-KU", clubPassword, "HI-KU" + emailDomain, club7);
    UserWithRoles club8User = new UserWithRoles("HSF", clubPassword, "HSF" + emailDomain, club8);
    UserWithRoles club9User = new UserWithRoles("HSK", clubPassword, "HSK" + emailDomain, club9);
    UserWithRoles club10User = new UserWithRoles("HKF", clubPassword, "HKF" + emailDomain, club10);
    UserWithRoles club11User = new UserWithRoles("OSK", clubPassword, "OSK" + emailDomain, club11);
    UserWithRoles club12User = new UserWithRoles("RSIK", clubPassword, "RSIK" + emailDomain, club12);
    UserWithRoles club13User = new UserWithRoles("SSF", clubPassword, "SSF" + emailDomain, club13);
    UserWithRoles club14User = new UserWithRoles("SKK", clubPassword, "SKK" + emailDomain, club14);
    UserWithRoles club15User = new UserWithRoles("SOS", clubPassword, "SOS" + emailDomain, club15);
    UserWithRoles club16User = new UserWithRoles("TSK", clubPassword, "TSK" + emailDomain, club16);
    UserWithRoles club17User = new UserWithRoles("VSK", clubPassword, "VSK" + emailDomain, club17);
    UserWithRoles club18User = new UserWithRoles("OESK", clubPassword, "OESK" + emailDomain, club18);


// Save all users to the database
    userWithRolesRepository.saveAll(Arrays.asList(
        club1User, club2User, club3User, club4User, club5User, club6User,
        club7User, club8User, club9User, club10User, club11User, club12User,
        club13User, club14User, club15User, club16User, club17User, club18User
    ));


  }


    public void createAthletes(List<Club> clubs) {

    }

    public void createCompetitions() {

    }

  public void createElementGroups() {

    // FunSkate Elements Groups

    // FunBubbles Groups
    SkateGroup funBubbles1 = new SkateGroup("FunBubbles 1", 2, 0, 8);
    SkateGroup funBubbles2 = new SkateGroup("FunBubbles 2", 2, 8, 10);
    SkateGroup funBubbles3 = new SkateGroup("FunBubbles 3", 2, 10, 18);
    SkateGroup funBubbles41 = new SkateGroup("FunBubbles 4", 2, 18, Integer.MAX_VALUE);
    SkateGroup funBubbles42 = new SkateGroup("FunBubbles 4", 3, 18, Integer.MAX_VALUE);


// FunFlakes Groups
    SkateGroup funFlakes1 = new SkateGroup("FunFlakes 1", 3, 0, 10);
    SkateGroup funFlakes2 = new SkateGroup("FunFlakes 2", 3, 10, 12);
    SkateGroup funFlakes3 = new SkateGroup("FunFlakes 3", 3, 12, 18);

// FunCubes Groups
    SkateGroup funCubes1 = new SkateGroup("FunCubes 1", 4, 0, 11);
    SkateGroup funCubes2 = new SkateGroup("FunCubes 2", 4, 11, 13);
    SkateGroup funCubes3 = new SkateGroup("FunCubes 3", 4, 13, 18);
    SkateGroup funCubes41 = new SkateGroup("FunCubes 4", 4, 18, Integer.MAX_VALUE);
    SkateGroup funCubes42 = new SkateGroup("FunCubes 4", 5, 18, Integer.MAX_VALUE);
    SkateGroup funCubes43 = new SkateGroup("FunCubes 4", 6, 18, Integer.MAX_VALUE);
    SkateGroup funCubes44 = new SkateGroup("FunCubes 4", 7, 18, Integer.MAX_VALUE);

// FunCrystals Groups
    SkateGroup funCrystals11 = new SkateGroup("FunCrystals 1", 5, 0, 11);
    SkateGroup funCrystals12 = new SkateGroup("FunCrystals 1", 6, 0, 11);
    SkateGroup funCrystals13 = new SkateGroup("FunCrystals 1", 7, 0, 11);
    SkateGroup funCrystals21 = new SkateGroup("FunCrystals 2", 5, 11, 13);
    SkateGroup funCrystals22 = new SkateGroup("FunCrystals 2", 6, 11, 13);
    SkateGroup funCrystals23 = new SkateGroup("FunCrystals 2", 7, 11, 13);
    SkateGroup funCrystals31 = new SkateGroup("FunCrystals 3", 5, 13, 18);
    SkateGroup funCrystals32 = new SkateGroup("FunCrystals 3", 6, 13, 18);
    SkateGroup funCrystals33 = new SkateGroup("FunCrystals 3", 7, 13, 18);


    // FunSkate Free Groups
    // Bestået DSU klubmærke 4.

    SkateGroup group1 = new SkateGroup("FunSkate Free Tots 1", 4, 0, 8);
    SkateGroup group2 = new SkateGroup("FunSkate Free Tweens 1", 4, 0, 10);
    SkateGroup group3 = new SkateGroup("FunSkate Free Teens 1", 4, 11, 12);
    SkateGroup group4 = new SkateGroup("FunSkate Free Togs 1", 4, 13, 17);
    SkateGroup group5 = new SkateGroup("FunSkate Free Adults 1", 4, 18, Integer.MAX_VALUE);


    // Bestået DSU klubmærke 5-7

    SkateGroup group61 = new SkateGroup("FunSkate Free Tots 2", 5, 0, 8);
    SkateGroup group62 = new SkateGroup("FunSkate Free Tots 2", 6, 0, 8);
    SkateGroup group63 = new SkateGroup("FunSkate Free Tots 2", 7, 0, 8);
    SkateGroup group71 = new SkateGroup("FunSkate Free Tweens 2", 5, 0, 10);
    SkateGroup group72 = new SkateGroup("FunSkate Free Tweens 2", 6, 0, 10);
    SkateGroup group73 = new SkateGroup("FunSkate Free Tweens 2", 7, 0, 10);
    SkateGroup group81 = new SkateGroup("FunSkate Free Teens 2", 5, 11, 12);
    SkateGroup group82 = new SkateGroup("FunSkate Free Teens 2", 6, 11, 12);
    SkateGroup group83 = new SkateGroup("FunSkate Free Teens 2", 7, 11, 12);
    SkateGroup group91 = new SkateGroup("FunSkate Free Togs 2", 5, 13, 17);
    SkateGroup group92 = new SkateGroup("FunSkate Free Togs 2", 6, 13, 17);
    SkateGroup group93 = new SkateGroup("FunSkate Free Togs 2", 7, 13, 17);
    SkateGroup group101 = new SkateGroup("FunSkate Free Adults 2", 5, 18, Integer.MAX_VALUE);
    SkateGroup group102 = new SkateGroup("FunSkate Free Adults 2", 6, 18, Integer.MAX_VALUE);
    SkateGroup group103 = new SkateGroup("FunSkate Free Adults 2", 7, 18, Integer.MAX_VALUE);


    skateGroupRepository.save(funBubbles1);
    skateGroupRepository.save(funBubbles2);
    skateGroupRepository.save(funBubbles3);
    skateGroupRepository.save(funBubbles41);
    skateGroupRepository.save(funBubbles42);
    skateGroupRepository.save(funFlakes1);
    skateGroupRepository.save(funFlakes2);
    skateGroupRepository.save(funFlakes3);
    skateGroupRepository.save(funCubes1);
    skateGroupRepository.save(funCubes2);
    skateGroupRepository.save(funCubes3);
    skateGroupRepository.save(funCubes41);
    skateGroupRepository.save(funCubes42);
    skateGroupRepository.save(funCubes43);
    skateGroupRepository.save(funCubes44);
    skateGroupRepository.save(funCrystals11);
    skateGroupRepository.save(funCrystals12);
    skateGroupRepository.save(funCrystals13);
    skateGroupRepository.save(funCrystals21);
    skateGroupRepository.save(funCrystals22);
    skateGroupRepository.save(funCrystals23);
    skateGroupRepository.save(funCrystals31);
    skateGroupRepository.save(funCrystals32);
    skateGroupRepository.save(funCrystals33);



    skateGroupRepository.save(group1);
    skateGroupRepository.save(group2);
    skateGroupRepository.save(group3);
    skateGroupRepository.save(group4);
    skateGroupRepository.save(group5);
    skateGroupRepository.save(group61);
    skateGroupRepository.save(group62);
    skateGroupRepository.save(group63);
    skateGroupRepository.save(group71);
    skateGroupRepository.save(group72);
    skateGroupRepository.save(group73);
    skateGroupRepository.save(group81);
    skateGroupRepository.save(group82);
    skateGroupRepository.save(group83);
    skateGroupRepository.save(group91);
    skateGroupRepository.save(group92);
    skateGroupRepository.save(group93);
    skateGroupRepository.save(group101);
    skateGroupRepository.save(group102);
    skateGroupRepository.save(group103);



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