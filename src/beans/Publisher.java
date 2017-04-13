package beans;

import java.io.Serializable;

public class Publisher implements Serializable, Comparable<Publisher>
{
	private int id;
	private String name;

	public Publisher(int i, String n)
	{
		id = i;
		name = n;
	}

	
	int getId()
	{
		return id;
	}
	
	String getName()
	{
		return name;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null||(!(obj instanceof Product)))
			return false;
		Publisher tmp = (Publisher)obj;
		
		return((this.id==tmp.id) && this.name.equals(tmp.getName()));
	}
	@Override
	public int compareTo(Publisher pub) 
	{
		if(this.name== pub.name)
			return 0;
		else
			return 1;
	}
	
};