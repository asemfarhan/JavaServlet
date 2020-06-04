package model;

public class Item {
	private long num;
	private String name;
	private String describe;
	
  

	public Item(long num, String name, String describe) {
		super();
		this.num = num;
		this.name = name;
		this.describe = describe;
	}


	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
}
