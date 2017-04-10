package beans;
import java.io.Serializable;

public class ConsoleType implements Serializable
{
		private String type;
		
		public ConsoleType(String type) {
			this.type = type;
		}
		
		
		public ConsoleType() {
	
		}
		
		public String getType()
		{
			return type;
		}
		
		public void setType(String type)
		{
			this.type = type;
		}
		
}