package Personajes;

public class Curandero extends Personaje {

	private int sabiduria;

	public Curandero(int sabiduria) {
		super();
		this.sabiduria = sabiduria;
	}

	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}

}
