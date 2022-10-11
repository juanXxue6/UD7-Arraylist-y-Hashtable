import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Map.Entry;

public class Ejercicio4 {
	
	static public Scanner sc = new Scanner(System.in);
	
	
	static Hashtable<String, Double>precio  = new Hashtable<String, Double>();
	static Hashtable<String, Integer>stock  = new Hashtable<String, Integer>();
	private static ArrayList<ArrayList<Integer>> totalVentas = new ArrayList<ArrayList<Integer>>();   
	
	
	public static String[] NombresBD = {"Cama","Alfombra","escritorio","Camara","Sofa","Piano","Tocadiscos","Mesa","Comedor","Horno"};
	public static double[] PreciosBD = {672.22,31.51,245.21,122.90,689.55,829.02,3116.12,41.22,301.22,2569.35};
	public static int[] StockDB = {33,12,9,4,13,1,23,60,21,5};
	
	
	public static void LlenarRegistrosStock() {
		
		for (int i = 0; i < 10; i++) {
			precio.put(NombresBD[i], PreciosBD[i]);
			stock.put(NombresBD[i], StockDB[i]);
		}
		
	}
	
	
	public static void Menu() {
			
			LlenarRegistrosStock();
			
			String opcion = "";
			boolean isValid = false;
	
			
			do {
				
			System.out.println("*------------------------*");
			System.out.println("1. Introducir Producto Nuevo");
			System.out.println("2. Enseñar Productos");
			System.out.println("3. Introducir venta");
			System.out.println("4. Enseñar flujo de ventas");
			System.out.println("5. Salir");
			System.out.println("*------------------------*");
			
			opcion = sc.nextLine();
			
			
			switch (opcion.toLowerCase()) {
			
			case "1":
			case "introducir Producto Nuevo":
				
				IntroducirObjeto();
				break;
	
			case "2":
			case "enseñar Productos":	
				
				EnseñarRegistrosStock();
				break;
				
			case "3":
			case "introducir venta":	
				
				IntroducirVenta();
				break;
				
			case "4":
			case "enseñar flujo de ventas":	
				
				EnseñarCarrito();
				break;
					
			case "5":
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
		
	public static void EnseñarRegistrosStock() {			 
	     for (Entry<String, Double> e : precio.entrySet())
	            System.out.println("Objeto: " + e.getKey() + " Precio: " + e.getValue() + " Stock: " + stock.get(e.getKey()));		
	}
	
	
	public static void IntroducirVenta() {
			
			
			ArrayList<Integer> compra = new ArrayList<Integer>();
			
			
			int iva = 0;
			int precioBruto = 0;
			int precioconIva = 0;
			int totalProductos = 0;
			int dineroPagado = 0;
			int dineroDevolver = 0;
			
			
			do {
				
				System.out.println("Introduce el iva (4 o 21)");
				iva = Integer.parseInt(sc.nextLine()); //iva del usuario
				
			}while(iva != 4 && iva !=21);
			
			System.out.println("Introduce el precio sin iva");
			precioBruto = Integer.parseInt(sc.nextLine());
			
			
			precioconIva = ((precioBruto * iva / 100) + precioBruto);
			
			System.out.println("Introduce el total de los productos");
			totalProductos = Integer.parseInt(sc.nextLine());
			
			
			do {
				
				System.out.println("Introduce el dinero pagado");
				dineroPagado = Integer.parseInt(sc.nextLine());
				
				if(dineroPagado < precioBruto) {
					System.out.println("La cantidad no llega para saldar la cuenta");
				}
			}while(dineroPagado < precioBruto);
			
			dineroDevolver = Math.abs(precioBruto - dineroPagado);
			
			
			compra.add(iva);
			compra.add(precioBruto);
			compra.add(precioconIva);
			compra.add(totalProductos);
			compra.add(dineroPagado);
			compra.add(dineroDevolver);
			
			totalVentas.add(compra);
			
			
		}
		
	
	
	public static void EnseñarCarrito() {
		
			for (int i = 0; i < totalVentas.size(); i++) {
				
				System.out.println("*----------------------------------------*");
				System.out.println("Carrito " + (i+1) + ": ");
				System.out.println("Iva " + totalVentas.get(i).get(0));
				System.out.println("Precio Bruto " + totalVentas.get(i).get(1));
				System.out.println("Precio Total " + totalVentas.get(i).get(2));
				System.out.println("Numero de articulos " + totalVentas.get(i).get(3));	
				System.out.println("Cantidad pagada " + totalVentas.get(i).get(4));
				System.out.println("Cantidad a devolver " + totalVentas.get(i).get(5));
				System.out.println("*----------------------------------------*");
			}
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu();
	}

}
