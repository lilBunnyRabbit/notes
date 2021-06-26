import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Test{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(9);
        list.add(7);
        list.add(6);
        list.add(2);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(list);
            System.out.println(list.get(list.size() - i));
            if(list.get(list.size() - i) <= 7){
                list.remove(list.size() - i);
                list2.remove(list.size() - i);
                i--;
            }else{
                list.add(7);
                list2.add(4);
                break;
            }
        }
        
        System.out.println(list);
    }
}