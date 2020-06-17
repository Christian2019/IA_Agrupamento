package main;

public class Petala {
public double petal_length,petal_width;

public Petala(double petal_length, double petal_width) {
	
	this.petal_length = petal_length;
	this.petal_width = petal_width;
}

@Override
public String toString() {
	return "Petala [petal_length=" + petal_length + ", petal_width=" + petal_width + "]\n";
}

}
