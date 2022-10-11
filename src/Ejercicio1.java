import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ejercicio1 {
	static public Scanner sc = new Scanner(System.in);
	
	//declaracion diccionario
	static Hashtable<String, Double> diccionario = new Hashtable<String, Double>();
	
	public static void Menu() {
		
		boolean isValid = false;
		String opcion = "";
		String nombreAlumno = "";
		
		do {
			

		System.out.println("*------------------------*");
		System.out.println("1. Introducir alumno");
		System.out.println("2. Enseñar nota media");
		System.out.println("3. Salir");
		System.out.println("*------------------------*");
		
		opcion = sc.nextLine();
		
		
		switch (opcion.toLowerCase()) {
		case "1":
		case "Introducir alumno":	
			
			do {
			System.out.println("Introduce el nombre del alumno ");	
			nombreAlumno = sc.nextLine();
			}while(ComprobarDuplicado(nombreAlumno));
			
			IntroducirNotaMedia(nombreAlumno);
			
			break;

		case "2":
		case "Enseñar nota media":	
			
			EnseñarRegistros();
			break;
				
		case "3":
		case "Salir":	
			
			isValid = true;
			System.out.println("Fin del programa");
			break;
		
		default:
			
			System.err.println("Introduce una opcion valida");

			break;
		}	
		
		}while(!isValid);
		
	}
	
	public static void IntroducirNotaMedia(String nombre) {
		
		double mediaNota = 0;
		double nota = 0;
		for (int i = 0; i < 4; i++) {
			
			do {
			System.out.println("Introduce la nota " + (i+1) + " del alumno " + nombre  + ":" );
			try {
			nota =  Integer.parseInt(sc.nextLine());
			
			if(nota < 0 || nota > 10) {
				System.err.println("Introduce un valor valido");
			}
			}catch (Exception e) {
				System.err.println("Introduce un valor valido");
				nota = -1;
			}
			}while(nota < 0 || nota > 10);
			
			mediaNota = mediaNota + nota;	
		}
		diccionario.put(nombre, (mediaNota/4));

	}
		
	public static boolean ComprobarDuplicado(String nombre) {	
		
		Enumeration<String> iterator = diccionario.keys();
		 
	       while(iterator.hasMoreElements()) {
	    	   if(iterator.nextElement().toLowerCase().trim().equals(nombre.toLowerCase().trim())) {
	    		   System.out.println("Nombre dupicado, intentelo con otro nombre");
	    			return true;
	    	   }
	       }
	       return false;
	}
		
	public static void EnseñarRegistros() {			 
	     for (Entry<String, Double> e : diccionario.entrySet())
	            System.out.println(e.getKey() + ": " + e.getValue());		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu();		
	}

}
