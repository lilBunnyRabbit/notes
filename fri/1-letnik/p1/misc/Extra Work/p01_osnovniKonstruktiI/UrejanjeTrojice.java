import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class UrejanjeTrojice{
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<Integer>();

        list.add(sc.nextInt());
        list.add(sc.nextInt());
        list.add(sc.nextInt());

        Collections.sort(list);


        System.out.print(list.get(0) + " " + list.get(1) + " " + list.get(2));
	}
}