package swampMaster2160.lib.color;

import swampMaster2160.lib.number.SMNum;

public class HSV {
	public short h, s, v;
	public byte a;
	
	public HSV() {}
	
	public HSV(short h, short s, short v, byte a) {
		this.h = h;
		this.s = s;
		this.v = v;
		this.a = a;
	}
	
	public HSV(short h, short s, short v) {
		this.h = h;
		this.s = s;
		this.v = v;
		this.a = 0;
	}
	
	public RGB toRGB() {
		RGB out = new RGB();
		out.a = a;
		
		byte h1 = (byte)Math.floor((h & 0xFFFF) / 10922.5);
		byte l = (byte)((((v & 0xFFFF) / 65535.) * (1. - ((s & 0xFFFF) / 65535.))) * 0xFF);
		byte h2 = (byte)SMNum.reMap(((short)((h & 0xFFFF) * 6.) & 0xFFFF), 0, 0xFFFF, l & 0xFF, (v & 0xFFFF) / 255.);
		byte h3 = (byte)SMNum.reMap(((short)(0. - (short)((h & 0xFFFF) * 6.)) & 0xFFFF), 0, 0xFFFF, l & 0xFF, (v & 0xFFFF) / 255.);
		
		System.out.println(h1);
		
		switch(h1) {
			case 0:
				out.r = (byte)(v / 255);
				out.g = h2;
				out.b = l;
				break;
			case 1:
				out.g = (byte)(v / 255);
				out.r = h3;
				out.b = l;
				break;
			case 2:
				out.g = (byte)(v / 255);
				out.b = h2;
				out.r = l;
				break;
			case 3:
				out.b = (byte)(v / 255);
				out.g = h3;
				out.r = l;
				break;
			case 4:
				out.b = (byte)(v / 255);
				out.r = h2;
				out.g = l;
				break;
			case 5:
				out.r = (byte)(v / 255);
				out.b = h3;
				out.g = l;
				break;
		}
		
		return out;
	}
}
