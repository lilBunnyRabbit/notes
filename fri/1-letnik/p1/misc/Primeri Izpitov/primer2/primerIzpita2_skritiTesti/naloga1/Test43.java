public class Test43 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][][] g = {
            {
                {F, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
            {
                {T, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
            {
                {F, F},
                {F, F},
            } ,
        };
        System.out.println(Park.najboljProstoNadstropje(g));
    }
}