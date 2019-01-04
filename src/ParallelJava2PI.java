import edu.rit.pj2.LongLoop;
import edu.rit.pj2.Task;
import edu.rit.pj2.vbl.LongVbl;
import edu.rit.util.Random;

import java.text.DecimalFormat;

public class ParallelJava2PI extends Task {
    private long mRandomLimit;          //Received random value limit
    private long mNumberOfPoints;       //Received number of points that should be created
    private LongVbl count;

    public void main(String[] args) {

        mRandomLimit = Long.parseLong(args[0]);
        mNumberOfPoints = Long.parseLong(args[1]);
        count = new LongVbl.Sum(0);
        parallelFor(0, mNumberOfPoints - 1).exec(new LongLoop() {
            Random random;
            LongVbl threadCount;

            public void start() {
                random = new Random(mRandomLimit + rank());
                threadCount = threadLocal(count);
            }

            public void run(long i) {
                double x = random.nextDouble();
                double y = random.nextDouble();
                if (x * x + y * y <= 1.0)
                    threadCount.item++;
            }
        });

        System.out.print("pi = 4*" + String.valueOf(count.item) + "/" +
                String.valueOf(mNumberOfPoints) + " = " +
                String.valueOf(new DecimalFormat("0.#####").format(4.0 * count.item / mNumberOfPoints)) + " ");
    }

}
