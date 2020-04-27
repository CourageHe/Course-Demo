package com.couragehe;

public class Main {

	public static void main(String[] args) {
		Directory rootDir = new Directory("root");
		Directory tmpDir = new Directory("tmp");
		Directory binDir = new Directory("bin");
		Directory usrDir = new Directory("usr");
		rootDir.add(tmpDir);
		rootDir.add(binDir);
		rootDir.add(usrDir);
		
		binDir.add(new File("vi", 1000));
		binDir.add(new File("latex.md", 2000));
		
		rootDir.printList();
		
//		Directory
	}

}
