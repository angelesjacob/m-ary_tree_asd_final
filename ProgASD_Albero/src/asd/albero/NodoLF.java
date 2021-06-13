/**
 * @author Jacob Angeles
 */

package asd.albero;

import java.util.LinkedList;

public class NodoLF<T> {
	private T info;
	private int depth;
	private NodoLF<T> parentNode;	
	private LinkedList<NodoLF<T>> listChildren;
	
	/**
	 * Crea un nodo, impostando il suo informazione
	 * @param info
	 */
	public NodoLF(T info) {
		this.info = info;
		listChildren = new LinkedList<NodoLF<T>>();
	}
	
	/**
	 * Restituisce il padre del nodo
	 * @return NodoLF<T>
	 */
	public NodoLF<T> getParentNode(){
		return parentNode;
	}
	
	/**
	 * Imposta il padre del nodo
	 * @param parentNode
	 */
	public void setParentNode(NodoLF<T> parentNode) {		
		this.parentNode = parentNode;
	}
	
	/**
	 * Restituisce l'informazione del nodo
	 * @return Object T
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Setta l'informazione del nodo
	 * @param info
	 */
	public void setInfo(T info) {
		this.info = info;
	}
	
	/**
	 * Aggiunge il riferimento di un figlio nella lista dei puntatori del nodo
	 * @param childNode
	 */
	public void addChildNode(NodoLF<T> childNode) {
		listChildren.add(childNode);
	}
	
	/**
	 * Restituisce la lista dei puntatori figli del nodo
	 * @return LinkedList<NodoLF<T>>
	 */
	public LinkedList<NodoLF<T>> getChildren() {
		return listChildren;
	}
	
	/**
	 * Imposta il valore di profondita/livello del nodo
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Restituisce il livello/profondita del nodo
	 * @return int
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Restituisce il grado del nodo
	 * @return int
	 */
	public int getDegree(){
		return listChildren.size();
	}
	
	/**
	 * Converte in stringa l'informazione del nodo
	 * @return String
	 */
	@Override
	public String toString() {
		return info.toString();
	}	
}
