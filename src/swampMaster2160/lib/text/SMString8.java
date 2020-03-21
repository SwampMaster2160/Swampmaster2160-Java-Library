package swampMaster2160.lib.text;

public class SMString8 {
	public SMChar8[] chars;
	
	public SMString8() {
		chars = new SMChar8[0];
	}
	
	public SMString8(byte[] in) {
		chars = new SMChar8[in.length];
		
		for(int i = 0; i < in.length; i++) {
			chars[i] = new SMChar8(in[i]);
		}
	}
	
	public SMString8(SMChar8 in) {
		chars = new SMChar8[1];
		chars[0] = in;
	}
	
	public SMString8(String in) {
		chars = new SMChar8[in.length()];
		for(int i = 0; i < in.length(); i++) {
			chars[i] = new SMChar8(in.charAt(i));
		}
	}
	
	public static SMString8 join(SMString8 a, SMString8 b) {
		SMString8 out = new SMString8();
		out.chars = new SMChar8[a.length() + b.length()];
		
		for(int i = 0; i < a.length(); i++) {
			out.chars[i] = a.chars[i];
		}
		
		for(int i = 0; i < b.length(); i++) {
			out.chars[i + a.length()] = b.chars[i];
		}
		
		return out;
	}
	
	public static SMString8 join(SMString8 a, SMChar8 b) {
		SMString8 out = new SMString8();
		out.chars = new SMChar8[a.length() + 1];
		
		for(int i = 0; i < a.length(); i++) {
			out.chars[i] = a.chars[i];
		}
		
		out.chars[a.length()] = b;
		
		return out;
	}
	
	public static SMString8 join(SMChar8 a, SMString8 b) {
		SMString8 out = new SMString8();
		out.chars = new SMChar8[b.length() + 1];
		
		out.chars[0] = a;
		
		for(int i = 0; i < b.length(); i++) {
			out.chars[i + 1] = b.chars[i];
		}
		
		return out;
	}
	
	public static SMString8 join(SMChar8 a, SMChar8 b) {
		SMString8 out = new SMString8();
		out.chars = new SMChar8[2];
		
		out.chars[0] = a;
		out.chars[1] = b;
		
		return out;
	}
	
	public int length() {
		return chars.length;
	}
	
	public boolean isEqual(SMString8 in) {
		if(this.length() != in.length()) return false;
		
		for(int i = 0; i < this.length(); i++) {
			if(this.chars[i].raw != in.chars[i].raw) return false;
		}
		return true;
	}
	
	public SMChar8 charAt(int index) {
		return chars[index];
	}
	
	public String toString() {
		String out = "";
		
		for(int i = 0; i < this.length(); i++) {
			out += this.chars[i].toChar();
		}
		
		return out;
	}
}
