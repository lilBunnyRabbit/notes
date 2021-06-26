package excercises.e5;

class SetElement
{
	Object element;
	SetElement next;

	SetElement()
	{
		element = null;
		next = null;
	}

	public void print() {
		System.out.println(this.element + " " + this.next);
	}
}

public class Set 
{
	private SetElement first;
	
	public Set() 
	{
		makenull();
	}
	
	public void makenull()
	{
		// kazalec first kaze na glavo seznama
		first = new SetElement();
	}
	
	public SetElement first()
	{
		return first;
	}
	
	public SetElement next(SetElement pos)
	{
		return pos.next;
	}
	
	public boolean overEnd(SetElement pos)
	{
		if (pos.next == null)
			return true;
		else
			return false;
	}
	
	public boolean empty()
	{
		return first.next == null;
	}
	
	public Object retrieve(SetElement pos)
	{
		return pos.next.element;
	}
	
	public void print()
	{
		System.out.print("{");
		for (SetElement iter = first(); !overEnd(iter); iter = next(iter))
		{
			System.out.print(retrieve(iter));
			if (!overEnd(next(iter)))
				System.out.print(", ");
		}
		System.out.println("}");
	}
	
	
	public void insert(Object obj) 
	{
		// nov element vstavimo samo, ce ga ni med obstojecimi elementi mnozice
		SetElement current = this.first;
		while(!this.overEnd(current)) {
			if(this.retrieve(current).equals(obj)) return;
			current = current.next;
		}

		current.next = new SetElement();
		current.next.element = obj;
	}
	
	public void delete(SetElement pos)
	{
		// odstranimo element na poziciji pos (pozor, zaradi glave seznama so polozaji zamaknjeni!)
		if(pos == null) return;
		if(!this.overEnd(pos)) pos.next = pos.next.next;
	}
	
	public SetElement locate(Object obj)
	{
		// sprehodimo se cez seznam elementov in preverimo enakost (uporabimo metodo equals)
		//
		// ce element najdemo, vrnemo njegov polozaj (pozor, zaradi glave seznama so polozaji zamaknjeni)
		// sicer vrnemo null
		System.out.println("Locating " + obj);
		SetElement current = this.first;
		while(!this.overEnd(current)) {
			if(this.retrieve(current).equals(obj)) return current;
			current = current.next;
		}
		
		return null;
	}
	
	public void union(Set a)
	{
		// brez podvajanja dodaj vse elemente iz mnozice a
		SetElement current = a.first;
		while(current != null) {
			if(current.element != null) this.insert(current.element);
			current = current.next;
		}
	}
	
	public void intersection(Set a)
	{
		// odstrani vse elemente, ki se ne nahajajo tudi v mnozici a
		SetElement current = a.first;
		while(current != null) {
			if(this.locate(current.element) == null) {
				a.delete(current);
				System.out.println("Deleted");
				current.print();
			} 
			current = current.next;

		}
	}
}
