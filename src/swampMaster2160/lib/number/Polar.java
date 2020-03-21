package swampMaster2160.lib.number;

public class Polar {
	public Object r, t;
	
	public Polar() {
		
	}
	
	public Polar(Object r, Object t) {
		this.r = r;
		this.t = t;
	}
	
	public Polar(Vec2 number) {
		this.r = Math.sqrt(Math.pow((double)number.x, 2) + Math.pow((double)number.y, 2));
		this.t = Math.atan2((double)number.y, (double)number.x);
	}
	
	public Polar(CompNum number) {
		this.r = Math.sqrt(Math.pow((double)number.r, 2) + Math.pow((double)number.i, 2));
		this.t = Math.atan2((double)number.i, (double)number.r);
	}
	
	public String phrase() {
		return "" + this.r + ", " + ((double)this.t / Math.PI) + (char)0x03C0;
	}
	
	public String phrase1x() {
		return this.r + ", " + this.t;
	}
	
	public Vec2 toVec2() {
		Vec2 number = new Vec2();
		number.x = (double)this.r * Math.cos((double)this.t);
		number.y = (double)this.r * Math.sin((double)this.t);
		return number;
	}
	
	public CompNum toCompNum() {
		CompNum number = new CompNum();
		number.r = (double)this.r * Math.cos((double)this.t);
		number.i = (double)this.r * Math.sin((double)this.t);
		return number;
	}
}
