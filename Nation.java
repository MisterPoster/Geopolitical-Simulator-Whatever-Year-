public class Nation 
{ //start of Nation
	//1.Instance Variable
  //National Information
	public String name;        //Full Name
  public String government;  //System of Government*
  public int area;           //In KM^2
	public int population;     //Full Population
	public double total_gdp;   //In Trillions
	public int army;           //Active Persons

	//Alliance Information
	public boolean un_member;      //United Nations
	public boolean nato_member;    //North Atlantic Treaty Organization
	public boolean cis_member;     //Commonwealth of Independent States
	public boolean asean_member;   //Assiocation of Southeast Asian Nations
	public boolean au_member;      //African Union
	
  //Misc Information
	public boolean nuclear_state;
  public int power;          //Int Value ranging from 0 to 5
	
	private static int counter = 0;
	
	//2. Constructor
  public Nation()
  { //start of Nation-0
	  name = "";
    government = "";
    area = 0;
		population = 0;
		total_gdp = 0.0;
		army = 0;
		
		un_member = false;
		nato_member = false;
		cis_member = false;
		asean_member = false;
		au_member = false;
		
		nuclear_state = false;
		power = 0;	
		
		counter++;
  } //end of Nation-0
	public Nation(String int_name, String int_gov, int int_area, int int_pop, double int_gdp, int int_army, boolean int_un, boolean int_nato, boolean int_cis, boolean int_asean, boolean int_au, boolean int_nuclear, int int_power)
	{ //start of Nation-13
		name = int_name;
    government = int_gov;
    area = int_area;
		population = int_pop;
		total_gdp = int_gdp;
		army = int_army;
		
		un_member = int_un;
		nato_member = int_nato;
		cis_member = int_cis;
		asean_member = int_asean;
		au_member = int_au;
		
		nuclear_state = int_nuclear;
		power = int_power;	
		
		counter++;
	}//end of Nation-13
	
	//3. Getters
	public String getName()
	{
		return name;
	} //end of getName
  public String getGov()
  {
    return government;
  } //end of getGov
  public int getArea()
  {
    return area;
  } //end of getGov
	public int getPopulation()
	{
		return population;
	} //end of getPopulation
	public String getGDP()
	{
    String result = total_gdp + "in trillions";

		return result;
	} //end of getGDP
  public double getGDPValue()
  {
    return total_gdp;
  } //end of getGDPValue
	public int getArmy()
	{
		return army;
	} //return of getArmy
  public String getAlliances()
	{
		String result = "";
		
		result += "UN MEMBER: " + un_member + "\n" + 
				  "NATO MEMBER: " + nato_member + "\n" +
				  "CIS MEMBER: " + cis_member + "\n" + 
				  "ASEAN MEMBER: " + asean_member + "\n" +
				  "AU MEMBER: " + au_member + " ";
				  
		return result;
	} //end of getAlliances
  public String getIfNuclear()
  {
    String result = "";

    //Another example of if with booleans
    //Use of the String class
    if(nuclear_state == true)
      result.concat("True: the state is a nuclear power");
    else
      result.concat("False: the state is not a nuclear power");

    return result;
  } //end of getIfNuclear
  public boolean getIfNuclearValue()
  {
    return nuclear_state;
  } //end of getIfNuclearValue
	public int getPower()
	{
		return power;
	} //end of getIfNuclearValue
  public boolean getUN()
  {
    return un_member;
  } //end of getUN
  public int getCounter()
  {
    return counter;
  } //end of getCounter

	//4. Setters
  public void setName(String p_name)
  {
    name = p_name;
  } //end of setName
  public void setGov(String p_gov)
  {
    government = p_gov;
  } //end of setGov
  public void joinUN()
  {
    if(un_member == true)
    {
      System.out.println("You're already in the UN!");
    } //end of inner-if
    else
    {
      un_member = true;
    } //end of inner-else
  } //end of joinUN
  public void leaveUN()
  {
    if(un_member == false)
    {
      System.out.println("You're already not in the UN!");
    } //end of inner-if
    else 
    {
      un_member = false;
    } //end of inner-else
  } //end of leaveUN
  public void setGDP(double para_gdp)
  {
    total_gdp = para_gdp;
  } //end of setGDP
  public void setPop(int para_pop)
  {
    population = para_pop;
  } //end of setPop
  public void setArmy(int para_army)
  {
    army = para_army;
  } //end of setArmy
  public void setArea(int para_area)
  {
    area = para_area;
  } //end of setArea
  public void addPower(Nation nat, int para_power)
  {
    if(nat.getPower() == 5)
    {
      power = 5;
    } //end of inner-if
    else
    {
      power = para_power;
    } //end of inner-else
  } //end of addPower

	//5. To String
  public String TO_String()
  { //start of TO_String
    String results = "";

    results += "Name: " + name + "\n" +
               "Government: " + government + "\n" +
               "Area(in Kilometers): " + area + "\n" + 
               "Population: " + population + "\n" + 
               "Gross Domestic Product(GDP in trillions): " + total_gdp + "\n" +
               "Army(Active): " + army + "\n\n" + 
               "UN MEMBER: " + un_member + "\n" + 
				       "NATO MEMBER: " + nato_member + "\n" +
				       "CIS MEMBER: " + cis_member + "\n" + 
				       "ASEAN MEMBER: " + asean_member + "\n" +
				       "AU MEMBER: " + au_member + "\n\n" + 
               "Nuclear State: " + nuclear_state + "\n" +
               "International Scaling: " + power + "\n";

    return results;
  } //end of TO_String
} //end of Nation
