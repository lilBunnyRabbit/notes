package excercises.e3;

public class LinkedList
{
	protected LinkedListElement first;
	protected LinkedListElement last;
	
	LinkedList()
	{
		makenull();
	}
	
	//Funkcija makenull inicializira seznam
	public void makenull()
	{
		//drzimo se implementacije iz knjige:
		//po dogovoru je na zacetku glava seznama (header)
		first = new LinkedListElement(null, null);
		last = null;
	}
	
	//Funkcija addLast doda nov element na konec seznama
	public void addLast(Object obj)
	{
		//najprej naredimo nov element
		
		//ustrezno ga povezemo s koncem verige obstojecih elementov
		
		//po potrebi posodobimo kazalca "first" in "last"
		LinkedListElement element = new LinkedListElement(obj, null);
		if(this.last == null) {
			this.first.next = element;
			this.last = this.first;
		} else {
			this.last.next.next = element;
			this.last = last.next;
		}
	}
	
	//Funkcija write izpise elemente seznama
	public void write()
	{
		//zacnemo pri elementu za glavo seznama
		//sprehodimo se po elementih do konca seznama
		//in izpisemo vrednost vsakega elementa
		
		//za kontrolo lahko izpisemo tudi vrednosti kazalcev "first" in "last"
		LinkedListElement element = this.first.next;
		while (element != null) {
			System.out.print(element.element);
			element = element.next;
			if(element == null) System.out.println();
			else System.out.print(", ");
		}
	}
	
	//Funkcija addFirst doda nov element na prvo mesto v seznamu (takoj za glavo seznama)
	void addFirst(Object obj)
	{
		//najprej naredimo nov element
		LinkedListElement element = new LinkedListElement(obj, this.first.next);
		this.first.next = element;

		if(this.last == null) {
			this.last = this.first;
		} else {
			this.last = element;
		}
		
		//ustrezno ga povezemo z glavo seznama
		
		//po potrebi posodobimo kazalca "first" in "last"
	}
	
	//Funkcija length() vrne dolzino seznama (pri tem ne uposteva glave seznama)
	int length()
	{
		int counter = 0;
		LinkedListElement element = this.first.next;

		while(element != null) {
			counter++;
			element = element.next;
		}
		return counter;
	}
	
	//Funkcija lengthRek() klice rekurzivno funkcijo za izracun dolzine seznama
	int lengthRek()
	{
		// pomagajte si z dodatno funkcijo int lengthRek(LinkedListElement el), ki izracuna
		// dolzino seznama za opazovanim elementom ter pristeje 1
		
		return lengthRek(this.first.next);
	}

	int lengthRek(LinkedListElement element) {
		if(element == null) return 0;
		return lengthRek(element.next) + 1;
	}
	
	//Funkcija insertNth vstavi element na n-to mesto v seznamu
	//(prvi element seznama, ki se nahaja takoj za glavo seznama, je na indeksu 0)
	boolean insertNth(Object obj, int n)
	{
		//zacnemo pri glavi seznama
		LinkedListElement element = this.first;
		for (int i = 0; i < n; i++) {
			element = element.next;
			if(element == null) return false;
		}

		LinkedListElement new_element = new LinkedListElement(obj, element.next);
		element.next = new_element;

		if(this.last == null) this.last = this.first;
		else if(this.last == element) this.last = this.last.next;
		else if(this.last.next == element) this.last = element;

		return true;
		
		//sprehodimo se po elementih dokler ne pridemo do zeljenega mesta
		
		// ce je polozaj veljaven
		//   naredimo nov element
		//   ustrezno ga povezemo v verigo elementov
		//   po potrebi posodobimo kazalec "last"
		//   vrnemo true
		// sicer
		//   vrnemo false
	}
	
	//Funkcija deleteNth izbrise element na n-tem mestu v seznamu
	//(prvi element seznama, ki se nahaja takoj za glavo seznama, je na indeksu 0)
	boolean deleteNth(int n)
	{
		//zacnemo pri glavi seznama
		LinkedListElement element = this.first;
		LinkedListElement previus = null;

		for (int i = 0; i < n; i++) {
			previus = element;
			element = element.next;
			if(element == null || element.next == null) return false;
		}

		if(this.last == element.next) this.last = element;
		else if (this.last == element) this.last = previus;

		element.next = element.next.next;
		return true;
		
		//sprehodimo se po elementih dokler ne pridemo do zeljenega mesta
		
		// ce je polozaj veljaven
		//   ustrezno prevezemo elemente seznama tako, da ciljni element izlocimo iz verige
		//   po potrebi posodobimo kazalec "last"
		//   vrnemo true
		// sicer
		//   vrnemo false
	}
	
	//Funkcija reverse obrne vrstni red elementov v seznamu (pri tem ignorira glavo seznama)
	void reverse()
	{
		if(this.first.next == null || this.first.next.next == null) return;

		//ne pozabimo na posodobitev kazalca "last"!
		LinkedListElement current = null;
		LinkedListElement temp = null;

		current = this.first.next.next;
		this.first.next.next = null;
		this.last = current;

		while(current != null) {
			temp = current.next;
			current.next = this.first.next;
			this.first.next = current;
			current = temp;
		}
	}
	
	//Funkcija reverseRek klice rekurzivno funkcijo, ki obrne vrstni red elementov v seznamu
	void reverseRek()
	{
		// pomagajte si z dodatno funkcijo void reverseRek(LinkedListElement el), ki
		// obrne del seznama za opazovanim elementom, nato ta element doda na konec (obrnjenega) seznama
		reverseRek(this.first.next);
	}
	
	void reverseRek(LinkedListElement el) {
		if(el == null) return;
		if(el.next == null) {
			this.first.next = el;
			this.last = this.first;
		} else {
			reverseRek(el.next);
			el.next = null;
			this.last = this.last.next;
			this.last.next = el;
		}
	}

	//Funkcija removeDuplicates odstrani ponavljajoce se elemente v seznamu
	void removeDuplicates()
	{
		//ne pozabimo na posodobitev kazalca "last"!
		LinkedListElement current = this.first.next;

		while(current != null) {
			LinkedListElement temp = current;
			
			while (temp.next != null) {
				if (temp.next.element.equals(current.element)) temp.next = temp.next.next;	
				else temp = temp.next;
			}
	
			current = current.next;
		}
		
		this.last = null;
		current = this.first;
		while(current.next != null) {
			if (current.next.next == null) {
				last = current;
				break;
			}
			else current = current.next;
		}
	}
}
