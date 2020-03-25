package swampMaster2160.lib.color;

public class BW {
	public byte v, a;
	
	public BW() {}
	
	public BW(byte v, byte a) {
		this.v = v;
		this.a = a;
	}
	
	public BW(byte v) {
		this.v = v;
		this.a = 0;
	}
	
	public RGB toRGB() {
		return new RGB(v, v, v, a);
	}
}
