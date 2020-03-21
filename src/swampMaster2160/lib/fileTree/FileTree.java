package swampMaster2160.lib.fileTree;

public class FileTree {
	public Directory directory;
	
	public FileTree() {
		this.directory = new Directory("root");
	}
	
	public void createDir(String path) {
		this.directory.createDir(path);
	}
}
