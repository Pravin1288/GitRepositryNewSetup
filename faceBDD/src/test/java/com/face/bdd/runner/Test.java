package com.face.bdd.runner;

import java.io.File;

public class Test {

	public static void main(String [] args) {
		File file = new File("");
		System.err.println(file.getAbsolutePath().toString());
	}
}
