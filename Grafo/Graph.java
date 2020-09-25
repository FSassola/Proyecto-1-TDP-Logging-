package Grafo;

import java.util.*;
import java.util.logging.*;

/**
 * Modela un grafo que contendrá distintos nodos y arcos entre estos.
 */
public class Graph {

	private Map<Integer, Node> nodes;
	private Map<String, Edge> edges;
	private static Logger logger;
	
	/**
	 * Inicializa un grafo vacío.
	 */
	public Graph() {
		nodes = new HashMap<Integer, Node>();
		edges = new HashMap<String, Edge>();
		if(logger == null) {
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hand = new ConsoleHandler();
			hand.setLevel(Level.FINE);
			logger.addHandler(hand);
			
			logger.setLevel(Level.FINE);
			
			Logger rootLogger = logger.getParent();
			for(Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}
	
	/**
	 * Agrega un nodo al grafo, si aún no pertenecia a este.
	 * @param node Nodo a insertar en el grafo.
	 */
	public void addNode(int node) {
		boolean esta = nodes.containsKey(node);
		if(!esta) {
			nodes.put(node, new Node(node));
			logger.info("El nodo " + node + " fue agregado correctamente al grafo.");
		}
		else {
			logger.warning("El nodo " + node + " ya existe dentro del grafo.");
		}
	}
	
	/**
	 * Agrega un arco entre "node1" y "node2", si aún no existia dicho arco y los nodos pertenecen al grafo.
	 * @param node1 Nodo del cual emerge el arco.
	 * @param node2 Nodo sobre el cual incide el arco.
	 */
	public void addEdge(int node1, int node2) {
		boolean estaN1, estaN2, estaArco;
		estaN1 = nodes.containsKey(node1);
		estaN2 = nodes.containsKey(node2);
		
		if(!estaN1 && !estaN2) {
			logger.warning("Ninguno de los dos nodos parámetrizados pertencen al grafo.");
		}
		else {
			if(!estaN1) {
				logger.warning("El nodo " + node2 + " no pertenece al grafo.");
			}
			else {
				if(!estaN2) {
					logger.warning("El nodo " + node1 + " no pertenece al grafo.");
				}
				else {
					if(estaN1 && estaN2) {
						Edge edge = new Edge(node1, node2);
						String clave = node1 + ", " + node2;
						estaArco = edges.containsKey(clave);
							
						if(!estaArco) {
							edges.put(clave, edge);
							nodes.get(node1).addEmergent(nodes.get(node2));
							nodes.get(node2).addIncident(nodes.get(node1));
							logger.info("El arco entre " + node1 + " y " + node2 + " fue agregado correctamente.");
						}
						else {
							logger.warning("El arco entre " + node1 + " y " + node2 + " ya existe dentro del grafo.");
						}
					}
				}
			}
		}
	}
	
	/**
	 * Remueve el nodo recibido por parámetro, si este existe.
	 * @param node Nodo a eliminar del grafo.
	 */
	public void removeNode(int node) {
		boolean esta = nodes.containsKey(node);
		Node aux;
		LinkedList<Node> emergentes, incidentes;
		
		if(esta) {
			emergentes = (LinkedList<Node>) nodes.get(node).getEmergents();
			incidentes = (LinkedList<Node>) nodes.get(node).getIncidents();
			while(!emergentes.isEmpty()) {
				aux = emergentes.removeFirst();
				edges.remove(node + ", " + aux.getNum());
			}
			logger.info("Todos los arcos emergentes de " + node + " fueron eliminados.");
			while(!incidentes.isEmpty()) {
				aux = incidentes.removeFirst();
				edges.remove(aux + ", " + node);
			}
			logger.info("Todos los arcos incidentes de " + node + " fueron eliminados.");
			nodes.remove(node);
			logger.info("El nodo " + node + " fue eliminado correctamente.");
		}
		else {
			logger.warning("El nodo parámetrizado no existe dentro del grafo.");
		}
	}
	
	/**
	 * Elimina el arco entre "node1" y "node2", si el arco existe y los nodos pertenecen al grafo.
	 * @param node1 Nodo del cual emerge el arco a eliminar.
	 * @param node2 Nodo sobre el cual incide el arco a eliminar.
	 */
	public void removeEdge(int node1, int node2) {
		boolean estaN1, estaN2, estaArco;
		estaN1 = nodes.containsKey(node1);
		estaN2 = nodes.containsKey(node2);
		
		if(!estaN1 && !estaN2) {
			logger.warning("Ninguno de los dos nodos parámetrizados pertenecen al grafo.");
		}
		else {
			if(!estaN1) {
				logger.warning("El nodo " + node1 + " no pertenece al grafo.");
			}
			else {
				if(!estaN2) {
					logger.warning("El nodo " + node2 + " no pertenece al grafo.");
				}
				else {
					if(estaN1 && estaN2) {
						estaArco = edges.containsKey(node1 + ", " + node2);
						if(estaArco) {
							nodes.get(node1).removeEmergentNode(nodes.get(node2));
							nodes.get(node2).removeIncidentNode(nodes.get(node1));
							edges.remove(node1 + ", " + node2);
							logger.info("El arco entre " + node1 + " y " + node2  + " fue eliminado correctamente.");
						}
						else {
							logger.warning("El arco entre " + node1 + " y " + node2 + " no pertenece al grafo.");
						}
					}
				}
			}
		}
	}
	
}
