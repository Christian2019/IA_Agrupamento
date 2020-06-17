package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Save_Game {
	public static boolean saveExist = false;
	public static boolean saveGame = false;

	public static void save_geracoes() {
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter("ag.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	write = creat_String(write, geracoes);
		try {
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void save_mapa() {
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter("save.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		write = creat_String_Mapa(write);
		try {
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static BufferedWriter creat_String_Mapa(BufferedWriter write) {
		String current; 
		current = "10";
		try {
			write.write(current);
			write.newLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for (int y=0;y<10;y++) {
			current="";
		for (int x=0;x<10;x++) {
			if (x>0) {
			current=current+" ";
			}
			/*
			int lab=World.labirinto[x][y];
			//0=chao 1=parede 2=buraco 3=saida 4=entrada
			if (lab==0) {
				current=current+"0";	
			}else if (lab==1) {
				current=current+"1";	
			}else if (lab==2) {
				current=current+"B";	
			}else if (lab==3) {
				current=current+"S";	
			}else if (lab==4) {
				current=current+"E";	
			}
			*/
		}
		try {
			write.write(current);
			if (y<9) {
			write.newLine();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}
		
		return write;
	}
	private static BufferedWriter creat_String(BufferedWriter write) {

		String current; 
		current = "Movimentos 0=NW 1=N 2=NE 3=E 4=SE 5=S 6=SW 7=W";
		try {
			write.write(current);
			write.newLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*
		for (int i = 0; i < geracoes.size(); i++) {
			current = "Geração: "+i;
			try {
				write.write(current);
				write.newLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			current = "População: ";
			try {
				write.write(current);
				write.newLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			for (int j=0;j<geracoes.get(i).populacao.size();j++) {
				current = geracoes.get(i).populacao.get(j)+" "+geracoes.get(i).aptidoes.get(j);
				try {
					write.write(current);
					write.newLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			current = "Elite:";
			try {
				write.write(current);
				write.newLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			current = geracoes.get(i).elite+" "+geracoes.get(i).aptidao_elite;
			try {
				write.write(current);
				write.newLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			current = "";
			try {
				write.write(current);
				write.newLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
*/
		return write;
	}

	public static void load(String path) {
		
		int cont_line = 1;
		File file = new File(path);
		if (file.exists()) {
			String singleLine = null;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				try {
					while ((singleLine = reader.readLine()) != null) {
						
						if (cont_line > 1) {
							
							String[] dados = singleLine.split(",");
							double petal_length = Double.parseDouble(dados[2]);
							 double petal_width=Double.parseDouble(dados[3]);
							 Petala petala = new Petala(petal_length,petal_width);
							Agrupamento.petalas.add(petala);
						}
						
						cont_line++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		}
	}
}
