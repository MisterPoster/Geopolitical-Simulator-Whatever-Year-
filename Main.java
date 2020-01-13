import java.util.*;

public class Main 
{ // start of Main
  // ------------------MAIN FUNCTION-----------------------------

  public static void main(String args[])
   { // start of main
    // ------------------VARIABLES-----------------------------
    Nation m_player = new Nation();
    Leader m_player_leader = new Leader();

    Scanner kb = new Scanner(System.in);
    int i = 0; // First choice
    int k = 0; // Second Choice

    // NAME, GOV, AREA(in KM), POPULATION, GDP(In Trillions), ARMY(Active), UN,
    // NATO, CIS, ASEAN, AU, NUCLEAR, POWER

    // System of International Scaling
    // 0 - N/A/Collapsed
    // 1 - Microstate
    // 2 - Unstable State
    // 3 - Middle Power
    // 4 - Great Power
    // 5 - Superpower - 

    // ------------------UNSC-----------------------------
    Nation[] p_5 = new Nation[5];

    p_5[0] = new Nation("Russian Federation", "Federal Republic", 17098246, 144526636, 4.18, 1013628, true, false, true, false, false, true, 4);
    p_5[1] = new Nation("United States of America", "Federal Republic", 9833520, 325719178, 19.39, 1281900, true, true, false, false, false, true, 5);
    p_5[2] = new Nation("People's Republic of China", "Communist Republic", 9596961, 1403500365, 25.238, 2035000, true, false, false, false, false, true, 4);
    p_5[3] = new Nation("United Kingdom of Great Britain and Northern Ireland", "Constitutional Monarchy", 242495, 66040229, 3.028, 149710, true, true, false, false, false, true, 4);
    p_5[4] = new Nation("French Republic", "Republic", 640679, 67348000, 2.960, 205121, true, true, false, false, false, true, 4);

    System.out.println();

    System.out.println("Welcome to Geopolitical Simulator: whatever year!");

    do 
    { // start of do-while-choice
      System.out.println();

      System.out.println("What do you want to do?");
      System.out.println("1. Play as an existing nation");
      System.out.println("2. Found a new nation");
      System.out.println("3. Quit");

      i = kb.nextInt();
    } while (i > 3 || i < 1); // end of do-while-choice

    // ------------------LOGIC-----------------------------

    if (i == 1) // Country Choice
    { // start of if
      k = 0;

      for (int j = 0; j < p_5.length; j++) 
      {
        System.out.println(p_5[j].TO_String());
        System.out.println("-------------------------------------");
      } // end of for

      int a = 0;

      do
       {
        System.out.println();

        System.out.println("Choose one: " + "\n" + "Russia - 0" + "\n" + "USA - 1" + "\n" + "China - 2" + "\n" + "UK - 3" + "\n" + "France - 4");

        a = kb.nextInt();
      } while (a > 4 || a < 0); // end of do-while

      m_player = p_5[a];

      do 
      { // start of National Actions
        k = 0;
        k = askAgain();

        int war_on = -1;
        // int compare;
        Nation defender = new Nation();

        if (k == 1) //Declares war
        { // start of WAR
          for (int j = 0; j < p_5.length; j++) 
          {
            System.out.println(p_5[j].getName());
            System.out.println("-------------------------------------");
          } // end of for-1

          do 
          {
            System.out.print("War on who? ");
            war_on = kb.nextInt();
          } while (war_on == -1); // end of do-while

          for (int b = 0; b < p_5.length; b++)
           {
            if (war_on == b) 
            {
              defender = p_5[b];
            } // end of in-if
          } // end of for-2

          System.out.println(defender.TO_String());

          International_Rel state = new International_Rel();
          state.goToWar(m_player, defender);

          state.getWar().fightWar();

          k = askAgain();
        } // end of WAR
        else if (k == 2) //Chooses leader
         { // start of LEADER
          String nat_leader;
          int para_control;
          int para_power;
          Nation nat = m_player;

          do 
          {
            System.out.print("Name your leader: ");
            nat_leader = kb.nextLine();
          } while (nat_leader.equals("")); // end of do-while

          System.out.print("How much power? ");
          para_power = kb.nextInt();

          System.out.print("How much control? ");
          para_control = kb.nextInt();

          m_player_leader = new Leader(nat_leader, para_power, para_control, nat);

          k = askAgain();
        } // end of LEADER
        else if (k == 3) //Compares two states
         { // start of COMPARE
          int compareTo = 0;
          Nation comp = new Nation();

          for (int j = 0; j < p_5.length; j++) 
          {
            System.out.println(p_5[j].getName());
            System.out.println("-------------------------------------");
          } // end of for

          do 
          {
            System.out.print("Compare with who? ");
            compareTo = kb.nextInt();
          } while (compareTo == -1); // end of do-while

          for (int b = 0; b < p_5.length - 1; b++) 
          {
            if (compareTo == b)
             {
              comp = p_5[b];
            } // end of in-if
          } // end of for

          System.out.println(m_player.TO_String());
          System.out.println("---------------");
          System.out.println(comp.TO_String());

          k = askAgain();
        } // end of COMPARE
        else if (k == 4) //Recites info
        { // start of RECITE
          System.out.println(m_player.TO_String());

          if (m_player_leader.getLeader().equals("")) 
          { // start of if
            System.out.println("You should choose a Leader");
          } 
          else 
          {
            System.out.println(m_player_leader.toString());
          } // end of else

          k = askAgain();
        } // end of RECITE
        else if (k == 5) //Join/leave UN
         { // start of UN
          int m = 0;

          do 
          {
            System.out.print("Join or leave?");
            m = kb.nextInt();
          } while (m > 2 || m < 1); // end of do-while

          if (m == 1)
           {
            m_player.joinUN();
          } 
          else 
          {
            m_player.leaveUN();
            System.out.println("You've left the United Nations!");
          } // end of if

          k = askAgain();
        } // end of UN
        else if (k == 6) //Changes Name/Gov
        { // start of REVOLUTION
          String p_name;
          String p_gov;
          String p_leader;

          do 
          {
            System.out.print("New Name: ");
            p_name = kb.nextLine();
          } while (p_name.equals("")); // end of do-while

          do 
          {
            System.out.print("New Government: ");
            p_gov = kb.nextLine();
          } while (p_gov.equals("")); // end of do-while

          do
          {
            System.out.print("New Leader: ");
            p_leader = kb.next();
          } while(p_leader.equals(""));

          m_player.setName(p_name);
          m_player.setGov(p_gov);

          m_player_leader.setLeader(p_leader);

          k = askAgain();
        } // end of REVOLUTION
        else if (k == 7) //End Program/Credits
         { // start of BYE
          System.out.println("BYE");
          System.out.println("If you liked this, then check out Model United Nations!");
          System.out.println("President: Samuel Sparenga");
          System.out.println("Meets: Mondays");
          System.out.println("Time: 3:04-4:00");
        } // end of BYE
      } while (k != 7);

    } // end of if
    else if (i == 2) // Custom Country
    { // start of elif-1
      String p_name;
      String p_gov;

      do 
      {
        System.out.print("Name: ");
        p_name = kb.nextLine();
      } while (p_name.equals("")); // end of do-while

      do 
      {
        System.out.print("Government: ");
        p_gov = kb.nextLine();
      } while (p_gov.equals("")); // end of do-while

      System.out.print("Area: ");
      int area = kb.nextInt();

      System.out.print("Population: ");
      int pop = kb.nextInt();

      System.out.print("Total GDP: ");
      double gdp = kb.nextDouble();

      System.out.print("Army: ");
      int army = kb.nextInt();

      System.out.print("UN Member: ");
      boolean un = kb.nextBoolean();

      System.out.print("NATO Member: ");
      boolean nato = kb.nextBoolean();

      System.out.print("CIS Member: ");
      boolean cis = kb.nextBoolean();

      System.out.print("ASEAN Member: ");
      boolean asean = kb.nextBoolean();

      System.out.print("AU Member: ");
      boolean au = kb.nextBoolean();

      System.out.print("Nuclear power: ");
      boolean nuke = kb.nextBoolean();

      System.out.print("Power: ");
      int power = kb.nextInt();

      m_player = new Nation(p_name, p_gov, area, pop, gdp, army, un, nato, cis, asean, au, nuke, power);

      do
       { // start of National Actions
        k = 0;
        k = askAgain();

        int war_on = -1;
        Nation defender = new Nation();

        if (k == 1)  //Decleares war
        { // start of WAR
          for (int j = 0; j < p_5.length; j++)
          {
            System.out.println(p_5[j].getName());
            System.out.println("-------------------------------------");
          } // end of for-1

          do
           {
            System.out.print("War on who? ");
            war_on = kb.nextInt();
          } while (war_on == -1); // end of do-while

          for (int b = 0; b < p_5.length; b++)
          {
            //if with one boolean operators
            if (war_on == b) 
            {
              defender = p_5[b];
            } // end of in-if
          } // end of for-2
          //If in context of a for loop

          System.out.println(defender.TO_String());

          International_Rel state = new International_Rel();
          state.goToWar(m_player, defender);

          state.getWar().fightWar();

          k = askAgain();
        } // end of WAR
        else if (k == 2) //Chooses leader
        { // start of LEADER
          String nat_leader;
          int para_control;
          int para_power;
          Nation nat = m_player;

          do 
          {
            System.out.print("Name your leader: ");
            nat_leader = kb.nextLine();
          } while (nat_leader.equals("")); // end of do-while

          System.out.print("How much power? ");
          para_power = kb.nextInt();

          System.out.print("How much control? ");
          para_control = kb.nextInt();

          //Passing object as parameter
          m_player_leader = new Leader(nat_leader, para_power, para_control, nat);

          k = askAgain();
        } // end of LEADER
        else if (k == 3) //Compares
        { // start of COMPARE
          int compareTo = 0;
          Nation comp = new Nation();

          for (int j = 0; j < p_5.length; j++) 
          {
            System.out.println(p_5[j].getName());
            System.out.println("-------------------------------------");
          } // end of for

          do
          {
            System.out.print("Compare with who? ");
            compareTo = kb.nextInt();
          } while (compareTo == -1); // end of do-while

          for (int b = 0; b < p_5.length - 1; b++)
          {
            if (compareTo == b) 
            {
              comp = p_5[b];
            } // end of in-if
          } // end of for

          System.out.println(m_player.TO_String());
          System.out.println("---------------");
          System.out.println(comp.TO_String());

          k = askAgain();
        } // end of COMPARE
        else if (k == 4) //Recites info
        { // start of RECITE
          System.out.println(m_player.TO_String());

          if (m_player_leader.getLeader().equals(""))
          { // start of if
            System.out.println("You should choose a Leader");
          } 
          else 
          {
            System.out.println(m_player_leader.toString());
          } // end of else

          k = askAgain();
        } // end of RECITE
        else if (k == 5) //Join/leave UN
        { // start of UN
          int m = 0;

          do 
          {
            System.out.print("Join or leave?");
            m = kb.nextInt();
          } while (m > 2 || m < 1); // end of do-while

          if (m == 1) 
          {
            m_player.joinUN();
          } 
          else
          {
            m_player.leaveUN();
            System.out.println("You've left the United Nations!");
          } // end of if

          k = askAgain();
        } // end of UN
        else if (k == 6) //Changes Name and Gov
        { // start of REVOLUTION
          String para_name = "";
          String para_gov = "";
          String para_leader = "";

          do
          {
            System.out.print("New Name: ");
            para_name = kb.nextLine();
          } while (para_name.equals("")); // end of do-while

          do 
          {
            System.out.print("New Government: ");
            para_gov = kb.nextLine();
          } while (para_gov.equals("")); // end of do-while

          do 
          {
            System.out.print("New Leader: ");
            para_leader = kb.nextLine();
          } while (para_leader.equals("")); // end of do-while

          m_player.setName(para_name);
          m_player.setGov(para_gov);

          m_player_leader.setLeader(para_leader);

          k = askAgain();
        } // end of REVOLUTION
        //Two logical relations
        else if (k == 7) //End Program/Credits
        { // start of BYE
          System.out.println("BYE");
          System.out.println("If you liked this, then check out Model United Nations!");
          System.out.println("President: Samuel Sparenga");
          System.out.println("Meets: Mondays");
          System.out.println("Time: 3:04-4:00");
        } // end of BYE
      } while (k != 7);

    } // end of elif-1

    else if (i == 3) // End Program/Credits
    { // start of elif-2
      System.out.println("BYE");
      System.out.println("If you liked this, then check out Model United Nations!");
      System.out.println("President: Samuel Sparenga");
      System.out.println("Meets: Mondays");
      System.out.println("Time: 3:04-4:00");
    } // end of elif-2

  } // end of main

  // ----------------------METHODS USED FOR MAIN--------------------------------------

  public static int askAgain() // Used to ask for National Actions
  { // start of askAgain

    Scanner k_b = new Scanner(System.in);
    int k = 0;

    do 
    {
      System.out.println();

      System.out.println("What do you want to do?");
      System.out.println("1. Go to War");
      System.out.println("2. Choose a Leader");
      System.out.println("3. Compare to another state");
      System.out.println("4. Recite Information");
      System.out.println("5. Leave/Join UN");
      System.out.println("6. Revolution!");
      System.out.println("7. Quit");

      k = k_b.nextInt();
    } while (k > 7 || k < 1);
    //Third one!

    return k;

  } // end of askAgain

} // end of Main
