public abstract class Multimedia {

	protected String nombre;
	protected int posX;
	protected int posY;
	protected int duracion;
	protected int delay;
	protected int pantalla;
	
	public Multimedia(){
		
	}
	
	
	public Multimedia(String nombre, int posX, 
		int posY, int duracion, int delay) {
		super();
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
		this.duracion = duracion;
		this.delay = delay;
	}
	
	public void correr(){
		
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getDuracion(){
		return this.duracion;
	}

	public int getDelay(){
		return this.delay;
	}

	public int getPantalla(){
		return this.pantalla;
	}
	
}
