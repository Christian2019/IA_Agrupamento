package main;

public class Proporcoes {
public static int X_Total= Game.WIDTH*Game.SCALE;
public static int Y_Total= Game.HEIGHT*Game.SCALE;

public static int porcentagem(int val, double porc) {
	
	
	
	double d = porc/100;

	double d2 = d*val;

	int magic =(int)d2;

	return magic;
}
}
