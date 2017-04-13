package beans;
import java.io.Serializable;

public class ConsoleType implements Serializable
{
		private int id;
		private String name;
		
		public ConsoleType(int id, String type) {
			this.id = id;
			this.name = type;
		}
		
		
		public ConsoleType() {
	
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setName(String type)
		{
			this.name = type;
		}
		
		public int getId()
		{
			return id;
		}
		
}