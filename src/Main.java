import java.math.BigInteger;

public class Main {
    private static String[] mPrimeArguments = {"1000000000100011"};
    private static String[] mPIArguments = {"2", "10000000000"};
    private static BigInteger mPrimeNumber;
    private static long time;

    public static void main(String args[]) {
        /*mPrimeNumber = new BigInteger("1000000000100011");
        System.out.println();
        time = System.currentTimeMillis();
        if (sequentialPrimeChecker(mPrimeNumber))
            System.out.println(String.valueOf(mPrimeNumber) + " Is a Prime, Sequential Processing Time: "
                    + String.valueOf(System.currentTimeMillis() - time) + "\n");
        else
            System.out.println(String.valueOf(mPrimeNumber) + " Is Not a Prime, Sequential Processing Time: "
                    + String.valueOf(System.currentTimeMillis() - time) + "\n");

        time = System.currentTimeMillis();
        parallelPrimeChecker();
        System.out.println("Parallel Processing Time: " + String.valueOf(System.currentTimeMillis() - time));
*/
        time = System.currentTimeMillis();
        parallelPICalculator();
        System.out.println("Parallel Processing Time: " + String.valueOf(System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sequentialPICalculator();
        System.out.println("Sequential Processing Time: " + String.valueOf(System.currentTimeMillis() - time));
    }

    private static boolean sequentialPrimeChecker(BigInteger number) {
        //check if even
        BigInteger two = new BigInteger("2");

        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        //find divisor if any from 3 to 'number'
        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) {
            if (BigInteger.ZERO.equals(number.mod(i)))
                return false;
        }
        return true;
    }

    private static void parallelPrimeChecker() {
        ParallelJava2Primes parallelJava2Primes = new ParallelJava2Primes();
        try {
            parallelJava2Primes.main(mPrimeArguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parallelPICalculator() {
        ParallelJava2PI parallelJava2PI = new ParallelJava2PI();
        try {
            parallelJava2PI.main(mPIArguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sequentialPICalculator() {
        SequentialPI sequentialPI = new SequentialPI();
        try {
            sequentialPI.main(mPIArguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
