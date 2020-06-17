package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UI {
	public static Font font1 = new Font("Arial", Font.BOLD, Proporcoes.porcentagem(Proporcoes.X_Total, 3));
	public static int geracao = 0;

	public static void render(Graphics g) {
		// String Geracoes:
		String str_geracoes = "Geração: " + geracao + "/" + Agrupamento.geracoes.size();
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

	}
}
