package cuentaBancariaV2;

import java.util.Random;

public class Cuenta {
	
	protected String[] ibanArray = {
            "ES0123456789012345678901",
            "ES1123456789012345678902",
            "ES2223456789012345678903",
            "ES3323456789012345678904",
            "ES4423456789012345678905",
            "ES5523456789012345678906",
            "ES6623456789012345678907",
            "ES7723456789012345678908",
            "ES8823456789012345678909",
            "ES9923456789012345678910",
            "ES1123456789012345678921",
            "ES2223456789012345678932",
            "ES3323456789012345678943",
            "ES4423456789012345678954",
            "ES5523456789012345678965",
            "ES6623456789012345678976",
            "ES7723456789012345678987",
            "ES8823456789012345678998",
            "ES9923456789012345679009",
            "ES1023456789012345679010",
            "ES1123456789012345679021",
            "ES1223456789012345679032",
            "ES1323456789012345679043",
            "ES1423456789012345679054",
            "ES1523456789012345679065",
            "ES1623456789012345679076",
            "ES1723456789012345679087",
            "ES1823456789012345679098",
            "ES1923456789012345679109",
            "ES2023456789012345679110",
            "ES2123456789012345679121",
            "ES2223456789012345679132",
            "ES2323456789012345679143",
            "ES2423456789012345679154",
            "ES2523456789012345679165",
            "ES2623456789012345679176",
            "ES2723456789012345679187",
            "ES2823456789012345679198",
            "ES2923456789012345679209",
            "ES3023456789012345679210",
            "ES3123456789012345679221",
            "ES3223456789012345679232",
            "ES3323456789012345679243",
            "ES3423456789012345679254",
            "ES3523456789012345679265",
            "ES3623456789012345679276",
            "ES3723456789012345679287",
            "ES3823456789012345679298",
            "ES3923456789012345679309",
            "ES4023456789012345679310"
        };
	protected String nombre, apellidos, dni, iban, passUsuario;
	protected double saldo;
	
	

	


	public Cuenta(String nombre2, String apellidos2, String dni2, String passUsuario2, double cantidad) {
		this.nombre = nombre2;
		this.apellidos = apellidos2;
		this.dni = dni2;
		this.passUsuario = passUsuario2;
		this.saldo = cantidad;
	}


	public String getPassUsuario() {
		return passUsuario;
	}


	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}


	public String[] getIbanArray() {
		return ibanArray;
	}



	public void setIbanArray(String[] ibanArray) {
		this.ibanArray = ibanArray;
	}
	
	



	public String getIban() {
		return iban;
	}




	public void setIban(String iban) {
		this.iban = iban;
	}




	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public double getSaldo() {
		return saldo;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	protected static boolean inputValido(String input, boolean inputValidoB) {
		inputValidoB = false;
		if (input.length() < 3) {
			System.out.println("La longitud debe ser minimo de 3 caracteres.");
		} else {
			inputValidoB = true;
		}
		
		return inputValidoB;
		
	}
	
	protected static boolean passValidaLongitud(String pass, boolean passCorrectaB) {
		passCorrectaB = false;
		if(pass.length() < 8) {
			System.out.println("La longitud de la contraseña debe ser de minimo 8 caracteres");
		} else {
			passCorrectaB = true;
		}
		return passCorrectaB;
		
	}
	



	protected String asignarIban() {
	    String iban = null;
	    Random random = new Random();

	    int indiceAleatorio = random.nextInt(ibanArray.length);


	    if (ibanArray[indiceAleatorio] != null) {
	        iban = ibanArray[indiceAleatorio];
	        ibanArray[indiceAleatorio] = null;
	    } else {
	        System.out.println("No hay IBAN disponible en este momento.");
	    }

	    return iban;
	}
	
	protected void ingresarDinero(Double cantidad) {
		saldo += cantidad;
		System.out.println("Su saldo actual es de: " + saldo);
		
		
	}
	
	protected void sacarDinero(Double cantidad) {
		if (saldo >= cantidad) {
			saldo -= cantidad;
		} else {
			System.out.println("No dispones de fondos suficientes, lo maximo que puedes sacar es " + saldo + "€");
		}
		
		
	}
	
	
	
	
}
