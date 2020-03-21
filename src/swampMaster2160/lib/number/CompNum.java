package swampMaster2160.lib.number;

public class CompNum {
	public Object r, i;
	
	public CompNum() {
		
	}
	
	public CompNum(Object r, Object i) {
		this.r = r;
		this.i = i;
	}
	
	public CompNum(Vec2 number) {
		this.r = number.x;
		this.i = number.y;
	}
	
	public CompNum(Polar number) {
		this.r = (double)number.r * Math.cos((double)number.t);
		this.i = (double)number.r * Math.sin((double)number.t);
	}
	
	public static boolean isEqual(CompNum a, CompNum b) {
		return (a.r == b.r && a.i == b.i);
	}
	
	public static CompNum add(CompNum a, CompNum b) {
		a.r = (double)a.r + (double)b.r;
		a.i = (double)a.i + (double)b.i;
		
		return a;
	}
	
	public static CompNum sub(CompNum a, CompNum b) {
		a.r = (double)a.r - (double)b.r;
		a.i = (double)a.i - (double)b.i;
		
		return a;
	}
	
	public static CompNum mult(CompNum a, CompNum b) {
		CompNum number = new CompNum();
		
		number.r = (double)a.r * (double)b.r - (double)a.i * (double)b.i;
		number.i = (double)a.r * (double)b.i + (double)a.i * (double)b.r;
		
		return number;
	}
	
	public static CompNum div(CompNum a, CompNum b) {
		CompNum number = new CompNum();

		number.r = ((((double)a.r * (double)b.r) + ((double)a.i * (double)b.i)) / (((double)b.r * (double)b.r) + (double)b.i * (double)b.i));
		number.i = ((((double)a.i * (double)b.r) - ((double)a.r * (double)b.i)) / (((double)b.r * (double)b.r) + (double)b.i * (double)b.i));
		
		/*if((double)a.r < 0 ^ (double)a.i < 0) number.r = 0 - (double)number.r;
		if((double)b.r < 0 ^ (double)b.i < 0) number.r = 0 - (double)number.r;
		
		if((double)a.r < 0 ^ (double)a.i < 0) number.i = 0 - (double)number.i;
		if((double)b.r < 0 ^ (double)b.i < 0) number.i = 0 - (double)number.i;*/
		
		//number.r = 0 - (double)number.r;
		//number.i = 0 - (double)number.i;
		
		return number;
	}
	
	public static CompNum pow(CompNum a, int b) {
		CompNum number = new CompNum(1., 0.);
		
		for(int i = 0; i < b; i++) {
			number = CompNum.mult(number, a);
		}
		
		return number;
	}
	
	public CompNum sin() {
		CompNum number = new CompNum(0., 0.);
		
		number.r = Math.sin((double)this.r) * Math.cosh((double)this.i);
		number.i = Math.cos((double)this.r) * Math.sinh((double)this.i);
		
		return number;
	}
	
	public CompNum cos() {
		CompNum number = new CompNum(0., 0.);
		
		number.r = Math.cos((double)this.r) * Math.cosh((double)this.i);
		number.i = 0 - Math.sin((double)this.r) * Math.sinh((double)this.i);
		
		return number;
	}
	
	public CompNum tan() {
		return CompNum.div(this.sin(), this.cos());
	}
	
	public CompNum cot() {
		return CompNum.div(this.cos(), this.sin());
	}
	
	public CompNum sec() {
		CompNum number = CompNum.div(new CompNum(1., 0.), this.cos());
		
		if((double)number.r < 0) number.r = 0 - (double)number.r;
		if((double)number.i < 0) number.i = 0 - (double)number.i;
		
		if((double)this.r < 0 ^ (double)this.i < 0) number.i = 0 - (double)number.i;
		
		return number;
	}
	
	public CompNum csc() {
		CompNum number = CompNum.div(new CompNum(1., 0.), this.sin());
		
		if((double)number.r < 0) number.r = 0 - (double)number.r;
		if((double)number.i < 0) number.i = 0 - (double)number.i;

		if((double)this.r < 0) number.r = 0 - (double)number.r;
		if((double)this.i > 0) number.i = 0 - (double)number.i;
		
		return number;
	}
	
	public CompNum sqrt() {
		CompNum number = new CompNum();
		
		number.r = Math.sqrt(((double)this.r + Math.sqrt((double)this.r * (double)this.r + (double)this.i * (double)this.i)) / 2);
		number.i = Math.signum((double)this.r) * Math.sqrt((-(double)this.r + Math.sqrt((double)this.r * (double)this.r + (double)this.i * (double)this.i)) / 2);
		
		if((double)this.r < 0 ^ (double)this.i < 0) number = number.conj();
		
		return number;
	}
	
	public CompNum sq() {
		return(CompNum.mult(this, this));
	}
	
	public CompNum conj() {
		CompNum number = this;
		number.i = -(double)number.i;
		return number;
	}
	
	public CompNum recip() {
		return CompNum.div(new CompNum(1., 0.), this);
	}
	
	public String phrase() {
		if((double)this.i < 0) return this.r + " - " + (0. - (double)this.i) + "i";
		else return this.r + " + " + this.i + "i";
	}
	
	public Vec2 toVec2() {
		Vec2 number = new Vec2();
		number.x = this.r;
		number.y = this.i;
		return number;
	}
	
	public Polar toPolar() {
		Polar number = new Polar();
		number.r = Math.sqrt(Math.pow((double)this.r, 2) + Math.pow((double)this.i, 2));
		number.t = Math.atan2((double)this.i, (double)this.r);
		return number;
	}
}
