package excercises.e4.sklad;

class StackElement
{
	Object element;
	StackElement next;

	StackElement()
	{
		element = null;
		next = null;
	}
}

class Stack
{
	//StackElement -> StackElement -> StackElement -> ... -> StackElement
	//     ^
	//     |
	//    top                                                   
	//
	// elemente vedno dodajamo in brisemo na zacetku seznama (kazalec top)
	
	
	private StackElement top;
	
	public Stack()
	{
		makenull();
	}
	
	public void makenull()
	{
		top = null;
	}
	
	public boolean empty()
	{
		return (top == null);
	}
	
	public Object top()
	{
		// Funkcija vrne vrhnji element sklada (nanj kaze kazalec top).
		// Elementa NE ODSTRANIMO z vrha sklada!
		return this.top.element;
	}
	
	public void push(Object obj)
	{
		// Funkcija vstavi nov element na vrh sklada (oznacuje ga kazalec top)
		StackElement new_top = new StackElement();
		new_top.element = obj;

		if(this.top == null) this.top = new_top;
		else {
			StackElement old_top = this.top;
			this.top = new_top;
			this.top.next = old_top;
		}
	}
	
	public void pop()
	{
		// Funkcija odstrani element z vrha sklada (oznacuje ga kazalec top)
		if (this.top == null) return;
		if (this.top.next == null) this.top = null;
		else this.top = this.top.next;
	}
}
