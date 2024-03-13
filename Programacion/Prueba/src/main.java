public class main {

    public static void main(String[] args) {
       System.out.println("DNI: "+ validarDNI("01104147D"));
       System.out.println("NIE: "+ validarNIE("X9114660J"));
       
       System.out.println("---------------MAL------------");
       System.out.println("DNI: "+ validarDNI("01184147D"));
       System.out.println("NIE: "+ validarNIE("X91474660J"));
    }
    
    protected static boolean validarDNI(String dni) {
		if (dni == null || dni.length() != 9) {
			return false;
		}

		for (int i = 0; i < 8; i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				return false;
			}
		}

		char letra = Character.toUpperCase(dni.charAt(8));
		if (!Character.isLetter(letra)) {
			return false;
		}

		int numDNI;
		try {
			numDNI = Integer.parseInt(dni.substring(0, 8));
		} catch (NumberFormatException e) {
			return false;
		}

		char letraCalculada = calcularLetra(numDNI);
		

		if (letra != letraCalculada) {
			return false;
		}

		return true;
	}
    
	private static char calcularLetra(int numero) {
		String letrasNIE = "TRWAGMYFPDXBNJZSQVHLCKE";
		int indiceLetra = numero % 23;
		return letrasNIE.charAt(indiceLetra);
		
	}

	protected static boolean validarNIE(String nie) {
		char primeraLetra = nie.charAt(0);
        if (primeraLetra == 'X') {
            nie = "0" + nie.substring(1);
        } else if (primeraLetra == 'Y') {
            nie = "1" + nie.substring(1);
        } else if (primeraLetra == 'Z') {
            nie = "2" + nie.substring(1);
        } else {
            return false; 
        }

        
        if (nie.length() != 9 || !nie.substring(1).matches("\\d{7}[A-Z]")) {
            return false; 
        }

        
        String digitos = nie.substring(0, 8);
        int numNIE = Integer.parseInt(digitos);
        char letraCalculada = calcularLetra(numNIE);
        char letraControl = nie.charAt(8);
        
        

        if (letraControl != letraCalculada) {
			return false;
		}

		return true;
	}


}
