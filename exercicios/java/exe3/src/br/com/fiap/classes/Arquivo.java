package br.com.fiap.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo {
	public static void salvar(String texto, String filename) {
		try {
			Path path = Paths.get(System.getProperty("java.io.tmpdir") + filename);
			Files.write(path, texto.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String ler(String filename) {
		byte[] b = null;
		Path p = Paths.get(System.getProperty("java.io.tmpdir") + filename);
		try {
			b = Files.readAllBytes(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(b);
	}
}
