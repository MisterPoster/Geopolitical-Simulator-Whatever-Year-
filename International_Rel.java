import java.util.Random;

public class International_Rel implements Abstraction
{ // start of International_Rel

  //-----------------------------War---------------------------------------

  public class War 
  { //start of War
      Random war_die = new Random();

      public War(Nation player, Nation defender)
      { //start of War
        attacker_state = player;
        defender_state = defender;

        war_state = true;
      } //end of War

      public void fightWar()
      { //start of fightWar
        int d_addition = 0;
        int a_addition = 0;

        int defender_level = 0;
        int attacker_level = 0;

        String a_name = attacker_state.getName();
        String d_name = defender_state.getName();

        //start of ARMY Comparsion
        if((attacker_state.getArmy() > 100000) && (defender_state.getArmy() > 100000))
        {
          attacker_level++;
          defender_level++;
        } //end of inner-if
        else       
        {
          if(attacker_state.getArmy() > 100000)
          {
            attacker_level++;
          } //end of inner-inner-if
          else
          {
            defender_level++;
          } //end of inner-inner-else
        } //end of ARMY Comparsion

        //start of NUCLEAR Comparsion
        if((attacker_state.getIfNuclearValue()) && (defender_state.getIfNuclearValue()))
        {
          attacker_level += 5;
          defender_level += 5;
        } //end of inner-if
        else       
        {
          if(attacker_state.getIfNuclearValue())
          {
            attacker_level++;
          } //end of inner-inner-if
          else
          {
            defender_level++;
          } //end of inner-inner-else
        } //end of NUCLEAR Comparsion

        System.out.println(name.ToString()); //Highlights War to main

        //War die being rolled
        a_addition = (war_die.nextInt(7));
        attacker_level += a_addition;

        d_addition = (war_die.nextInt(7));
        defender_level += d_addition;

        System.out.println("Attacker level: " + attacker_level);
        System.out.println("Defender level: " + defender_level);

        System.out.println();

        if(attacker_level > defender_level)
        { //start of Attacker victory
          int area = attacker_state.getArea();
          int population = attacker_state.getPopulation();
          int army = attacker_state.getArmy();
          double GDP = attacker_state.getGDPValue();

          int a_power = attacker_state.getPower() + 1;

          System.out.println(a_name + " has won the war!");

          attacker_state.addPower(attacker_state, a_power);

          area += defender_state.getArea();
          population += defender_state.getPopulation();
          army += defender_state.getArmy();
          GDP += defender_state.getGDPValue();

          attacker_state.setArea(area);
          attacker_state.setArmy(army);
          attacker_state.setGDP(GDP);
          attacker_state.setPop(population);

          System.out.println(a_name + " now has a scale of " + attacker_state.getPower());

          attacker_state = new Nation();
          defender_state = new Nation();

          attacker_level = 0;
          defender_level = 0;
        } //end of Attacker Victory
        else if(defender_level > attacker_level)
        { //start of Defender Victory
          int area = attacker_state.getArea();
          int population = attacker_state.getPopulation();
          int army = attacker_state.getArmy();
          double GDP = attacker_state.getGDPValue();

          int d_power = defender_state.getPower() + 1;

          System.out.println(d_name + " has won the war!");

          defender_state.addPower(defender_state, d_power);

          area += defender_state.getArea();
          population += defender_state.getPopulation();
          army += defender_state.getArmy();
          GDP += defender_state.getGDPValue();

          defender_state.setArea(area);
          defender_state.setArmy(army);
          defender_state.setGDP(GDP);
          defender_state.setPop(population);

          System.out.println(d_name + " now has a scale of " + defender_state.getPower());

          defender_state = new Nation();
          attacker_state = new Nation();

          defender_level = 0;
          attacker_level = 0;
        } //end of Defender Victory
        else if(attacker_level == defender_level)
        { //start of TIE
          System.out.println("abortnite");
          System.out.println("SIKE: NO ONE WON");
        } //end of TIE
      } //end of fightWar

    public String ToString()
    { //start of ToString
      String returner = "";

      String a_name = attacker_state.getName();
      String d_name = defender_state.getName();

      if(war_state == true)
      {
        returner += "War is on between " + a_name + " and " + d_name;
      }

      return returner;
    } //end of ToString
  } //end of War

  //-----------------------------International_Rel---------------------------------------

    public Nation attacker_state;
    public Nation defender_state;
    public boolean war_state;
    public War name;

    public International_Rel() 
    { //start of International_Rel
      attacker_state = new Nation();
      defender_state = new Nation();
    } //end of International_Rel

    public void goToWar(Nation attack, Nation defend)
    { //start of goToWar
      attacker_state = attack;
      defender_state = defend;

      name = new War(attacker_state, defender_state);
    } //end of goToWar

    //Returning object from method
    public War getWar()
    { //start of getWar
      return name;
    } //end of getWar
} // end of International_Rel 
