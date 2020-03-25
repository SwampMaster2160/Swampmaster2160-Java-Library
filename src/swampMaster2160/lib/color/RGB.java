package swampMaster2160.lib.color;

import java.awt.Color;

public class RGB {
	public byte r, g, b, a;
	
	public RGB() {}
	
	public RGB(byte r, byte g, byte b, byte a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public RGB(byte r, byte g, byte b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 0;
	}
	
	public RGB(Color color) {
		this.r = (byte)color.getRed();
		this.g = (byte)color.getGreen();
		this.b = (byte)color.getBlue();
		this.a = (byte)color.getAlpha();
	}
	
	public Color toColor() {
		return new Color(r & 0xFF, g & 0xFF, b & 0xFF, a & 0xFF);
	}
	
	public BW toBW() {
		return new BW((byte)((r & 0xFF + g & 0xFF + b & 0xFF) / 3), a);
	}
	
	public HSV toHSV() {
		HSV out = new HSV();
		byte min = 0, max = 0;
		
		out.a = this.a;
		
		if((r & 0xFF) <= (g & 0xFF) && (r & 0xFF) <= (b & 0xFF)) min = r;
		if((g & 0xFF) <= (r & 0xFF) && (g & 0xFF) <= (b & 0xFF)) min = g;
		if((b & 0xFF) <= (r & 0xFF) && (b & 0xFF) <= (g & 0xFF)) min = b;
		
		if((r & 0xFF) >= (g & 0xFF) && (r & 0xFF) >= (b & 0xFF)) max = r;
		if((g & 0xFF) >= (r & 0xFF) && (g & 0xFF) >= (b & 0xFF)) max = g;
		if((b & 0xFF) >= (r & 0xFF) && (b & 0xFF) >= (g & 0xFF)) max = b;
		
		out.v = (short)(max * 255.);
		
		byte c = (byte)((max & 0xFF) - (min & 0xFF));
		
		out.s = (short)((((double)(c & 0xFF) / 256.) / ((double)(out.v & 0xFFFF) / 65535.)) * 0xFFFF);
		
		if(max == r) out.h = (short)((((double)((g & 0xFF) - (b & 0xFF)) / 255.) / ((double)(c & 0xFF) / 255.)) * 10922.5);
		if(max == g) out.h = (short)((((double)((b & 0xFF) - (r & 0xFF)) / 255.) / ((double)(c & 0xFF) / 255.)) * 10922.5 + 21845.);
		if(max == b) out.h = (short)((((double)((r & 0xFF) - (g & 0xFF)) / 255.) / ((double)(c & 0xFF) / 255.)) * 10922.5 + 43690.);
		
		return out;
	}
}
