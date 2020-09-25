package Grafo;

/**
 * Modela un arco entre dos nodos representados por n�meros enteros.
 */
public class Edge {

	private int node1, node2;
	
	/**
	 * Inicializa un arco con dos nodos como extremos.
	 * @param n1 N�mero que representar� el primer nodo extremo del arco.
	 * @param n2 N�mero que representar� el segundo nodo extremo del arco.
	 */
	public Edge(int n1, int n2) {
		node1 = n1;
		node2 = n2;
	}
	
	//Setters
	public int getN1(){
		return node1;
	}
	
	public int getN2(){
		return node2;
	}
	
	//Getters
	public void setN1(int n1) {
		node1 = n1;
	}
	
	public void setN2(int n2) {
		node2 = n2;
	}
	
}
