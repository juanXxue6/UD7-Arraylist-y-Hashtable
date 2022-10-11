import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Map.Entry;

public class Ejercicio3 {

static public Scanner sc = new Scanner(System.in);
	
	//declaracion diccionario
	static Hashtable<String, Double>precio  = new Hashtable<String, Double>();
	static Hashtable<String, Integer>stock  = new Hashtable<String, Integer>();
	
	
	public static String[] NombresBD = {"Cama","Alfombra","escritorio","Camara","Sofa","Piano","Tocadiscos","Mesa","Comedor","Horno"};
	public static double[] PreciosBD = {672.22,31.51,245.21,122.90,689.55,829.02,3116.12,41.22,301.22,2569.35};
	public static int[] StockDB = {33,12,9,4,13,1,23,60,21,5};
	
	
	public static void Menu() {
		
		LlenarRegistros();
		
		String opcion = "";
		boolean isValid = false;

		
		do {
			
		System.out.println("*------------------------*");
		System.out.println("1. Introducir Producto Nuevo");
		System.out.println("2. Enseñar Productos");
		System.out.println("3. Salir");
		System.out.println("*------------------------*");
		
		opcion = sc.nextLine();
		
		
		switch (opcion.toLowerCase()) {
		
		case "1":
		case "Introducir Producto Nuevo":
			
			IntroducirObjeto();
			break;

		case "2":
		case "Enseñar Productos":	
			
			EnseñarRegistros();
			break;
				
		case "3":
		case "salir":	
			isValid = true;
			System.out.println("Fin del programa");
			break;
		
		default:		
			System.err.println("Introduce una opcion valida");
			break;
		}	
		
		}while(!isValid);
		
	}
	
	public static void IntroducirObjeto() {
		
		String nombre = "";
		double precioValue = 0;
		int stockValue = 0;
		
		do {
		System.out.println("Introduce el nombre del producto: ");
		nombre = sc.nextLine();
		
		}while(ComprobarDuplicado(nombre));
		
		do {
			try {
				System.out.println("Introduce un precio entre 0 y 100000");
				precioValue =  Double.parseDouble(sc.nextLine());
			
			if(precioValue < 0 || precioValue > 100000.0000) {
				System.err.println("Introduce un precio entre 0 y 100000");
			}
			}catch (Exception e) {
				System.err.println("Introduce un valor valido");
				precioValue = -1;
			}
		}while(precioValue < 0 || precioValue > 100000);
		precio.put(nombre, precioValue);
		
		do {
			try {
				System.out.println("Introduce el stock entre 0 y 100000");
				stockValue =  Integer.parseInt(sc.nextLine());
			
			if(stockValue < 0 || stockValue > 100000) {
				System.err.println("Introduce un stock entre 0 y 100000");
			}
			}catch (Exception e) {
				System.err.println("Introduce un valor valido");
				stockValue = -1;
			}
		}while(stockValue < 0 || stockValue > 100000);
		
		stock.put(nombre, stockValue);

	}
		
	public static boolean ComprobarDuplicado(String nombre) {	
		
		Enumeration<String> iterator = precio.keys();
	
	       while(iterator.hasMoreElements()) {
	    	   if(iterator.nextElement().toLowerCase().trim().equals(nombre.toLowerCase().trim())) {
	    		   System.err.println("Nombre dupicado, intentelo con otro nombre");
	    			return true;
	    	   }
	       }
	       return false;
	}
		
	public static void EnseñarRegistros() {			 
	     for (Entry<String, Double> e : precio.entrySet())
	            System.out.println("Objeto: " + e.getKey() + " Precio: " + e.getValue() + " Stock: " + stock.get(e.getKey()));		
	}
	
	
	public static void LlenarRegistros() {
		
		for (int i = 0; i < 10; i++) {
			precio.put(NombresBD[i], PreciosBD[i]);
			stock.put(NombresBD[i], StockDB[i]);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu();		
	}
	
	


}
