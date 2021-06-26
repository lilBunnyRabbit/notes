package excercises.e4.vrsta;

class QueueElement
{
	Object element;
	QueueElement next;

	QueueElement()
	{
		element = null;
		next = null;
	}
}

class Queue
{
	//QueueElement -> QueueElement -> QueueElement -> ... -> QueueElement
	//     ^                                                       ^
	//     |                                                       |  
	//    front                                                   rear
	//
	// nove elemente dodajamo na konec vrste (kazalec rear)
	// elemente brisemo na zacetku vrste (kazalec front)
	
	private QueueElement front;
	private QueueElement rear;
	
	public Queue()
	{
		makenull();
	}
	
	public void makenull()
	{
		front = null;
		rear = null;
	}
	
	public boolean empty()
	{
		return (front == null);
	}
	
	public Object front()
	{
		// funkcija vrne zacetni element vrste (nanj kaze kazalec front).
		// Elementa NE ODSTRANIMO iz vrste!
		
		return this.front.element;
	}
	
	public void enqueue(Object obj)
	{
		// funkcija doda element na konec vrste (nanj kaze kazalec rear)
		QueueElement new_element = new QueueElement();
		new_element.element = obj;

		if (this.front == null) this.front = new_element;
		if (this.rear == null) this.rear = new_element;
		else {
			QueueElement temp = this.rear;
			temp.next = new_element;
			this.rear = new_element;
		}
	}
	
	public void dequeue()
	{
		// funkcija odstrani zacetni element vrste (nanj kaze kazalec front)
		if (this.front == null) return;
		if (this.front.next == null) this.front = null;
		else this.front = this.front.next;
	}
}
