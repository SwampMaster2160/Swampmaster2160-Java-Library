package swampMaster2160.lib.number;

public class Sph {
	public Object r, t, p;
	
	public Sph() {
		
	}
	
	public Sph(Object r, Object t, Object p) {
		this.r = r;
		this.t = t;
		this.p = p;
	}
	
	public Sph(Vec3 number) {
		this.r = Math.sqrt(Math.pow((double)number.x, 2) + Math.pow((double)number.y, 2) + Math.pow((double)number.z, 2));
		this.t = Math.atan((double)number.y / (double)number.x);
		this.p = Math.acos((double)number.z / (double)this.r);
	}
	
	public Sph(Cyl number) {
		this.r = Math.sqrt(Math.pow((double)number.r, 2) + Math.pow((double)number.z, 2));
		this.t = Math.atan((double)number.r / (double)number.z);
		this.p = number.p;
	}
	
	public String phrase() {
		return "" + this.r + ", " + ((double)this.t / Math.PI) + (char)0x03C0 + ", " + ((double)this.p / Math.PI) + (char)0x03C0;
	}
	
	public String phrase1x() {
		return this.r + ", " + this.t + ", " + this.p;
	}
	
	public Vec3 toVec3() {
		Vec3 number = new Vec3();
		number.x = (double)this.r * Math.sin((double)this.t) * Math.cos((double)this.p);
		number.y = (double)this.r * Math.sin((double)this.t) * Math.sin((double)this.p);
		number.z = (double)this.r * Math.cos((double)this.t);
		return(number);
	}
	
	public Cyl toCyl() {
		Cyl number = new Cyl();
		number.r = (double)this.r * Math.sin((double)this.t);
		number.p = this.p;
		number.z = (double)this.r * Math.cos((double)this.t);
		return(number);
	}
}
