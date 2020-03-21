package swampMaster2160.lib.number;

public class SMNum {
	public static double reMap(double value, double min1, double max1, double min2, double max2) {
		return min2 + (max2 - min2) * ((value - min1) / (max1 - min1));
	}
	
	public static double log2(double value) {
		return Math.log(value) / Math.log(2);
	}
	
	public static double logBase(double value, double base) {
		return Math.log(value) / Math.log(base);
	}
	
	public static String hexPhrase(byte in) {
		String out = "0x";
		
		if(((in & 0xF0) >> 4) < 10) {
			out = out + ((in & 0xF0) >> 4);
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF0) >> 4) - 10));
		}
		
		if(((in & 0x0F)) < 10) {
			out = out + ((in & 0x0F));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F)) - 10));
		}
		
		return out;
	}
	
	public static String hexPhrase(short in) {
		String out = "0x";
		
		if(((in & 0xF000) >> 12) < 10) {
			out = out + ((in & 0xF000) >> 12);
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF000) >> 12) - 10));
		}
		
		if(((in & 0x0F00) >> 8) < 10) {
			out = out + ((in & 0x0F00) >> 8);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F00) >> 8) - 10));
		}
		
		if(((in & 0xF0) >> 4) < 10) {
			out = out + ((in & 0xF0) >> 4);
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF0) >> 4) - 10));
		}
		
		if(((in & 0x0F)) < 10) {
			out = out + ((in & 0x0F));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F)) - 10));
		}
		
		return out;
	}
	
	public static String hexPhrase(int in) {
		String out = "0x";
		
		if(((in & 0xF0000000L) >> 28) < 10) {
			out = out + (((in & 0xF0000000L) >> 28));
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF0000000L) >> 28) - 10));
		}
		
		if(((in & 0x0F000000) >> 24) < 10) {
			out = out + ((in & 0x0F000000) >> 24);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F000000) >> 24) - 10));
		}
		
		if(((in & 0x00F00000) >> 20) < 10) {
			out = out + ((in & 0x00F00000) >> 20);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x00F00000) >> 20) - 10));
		}
		
		if(((in & 0x000F0000) >> 16) < 10) {
			out = out + ((in & 0x000F0000) >> 16);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x000F0000) >> 16) - 10));
		}
		
		//
		
		if(((in & 0xF000) >> 12) < 10) {
			out = out + ((in & 0xF000) >> 12);
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF000) >> 12) - 10));
		}
		
		if(((in & 0x0F00) >> 8) < 10) {
			out = out + ((in & 0x0F00) >> 8);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F00) >> 8) - 10));
		}
		
		if(((in & 0xF0) >> 4) < 10) {
			out = out + ((in & 0xF0) >> 4);
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF0) >> 4) - 10));
		}
		
		if(((in & 0x0F)) < 10) {
			out = out + ((in & 0x0F));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F)) - 10));
		}
		
		return out;
	}
	
	public static String hexPhrase(long in) {
		String out = "0x";
		
		if(in > -1) {
			if(((in & 0xF000000000000000L) >> 60) < 10) {
				out = out + (((in & 0xF000000000000000L) >> 60));
			}
			else {
				out = out + (char)(0x41 + (((in & 0xF000000000000000L) >> 60) - 10));
			}
		}
		else {
			if((8 - (0 - ((in & 0xF000000000000000L) >> 60)) + 8) < 10) {
				out = out + (8 - (0 - ((in & 0xF000000000000000L) >> 60)) + 8);
			}
			else {
				out = out + (char)(0x41 + (8 - (0 - ((in & 0xF000000000000000L) >> 60)) - 2));
			}
		}
		
		if(((in & 0x0F00000000000000L) >> 56) < 10) {
			out = out + (((in & 0x0F00000000000000L) >> 56));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F00000000000000L) >> 56) - 10));
		}
		
		if(((in & 0x00F0000000000000L) >> 52) < 10) {
			out = out + (((in & 0x00F0000000000000L) >> 52));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x00F0000000000000L) >> 52) - 10));
		}
		
		if(((in & 0x000F000000000000L) >> 48) < 10) {
			out = out + (((in & 0x000F000000000000L) >> 48));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x000F000000000000L) >> 48) - 10));
		}
		
		//
		
		if(((in & 0x0000F00000000000L) >> 44) < 10) {
			out = out + (((in & 0x0000F00000000000L) >> 44));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0000F00000000000L) >> 44) - 10));
		}
		
		if(((in & 0x00000F0000000000L) >> 40) < 10) {
			out = out + (((in & 0x00000F0000000000L) >> 40));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x00000F0000000000L) >> 40) - 10));
		}
		
		if(((in & 0x000000F000000000L) >> 36) < 10) {
			out = out + (((in & 0x000000F000000000L) >> 36));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x000000F000000000L) >> 36) - 10));
		}
		
		if(((in & 0x0000000F00000000L) >> 32) < 10) {
			out = out + (((in & 0x0000000F00000000L) >> 32));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0000000F00000000L) >> 32) - 10));
		}
		
		//--------
		
		if(((in & 0xF0000000L) >> 28) < 10) {
			out = out + (((in & 0xF0000000L) >> 28));
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF0000000L) >> 28) - 10));
		}
		
		if(((in & 0x0F000000) >> 24) < 10) {
			out = out + ((in & 0x0F000000) >> 24);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F000000) >> 24) - 10));
		}
		
		if(((in & 0x00F00000) >> 20) < 10) {
			out = out + ((in & 0x00F00000) >> 20);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x00F00000) >> 20) - 10));
		}
		
		if(((in & 0x000F0000) >> 16) < 10) {
			out = out + ((in & 0x000F0000) >> 16);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x000F0000) >> 16) - 10));
		}
		
		//
		
		if(((in & 0xF000) >> 12) < 10) {
			out = out + ((in & 0xF000) >> 12);
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF000) >> 12) - 10));
		}
		
		if(((in & 0x0F00) >> 8) < 10) {
			out = out + ((in & 0x0F00) >> 8);
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F00) >> 8) - 10));
		}
		
		if(((in & 0xF0) >> 4) < 10) {
			out = out + ((in & 0xF0) >> 4);
		}
		else {
			out = out + (char)(0x41 + (((in & 0xF0) >> 4) - 10));
		}
		
		if(((in & 0x0F)) < 10) {
			out = out + ((in & 0x0F));
		}
		else {
			out = out + (char)(0x41 + (((in & 0x0F)) - 10));
		}
		
		return out;
	}
}
