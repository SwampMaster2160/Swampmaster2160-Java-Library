package swampMaster2160.lib.number;

public class Quarter {
	public static final Quarter POSITIVE_INFINITY = new Quarter((byte)0x78);
	public static final Quarter NEGATIVE_INFINITY = new Quarter((byte)0xF8);
	public static final Quarter NaN = new Quarter((byte)0x7F);
	
	public static final Quarter MAX_VALUE = new Quarter((byte)0x77);
	public static final Quarter MIN_VALUE = new Quarter((byte)0x01);
	public static final Quarter MIN_NEGATIVE = new Quarter((byte)0xF7);
	public static final Quarter MAX_NEGATIVE = new Quarter((byte)0x81);
	
	public static final int MIN_EXPONENT = -7;
	public static final int MAX_EXPONENT = 7;
	
	public static final int SIZE = 8;
	
	public byte raw;
	
	public Quarter(){
		this.raw = 0x00;
	}
	
	public Quarter(byte raw){
		this.raw = raw;
	}
	
	public Quarter(double num){
		if(num > MAX_VALUE.toDouble()) {
			this.raw = POSITIVE_INFINITY.raw;
			return;
		}
		
		if(num < MIN_NEGATIVE.toDouble()) {
			this.raw = NEGATIVE_INFINITY.raw;
			return;
		}
		
		if(num == Double.POSITIVE_INFINITY) {
			this.raw = POSITIVE_INFINITY.raw;
			return;
		}
		if(num == Double.NEGATIVE_INFINITY) {
			this.raw = NEGATIVE_INFINITY.raw;
			return;
		}
		
		if(num == 0) {
			this.raw = 0x00;
			return;
		}
		
		if(num < 0) {
			this.raw = (byte)0x80;
			this.raw += (int)Math.floor(SMNum.log2(0 - num) + 1) << 3;
			if(num > -1) {
				this.raw = (byte)0x80;
				this.raw += (byte)((0 - num) * 8.);
			}
			else {
				this.raw += Math.floor(((0 - num - Math.pow(2, (byte)((int)Math.floor(SMNum.log2(0 - num) + 1) - 1))) / Math.pow(2, (byte)((int)Math.floor(SMNum.log2(0 - num) + 1)))) * 16.);
			}
		}
		else {
			this.raw = 0x00;
			this.raw += calcExp(num);//(int)Math.floor(Num.log2(num) + 1) << 3;
			if(num < 1) {
				this.raw = 0x00;
				this.raw += (byte)(num * 8.);
			}
			else {
				this.raw += Math.floor(((num - Math.pow(2, (byte)((int)Math.floor(SMNum.log2(num) + 1) - 1))) / Math.pow(2, (byte)((int)Math.floor(SMNum.log2(num) + 1)))) * 16.);
			}
		}
	}
	
	public static byte calcExp(double num) {
		return (byte)((int)Math.floor(SMNum.log2(num) + 1) << 3);
	}
	
	public boolean sign() {
		return (this.raw & 0x80) == 0x80;
	}
	
	public byte exp() {
		return (byte)(((this.raw & 0xFF) & 0x7F) >> 3);
	}
	
	public byte mant() {
		return (byte)(this.raw & 0x07);
	}
	
	public double toDouble() {
		if(this.raw == POSITIVE_INFINITY.raw) return Double.POSITIVE_INFINITY;
		if(this.raw == NEGATIVE_INFINITY.raw) return Double.NEGATIVE_INFINITY;
		if(this.exp() == 0x0F) return Double.NaN;
		if((this.raw & 0xFF) == 0x80) return -0.;
		
		double num = 0.;
		
		if(this.exp() == 0) num = this.mant() / 8.;
		else num = ((this.mant() / 8.) * Math.pow(2, this.exp() - 1.)) + Math.pow(2., this.exp() - 1.);
		
		if(this.sign()) num = 0 - num;
		
		return num;
	}
}
/*
if(q.exp() == 0) a = q.mant() / 8.;
else a = ((q.mant() / 8.) * Math.pow(2, q.exp() - 1.)) + Math.pow(2., q.exp() - 1.);
*/