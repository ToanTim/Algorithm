/*
difer string is one version of origin string, add one word to difer and find that added word
*/
class FindWordBetween2String {
    // not shuffle
    static char solution1(char[] origin, char[] difer) {
        char word = ' ';
        int count = 0;
        for (char a : origin) {
            if (a != difer[count]) {
                word = difer[count];
                break;
            }
            count++;
        }

        if (word == ' ') {
            word = difer[difer.length - 1];
        }
        return word;
    }

    // shuffled
    static char solution2(char[] origin, char[] difer) {
        char word = ' ';
        int countOrigin = 0;
        int countDifer = 0;

        for (char a : origin) {
            for (char b : difer) {

                if (b == a) {
                    difer[countDifer] = origin[countOrigin] = ' ';
                    countDifer = 0;
                    break;
                }
                countDifer++;
            }
            countOrigin++;
        }

        for (char c : difer) {
            if (c != ' ') {
                word = c;
            }
        }

        return word;
    }

    // shuffled, XOR concept
    static char solution3(char[] origin, char[] difer) {
        char word = 'c';
        char c = 0;
        for (char cs : origin)
            c ^= cs;
        System.out.println(c);
        return word;
    }

    public static void main(String[] args) {
        String origin = "abc";
        String difer = "bacd";

        char word = solution3(origin.toCharArray(), difer.toCharArray());
        System.out.println(word);
    }
}
