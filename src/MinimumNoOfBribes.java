
/*
Hackerrank https://www.hackerrank.com/challenges/new-year-chaos/forum/comments/143969
 */
public class MinimumNoOfBribes {


    /*
    bubblesort solution but getting timeout
     */
    public static int findMinimumBribes(int[] q) {
        int count = 0;
        int totalBribes = 0;
        for(int i = 0; i < q.length -1; i++) {
            for(int j=i+1; j < q.length; j++) {
                if (q[i] > q[j]) {
                    count++;
                    totalBribes++;
                }
                if (count > 2) {
                    return -1;
                }
            }
            if (count == 0) {
                break;
            }
            count = 0;
        }
        return totalBribes;
    }


    /*
alternative solution that didn't timeout with huge number of input
 */
    static void minimumBribes(int[] q) {
        int bribe = 0;
        boolean chaotic = false;
        for(int i = 0; i < q.length; i++)
        {
            if(q[i]-(i+1) > 2)
            {
                chaotic = true;
                break;
            }
            for (int j = Math.max(0, q[i]-2); j < i; j++)
                if (q[j] > q[i])
                    bribe++;
        }
        if(chaotic)
            System.out.println("Too chaotic");
        else
            System.out.println(bribe);

    }


    public static void main(String[] args) {
        int[] input = {2,1,5,3,4};

        int noOfBribes = findMinimumBribes(input);

        if (noOfBribes == -1) {
            System.out.println("Too chaotic");
        } else {
            System.out.println("It takes " + noOfBribes + " bribes");
        }
    }

}
