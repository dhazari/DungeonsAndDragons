import java.util.Scanner;
public class Adventure
{
	Scanner input = new Scanner(System.in);
	int attributes[]=new int[6];
	int modifiers[]=new int[6];
	String weaponList[]=new String[2];
	String adventurerClass;
	String race;
	String name;
	String height;
	int level;
	int hitpoints;
	int age;
	int speed;
	int sight;
	////////////////////////////////////////////////////////////////////////
	public Adventure()
	{
		level=1;
		name=createName();
		attributeBuilder();
		race=raceSelector();
		adventurerClass=classSelector(attributes);
		for (int i=0; i<6; i++)
			modifiers[i] = setModifiers(attributes[i]);
		hitpoints=setHitpoints(adventurerClass);
		age=setAge(race);
		weaponList=selectWeapons(adventurerClass);
		speed=setSpeed(race);
		sight=setSight(race);
		height=setHeight(race);
	}
	////////////////////////////////////////////////////////////////////////
	public String createName()
	{
		System.out.print("What is the name of your character?: ");
		return (input.nextLine());
	}
	////////////////////////////////////////////////////////////////////////
	public int rollDie(int n)
	{
		return ((int)(Math.random()*n)+1);
	}
	////////////////////////////////////////////////////////////////////////
	public int randBetween(int start, int end)
	{
		return ((int)(Math.random()*(end-start))+start);
	}
	////////////////////////////////////////////////////////////////////////
	public int sumOfThree(int a, int b, int c)
	{
		return (a+b+c);
	}
	////////////////////////////////////////////////////////////////////////
	public int[] sort(int [] list)
	{
		for(int x=0; x<list.length-1; x++)
		{
			int y=x;
			while(y>=0 && list[y]<list[y+1])
			{
				int hold = list[y];
				list[y] = list[y+1];
				list[y+1] = hold;
				y--;
			}
		}
		return list;
	}
	////////////////////////////////////////////////////////////////////////
	public void attributeBuilder()
	{
		int ran[]=new int[4];
		for(int x=0; x<6; x++)
		{
			for(int i=0; i<4; i++)
				ran[i] = ((int)(Math.random()*6)+1);
			ran = sort(ran);
			attributes[x]=sumOfThree(ran[0], ran[1], ran[2]);
		}
	}
	////////////////////////////////////////////////////////////////////////
	public String raceSelector()
	{
		int ran = ((int)(Math.random()*9)+1);
		switch (ran)
		{
			case 1:
				race = "Human";
				for(int i=0; i<attributes.length; i++)
					attributes[i]=attributes[i]+1;
				break;
			case 2:
				race = "Elf";
				attributes[1]=attributes[1]+2;
				break;
			case 3:
				race = "Dwarf";
				attributes[2]=attributes[2]+2;
				break;
			case 4:
				race = "Halfling";
				attributes[1]=attributes[1]+2;
				break;
			case 5:
				race = "Dragonborn";
				attributes[0]=attributes[0]+2;
				attributes[5]=attributes[5]+1;
				break;
			case 6:
				race = "Gnome";
				attributes[3]=attributes[3]+2;
				break;
			case 7:
				race = "Half-Elf";
				attributes[5]=attributes[5]+2;
				attributes[3]=attributes[3]+1;
				attributes[1]=attributes[1]+1;
				break;
			case 8:
				race = "Half-Orc";
				attributes[0]=attributes[0]+2;
				attributes[2]=attributes[2]+1;
				break;
			case 9:
				race = "Tiefling";
				attributes[3]=attributes[3]+1;
				attributes[5]=attributes[5]+2;
				break;
		}
		return race;
	}
	////////////////////////////////////////////////////////////////////////
	public String classSelector(int[] att)
	{
		if(att[2]>=att[1] && att[2]>=att[0] && att[2]>=att[3] && att[2]>=att[4] && att[2]>=att[5])
		{
			if(att[5]> att[0])
				return "Sorceror";
			return "Barbarian";
		}
		if(att[0]>=att[1] && att[0]>=att[2] && att[0]>=att[3] && att[0]>=att[4] && att[0]>=att[5])
		{
			if(att[2]> att[1] && att[2]>att[5])
				return "Barbarian";
			if(att[1]> att[2] && att[1]>att[5])
				return "Fighter";
			return "Paladin";
		}
		if(att[5]>=att[1] && att[5]>=att[2] && att[5]>=att[3] && att[5]>=att[4] && att[5]>=att[0])
		{
			if(att[1]> att[2] && att[1]>att[4])
				return "Bard";
			if(att[2]> att[1] && att[2]>att[4])
				return "Sorceror";
			return "Warlock";
		}
		if(att[4]>=att[1] && att[4]>=att[2] && att[4]>=att[3] && att[4]>=att[5] && att[4]>=att[0])
		{
			if(att[5]> att[1] && att[5]>att[3])
				return "Cleric";
			if(att[3]> att[1] && att[3]>att[5])
				return "Druid";
			return "Ranger";
		}
		if(att[1]>=att[5] && att[1]>=att[2] && att[1]>=att[3] && att[1]>=att[4] && att[1]>=att[0])
		{
			if(att[4]> att[3])
				return "Monk";
			return "Rogue";
		}
		return "Wizard";
	}
	////////////////////////////////////////////////////////////////////////
	public int setModifiers(int n)
	{
		if (n==1)
			return -5;
		if (n==2||n==3)
			return -4;
		if (n==4||n==5)
			return -3;
		if (n==6||n==7)
			return -2;
		if (n==8||n==9)
			return -1;
		if (n==10||n==11)
			return 0;
		if (n==12||n==13)
			return 1;
		if (n==14||n==15)
			return 2;
		if (n==16||n==17)
			return 3;
		if (n==18||n==19)
			return 4;
		return 5;
	}
	////////////////////////////////////////////////////////////////////////
	public int setHitpoints(String character)
	{
		switch (character)
		{
			case "Barbarian":
				return 10 + rollDie(4) + modifiers[2];
			case "Fighter":
				return 8 + rollDie(4) + modifiers[2];
			case "Paladin":
				return 8 + rollDie(4) + modifiers[2];
			case "Ranger":
				return 8 + rollDie(4) + modifiers[2];
			case "Sorceror":
				return 4 + rollDie(4) + modifiers[2];
			case "Wizard":
				return 4 + rollDie(4) + modifiers[2];
			default:
				return 6 + rollDie(4) + modifiers[2];
		}
	}
	////////////////////////////////////////////////////////////////////////
	public int setAge(String race)
	{
		int n = 0;
		switch (race)
		{
			case "Dwarf":
				n = randBetween(50,250);
				break;
			case "Elf":
				n = randBetween(100,600);
				break;
			case "Halfling":
				n = randBetween(20,120);
				break;
			case "Human":
				n = randBetween(17,55);
				break;
			case "Dragonborn":
				n = randBetween(15,60);
				break;
			case "Gnome":
				n = randBetween(40,425);
				break;
			case "Half-Elf":
				n = randBetween(19,140);
				break;
			case "Half-Orc":
				n = randBetween(14,60);
				break;
			case "Tiefling":
				n = randBetween(17,65);
				break;
		}
		return n;
	}
	////////////////////////////////////////////////////////////////////////
	public String setHeight(String race)
		{
			int f = 0;
			int i = 0;
			int ran = randBetween(1,11);
			switch (race)
			{
				case "Dwarf":
					if (ran <= 5)
					{
						f = 4;
						i = randBetween(0,12);
					}
					else
						f = 5;
					break;
				case "Elf":
					if (ran <= 5)
					{
						f = 5;
						i = randBetween(0,12);
					}
					else
					{
						f = 6;
						i = randBetween(0,3);
					}
					break;
				case "Halfling":
					if (ran <= 5)
					{
						f = 2;
						i = randBetween(6,12);
					}
					else
					{
						f = 3;
						i = randBetween(0,7);
					}
					break;
				case "Human":
					if (ran <= 5)
					{
						f = 5;
						i = randBetween(0,12);
					}
					else
					{
						f = 6;
						i = randBetween(0,7);
					}
					break;
				case "Dragonborn":
					if (ran <= 5)
					{
						f = 6;
						i = randBetween(4,12);
					}
					else
					{
						f = 7;
						i = randBetween(0,7);
					}
					break;
				case "Gnome":
					if (ran <= 5)
					{
						f = 3;
						i = randBetween(0,12);
					}
					else
					{
						f = 4;
						i = randBetween(0,5);
					}
					break;
				case "Half-Elf":
					if (ran <= 5)
					{
						f = 5;
						i = randBetween(0,12);
					}
					else
					{
						f = 6;
						i = randBetween(0,5);
					}
					break;
				case "Half-Orc":
					if (ran <= 5)
					{
						f = 5;
						i = randBetween(5,12);
					}
					else
					{
						f = 6;
						i = randBetween(0,11);
					}
					break;
				case "Tiefling":
					if (ran <= 5)
					{
						f = 5;
						i = randBetween(0,12);
					}
					else
					{
						f = 6;
						i = randBetween(0,7);
					}
					break;
			}
		return f+"'"+i+"\"";
	}
	////////////////////////////////////////////////////////////////////////
	public String[] selectWeapons(String character)
	{
		String weapons[]=new String[7];
		String weapon[]=new String[2];
		String ran="";
		String ran2="";
		switch (character)
		{
			case "Barbarian":
				weapons[0] = "Longsword";
				weapons[1] = "Mace";
				weapons[2] = "Warhammer";
				weapons[3] = "Shortsword";
				weapons[4] = "Morningstar";
				weapons[5] = "Greatsword";
				ran = weapons[(int)(Math.random()*6)];
				ran2 = weapons[(int)(Math.random()*6)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*6)];
				}
				break;
			case "Bard":
				weapons[0] = "Dagger";
				weapons[1] = "Rapier";
				weapons[2] = "Shortsword";
				weapons[3] = "Longsword";
				weapons[4] = "Quarterstaff";
				weapons[5] = "Light Crossbow";
				ran = weapons[(int)(Math.random()*6)];
				ran2 = weapons[(int)(Math.random()*6)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*6)];
				}
				break;
			case "Cleric":
				weapons[0] = "Dagger";
				weapons[1] = "Darts";
				weapons[2] = "Sling";
				weapons[3] = "Quarterstaff";
				ran = weapons[(int)(Math.random()*4)];
				ran2 = weapons[(int)(Math.random()*4)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*4)];
				}
				break;
			case "Druid":
				weapons[0] = "Dagger";
				weapons[1] = "Darts";
				weapons[2] = "Sling";
				weapons[3] = "Quarterstaff";
				weapons[4] = "Trident";
				weapons[5] = "Mace";
				weapons[6] = "Scimitar";
				ran = weapons[(int)(Math.random()*7)];
				ran2 = weapons[(int)(Math.random()*7)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*7)];
				}
				break;
			case "Fighter":
				weapons[0] = "Longsword";
				weapons[1] = "Mace";
				weapons[2] = "Warhammer";
				weapons[3] = "Shortsword";
				weapons[4] = "Morningstar";
				weapons[5] = "Greatsword";
				ran = weapons[(int)(Math.random()*6)];
				ran2 = weapons[(int)(Math.random()*6)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*6)];
				}
				break;
			case "Monk":
				weapons[0] = "Quarterstaff";
				weapons[1] = "Nunchaku";
				weapons[2] = "Katana";
				ran = weapons[(int)(Math.random()*3)];
				ran2 = weapons[(int)(Math.random()*3)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*3)];
				}
				break;
			case "Paladin":
				weapons[0] = "Longsword";
				weapons[1] = "Mace";
				weapons[2] = "Warhammer";
				weapons[3] = "Shortsword";
				ran = weapons[(int)(Math.random()*4)];
				ran2 = weapons[(int)(Math.random()*4)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*4)];
				}
				break;
			case "Ranger":
				weapons[0] = "Longbow";
				weapons[1] = "Shortbow";
				weapons[2] = "Light Crossbow";
				weapons[3] = "Longsword";
				ran = weapons[(int)(Math.random()*4)];
				ran2 = weapons[(int)(Math.random()*4)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*4)];
				}
				break;
			case "Rogue":
				weapons[0] = "Dagger";
				weapons[1] = "Rapier";
				weapons[2] = "Shortsword";
				weapons[3] = "Longsword";
				ran = weapons[(int)(Math.random()*4)];
				ran2 = weapons[(int)(Math.random()*4)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*4)];
				}
				break;
			case "Sorceror":
				weapons[0] = "Dagger";
				weapons[1] = "Darts";
				weapons[2] = "Sling";
				weapons[3] = "Quarterstaff";
				ran = weapons[(int)(Math.random()*4)];
				ran2 = weapons[(int)(Math.random()*4)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*4)];
				}
				break;
			case "Warlock":
				weapons[0] = "Dagger";
				weapons[1] = "Darts";
				weapons[2] = "Sling";
				weapons[3] = "Quarterstaff";
				weapons[4] = "Trident";
				ran = weapons[(int)(Math.random()*5)];
				ran2 = weapons[(int)(Math.random()*5)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*5)];
				}
				break;
			case "Wizard":
				weapons[0] = "Dagger";
				weapons[1] = "Darts";
				weapons[2] = "Sling";
				weapons[3] = "Quarterstaff";
				ran = weapons[(int)(Math.random()*4)];
				ran2 = weapons[(int)(Math.random()*4)];
				while (ran.equals(ran2))
				{
					ran2 = weapons[(int)(Math.random()*4)];
				}
				break;
		}
		weapon[0]=ran;
		weapon[1]=ran2;
		return weapon;
	}
	////////////////////////////////////////////////////////////////////////
	public int setSpeed(String race)
	{
		switch (race)
		{
			case "Dwarf":
				return 25;
			case "Elf":
				return 35;
			case "Halfling":
				return 25;
			case "Gnome":
				return 25;
			default:
				return 30;
		}
	}
	////////////////////////////////////////////////////////////////////////
	public int setSight(String race)
	{
		switch (race)
		{
			case "Human":
				return 30;
			case "Dragonborn":
				return 30;
			case "Halfling":
				return 30;
			case "Half-Orc":
				return 30;
			default:
				return 60;
		}
	}
	////////////////////////////////////////////////////////////////////////
	public String getName()
	{
		return name;
	}
	public int[] getAttributes()
	{
		return attributes;
	}
	public String getRace()
	{
		return race;
	}
	public String getClasses()
	{
		return adventurerClass;
	}
	public int[] getModifiers()
	{
		return modifiers;
	}
	public int getHitpoints()
	{
		return hitpoints;
	}
	public int getAge()
	{
		return age;
	}
	public String[] getWeapons()
	{
		return weaponList;
	}
	public int getSpeed()
	{
		return speed;
	}
	public int getSight()
	{
		return sight;
	}
	public String getHeight()
	{
		return height;
	}
	public int getLevel()
	{
		return level;
	}
}