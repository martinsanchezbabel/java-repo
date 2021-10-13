package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
//import modelo.persistencia.PersonaDaoDerby;
import modelo.persistencia.CocheDaoMySql;
import modelo.persistencia.interfaces.CocheDao;

//Aquí irian todas las reglas de negocio de nuestra aplicacion, se aplicarian
//antes de llamar a la BBDD. Por ejemplo si la persona tiene que tener al
//menos un nombre con 3 caracteres 

public class GestorCoche {
	
	//Aqui podemos jugar con cambiar el dao que queremos usar
	//podemos usar PersonaDaoDerby o PersonaDaoMySql
	//Gracias a las interfaces solo tenemos que cambiar el objeto
	CocheDao cocheDao = new CocheDaoMySql();
	
	public boolean alta(Coche c){
		//aplicamos la regla de negocio
		if(c.getMatricula().length() == 7  ) {
			boolean alta = cocheDao.alta(c);
			return alta;
		}
		return false;
	}
	
	public boolean baja(String matricula){
		boolean baja = cocheDao.baja(matricula);
		return baja;
	}
	
	public boolean modificar(Coche c){
		//aplicamos la regla de negocio
		if(c.getMatricula().length() == 7) {
			boolean modificada = cocheDao.modificar(c);
			return modificada;
		}
		return false;
	}
	
	public Coche obtener(String matricula){
		Coche coche = cocheDao.obtener(matricula);
		return coche;
	}
	
	public List<Coche> listar(){
		List<Coche> listaCoches = cocheDao.listar();
		return listaCoches;
	}
	
}
