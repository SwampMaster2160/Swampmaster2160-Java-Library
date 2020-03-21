package swampMaster2160.lib.text;

public class SMChar8 {
	public byte raw;
	
	public static final SMChar8 NULL = new SMChar8((byte)0x00);
	public static final SMChar8 TAB = new SMChar8((byte)0x09);
	public static final SMChar8 NEW_LINE = new SMChar8((byte)0x0A);
	public static final SMChar8 CAR_RET = new SMChar8((byte)0x0D);
	
	public static final SMChar8 NOT_A_CHAR = new SMChar8((byte)0x01);
	public static final SMChar8 UNICODE16 = new SMChar8((byte)0x02);
	public static final SMChar8 UNICODE24 = new SMChar8((byte)0x03);
	public static final SMChar8 UNICODE32 = new SMChar8((byte)0x04);
	public static final SMChar8 RESET_FORMAT = new SMChar8((byte)0x05);
	public static final SMChar8 RESET_COLOR = new SMChar8((byte)0x06);
	public static final SMChar8 GRAY_COLOR8 = new SMChar8((byte)0x07);
	public static final SMChar8 COLOR8 = new SMChar8((byte)0x08);
	public static final SMChar8 COLOR16 = new SMChar8((byte)0x0B);
	public static final SMChar8 COLOR24 = new SMChar8((byte)0x0D);
	public static final SMChar8 COLOR32 = new SMChar8((byte)0x0E);
	public static final SMChar8 ALPHA8 = new SMChar8((byte)0x0F);
	
	public static final SMChar8 BOLD_ON = new SMChar8((byte)0x10);
	public static final SMChar8 BOLD_OFF = new SMChar8((byte)0x11);
	public static final SMChar8 ITALIC_ON = new SMChar8((byte)0x12);
	public static final SMChar8 ITALIC_OFF = new SMChar8((byte)0x13);
	public static final SMChar8 STRIKETHRUGH_ON = new SMChar8((byte)0x14);
	public static final SMChar8 STRIKETHRUGH_OFF = new SMChar8((byte)0x15);
	public static final SMChar8 RESET_FONT_SIZE = new SMChar8((byte)0x16);
	public static final SMChar8 FONT_SIZE8 = new SMChar8((byte)0x17);
	public static final SMChar8 FONT_SIZE16 = new SMChar8((byte)0x18);
	public static final SMChar8 RESET_FONT = new SMChar8((byte)0x19);
	public static final SMChar8 FONT8 = new SMChar8((byte)0x1A);
	public static final SMChar8 FONT16 = new SMChar8((byte)0x1B);
	public static final SMChar8 INSERT_DATA8 = new SMChar8((byte)0x1C);
	public static final SMChar8 INSERT_DATA16 = new SMChar8((byte)0x1D);
	public static final SMChar8 ACTION8 = new SMChar8((byte)0x1E);
	public static final SMChar8 ACTION16 = new SMChar8((byte)0x1F);
	
	public static final SMChar8 RESET_SPACING = new SMChar8((byte)0x80);
	public static final SMChar8 MONOSPACING_ON = new SMChar8((byte)0x81);
	public static final SMChar8 MONOSPACING_OFF = new SMChar8((byte)0x82);
	
	public SMChar8() {
		
	}
	
	public SMChar8(byte raw) {
		this.raw = raw;
	}
	
	public SMChar8(char in) {
		if(in < 0x100) {
			this.raw = (byte)in;
		}
	}
	
	public String toString() {
		return new SMString8(this).toString();
	}
	
	public char toChar() {
		if(this.raw > 0x1F & this.raw < 0x7F) {
			return (char)(this.raw & 0xFF);
		}
		if((this.raw & 0xFF) > 0xA0) {
			return (char)(this.raw & 0xFF);
		}
		if((this.raw & 0xFF) == TAB.raw) return 0x09;
		if((this.raw & 0xFF) == NEW_LINE.raw) return 0x0A;
		if((this.raw & 0xFF) == CAR_RET.raw) return 0x1F;
		
		return 0x1F;
	}
	public char toCharAll() {
		if(this.raw > 0x1F & this.raw < 0x7F) {
			return (char)(this.raw & 0xFF);
		}
		if((this.raw & 0xFF) > 0xA0) {
			return (char)(this.raw & 0xFF);
		}
		if((this.raw & 0xFF) == TAB.raw) return 0x09;
		if((this.raw & 0xFF) == NEW_LINE.raw) return 0x0A;
		if((this.raw & 0xFF) == CAR_RET.raw) return 0x1F;
		
		return '?';
	}
}
