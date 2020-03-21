package swampMaster2160.lib.number;

public class Vec2 {
	public Object x, y;
	
	public Vec2() {
		
	}
	
	public Vec2(Object x, Object y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2(CompNum number) {
		this.x = number.r;
		this.y = number.i;
	}
	
	public Vec2(Polar number) {
		this.x = (double)number.r * Math.cos((double)number.t);
		this.y = (double)number.r * Math.sin((double)number.t);
	}
	
	public static Vec2 reMap(Vec2 value, Vec2 min1, Vec2 max1, Vec2 min2, Vec2 max2) {
		return add(min2, mult(sub(max2, min2), div(sub(value, min1), sub(max1, min1))));
	}
	
	public static Vec2 add(Vec2 a, Vec2 b) {
		
		switch(a.x.getClass().getSimpleName()) {
			case "Byte":
				a.x = (byte)a.x + (byte)b.x;
				a.y = (byte)a.y + (byte)b.y;
				break;
			case "Short":
				a.x = (short)a.x + (short)b.x;
				a.y = (short)a.y + (short)b.y;
				break;
			case "Integer":
				a.x = (int)a.x + (int)b.x;
				a.y = (int)a.y + (int)b.y;
				break;
			case "Long":
				a.x = (long)a.x + (long)b.x;
				a.y = (long)a.y + (long)b.y;
				break;
			case "Float":
				a.x = (float)a.x + (float)b.x;
				a.y = (float)a.y + (float)b.y;
				break;
			case "Double":
				a.x = (double)a.x + (double)b.x;
				a.y = (double)a.y + (double)b.y;
				break;
		}
		return a;
	}
	
	public static Vec2 sub(Vec2 a, Vec2 b) {
		switch(a.x.getClass().getSimpleName()) {
			case "Byte":
				a.x = (byte)a.x - (byte)b.x;
				a.y = (byte)a.y - (byte)b.y;
				break;
			case "Short":
				a.x = (short)a.x - (short)b.x;
				a.y = (short)a.y - (short)b.y;
				break;
			case "Integer":
				a.x = (int)a.x - (int)b.x;
				a.y = (int)a.y - (int)b.y;
				break;
			case "Long":
				a.x = (long)a.x - (long)b.x;
				a.y = (long)a.y - (long)b.y;
				break;
			case "Float":
				a.x = (float)a.x - (float)b.x;
				a.y = (float)a.y - (float)b.y;
				break;
			case "Double":
				a.x = (double)a.x - (double)b.x;
				a.y = (double)a.y - (double)b.y;
				break;
		}
		return a;
	}
	
	public static Vec2 mult(Vec2 a, Vec2 b) {
		switch(a.x.getClass().getSimpleName()) {
			case "Byte":
				a.x = (byte)a.x * (byte)b.x;
				a.y = (byte)a.y * (byte)b.y;
				break;
			case "Short":
				a.x = (short)a.x * (short)b.x;
				a.y = (short)a.y * (short)b.y;
				break;
			case "Integer":
				a.x = (int)a.x * (int)b.x;
				a.y = (int)a.y * (int)b.y;
				break;
			case "Long":
				a.x = (long)a.x * (long)b.x;
				a.y = (long)a.y * (long)b.y;
				break;
			case "Float":
				a.x = (float)a.x * (float)b.x;
				a.y = (float)a.y * (float)b.y;
				break;
			case "Double":
				a.x = (double)a.x * (double)b.x;
				a.y = (double)a.y * (double)b.y;
				break;
		}
	return a;
	}
	
	public static Vec2 div(Vec2 a, Vec2 b) {
		switch(a.x.getClass().getSimpleName()) {
			case "Byte":
				a.x = (byte)a.x / (byte)b.x;
				a.y = (byte)a.y / (byte)b.y;
				break;
			case "Short":
				a.x = (short)a.x / (short)b.x;
				a.y = (short)a.y / (short)b.y;
				break;
			case "Integer":
				a.x = (int)a.x / (int)b.x;
				a.y = (int)a.y / (int)b.y;
				break;
			case "Long":
				a.x = (long)a.x / (long)b.x;
				a.y = (long)a.y / (long)b.y;
				break;
			case "Float":
				a.x = (float)a.x / (float)b.x;
				a.y = (float)a.y / (float)b.y;
				break;
			case "Double":
				a.x = (double)a.x / (double)b.x;
				a.y = (double)a.y / (double)b.y;
				break;
		}
		return a;
	}
	
	public Vec2 toInt() {
		double x = (double)this.x;
		double y = (double)this.y;
		return new Vec2((int)x, (int)y);
	}
	
	public Vec2 toDouble() {
		double x = (int)this.x;
		double y = (int)this.y;
		return new Vec2((double)x, (double)y);
	}
	
	public String phrase() {
		return this.x + ", " + this.y;
	}
	
	public CompNum toCompNum() {
		CompNum number = new CompNum();
		number.r = this.x;
		number.i = this.y;
		return number;
	}
	
	public Polar toPolar() {
		Polar number = new Polar();
		number.r = Math.sqrt(Math.pow((double)this.x, 2) + Math.pow((double)this.y, 2));
		number.t = Math.atan2((double)this.y, (double)this.x);
		return number;
	}
}
