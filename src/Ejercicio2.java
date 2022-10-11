import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio2 {
	
	private static Scanner sc = new Scanner(System.in);
	
	//array que contendra cada carrito del flujo
	private static ArrayList<ArrayList<Integer>> totalVentas = new ArrayList<ArrayList<Integer>>();   

	
		
	
	public static void Menu() {
		
		boolean exec = true;
		
		do {
		System.out.println("------------------------");
		System.out.println("1. Introducir venta");
		System.out.println("2. Enseñar flujo de ventas");
		System.out.println("3. Salir");
		System.out.println("------------------------");
		
		String opcion = sc.next();
		
		switch (opcion.toLowerCase()) {
		case "1":
		case "introducir":
			
				Introducir();
			break;
			
		case "2":
		case "enseñar":
			
			EnseñarCarrito();
			break;
			
		case "3":
		case "salir":
			exec = false;
			break;

		default:
			System.out.println("Introduce un valor valido");
			break;
		}
		}while(exec);
		
	}
	
	
	public static void Introducir() {
		
		
		ArrayList<Integer> compra = new ArrayList<Integer>();
		
		
		int iva = 0;
		int precioBruto = 0;
		int precioconIva = 0;
		int totalProductos = 0;
		int dineroPagado = 0;
		int dineroDevolver = 0;
		
		
		do {
			
			System.out.println("Introduce el iva (4 o 21)");
			iva = Integer.parseInt(sc.next()); //iva del usuario
			
		}while(iva != 4 && iva !=21);
		
		System.out.println("Introduce el precio sin iva");
		precioBruto = Integer.parseInt(sc.next());
		
		
		precioconIva = ((precioBruto * iva / 100) + precioBruto);
		
		System.out.println("Introduce el total de los productos");
		totalProductos = Integer.parseInt(sc.next());
		
		
		do {
			
			System.out.println("Introduce el dinero pagado");
			dineroPagado = Integer.parseInt(sc.next());
			
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
		//pasamos 5 posciones de la cadena que almacena todos los datos, en orden: 
		//iva aplicado, precio bruto, precio con iba, numero de articulos, cantidad pagada, cantidad articulos, catidad a devolver


		Menu();

    
    
	
	}
	
	

}
