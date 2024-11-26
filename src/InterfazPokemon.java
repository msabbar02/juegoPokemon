import java.util.Scanner;

public class InterfazPokemon {
    private Scanner teclado;

    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }

    public void Juego() {
    	System.out.println();
    	System.out.println("(^Beinvenido al pokemon juego ^)");
    	System.out.println();
    	
          Pokemon jugador = menuCreacionPokemonJugador();
          for (int i = 1; i <= 3; i++) {
              Pokemon rival = siguientePokemonRival(i);
              System.out.println("Presentación del pokemon oponente:" + "\n" + rival);
              jugador = Partida(jugador, rival);
              pressAnyKeyToContinue();
              if (jugador == null) {
                  mostrarFinPartida();
                  return;
              }
          }
          mostrarJuegoSuperado();
    	
    	
    }

    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival){
    	
    	Combate comba = new Combate(pokemonJugador,pokemonRival);
    	
    	while(pokemonJugador.getAguante() > 0 && pokemonRival.getAguante() > 0) {
    		Pokemon ganadorRonda = comba.Ronda();
    		  System.out.println("Gana la ronda: " + (ganadorRonda != null ? ganadorRonda.getNombre() : "Empate"));
              System.out.println("Aguante de " + pokemonJugador.getNombre() +  ": " + pokemonJugador.getAguante());
              System.out.println("Aguante de " + pokemonRival.getNombre() + ": " + pokemonRival.getAguante());
          }
    	
          Pokemon ganadorCombate = comba.Ganador();
          if (ganadorCombate == pokemonJugador) {
              pokemonJugador.subirNivel();
              System.out.println("¡Genial! Has derrotado a " + pokemonRival.getNombre());
              return pokemonJugador;
          } else {
              System.out.println(pokemonRival.getNombre() + " te ha derrotado.");
              return null;
          }
    }


    private Pokemon menuCreacionPokemonJugador(){
    	
    	System.out.println("****************************");
    	System.out.println("  Crea tu Pokemon.... ");
    	System.out.println();
    	System.out.println("****************************");
    	
    	System.out.println("Introduze el nombre de tu pokemon:");
    	String nombre = teclado.next();
    	
    	System.out.println("Elige su tipo:" + "\n1.-Agua "+ "\n2.-Tierra "+ "\n3.-Fuego ");
    	int opcion = teclado.nextInt();
    	teclado.nextLine();
    	pressAnyKeyToContinue();
    	
    	String tipo = switch(opcion) {
    	case 1 -> tipo = "agua";
    	case 2 -> tipo = "tierra";
    	case 3 -> tipo = "fuego";
    	default -> null;
    	};
    	
    	return new Pokemon(nombre,tipo);


    }

    public Pokemon siguientePokemonRival(int numero) {
    		return switch(numero) {
    		case 1 -> new Pokemon ("Caterpie","tierra",1);
    		case 2 -> new Pokemon ("Bulbasur","agua",2);
    		case 3 -> new Pokemon ("Charmander","fuego",3);
			default -> null;
    		
    		};

    }

    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }
    
    // este methodo desde stackoverflow aqui la enlace: https://es.stackoverflow.com/questions/89884/c%c3%b3mo-pausar-textos-hasta-introducir-enter-en-consola 
    static public void pressAnyKeyToContinue()
    { 
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("PULSE ENTER PARA CONTINUAR...");
        try
          {
           seguir = teclado.nextLine();
          }   
       catch(Exception e)
        {}  
   }

}
