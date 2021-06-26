package excercises;


public class App {
    private static String[] input;

    public static void main(String[] args) {
        execute(args);
    }

    public static boolean execute(String[] args) {
        switch (args[0]) {
            case "1": return excercise1(args);
            case "2": return excercise2(args);
            case "3": return excercise3(args);
            case "4": return excercise4(args);
            case "5": return excercise5(args);
            case "8": return excercise8(args);
            default: return false;
        }
    }

    public static boolean excercise1(String[] args) {
        if(args.length < 2) {
            System.out.println("Missing second argument");
            return false;
        }

        switch (args[1]) {
            case "1":
                new excercises.e1.Binarni().main(args);
                break;
            case "2":
                new excercises.e1.Palindrom().main(args);
                break;
            case "3":
                new excercises.e1.Potenca().main(args);
                break;
            case "4":
                new excercises.e1.Sestevanje().main(args);
                break;
            case "5":
                new excercises.e1.VsotaElementov().main(args);
                break;
            default: return false;
        }
        return true;
    }

    public static boolean excercise2(String[] args) {
        if(args.length < 2) {
            System.out.println("Missing second argument");
            return false;
        }

        switch (args[1]) {
            case "1":
                new excercises.e2.Izrazi().main(args);
                break;
            case "2":
                new excercises.e2.Labirint().main(args);
                break;
            case "3":
                new excercises.e2.Oklepaji().main(args);
                break;
            case "4":
                new excercises.e2.Sudoku().main(args);
                break;
            case "5":
                new excercises.e2.Znesek().main(args);
                break;
            default: return false;
        }
        return true;
    }

    public static boolean excercise3(String[] args) {
        new excercises.e3.GlavniProgram().main(args);
        return true;
    }

    public static boolean excercise4(String[] args) {
        if(args.length < 2) {
            System.out.println("Missing second argument");
            return false;
        }

        switch (args[1]) {
            case "1":
                new excercises.e4.vrsta.NajkrajsaPot().main(args);
                break;
            case "2":
                new excercises.e4.sklad.Postfix().main(args);
                break;
            default: return false;
        }
        return true;
    }

    public static boolean excercise5(String[] args) {
        new excercises.e5.GlavniProgram().main(args);
        return true;
    }

    public static boolean excercise8(String[] args) {
        new excercises.e8.GlavniProgram().main(args);
        return true;
    }
}
