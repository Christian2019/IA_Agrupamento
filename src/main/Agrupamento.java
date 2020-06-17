package main;

import java.util.ArrayList;

public class Agrupamento {
	public static String path="iris.txt";
	public static ArrayList<Petala> petalas;
	public static void Agrupar() {
		petalas = new ArrayList<Petala>();
		Save_Game.load(path);
		System.out.println(petalas);
	}
}
