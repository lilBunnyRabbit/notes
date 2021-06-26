public class Test30 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][][] g = {
            {
                {T},
                {T},
                {T},
                {T},
            } ,
            {
                {T},
                {T},
                {F},
                {F},
            } ,
            {
                {F},
                {F},
                {T},
                {T},
            } ,
            {
                {F},
                {T},
                {F},
                {F},
            } ,
            {
                {T},
                {F},
                {F},
                {F},
            } ,
        };
        System.out.println(Park.steviloMest(g));
    }
}
