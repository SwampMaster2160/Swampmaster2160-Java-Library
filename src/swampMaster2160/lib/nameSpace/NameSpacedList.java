package swampMaster2160.lib.nameSpace;

import swampMaster2160.lib.text.SMString8;

public class NameSpacedList {
	public SMString8 name[];
	public Object data[];
	
	public NameSpacedList() {
		
		name = new SMString8[0];
		data = new Object[0];
	}
	
	public void append(SMString8 name, Object data) {
		
		SMString8[] nameOut = new SMString8[this.name.length + 1];
		Object[] dataOut = new Object[this.name.length + 1];
		
		for(int i = 0; i < this.name.length; i++) {
			nameOut[i] = this.name[i];
			dataOut[i] = this.data[i];
		}
		
		nameOut[this.name.length] = name;
		dataOut[this.data.length] = data;
		
		this.name = nameOut;
		this.data = dataOut;
	}
	
	public int length() {
		return this.name.length;
	}
	
	public int idFromName(SMString8 name) {
		for(int i = 0; i < this.length(); i++) {
			if(this.name[i].isEqual(name)) {
				return i;
			}
		}
		return -1;
	}
}
