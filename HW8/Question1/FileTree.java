import java.io.*;

public class FileTree{
	
	public static void printFileTree(File folder, int level){
		for(int i = 0; i < level - 1; i++){
			System.out.printf("   |");
		}
		
		if(level != 0){
			System.out.print("---");
		}
		System.out.println(folder.getName());
		
		File[] fileArray = folder.listFiles();
		if(!folder.isDirectory() || fileArray.length == 0){
			return;
		}

		for(int i = 0; i < fileArray.length; i++){
			System.out.printf("|");
			printFileTree(fileArray[i], level+1);
		}
	}
	
	public static void main(String[] args){
		File parentFolder = new File("E:\\java_project");
		printFileTree(parentFolder, 0);
	}
}