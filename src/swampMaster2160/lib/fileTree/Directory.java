package swampMaster2160.lib.fileTree;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	public String name;
	//public Directory[] subDirectories;
	public List<Directory> subDirs = new ArrayList<Directory>();
	//public File[] files;
	public List<File> files = new ArrayList<File>();
	
	public Directory(String name) {
		this.name = name;
	}
	
	public void createDir(String path) {
		/*String thisName;
		String subPath;
		boolean end = false;
		
		if(path.indexOf('/') != -1) {
			thisName = path.substring(0, path.indexOf('/'));
			subPath = path.substring(path.indexOf('/') + 1);
		}
		else {
			thisName = path;
			subPath = "";
			end = true;
		}
		//this.subDirs.add(new Directory(path));
		//System.out.println(this.subDirs.get(0));
		//for(Directory dir :this.subDirs) {
		//	System.out.println(dir.name);
		//}
		boolean exists = false;
		for(Directory dir:this.subDirs) {
			//System.out.println(dir.name);
			if(dir.name == thisName) {
				exists = true;
				break;
			}
		}
		if(!exists) {
			this.subDirs.add(new Directory(thisName));
		}
		if(!end) {
			//for(Directory dir:this.subDirs) {
			for(int i = 0; i < this.subDirs.size(); i++) {
				//System.out.println(dir.name);
				if(this.subDirs.get(i).name == thisName) {
					this.subDirs.get(i).createDir(subPath);
					//new Directory(thisName);
					//exists = true;
					//break;
				}
			}
		}
		for(Directory dir:this.subDirs) {
			System.out.println(dir.name);
		}
		System.out.println();*/
	}
}
