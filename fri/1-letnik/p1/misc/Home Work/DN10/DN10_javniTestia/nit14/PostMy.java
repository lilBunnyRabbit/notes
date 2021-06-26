import java.lang.StringBuilder;

class PostMy {
    public static void main(String[] args) {
        System.out.println(postFix());
    }

    public static String postFix() {
        StringBuilder post = new StringBuilder();
        String niz = "3+4*5-6*7/8";
        char zunanjiOp = 'n';
        char notranjiOp = 'n';
        for (int i = 0; i < niz.length(); i++) {
            char element = niz.charAt(i);
            if(Character.isDigit(element)) {
                post.append(element);


                if(notranjiOp != 'n') {
                    post.append(notranjiOp);
                    notranjiOp = 'n';
                }
                if(i + 1 == niz.length()) {
                    post.append(zunanjiOp);
                    return post.toString();
                }


            }else if(element == '+' || element == '-') {
                if(zunanjiOp != 'n') {
                    post.append(zunanjiOp);
                }
                zunanjiOp = element;
            }else if(element == '*' || element == '/') {
                notranjiOp = element;
            }


        }
        return post.toString();
    }
}