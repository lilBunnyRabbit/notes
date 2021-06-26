import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DN09_63180207 {

    private static LinkedList<String> lines = new LinkedList<>();
    private static LinkedList<Instruction> instructions = new LinkedList<>();
    private static Stack<Instruction> undoStack = new Stack<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cost = 0;

        StringBuilder b = new StringBuilder();

        String[] line;
        Instruction i;

        loop: while (true){
            line = s.nextLine().split(" ");

            switch(line[0]){
                case "#":
                    i = new Append(line);
                    undoStack.empty();
                    break;
                case "+":
                    i = new Insert(line);
                    undoStack.empty();
                    break;
                case "-":
                    i = new Delete(line);
                    undoStack.empty();
                    break;
                case "<":
                    i = instructions.removeLast().reverse();
                    undoStack.push(i);
                    break;
                case ">":
                    i = undoStack.pop().reverse();
                    break;
                default:
                    break loop;
            }

            if(!line[0].equals("<")) instructions.addLast(i);

            cost += i.execute();

            if (b.length() != 0) b.append(System.lineSeparator());
            b.append(String.valueOf(cost)).append(" | ").append(String.join("/", lines));
        }

        System.out.println(b.toString());
    }

    public interface Instruction {

        Instruction reverse();

        int execute();

    }

    public static class Insert implements Instruction {

        private int index;
        private String text;

        Insert(String[] args) {
            index = Integer.parseInt(args[1]);
            text = args[2];
        }

        Insert(int index, String text) {
            this.index = index;
            this.text = text;
        }

        @Override
        public Instruction reverse() {
            return new Delete(index);
        }

        @Override
        public int execute() {
            int cost = 2*(lines.size()-index)+text.length();
            lines.add(index, text);
            return cost;
        }

    }

    public static class Append extends Insert{

        Append(String[] args) {
            super(lines.size(), args[1]);
        }
        
    }

    public static class Delete implements Instruction {

        private int index;
        private String deleted = null;

        Delete(String[] args) {
            index = Integer.parseInt(args[1]);
        }

        Delete(int index) {
            this.index = index;
        }

        @Override
        public Instruction reverse() {
            return new Insert(index, deleted);
        }

        @Override
        public int execute() {
            deleted = lines.remove(index);
            return 3*(lines.size()-index)+2*deleted.length();
        }
    }

}