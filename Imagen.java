public class Imagen extends Multimedia{


	public Imagen(String nombre, int posX, 
		int posY, int duracion, int delay) {

		super(nombre, posX, posY, duracion, delay);
	}
	
	public Imagen(String nombre,int pantalla, 
		int duracion, int delay){
	
		super();
		this.nombre = nombre;
		this.pantalla = pantalla;
		this.posX = 1920*(pantalla-1)+1;
		this.posY = 1080;
		this.duracion = (duracion*1000);
		this.delay = (delay*1000);	
	}


	@Override
	public String toString() {
		return "Imagen [nombre=" + nombre + ", posX=" + posX + ", posY=" + posY + ", duracion=" + duracion + ", delay="
				+ delay + "]";
	}
	
}
