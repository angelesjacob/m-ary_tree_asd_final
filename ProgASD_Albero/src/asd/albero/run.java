/**
 * @author Jacob Angeles
 */

package asd.albero;

public class run {

	public static void main(String[] args) {
		
		System.out.println("Progetto di JACOB ANGELES [mat.7024541]");
		
		AlberoLF<String> tree	= new AlberoLF<>();
				
		/** Inserire la radice dell’albero speciﬁcando la sola informazione */
		NodoLF<String> claudia	= tree.setRootNode("Claudia");
				
		/** Inserire un nodo nell’albero speciﬁcando padre e informazione */
		NodoLF<String> marco	= tree.addNode(claudia,	"Marco");
		NodoLF<String> silvia	= tree.addNode(marco,	"Silvia");
		NodoLF<String> ugo		= tree.addNode(marco,	"Ugo");		
		NodoLF<String> luca		= tree.addNode(claudia,	"Luca");		
		NodoLF<String> giulia	= tree.addNode(claudia,	"Giulia");
		NodoLF<String> andrea	= tree.addNode(giulia,	"Andrea");
		NodoLF<String> carlo	= tree.addNode(andrea,	"Carlo");
		NodoLF<String> gianna	= tree.addNode(giulia,	"Gianna");
		
		/** Inserire una nuova radice nell’albero in maniera che la vecchia radice diventi ﬁglia di quella nuova */
//		NodoLF<String> jacob	= tree.setRootNode("Jacob");
		
		/** Restituire la radice dell’albero */
		System.out.println("Radice dell'albero	: "+tree.getRootNode().toString());
		
		/** Restituire l’altezza dell’albero */
		System.out.println("Altezza dell'albero	: "+tree.getHeight());
		
		/** Restituire il numero dei nodi presenti nell’albero */
		System.out.println("Nodi totali		: "+tree.countNodes());
				
		/** Restituire il livello di un nodo */
		System.out.println("Livello di "+andrea.toString()+"	: "+andrea.getDepth());
		
		/** Restituire l’informazione di un nodo */
		System.out.println("Informazione di "+gianna.toString()+"	: "+gianna.getInfo());
		
		/** Cambiare l’informazione di un nodo */
//		luca.setInfo("Lucas");
		
		/** Restituire il padre di un nodo */
		System.out.println("Padre di "+ugo.toString()+"		: "+ugo.getParentNode());
				
		/** Restituire la lista delle informazioni dei nodi dell’albero visitato in profondita */
//		System.out.println("DFS traversal:");		
//		tree.dfsTraversal().forEach(System.out::println);
		
		/** Restituire la lista delle informazioni dei nodi dell’albero visitato in ampiezza */
//		System.out.println("BFS traversal:");		
//		tree.bfsTraversal().forEach(System.out::println);
		
		/** Restituire il numero delle foglie dell’albero */
		System.out.println("Foglie dell'albero	: "+tree.getLeafNodes());
		
		/** Restituisca una stringa che sia la rappresentazione dell’albero */
		System.out.println(tree.toString());
	}
}
