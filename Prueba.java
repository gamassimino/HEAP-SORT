import java.util.Random;
public class Prueba{

	public static void main(String[] args) {

		//CONSTRUCTOR A UTILIZAR();
		Random num = new Random();
		int maximo = 1000;
		Comparable[] array = new Comparable[maximo];

		for (int i = 0; i < maximo; i++) {array[i]=num.nextInt()*5;}
		//UTILIZAR ALGUN ALGORITMO DE SOORTING
	}
}