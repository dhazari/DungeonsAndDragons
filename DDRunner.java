import java.util.ArrayList;

public class DDRunner{

	public DDRunner(){
		ArrayList<Adventure> list = new ArrayList<Adventure>();
		for (int i=0; i<10; i++)
		{
			Adventure dd=new Adventure();
			Output out=new Output(dd);
			list.add(dd);
		}
	}

	public static void main(String args[]){
		DDRunner app=new DDRunner();
	}
}