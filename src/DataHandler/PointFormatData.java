package DataHandler;

import java.util.ArrayList;
import java.util.Observer;

/**
 *
 *
 * @author yagaa
 * @version 1.1
 */
public interface PointFormatData {

    /**
     *
     */
    public Point generatePoint(int x);

    /**
     *
     */
    public void clearData();

    /**
     *
     *
     * @return
     */
    public double getMean();
}
