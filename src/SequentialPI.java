import edu.rit.util.Random;

import java.text.DecimalFormat;

public class SequentialPI {
    private long mRandomLimit;          //Received random value limit
    private long mNumberOfPoints;       //Received number of points that should be created
    private Random mRandom;             //Random object
    private long count;                 //Number of points within the unit circle

    public void main(String[] args) {

        mRandomLimit = Long.parseLong(args[0]);
        mNumberOfPoints = Long.parseLong(args[1]);
        mRandom = new Random(mRandomLimit);
        count = 0;              //n random points
        for (long i = 0; i < mNumberOfPoints; i++) {
            double x = mRandom.nextDouble();
            double y = mRandom.nextDouble();
            if (x * x + y * y <= 1.0)
                count++;
        }

        System.out.print("pi = 4*" + String.valueOf(count) + "/" +
                String.valueOf(mNumberOfPoints) + " = " +
                String.valueOf(new DecimalFormat("0.#####").format(4.0 * count / mNumberOfPoints)) + " ");
    }

}
