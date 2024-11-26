 public class Combate {

    // Añada los atributos y el constructor *************
	
	Pokemon pokemonJugador;
	Pokemon pokemonRival;
	
	public Combate(Pokemon pokemonJugador, Pokemon pokemonRival) {
		this.pokemonJugador = pokemonJugador;
		this.pokemonRival = pokemonRival;
	}
	
    //***************************************************

    public Pokemon Ronda(){
    	int poderJugador = pokemonJugador.calcularPoder(pokemonRival);
    	int poderRival = pokemonRival.calcularPoder(pokemonJugador);
    	
    	if(poderJugador > poderRival) {
    		pokemonRival.disminuirAguante();
    		return pokemonJugador;
    	}else if (poderJugador < poderRival) {
    		pokemonJugador.disminuirAguante();
    		return pokemonRival;
    	}
    	
    	return null; /* si hay empate */
    }

    public Pokemon Ganador(){
    	if(pokemonJugador.getAguante() <= 0) {
    		return pokemonRival;
    	}else if(pokemonRival.getAguante() <= 0) {
    		return pokemonJugador;
    	}
    	return null; // si no hay ganador aún

    }


}
