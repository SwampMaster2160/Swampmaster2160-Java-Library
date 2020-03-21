package swampMaster2160.lib.number;

public class Cyl {
	public Object r, p, z;
	
	public Cyl() {
		
	}
	
	public Cyl(Object r, Object p, Object z) {
		this.r = r;
		this.p = p;
		this.z = z;
	}
	
	public Cyl(Vec3 number) {
		this.r = Math.sqrt(Math.pow((double)number.x, 2) + Math.pow((double)number.y, 2));
		this.p = Math.atan2((double)number.y, (double)number.x);
		this.z = number.z;
	}
	
	public Cyl(Sph number) {
		this.r = (double)number.r * Math.sin((double)number.t);
		this.p = number.p;
		this.z = (double)number.r * Math.cos((double)number.t);
	}
	
	public String phrase() {
		return "" + this.r + ", " + ((double)this.p / Math.PI) + (char)0x03C0 + ", " + (double)this.z;
	}
	
	public String phrase1x() {
		return this.r + ", " + this.p + ", " + this.z;
	}
	
	public Vec3 toVec3() {
		Vec3 number = new Vec3();
		number.x = (double)this.r * Math.cos((double)this.p);
		number.y = (double)this.r * Math.sin((double)this.p);
		number.z = this.z;
		return number;
	}
	
	public Sph toSph() {
		Sph number = new Sph();
		number.r = Math.sqrt(Math.pow((double)this.r, 2) + Math.pow((double)this.z, 2));
		number.t = Math.atan((double)this.r / (double)this.z);
		number.p = this.p;
		return number;
	}
}
