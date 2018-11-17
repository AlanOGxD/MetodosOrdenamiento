import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import javax.swing.text.StyledEditorKit.ForegroundAction;

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
	
	public void mostrarVector(int[] numeros) {
		System.out.println(Arrays.toString(numeros));
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
}

public class EjemploMetodosDeOrdenamiento {
public static void main(String[] args) {
	long tinicio, tfinal;
	tinicio = System.currentTimeMillis();
	MetodosOrdenamiento mo=new MetodosOrdenamiento();
	int[] edades={34,25,12,87,9,10,34,37,24,2};
	mo.mostrarVector(edades);
	
	//mostrar vector
	
	System.out.println("Ordenamiento con burbuja");
	mo.ordenamientoBurbuja1(edades);
	mo.mostrarVector(edades);
	//ordenamiento burbuja
	//mostrar vector
	
	System.out.println("\nDATOS DE EFICIENCIA DEL ALGORITMO");
	
	//recorridos o pasadas
	//comparaciones
	//intercambios
	//tiempo de ejecucion

	tfinal = System.currentTimeMillis();
	System.out.println("Tiempo procesamiento: " + (tfinal - tinicio));
	
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("ordenamiento seleccion");
	mo.mostrarVector(edades);
	mo.ordenamientoPorSeleccion(edades);
	mo.mostrarVector(edades);
	
	//aqui en lugar de edades se hacen vectores con 1000 10000 100000 y un millon con git push 
}
}
