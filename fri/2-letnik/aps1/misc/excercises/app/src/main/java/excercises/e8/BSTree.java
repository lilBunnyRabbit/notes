package excercises.e8;

class BSTNode {
	Comparable key;
	BSTNode left;
	BSTNode right;
	
	public BSTNode(Comparable k) {
		key = k;
		left = null;
		right = null;
	}
}

class BSTree {
	BSTNode root;
	
	public BSTree() {
		makenull();
	}
	
	// Funkcija naredi prazno drevo
	void makenull() {
		root = null;
	}
	
	// Rekurzivna funkcija za vstavljanje elementa v list drevesa
	private BSTNode insertRek(BSTNode node, Comparable k)
	{
		if (node == null)
			node = new BSTNode(k);
		else if (k.compareTo(node.key) < 0)
			node.left = insertRek(node.left, k);
		else if (k.compareTo(node.key) > 0)
			node.right = insertRek(node.right, k);
		else
			;//element je ze v drevesu, ne naredimo nicesar
		return node;
	}
	
	// Rekurzivna funkcija za vstavljanje elementa v list drevesa
	public void insertRek(Comparable k) {
		root = insertRek(root, k);
	}
	
	// Rekurzivna funkcija za izpis poddrevesa s podanim korenom
	private void write(BSTNode node) {
		if (node != null) {
			System.out.print("(");
			write(node.left);
			System.out.print(", " + node.key + ", ");
			write(node.right);
			System.out.print(")");
		}
		else
			System.out.print("null");
	}
	
	// Funkcija za izpis drevesa
	public void write() {
		write(root);
		System.out.println();
	}
	
	// Rekurzivna funkcija, ki preveri, ali se podani element nahaja v podanem poddrevesu
	private boolean memberRek(BSTNode node, Comparable k) {
		if (node == null)
			return false;
		else if (k.compareTo(node.key) == 0)
			return true;
		else if (k.compareTo(node.key) < 0)
			return memberRek(node.left, k);
		else
			return memberRek(node.right, k);
	}
	
	// Funkcija preveri, ali se podani element nahaja v drevesu
	public boolean memberRek(Comparable k) {
		return memberRek(root, k);
	}
	
	
	//Samostojno delo

	// Funkcija, ki poreze liste drevesa
	public void prune()
	{
		// VSTAVITE SVOJO KODO
	}
	
	// Funkcija, ki vrne visino drevesa
	public int height() {
		// VSTAVITE SVOJO KODO
		
		return 0;
	}
	
	// Funkcija, ki preveri, ali je drevo uravnoveseno
	public boolean isBalanced() {
		// VSTAVITE SVOJO KODO
		
		return false;
	}
			
	// Funkcija, ki vrne stevilo elementov v drevesu
	public int numOfElements() {
		// VSTAVITE SVOJO KODO
		
		return 0;
	}
	
	// Iterativna funkcija za vstavljanje elementa v list drevesa
	public void insertIter(Comparable k) {
		// VSTAVITE SVOJO KODO
	}
	
	// Iterativna funkcija, ki preveri, ali se podani element nahaja v drevesu
	public boolean memberIter(Comparable k) {
		// VSTAVITE SVOJO KODO
		
		return false;
	}
	
	// Funkcija, ki izpise elemente drevesa v padajocem vrstnem redu
	public void descending() {
		// VSTAVITE SVOJO KODO
	}
	
	// Funkcija, ki vrne kazalec na element drevesa s prvo manjso vrednostjo kljuca od podane vrednosti
	public BSTNode predecessor(Comparable k) {
		// VSTAVITE SVOJO KODO
		
		return null;
	}
	
	// Funkcija, ki vrne kazalec na element drevesa s prvo vecjo vrednostjo kljuca od podane vrednosti
	public BSTNode successor(Comparable k) {
		// VSTAVITE SVOJO KODO
		
		return null;
	}
}	

