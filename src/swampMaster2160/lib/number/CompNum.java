package swampMaster2160.lib.number;

public class CompNum {
	public Object r, i;
	
	/**
	 * Create a new complex number with a null real and imaginary part.
	 */
	
	public CompNum() {
		
	}
	
	/**
	 * Create a new complex number with a set real and imaginary part.
	 * 
	 * @param r - the real part of the number.
	 * @param i - the imaginary part of the number.
	 */
	
	public CompNum(Object r, Object i) {
		this.r = r;
		this.i = i;
	}
	
	/**
	 * Converts a vec2 coordinate to a complex number, with (x, y) being converted to x + yi.
	 * 
	 * @param number - the vec2 coordinate to be converted.
	 * @see Vec2
	 */
	
	public CompNum(Vec2 number) {
		this.r = number.x;
		this.i = number.y;
	}
	
	/**
	 * Converts a polar coordinate to a complex number.
	 * 
	 * @param number - the polar coordinate to be converted.
	 * @see Polar
	 */
	
	public CompNum(Polar number) {
		this.r = (double)number.r * Math.cos((double)number.t);
		this.i = (double)number.r * Math.sin((double)number.t);
	}
	
	/**
	 * Returns true if and only if the real parts of the 2 numbers are equal and the imaginary parts of the 2 numbers are equal. Else will return false.
	 * 
	 * @param a - number 1.
	 * @param b - number 2.
	 * @return the equality of the 2 complex numbers.
	 */
	
	public static boolean isEqual(CompNum a, CompNum b) {
		return (a.r == b.r && a.i == b.i);
	}
	
	/**
	 * Adds the 2 complex numbers and returns the sum.
	 * 
	 * @param a - number 1.
	 * @param b - number 2.
	 * @return complex sum of a + b.
	 */
	
	public static CompNum add(CompNum a, CompNum b) {
		a.r = (double)a.r + (double)b.r;
		a.i = (double)a.i + (double)b.i;
		
		return a;
	}
	
	/**
	 * Subtracts b from a and returns the difference.
	 * 
	 * @param a - number 1.
	 * @param b - number 2.
	 * @return complex difference of a - b.
	 */
	
	public static CompNum sub(CompNum a, CompNum b) {
		a.r = (double)a.r - (double)b.r;
		a.i = (double)a.i - (double)b.i;
		
		return a;
	}
	
	/**
	 * Multiplies the 2 complex numbers and returns the product.
	 * 
	 * @param a - number 1.
	 * @param b - number 2.
	 * @return complex product of a × b.
	 */
	
	public static CompNum mult(CompNum a, CompNum b) {
		CompNum number = new CompNum();
		
		number.r = (double)a.r * (double)b.r - (double)a.i * (double)b.i;
		number.i = (double)a.r * (double)b.i + (double)a.i * (double)b.r;
		
		return number;
	}
	
	/**
	 * Divides a by b and returns the result.
	 * 
	 * @param a - number 1.
	 * @param b - number 2.
	 * @return complex result of a ÷ b.
	 */
	
	public static CompNum div(CompNum a, CompNum b) {
		CompNum number = new CompNum();

		number.r = ((((double)a.r * (double)b.r) + ((double)a.i * (double)b.i)) / (((double)b.r * (double)b.r) + (double)b.i * (double)b.i));
		number.i = ((((double)a.i * (double)b.r) - ((double)a.r * (double)b.i)) / (((double)b.r * (double)b.r) + (double)b.i * (double)b.i));
		
		return number;
	}
	
	/**
	 * Computes the complex exponent a<sup>b</sup> and returns the result.
	 * 
	 * @param a - number 1.
	 * @param b - number 2.
	 * @return complex result of exponent a<sup>b</sup>.
	 */
	
	public static CompNum pow(CompNum a, int b) {
		CompNum number = new CompNum(1., 0.);
		
		for(int i = 0; i < b; i++) {
			number = CompNum.mult(number, a);
		}
		
		return number;
	}
	
	/**
	 * Computes the complex sine of z and returns the result.
	 * 
	 * @return complex sine of z.
	 */
	
	public CompNum sin() {
		CompNum number = new CompNum(0., 0.);
		
		number.r = Math.sin((double)this.r) * Math.cosh((double)this.i);
		number.i = Math.cos((double)this.r) * Math.sinh((double)this.i);
		
		return number;
	}
	
	/**
	 * Computes the complex cosine of z and returns the result.
	 * 
	 * @return complex cosine of z.
	 */
	
	public CompNum cos() {
		CompNum number = new CompNum(0., 0.);
		
		number.r = Math.cos((double)this.r) * Math.cosh((double)this.i);
		number.i = 0 - Math.sin((double)this.r) * Math.sinh((double)this.i);
		
		return number;
	}
	
	/**
	 * Computes the complex tangent of z and returns the result.
	 * 
	 * @return complex tangent of z.
	 */
	
	public CompNum tan() {
		return CompNum.div(this.sin(), this.cos());
	}
	
	/**
	 * Computes the complex cotangent of z and returns the result.
	 * 
	 * @return complex cotangent of z.
	 */
	
	public CompNum cot() {
		return CompNum.div(this.cos(), this.sin());
	}
	
	/**
	 * Computes the complex secant of z and returns the result.
	 * 
	 * @return complex secant of z.
	 */
	
	public CompNum sec() {
		CompNum number = CompNum.div(new CompNum(1., 0.), this.cos());
		
		if((double)number.r < 0) number.r = 0 - (double)number.r;
		if((double)number.i < 0) number.i = 0 - (double)number.i;
		
		if((double)this.r < 0 ^ (double)this.i < 0) number.i = 0 - (double)number.i;
		
		return number;
	}
	
	/**
	 * Computes the complex cosecant of z and returns the result.
	 * 
	 * @return complex cosecant of z.
	 */
	
	public CompNum csc() {
		CompNum number = CompNum.div(new CompNum(1., 0.), this.sin());
		
		if((double)number.r < 0) number.r = 0 - (double)number.r;
		if((double)number.i < 0) number.i = 0 - (double)number.i;

		if((double)this.r < 0) number.r = 0 - (double)number.r;
		if((double)this.i > 0) number.i = 0 - (double)number.i;
		
		return number;
	}
	
	/**
	 * Computes the square root of z and returns the result.
	 * 
	 * @return complex square root of z.
	 */
	
	public CompNum sqrt() {
		CompNum number = new CompNum();
		
		number.r = Math.sqrt(((double)this.r + Math.sqrt((double)this.r * (double)this.r + (double)this.i * (double)this.i)) / 2);
		number.i = Math.signum((double)this.r) * Math.sqrt((-(double)this.r + Math.sqrt((double)this.r * (double)this.r + (double)this.i * (double)this.i)) / 2);
		
		if((double)this.r < 0 ^ (double)this.i < 0) number = number.conj();
		
		return number;
	}
	
	/**
	 * Computes the square of z and returns the result.
	 * 
	 * @return the result of complex exponent z<sup>2</sup>.
	 */
	
	public CompNum sq() {
		return(CompNum.mult(this, this));
	}
	
	/**
	 * Computes the complex conjugate of z and returns the result.
	 * 
	 * @return the complex conjugate of z.
	 */
	
	public CompNum conj() {
		CompNum number = this;
		number.i = -(double)number.i;
		return number;
	}
	
	/**
	 * Computes the complex reciprocal of z and returns the result.
	 * 
	 * @return the complex reciprocal of z or 1 ÷ z.
	 */
	
	public CompNum recip() {
		return CompNum.div(new CompNum(1., 0.), this);
	}
	
	/**
	 * Computes the complex exponent e<sup>z</sup> and returns the result.
	 * 
	 * @return the result of complex exponent e<sup>z</sup>.
	 */
	
	public CompNum exp() {
		return CompNum.mult(new CompNum(Math.pow(Math.E, (double)this.r), 0.), CompNum.add(new CompNum(Math.cos((double)this.i), 0.), CompNum.mult(new CompNum(0., 1.), new CompNum(Math.sin((double)this.i), 0.))));
	}
	
	/**
	 * Computes the complex natural logarithm of z and returns the result.
	 * 
	 * @return the complex natural logarithm of z.
	 */
	
	public CompNum ln() {
		CompNum out = new CompNum();
		
		if((double)this.r >= 0) out = new CompNum(Math.log(Math.pow((double)this.r, 2) + Math.pow((double)this.i, 2)) / 2, Math.atan((double)this.i / (double)this.r));
		else if((double)this.i >= 0) out = new CompNum(Math.log(Math.pow((double)this.r, 2) + Math.pow((double)this.i, 2)) / 2, Math.PI + Math.atan((double)this.i / (double)this.r));
		else out = new CompNum(Math.log(Math.pow((double)this.r, 2) + Math.pow((double)this.i, 2)) / 2, Math.atan((double)this.i / (double)this.r) - Math.PI);
		
		return out;
	}
	
	/**
	 * Computes the complex base 10 logarithm of z and returns the result.
	 * 
	 * @return the complex base 10 logarithm of z.
	 */
	
	public CompNum log() {
		return CompNum.div(this.ln(), new CompNum(2.302585092994046, 0.));
	}
	
	/**
	 * Computes the complex base b logarithm of z and returns the result.
	 * 
	 * @param b - base
	 * @return the complex base b logarithm of z.
	 */
	
	public CompNum logb(CompNum b) {
		return CompNum.div(this.ln(), b.ln());
	}
	
	/**
	 * Converts z to a java string.
	 * 
	 * @return z as a java string.
	 * @see String
	 */
	
	public String toString() {
		String out = new String();
		
		if((double)this.r != 0) out += this.r;
		
		if((double)this.r != 0 && (double)this.i > 0) out += " + ";
		if((double)this.r != 0 && (double)this.i < 0) out += " - ";
		
		if((double)this.i > 0 && (double)this.i != 1) out += i;
		
		if((double)this.i < 0 && (double)this.r == 0) out += "-";
		if((double)this.i < 0 && (double)this.i != -1) out += Math.abs((double)i);
		
		if((double)this.i != 0) out += "i";
		if((double)this.r == 0 && (double)this.i == -1) out = "-i";
		
		if((double)this.r == 0 && (double)this.i == 0) out = "0";
		
		return out;
	}
	
	/**
	 * Converts z to a vec2 coordinate.
	 * 
	 * @return z as a vec2 coordinate.
	 * @see String
	 */
	
	public Vec2 toVec2() {
		Vec2 number = new Vec2();
		number.x = this.r;
		number.y = this.i;
		return number;
	}
	
	/**
	 * Converts z to a polar coordinate.
	 * 
	 * @return z as a polar coordinate.
	 * @see String
	 */
	
	public Polar toPolar() {
		Polar number = new Polar();
		number.r = Math.sqrt(Math.pow((double)this.r, 2) + Math.pow((double)this.i, 2));
		number.t = Math.atan2((double)this.i, (double)this.r);
		return number;
	}
}
