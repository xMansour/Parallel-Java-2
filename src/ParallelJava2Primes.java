import edu.rit.pj2.Loop;
import edu.rit.pj2.Task;

public class ParallelJava2Primes extends Task {
    public void main
            (final String[] args)
            throws Exception {

        parallelFor(0, args.length - 1).exec(new Loop() {
            public void run(int i) {
                if (isPrime(Long.parseLong(args[i])))
                    System.out.print(String.valueOf(args[i]) + " Is a Prime, ");
                else
                    System.out.print(String.valueOf(args[i]) + " Is Not a Prime, ");
            }
        });
    }

    private static boolean isPrime(long x) {
        if (x % 2 == 0)
            return false;
        long p = 3;
        long psqr = p * p;
        while (psqr <= x) {
            if (x % p == 0)
                return false;
            p += 2;
            psqr = p * p;
        }
        return true;
    }

}
