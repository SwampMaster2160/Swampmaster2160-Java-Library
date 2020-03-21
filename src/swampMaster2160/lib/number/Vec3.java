package swampMaster2160.lib.number;

public class Vec3 {
	public Object x, y, z;
	
	public Vec3() {
		
	}
	
	public Vec3(Object x, Object y, Object z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3(Sph number) {
		this.x = (double)number.r * Math.sin((double)number.t) * Math.cos((double)number.p);
		this.y = (double)number.r * Math.sin((double)number.t) * Math.sin((double)number.p);
		this.z = (double)number.r * Math.cos((double)number.t);
	}
	
	public Vec3(Cyl number) {
		this.x = (double)number.r * Math.cos((double)number.p);
		this.y = (double)number.r * Math.sin((double)number.p);
		this.z = number.z;
	}
	
	public static Vec3 reMap(Vec3 value, Vec3 min1, Vec3 max1, Vec3 min2, Vec3 max2) {
		return add(min2, mult(sub(max2, min2), div(sub(value, min1), sub(max1, min1))));
	}
	
	public static Vec3 add(Vec3 a, Vec3 b) {
		a.x = (double)a.x + (double)b.x;
		a.y = (double)a.y + (double)b.y;
		a.z = (double)a.z + (double)b.z;
		return a;
	}
	
	public static Vec3 sub(Vec3 a, Vec3 b) {
		a.x = (double)a.x - (double)b.x;
		a.y = (double)a.y - (double)b.y;
		a.z = (double)a.z - (double)b.z;
		return a;
	}
	
	public static Vec3 mult(Vec3 a, Vec3 b) {
		a.x = (double)a.x * (double)b.x;
		a.y = (double)a.y * (double)b.y;
		a.z = (double)a.z * (double)b.z;
		return a;
	}
	
	public static Vec3 div(Vec3 a, Vec3 b) {
		a.x = (double)a.x / (double)b.x;
		a.y = (double)a.y / (double)b.y;
		a.z = (double)a.z / (double)b.z;
		return a;
	}
	
	public String phrase() {
		return this.x + ", " + this.y + ", " + this.z;
	}
	
	public Sph toSph() {
		Sph number = new Sph();
		number.r = Math.sqrt(Math.pow((double)this.x, 2) + Math.pow((double)this.y, 2) + Math.pow((double)this.z, 2));
		number.t = Math.atan((double)this.y / (double)this.x);
		number.p = Math.acos((double)this.z / (double)number.r);
		return(number);
	}
	
	public Cyl toCyl() {
		Cyl number = new Cyl();
		number.r = Math.sqrt(Math.pow((double)this.x, 2) + Math.pow((double)this.y, 2));
		number.p = Math.atan2((double)this.y, (double)this.x);
		number.z = this.z;
		return(number);
	}
}
