package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UI {
	public Font font1 = new Font("Arial", Font.BOLD, Proporcoes.porcentagem(Proporcoes.X_Total, 3));
	public int geracao = 0;
	// String Geracoes:
	int x_geracoes = Proporcoes.porcentagem(40, Proporcoes.X_Total);
	int y_geracoes = Proporcoes.porcentagem(10, Proporcoes.Y_Total);
	// Eixo y
	int x_eixo_y = Proporcoes.porcentagem(10, Proporcoes.X_Total);
	int y_eixo_y = Proporcoes.porcentagem(20, Proporcoes.Y_Total);
	int width_eixo_y = Proporcoes.porcentagem(1, Proporcoes.X_Total);
	int height_eixo_y = Proporcoes.porcentagem(70, Proporcoes.Y_Total);
	// Eixo x
	int x_eixo_x = Proporcoes.porcentagem(10, Proporcoes.X_Total);
	int y_eixo_x = Proporcoes.porcentagem(90, Proporcoes.Y_Total);
	int width_eixo_x = Proporcoes.porcentagem(70, Proporcoes.X_Total);
	int height_eixo_x = Proporcoes.porcentagem(1, Proporcoes.X_Total);
	// String 8:
	String str_8 = "8";
	int x_8 = Proporcoes.porcentagem(80, Proporcoes.X_Total);
	int y_8 = Proporcoes.porcentagem(97, Proporcoes.Y_Total);
	// String 4:
	String str_4 = "4";
	int x_4 = Proporcoes.porcentagem(45, Proporcoes.X_Total);
	int y_4 = Proporcoes.porcentagem(97, Proporcoes.Y_Total);
	// String 3:
	String str_3 = "3";
	int x_3 = Proporcoes.porcentagem(7, Proporcoes.X_Total);
	int y_3 = Proporcoes.porcentagem(24, Proporcoes.Y_Total);
	// String 1.5:
	String str_1_5 = "1.5";
	int x_1_5 = Proporcoes.porcentagem(5, Proporcoes.X_Total);
	int y_1_5 = Proporcoes.porcentagem(55, Proporcoes.Y_Total);
	// String 0:
	String str_0 = "0";
	int x_0 = Proporcoes.porcentagem(7, Proporcoes.X_Total);
	int y_0 = Proporcoes.porcentagem(97, Proporcoes.Y_Total);
	// String Width:
	String str_Width = "Width";
	int x_Width = Proporcoes.porcentagem(6, Proporcoes.X_Total);
	int y_Width = Proporcoes.porcentagem(17, Proporcoes.Y_Total);
	// String Length:
	String str_Length = "Length";
	int x_Length = Proporcoes.porcentagem(83, Proporcoes.X_Total);
	int y_Length = Proporcoes.porcentagem(97, Proporcoes.Y_Total);

	public void render(Graphics g) {
		String str_geracoes = "Geração: " + geracao + "/" + (Agrupamento.geracoes.size() - 1);

		// String Geracoes:
		g.setFont(font1);
		g.setColor(Color.BLUE);
		g.drawString(str_geracoes, x_geracoes, y_geracoes);
		// Eixo y
		g.setColor(Color.WHITE);
		g.fillRect(x_eixo_y, y_eixo_y, width_eixo_y, height_eixo_y);
		// Eixo x
		g.setColor(Color.WHITE);
		g.fillRect(x_eixo_x, y_eixo_x, width_eixo_x, height_eixo_x);
		// String 8:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_8, x_8, y_8);
		// String 4:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_4, x_4, y_4);
		// String 3:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_3, x_3, y_3);
		// String 1.5:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_1_5, x_1_5, y_1_5);
		// String 0:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_0, x_0, y_0);
		// String Width:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_Width, x_Width, y_Width);
		// String Length:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_Length, x_Length, y_Length);
		// String K:
		String str_k = "K: "+Agrupamento.k;
		int x_k = Proporcoes.porcentagem(83, Proporcoes.X_Total);
		int y_k = Proporcoes.porcentagem(10, Proporcoes.Y_Total);
		// K:
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(str_k, x_k, y_k);
		pontos(g);

	}

	private void pontos(Graphics g) {
		// Centroids
		int size = Proporcoes.porcentagem(4, Proporcoes.X_Total);
		int size_ponto = Proporcoes.porcentagem(3, Proporcoes.X_Total);
		for (int i = 0; i < Agrupamento.geracoes.get(geracao).centroids.size(); i++) {
			g.setColor(Agrupamento.cores.get(i));
			int x = 0;
			int y = 0;
			int width = 0;
			int height = 0;
			for (int j = 0; j < Agrupamento.geracoes.get(geracao).pontos_de_cada_centroid.get(i).size(); j++) {
				x = x_eixo_x
						+ (int) (Agrupamento.geracoes.get(geracao).pontos_de_cada_centroid.get(i).get(j).petal_length
								* width_eixo_x / 8)
						- size_ponto / 2;
				y = (height_eixo_y + y_eixo_y)
						- (int) (Agrupamento.geracoes.get(geracao).pontos_de_cada_centroid.get(i).get(j).petal_width
								* height_eixo_y / 3)
						- size_ponto / 2;

				width = size_ponto;
				height = size_ponto;
				g.fillOval(x, y, width, height);

			}
			x = x_eixo_x + (int) (Agrupamento.geracoes.get(geracao).centroids.get(i).petal_length * width_eixo_x / 8)
					- size / 2;
			y = (height_eixo_y + y_eixo_y)
					- (int) (Agrupamento.geracoes.get(geracao).centroids.get(i).petal_width * height_eixo_y / 3)
					- size / 2;

			width = size;
			height = size;
			g.fillRect(x, y, width, height);
			g.setColor(Color.white);
			g.drawRect(x, y, width, height);

		}

	}
}
