package Grafo;

public class PruebaGraph {
	
	public static void main(String args []) {
		Graph grafo = new Graph();
		
		//Se agregan nodos.
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		
		//Se intenta agregar otra vez en nodo 1
		grafo.addNode(1);
		
		//Se agregan distintos arcos.
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(3, 2);
		
		//Se intenta agregar arcos con nodos que no pertenecen al grafo
		grafo.addEdge(1, 0);
		grafo.addEdge(0, 10);
		
		//Se eliminan el nodo 3
		grafo.removeNode(3);
		
		//Se intenta eliminar un nodo que no pertenece al grafo.
		grafo.removeNode(10);
		
		//Se elimina arco entre 1 y 2.
		grafo.removeEdge(1, 2);
		
		//Se intenta eliminar un arco que no pertenece al grafo.
		grafo.removeEdge(2, 1);
		
		//Se intenta eliminar arcos con nodos que no pertenecen al grafo.
		grafo.removeEdge(2, 0);
		grafo.removeEdge(8, 9);
	}
	
}
