public class Leader
{ //start of Leader
  //1. Instance Variables
  public String l_name;
  public int l_power;
  public int l_control;
  public Nation l_nation;

  //2. Constructors
  public Leader()
  { //start of Leader-0
    l_name = "";
    l_power = 0;
    l_control = 0;
    l_nation = null;
  } //end of Leader-0

  public Leader(String int_Name, int int_Power, int int_Control, Nation nat)
  { //start of Leader-4
    l_name = int_Name;
    l_power = int_Power;
    l_control = int_Control;
    l_nation = nat;
  } //end of Leader-4

  //3. Getters
  public String getLeader()
  { //start of getLeader
    return l_name;
  } //end of getLeader

  public Nation getNation()
  { //start of getNation
    return l_nation;
  } //end of getNation
  //4. Setters
  public void setLeader(String leader)
  {
    l_name = leader;
  } //end of setLeader

  //5. To String
  public String toString()
  { //start of toString
    String returner = "";

    returner += l_name + " is the leader of the " + l_nation.getName() + 
                " and has " + l_power + " power and " + l_control + " control over the population.";

   return returner; 
  } //end of toString
} //end of Leader
