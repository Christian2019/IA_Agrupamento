package main;

import java.util.ArrayList;

public class Geracao {
	public ArrayList<Petala> centroids;
	public ArrayList<ArrayList<Petala>> pontos_de_cada_centroid;
	public Geracao(ArrayList<Petala> centroids, ArrayList<ArrayList<Petala>> pontos_de_cada_centroid) {
		super();
		this.centroids = centroids;
		this.pontos_de_cada_centroid = pontos_de_cada_centroid;
	}
}
