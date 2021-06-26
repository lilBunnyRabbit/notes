package excercises.e2;

public class Izrazi {

	// funkcija v infiksni obliki izpise prefiksni izraz, ki ga opazujemo v polju 'niz' od mesta 'index' naprej
	// rezultat funkcije je polozaj prvega neizpisanega elementa
	public static int infiksniIzpis(Object[] niz, int index) throws Exception
	{
		// najprej preverimo, ali 'index' kaze na obstojec element niza
		if (index < niz.length)
		{
			// ce opazovani element predstavlja operator
			if (niz[index] instanceof String)
			{
				System.out.print("(");
				
				// za operatorjem sledi prvi operand, ki je prav tako v prefiksni obliki
				// izpisimo ga (REKURZIJA)
				int out_index = infiksniIzpis(niz, index + 1);

				
				// izpisemo operator
				System.out.print(niz[index]);
				
				// za prvim operandom sledi drugi operand, ki je prav tako v prefiksni obliki
				// izpisimo ga (REKURZIJA)
				out_index = infiksniIzpis(niz, out_index);
				
				System.out.print(")");
				
				// vrnemo polozaj prvega neizpisanega elementa
				return out_index;
			}
			else
			{
				// opazovani element je operand
				// izpisemo ga
				System.out.print(niz[index]);
				// vrnemo polozaj prvega neizpisanega elementa
				return index + 1;
			}
		}
			
		// elementa ni, izraz je podan v neveljavni obliki
		throw new Exception("Napacen vhod!");
	}
	
	public static void izpis(Object[] vhod) {
		System.out.print("Infiksna oblika prefiksnega izraza ");
		for (int i=0; i<vhod.length; i++)
			System.out.print(vhod[i] + " ");
		
		System.out.print("je ");
		
		try
		{
			// izpisemo izraz v infiksni obliki
			infiksniIzpis(vhod,0);
			
			System.out.println();
		}
		catch (Exception ex)
		{
			// ujeli smo izjemo - podan izraz je v nepravilni obliki
			System.err.println(ex);
		}
	}
	
	public static void main(String[] args) {
		
		// zgradimo izraz v prefiksni obliki (gradniki izraza so podani kot elementi polja)
				Object[] vhod1 = new Object[5];
				
				vhod1[0] = "*"; // operatorji so podani v obliki stringov
				vhod1[1] = new Integer(2); // operandi so podani kot cela stevila
				vhod1[2] = "+";
				vhod1[3] = new Integer(4);
				vhod1[4] = new Integer(5);
				
				
				
				Object[] vhod2 = new Object[7];
				
				vhod2[0] = "*";
				vhod2[1] = "*";
				vhod2[2] = new Integer(2);
				vhod2[3] = new Integer(3);
				vhod2[4] = "*";
				vhod2[5] = new Integer(4);
				vhod2[6] = new Integer(5);
				
				
				izpis(vhod1);
				izpis(vhod2);		
	}

}
