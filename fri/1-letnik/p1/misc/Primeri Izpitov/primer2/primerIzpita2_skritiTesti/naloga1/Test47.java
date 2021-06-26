public class Test47 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][][] g = {
            {
                {F, F, T, T, T, F, F},
                {T, F, F, F, F, F, F},
                {F, F, F, F, F, F, T},
                {F, F, T, F, F, T, T},
                {F, F, F, F, F, F, F},
                {T, T, T, T, F, F, F},
                {T, T, T, T, F, T, F},
            } ,
            {
                {T, T, F, F, F, F, F},
                {F, F, F, F, F, F, F},
                {F, F, T, T, F, T, F},
                {F, T, F, F, F, T, T},
                {F, F, F, F, F, F, F},
                {T, T, F, T, F, F, F},
                {F, F, F, F, F, T, T},
            } ,
            {
                {F, T, F, F, F, T, F},
                {F, T, F, F, T, F, F},
                {F, F, F, F, F, T, T},
                {F, F, F, F, F, F, F},
                {F, F, F, F, F, F, F},
                {F, F, F, F, F, T, F},
                {F, F, F, F, T, T, T},
            } ,
            {
                {F, F, T, T, F, T, F},
                {F, T, T, F, F, F, F},
                {T, F, F, F, F, F, F},
                {F, F, F, T, F, F, F},
                {F, T, F, F, F, F, F},
                {T, F, F, F, F, T, F},
                {T, F, T, T, F, T, T},
            } ,
            {
                {F, F, T, T, F, T, F},
                {F, T, F, F, F, T, F},
                {T, T, F, F, F, T, F},
                {F, T, F, T, T, F, T},
                {F, T, F, F, T, F, F},
                {F, F, T, F, T, F, F},
                {F, F, F, T, T, F, F},
            } ,
            {
                {T, F, F, T, T, F, T},
                {T, T, T, F, F, F, T},
                {F, F, F, F, T, T, F},
                {F, F, F, F, F, F, F},
                {F, T, T, F, F, T, T},
                {F, F, T, F, F, T, F},
                {F, F, F, T, F, F, F},
            } ,
            {
                {T, F, F, F, T, F, F},
                {F, F, F, F, F, F, F},
                {F, F, F, T, F, F, F},
                {F, T, F, F, F, F, T},
                {F, F, F, F, F, F, T},
                {F, F, F, T, F, T, F},
                {F, F, T, F, T, F, F},
            } ,
        };
        System.out.println(Park.najboljProstoNadstropje(g));
    }
}
