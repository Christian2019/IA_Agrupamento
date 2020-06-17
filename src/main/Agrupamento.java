package main;

import java.util.ArrayList;

public class Agrupamento {
	public static String path = "iris.txt";
	static int k = 3;
	public static ArrayList<Petala> petalas;
	static ArrayList<Petala> centroids;
	static int geracao_atual; 
	public static ArrayList<Geracao> geracoes;

	public static void Agrupar() {
		/*
		System.out.println("Geracao: "+geracao_atual);
		System.out.println("Centroids: ");
		System.out.println(centroids);
		*/
		ArrayList<ArrayList<Double>> distancias_centroids = new ArrayList<ArrayList<Double>>();
		for (int i=0;i<centroids.size();i++) {
			ArrayList<Double> distancias= new ArrayList<Double>();
			for (int j=0;j<petalas.size();j++) {
				double x1= centroids.get(i).petal_length;
				double x2= petalas.get(j).petal_length;
				double y1= centroids.get(i).petal_width;
				double y2= petalas.get(j).petal_width;
				double cateto1= x1-x2;
				double cateto2= y1-y2;
				double hipotenusa = Math.sqrt(cateto1*cateto1+cateto2*cateto2);
				distancias.add(hipotenusa);
				/*
				System.out.println("cateto1: "+cateto1);
				System.out.println("cateto2: "+cateto2);
				System.out.println("hipotenusa: "+hipotenusa);
				*/
							}
			
			distancias_centroids.add(distancias);			
		}
		/*
		System.out.println("Distancias Centroids:");
		for (int i=0;i<distancias_centroids.size();i++) {
			System.out.println("Centroid "+i);
			for (int j=0;j<distancias_centroids.get(i).size();j++) {
				System.out.println(distancias_centroids.get(i).get(j));
			}
		}
		*/
		//Para qual centroid pertece cada ponto
		ArrayList<ArrayList<Petala>> pontos_de_cada_centroid = new ArrayList<ArrayList<Petala>>();
		for (int i=0;i<centroids.size();i++) {
			ArrayList<Petala> p = new ArrayList<Petala>();
			pontos_de_cada_centroid.add(p); 
		}
		for (int i=0;i<petalas.size();i++) {
			double menor =100;
			int centroid_menor=0;
			for (int j=0;j<centroids.size();j++) {
				if (distancias_centroids.get(j).get(i)<menor) {
					menor = distancias_centroids.get(j).get(i);
					centroid_menor=j;
				}
			}
			pontos_de_cada_centroid.get(centroid_menor).add(petalas.get(i));
		}
		/*
		for (int i=0;i<pontos_de_cada_centroid.size();i++) {
			System.out.println("Centroid "+i);
			System.out.println("Petalas: ");
			System.out.println(pontos_de_cada_centroid.get(i));
		}
		*/
		//Novos centroids
		ArrayList<Petala> novos_centroids = new ArrayList<Petala>();
		for (int i=0;i<pontos_de_cada_centroid.size();i++) {
			double soma_x=0;
			double soma_y=0;
			for (int j=0;j<pontos_de_cada_centroid.get(i).size();j++) {
				soma_x+=pontos_de_cada_centroid.get(i).get(j).petal_length;
				soma_y+=pontos_de_cada_centroid.get(i).get(j).petal_width;
			}
			double novo_x=soma_x/pontos_de_cada_centroid.get(i).size();
			double novo_y=soma_y/pontos_de_cada_centroid.get(i).size();
			Petala novo_centroid = new Petala(novo_x,novo_y);
			novos_centroids.add(novo_centroid);
 		}
		
		//Gravar Geracao
		ArrayList<Petala> gc= new ArrayList<Petala>();
		for (int i=0;i<centroids.size();i++) {
			gc.add(centroids.get(i));
		}
		Geracao geracao = new Geracao(gc,pontos_de_cada_centroid);
		geracoes.add(geracao);
		//Condicao de Parada
		boolean terminou = true;
		for (int i=0; i<centroids.size();i++) {
			if (centroids.get(i).petal_length!=novos_centroids.get(i).petal_length) {
				terminou = false;
				break;
			}
			if (centroids.get(i).petal_width!=novos_centroids.get(i).petal_width) {
				terminou = false;
				break;
			}
		}
		
		if (terminou) {
			
			System.out.println("Novos centroids:");
			System.out.println(novos_centroids);
			
			System.out.println("FIM!");
		}else {
			centroids.clear();
			for (int i=0;i<novos_centroids.size();i++) {
				centroids.add(novos_centroids.get(i));
			}
		geracao_atual++;
			Agrupar();
		}
	}
	public static void leitura() {
		geracao_atual=0; 
		geracoes = new ArrayList<Geracao>();
		petalas = new ArrayList<Petala>();
		centroids= new ArrayList<Petala>();
		Save_Game.load(path);
		
		for (int i = 0; i < k; i++) {

			boolean repetido = true;
			Petala centroid = null;
			while (repetido) {
				repetido = false;
				int random = Game.rand.nextInt(petalas.size());
				centroid = petalas.get(random);

				for (int j = 0; j < centroids.size(); j++) {
					if ((centroid.petal_length == centroids.get(j).petal_length)
							&& (centroid.petal_width == centroids.get(j).petal_width)) {
						repetido = true;
						break;
					}
				}
			
			}
			centroids.add(centroid);
			
		}
		Agrupar();
	} 
}
