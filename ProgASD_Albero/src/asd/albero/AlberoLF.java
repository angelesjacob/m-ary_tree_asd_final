/**
 * @author Jacob Angeles
 */

package asd.albero;

import java.util.Iterator;
import java.util.LinkedList;

public class AlberoLF<T> {
	private NodoLF<T> rootNode;
	private int nodes;
	private int height;
	private int leafNodes;

	/**
	 * Imposta la radice dell’albero speciﬁcando la sola informazione
	 * Se esiste gia la radice, inserisce la nuova radice nell’albero 
	 * e la vecchia radice diventa ﬁglia di quella nuova
	 * @param info
	 * @return NodoLF<T>
	 */
	public NodoLF<T> setRootNode(T info) {
		if(rootNode==null) {
			rootNode = new NodoLF<T>(info);
			leafNodes++;
		} else {
			NodoLF<T> temp = rootNode;
			rootNode = new NodoLF<T>(info);
			rootNode.addChildNode(temp);			
		}		
		nodes++;
		height++;
		return rootNode;
	}
	
	/**
	 * Aggiunge un nodo nell'albero
	 * @param parentNode
	 * @param info
	 * @return NodoLF<T>
	 */
	public NodoLF<T> addNode(NodoLF<T> parentNode, T info) {
		NodoLF<T> childNode = new NodoLF<>(info);
		parentNode.addChildNode(childNode);
		childNode.setParentNode(parentNode);
		childNode.setDepth(parentNode.getDepth() + 1);
		if (height <= childNode.getDepth())
			height = childNode.getDepth() + 1;
		if(parentNode.getDegree()>1)
			leafNodes++;		
		nodes++;
		return childNode;
	}
	
	/**
	 * Restituisce la radice dell'albero
	 * @return NodoLF<T>
	 */
	public NodoLF<T> getRootNode(){
		return rootNode;
	}
	
	/**
	 * Restituisce le foglie dell'albero
	 * @return int
	 */
	public int getLeafNodes() {
		return this.leafNodes;
	}
	
	/**
	 * Restituire l’altezza dell’albero
	 * @return int
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Restituire il numero dei nodi presenti nell’albero
	 * @return int
	 */
	public int countNodes() {
		return nodes;
	}
	
	/**
	 * Restituire la lista delle informazioni dei nodi dell’albero visitato in profondita
	 * @return LinkedList<T>
	 */
	public LinkedList<T> dfsTraversal(){
		LinkedList<T> treeNodes = new LinkedList<>();
		LinkedList<NodoLF<T>> stack = new LinkedList<>();
		stack.addFirst(rootNode);
		while(!stack.isEmpty()){
			NodoLF<T> node=stack.removeFirst();
			treeNodes.add(node.getInfo());
			Iterator<NodoLF<T>> iterator = node.getChildren().descendingIterator();
			iterator.forEachRemaining(stack::addFirst);
		}
		return treeNodes;
	}
	
	/**
	 * Restituire la lista delle informazioni dei nodi dell’albero visitato in ampiezza
	 * @return LinkedList<T> treeNodes
	 */
	public LinkedList<T> bfsTraversal(){
		LinkedList<T> treeNodes = new LinkedList<>();
		LinkedList<NodoLF<T>> queue = new LinkedList<>();
		queue.addLast(rootNode);
		while(!queue.isEmpty()){
			NodoLF<T> node = queue.removeFirst();
			treeNodes.add(node.getInfo());
			node.getChildren().forEach(queue::addLast);
		}
		return treeNodes;
	}
	
	/**
	 * Converte le informazioni dei nodi visitati(ANTICIPATA), e le concate in unica stringa
	 * @return String
	 */
	@Override
	public String toString() {
		String[] nodes = new String[]{""};
		preOrderVisit(rootNode, nodes);
		return nodes[0];
	}
	
	/**
	 * Method helper del toString per visitare i nodi ricorsivamente
	 * @param node		Nodo di partenza
	 * @param nodes		Contiene la stringa dei nodi visitati
	 */
	private void preOrderVisit(NodoLF<T> node, String[] nodes) {
		if(node==null) {
			return;
		} else {
			nodes[0] += node.toString()+"[";			
			node.getChildren().forEach(n -> {
				preOrderVisit(n, nodes);
				if(node.getChildren().indexOf(n) < node.getChildren().size()-1)
					nodes[0] += ",";
			});
			nodes[0] += "]";
		}
	}
}
