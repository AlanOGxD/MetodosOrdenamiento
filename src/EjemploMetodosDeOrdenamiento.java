
import java.util.Random;
import java.util.Scanner;

class MetodosOrdenamiento{
	public void ordenamientoBurbuja1(int[] numeros) {
		int aux=0, contpasada=0,contcompara=0, continter=0;
		for (int i = 2; i < numeros.length; i++) {
			contpasada++;
			for (int j = 0; j < numeros.length-i; j++) {
				contcompara++;
				if (numeros[j] > numeros[j+1]) {
					aux=numeros[j];
					numeros[j]=numeros[j+1];
					numeros[j+1]=aux;
					continter++;
				}
			}
		}
		System.out.println("Pasadas: "+contpasada);
		System.out.println("comparaciones "+contcompara);
		System.out.println("intercambios "+continter);
		
	}
	
	public void ordenamientoBurbuja2(int[] numeros) {
		int recorrido=0, compas=0, intercambios=0, aux=0;	
		int i=1;
		boolean ordenado = false;
		
		long init = System.currentTimeMillis();
		
		while( (i < numeros.length) && (ordenado == false)) {
			i=i+1;
			ordenado=true;
			for(int j=0; j <= numeros.length -i; j++) {
				compas++;
				if(numeros[j] > numeros[j+1]) {
					ordenado = false;
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
					intercambios++;
				}
				recorrido++;
			}
		}
		
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo: "+(fin-init));
		System.out.println("Pasadas: "+recorrido);
		System.out.println("comparaciones "+compas);
		System.out.println("intercambios "+intercambios);
	}
	
public void ordenamientoBurbuja3(int[] numeros) {
		
		int recorrido=0, compas=0, intercambios=0,aux=0;
		
		int i=1;
		boolean ordenado;
		
		long init = System.currentTimeMillis();
		
		do {
			i=i+1;
			ordenado = true;
			
			for(int j=0; j <= numeros.length-i; j++) {
				compas++;
				if(numeros[j] > numeros[j+1]) {
					intercambios++;
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
				}
				recorrido++;
			}
		} while( (i < numeros.length) && (ordenado == true) );
		
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo: "+(fin-init));
		System.out.println("Pasadas: "+recorrido);
		System.out.println("comparaciones "+compas);
		System.out.println("intercambios "+intercambios);
	}
	
	public void mostrarVector(int[] numeros) {
	byte cont=0;
		for (int i = 0; i < numeros.length; i++) {
			if (cont == 15 ) {
				System.out.println(numeros[i]+", ");
				cont=0;
			}
			else {
				System.out.print(numeros[i]+", ");
			}
		}
		System.out.println();
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////
	public void ordenamientoPorSeleccion(int[] numeros) {
		int recorrido=0, intercambio=0;
		long tini, tfin;
		tini=System.currentTimeMillis();
		for (int i = 0; i < numeros.length; i++) {
			int minimo=i;
			for (int j = i+1; j < numeros.length; j++) {
				if (numeros[j]<numeros[minimo]) {
					minimo=j;
				}
				int aux=numeros[i];
				numeros[i]=numeros[minimo];
				numeros[minimo]=aux;
				intercambio++;
			}
			recorrido++;
		}
		tfin=System.currentTimeMillis();
		System.out.println("tiempo procesamiento: "+(tfin-tini));
		System.out.println("recorrido: "+recorrido);
		System.out.println("Intercambio: "+intercambio);
	}
	
	public void insercion(int numeros[]) {
		long tfin,tini;
		int aux, recorrido=0, j, intercambio=0, comparacion=0;
		tini=System.currentTimeMillis();
		for (int i = 1; i < numeros.length; i++) { // desde el segundo elemento hasta
			aux = numeros[i]; // el final, guardamos el elemento y
			j = i - 1; // empezamos a comprobar con el anterior
			comparacion++;
			while ((j >= 0) && (aux < numeros[j])) { // mientras queden posiciones y el
												// valor de aux sea menor que los
				numeros[j + 1] = numeros[j]; // de la izquierda, se desplaza a
				j--; 
				comparacion++;// la derecha
				
			}
			numeros[j + 1] = aux; // colocamos aux en su sitio
			intercambio++;
			recorrido++;
		}

		tfin=System.currentTimeMillis();
		System.out.println("Tiempo procesamiento: "+(tfin-tini));
		System.out.println("Recorrido: "+recorrido);
		System.out.println("Intercambio: "+intercambio);
		System.out.println("Comparacion: "+comparacion);
	}
	
	public void ordenamientoShellSort(int array[]) {
		 int salto, aux, i;
		 int recorrido=0, intercambios=0, compas=0;
		 boolean cambio;
		 long init = System.nanoTime();
		 for(salto=array.length/2;salto!=0;salto/=2) {
			 recorrido++;
			 cambio=true;
			 while(cambio) {
				 compas++;
				 cambio=false;
				 for(i=salto;i<array.length;i++) {
					 
					 if(array[i-salto]>array[i]) {
						 aux=array[i];
						 array[i]=array[i-salto];
						 array[i-salto]=aux;
						 intercambios++;
						 cambio=true;
					 }
				 }
			 }
		 }
		 long fin=System.nanoTime();
		 System.out.println("Tiempo: "+(fin-init));
			System.out.println("Pasadas: "+recorrido);
			System.out.println("comparaciones "+compas);
			System.out.println("intercambios "+intercambios); 
	 }
	
	public void ordenamientoQuickSort(int numeros[],int primero,int ultimo) {
		 int recorrido = 0,intercambios=0,compas=0;
			
	     
	     long init =  System.currentTimeMillis();
			int i,j,pivote,aux;
			i = primero;
			j = ultimo;
			pivote = numeros[primero];
			while (i < j) {
	         while (numeros[i] <= pivote && i < j) {
	             i++;
	         }
	         while (numeros[j] > pivote) {
	             j--;
	         }
	         if (i < j) {
	         	compas++;
	             aux = numeros[i];
	             numeros[i] = numeros[j];
	             numeros[j] = aux;
	             intercambios++;
	         }
	     }
			recorrido++;
			numeros[primero] = numeros[j];
	     numeros[j] = pivote;
	     intercambios++;
	     if (primero < j - 1) {
	         ordenamientoQuickSort(numeros, primero, j - 1);
	     }
	     if (j + 1 < ultimo) {
	         ordenamientoQuickSort(numeros, j + 1, ultimo);
	     }
	     
	     long fin = System.currentTimeMillis();
	     System.out.println("Tiempo: "+(fin-init));
			System.out.println("Pasadas: "+recorrido);
			System.out.println("comparaciones "+compas);
			System.out.println("intercambios "+intercambios); 	
	 }
	
	 public static void radixSort(int[] arr){
	     if(arr.length == 0)
	         return;
	     int[][] np = new int[arr.length][2];
	     int[] q = new int[0x100];
	     int i,j,k,l,f = 0;
	     for(k=0;k<4;k++){
	         for(i=0;i<(np.length-1);i++)
	             np[i][1] = i+1;
	         np[i][1] = -1;
	         for(i=0;i<q.length;i++)
	             q[i] = -1;
	         for(f=i=0;i<arr.length;i++){
	             j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
	             if(q[j] == -1)
	                 l = q[j] = f;
	             else{
	                 l = q[j];
	                 while(np[l][1] != -1)
	                     l = np[l][1];
	                 np[l][1] = f;
	                 l = np[l][1];
	             }
	             f = np[f][1];
	             np[l][0] = arr[i];
	             np[l][1] = -1;
	         }
	         for(l=q[i=j=0];i<0x100;i++)
	             for(l=q[i];l!=-1;l=np[l][1])
	                     arr[j++] = np[l][0];
	     }
	 }
}

public class EjemploMetodosDeOrdenamiento {
public static void main(String[] args) {
	MetodosOrdenamiento mo=new MetodosOrdenamiento();	
	
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	System.out.println("Seleccion del metodo: ");
	System.out.println("1) Burbuja 1.");
	System.out.println("2) Burbuja 2.");
	System.out.println("3) Burbuja 3.");
	System.out.println("4) Seleccion.");
	System.out.println("5) insercion.");
	System.out.println("6) Shellsort.");
	System.out.println("7) Quicksort.");
	System.out.println("8) Radix.");
	byte op = sc.nextByte();
	
	int [] numeros= new int[100];
	for (int i = 0; i < numeros.length; i++) {
		numeros[i]=random.nextInt(100);
	}
	
	int[] numeros2= new int[1000];
	for (int i = 0; i < numeros2.length; i++) {
		numeros2[i]=random.nextInt(100);
	}
	
	int[] numeros3= new int[10000];
	for (int i = 0; i < numeros3.length; i++) {
		numeros3[i]=random.nextInt(100);
	}
	
	int[] numeros4= new int[100000];
	for (int i = 0; i < numeros4.length; i++) {
		numeros4[i]=random.nextInt(100);
	}
	
	int [] numeros5= new int[1000000];
	for (int i = 0; i < numeros5.length; i++) {
		numeros5[i]=random.nextInt(100);
	}
	
	switch (op) {
	case 1: 
		System.out.println("~~~~~~~~~~~~~~~~ Metodo Burbuja 1~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.ordenamientoBurbuja1(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.ordenamientoBurbuja1(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.ordenamientoBurbuja1(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.ordenamientoBurbuja1(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.ordenamientoBurbuja1(numeros5);
		mo.mostrarVector(numeros5);
		break;
	case 2:	
		System.out.println("~~~~~~~~~~~~~~~~~~~ Metodo Burbuja 2 ~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.ordenamientoBurbuja2(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.ordenamientoBurbuja2(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.ordenamientoBurbuja2(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.ordenamientoBurbuja2(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.ordenamientoBurbuja2(numeros5);
		mo.mostrarVector(numeros5); 
		break;
	case 3:	
		System.out.println("~~~~~~~~~~~~~~~~~~~ Metodo Burbuja 3 ~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.ordenamientoBurbuja3(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.ordenamientoBurbuja3(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.ordenamientoBurbuja3(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.ordenamientoBurbuja3(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.ordenamientoBurbuja3(numeros5);
		mo.mostrarVector(numeros5); 
		break;
	case 4: 
		System.out.println("~~~~~~~~~~~~~~~~ Metodo Seleccion~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.ordenamientoPorSeleccion(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.ordenamientoPorSeleccion(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.ordenamientoPorSeleccion(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.ordenamientoPorSeleccion(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.ordenamientoPorSeleccion(numeros5);
		mo.mostrarVector(numeros5);
		break;
	case 5:	
		System.out.println("~~~~~~~~~~~~~~~~~~~ Metodo Insercion~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.insercion(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.insercion(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.insercion(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.insercion(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.insercion(numeros5);
		mo.mostrarVector(numeros5); 
		break;
	case 6:	
		System.out.println("~~~~~~~~~~~~~~~~~~~ Metodo Shell sort ~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.ordenamientoShellSort(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.ordenamientoShellSort(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.ordenamientoShellSort(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.ordenamientoShellSort(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.ordenamientoShellSort(numeros5);
		mo.mostrarVector(numeros5); 
		break;
	case 7:	
		System.out.println("~~~~~~~~~~~~~~~~~~~ Metodo Quicksort ~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.ordenamientoShellSort(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.ordenamientoShellSort(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.ordenamientoShellSort(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.ordenamientoShellSort(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.ordenamientoShellSort(numeros5);
		mo.mostrarVector(numeros5); 
		break;
	case 8:	
		System.out.println("~~~~~~~~~~~~~~~~~~~ Metodo Radix ~~~~~~~~~~~~~~~~~~");
		System.out.println("Prueba 100 numeros");
		mo.mostrarVector(numeros);
		mo.ordenamientoShellSort(numeros);
		mo.mostrarVector(numeros);
		System.out.println();
		System.out.println("Prueba 1000 numeros");
		mo.mostrarVector(numeros2);
		mo.ordenamientoShellSort(numeros2);
		mo.mostrarVector(numeros2);
		System.out.println();
		System.out.println("Prueba 10000 numeros");
		mo.mostrarVector(numeros3);
		mo.ordenamientoShellSort(numeros3);
		mo.mostrarVector(numeros3);
		System.out.println();
		System.out.println("Prueba 100000 numeros");
		mo.mostrarVector(numeros4);
		mo.ordenamientoShellSort(numeros4);
		mo.mostrarVector(numeros4);
		System.out.println();
		System.out.println("Prueba 1000000 numeros");
		mo.mostrarVector(numeros5);
		mo.ordenamientoShellSort(numeros5);
		mo.mostrarVector(numeros5); 
		break;
	default: System.out.println("Opcion incorrecta :)");break;
	}
	sc.close();
	
}
}
