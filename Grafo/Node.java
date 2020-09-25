package Grafo;

import java.util.*;

/**
 * Modela un nodo en el cual se almacenará un número y dos listas que haran referencia a sus arcos emergentes e incidentes.
 */
public class Node {

	private int num;
	private List<Node> emergents, incidents;
	
	/**
	 * Inicializa un nodo con su número.
	 * @param num Número a almacenar.
	 */
	public Node(int num) {
		this.num = num;
		emergents = new LinkedList<Node>();
		incidents = new LinkedList<Node>();
	}
	
	/**
	 * Agrega un nodo conectado por un arco emergente, a la lista de emergentes.
	 * @param em Nodo agregado a lista de emergentes.
	 */
	public void addEmergent(Node em) {
		if(!emergents.contains(em)) {
			emergents.add(em);
		}
	}
	
	/**
	 * Agrega un nodo conectado por un arco incidente, a la lista de incidentes.
	 * @param in Nodo agregado a lista de incidentes.
	 */
	public void addIncident(Node in) {
		if(!incidents.contains(in)) {
			incidents.add(in);
		}
	}
	
	/**
	 * Elimina, si existe, el nodo recibido por parámetro de la lista de emergentes.
	 * @param em Nodo a eliminar de la lista de emergentes.
	 */
	public void removeEmergentNode(Node em) {
		if(emergents.contains(em)) {
			emergents.remove(em);
		}
	}
	
	/**
	 * Elimina, si existe, el nodo recibido por parámetro de la lista de incidentes.
	 * @param in Nodo a eliminar de la lista de incidentes.
	 */
	public void removeIncidentNode(Node in) {
		if(incidents.contains(in)) {
			incidents.remove(in);
		}
	}
	
	//Getters
	public int getNum() {
		return num;
	}
	
	public List<Node> getEmergents(){
		return emergents;
	}
	
	public List<Node> getIncidents() {
		return incidents;
	}
	
	//Setters
	public void setNum(int num) {
		this.num = num;
	}
	
}
