public class ValidSquare {

    public static void main(String[] args) {
        System.out.println("Is this a valid square? " + validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));



    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        long[] lengths = {distance(p1,p2), distance(p1,p3), distance(p1,p4), distance(p2,p3), distance(p2,p4), distance(p3,p4)};

        long max = 0, maxCounter = 0, nonmax = 0;
        for (long length: lengths) {
            System.out.println("This is the length " + length);
            max = Math.max(length,max);
        }
        for (long length: lengths) {
            if (length == max) {
                maxCounter++;
            } else {
                nonmax = length;
            }
        }

        if (maxCounter != 2) {
            return false;
        }

        for(long length : lengths) {
            if (length != max && length != nonmax) {
                return false;
            }
        }

        return true;
    }

    public static long distance(int[] p1, int[] p2) {

        return (long) Math.pow(p1[0] - p2[0],2) + (long) Math.pow(p1[1] - p2[1],2);

    }
}
