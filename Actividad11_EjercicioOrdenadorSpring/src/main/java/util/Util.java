package util;

public class Util {

	public static double generateRandomNumber(int min, int max) {
		return (Math.floor(Math.random() * ((max - min) + 1)) + min);
	}

	public static String getRandomMarca() {
		String[] marcas = new String[] { "Nvidia", "LG", "Dell", "Samsung" };

		int i = (int) Util.generateRandomNumber(0, marcas.length - 1);

		return marcas[i];
	}
}
