package graficos;

public class Ponto {
public int x;
public int y;
public double xd;
public double yd;
public Ponto(int x, int y) {
	this.x=x;
	this.y=y;
}
public Ponto(double x, double y) {
	this.xd=x;
	this.yd=y;
}
@Override
public String toString() {
	return "Ponto [x=" + x + ", y=" + y + "]\n";
}

}
