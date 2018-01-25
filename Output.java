import java.util.Arrays;
public class Output{

	public Output(Adventure adv)
	{
		int att[]=adv.getAttributes();
		int mod[]=adv.getModifiers();
		String wea[]=adv.getWeapons();
		String race="Race";
		String age="Age";
		String Classes="Class";
		String Level="Level";
		String Speed="Speed";
		String Sight="Sight";
		String Strength="Strength";
		String Dexterity="Dexterity";
		String Constitution="Constitution";
		String Intelligence="Intelligence";
		String Wisdom="Wisdom";
		String Charisma="Charisma";
		String modifier="Modifier";
		String Hitpoints="Hitpoints";
		String Height="Height";
		System.out.println("Name: "+adv.getName()+"\n");
		String Line1 = String.format("%-40s %s", race+": "+adv.getRace(), age+": "+adv.getAge());
        System.out.println(Line1+"\n");
        String Line2 = String.format("%-40s %s", Classes+": "+adv.getClasses(), Level+": "+adv.getLevel());
        System.out.println(Line2+"\n");
        String Line3 = String.format("%-40s %s", Speed+": "+adv.getSpeed(), Sight+": "+adv.getSight());
        System.out.println(Line3+"\n");
        String Line10 = String.format("%-40s %s", Hitpoints+": "+adv.getHitpoints(), Height+": "+adv.getHeight());
        System.out.println(Line10+"\n");
        System.out.println("*******************************************************");
		String Line4 = String.format("%-40s %s", Strength+": "+att[0], modifier+": "+mod[0]);
        System.out.println(Line4+"\n");
        String Line5 = String.format("%-40s %s", Dexterity+": "+att[1], modifier+": "+mod[1]);
        System.out.println(Line5+"\n");
        String Line6 = String.format("%-40s %s", Constitution+": "+att[2], modifier+": "+mod[2]);
        System.out.println(Line6+"\n");
        String Line7 = String.format("%-40s %s", Intelligence+": "+att[3], modifier+": "+mod[3]);
        System.out.println(Line7+"\n");
        String Line8 = String.format("%-40s %s", Wisdom+": "+att[4], modifier+": "+mod[4]);
        System.out.println(Line8+"\n");
        String Line9 = String.format("%-40s %s", Charisma+": "+att[5], modifier+": "+mod[5]);
        System.out.println(Line9+"\n");
        System.out.println("*******************************************************");
		System.out.println("Weapon List: "+wea[0]+", "+wea[1]+"\n");
	}
}