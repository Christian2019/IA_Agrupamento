package main;

import java.util.ArrayList;

public class Agrupamento {
	public static String path = "iris.txt";
	public static ArrayList<Petala> petalas;
	static int k = 3;
	static ArrayList<Petala> centroids;

	public static void Agrupar() {
		petalas = new ArrayList<Petala>();
		centroids= new ArrayList<Petala>();
		Save_Game.load(path);
		// System.out.println(petalas);
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
		System.out.println(centroids);
	}
}
