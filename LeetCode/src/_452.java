import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class _452 {
    public static void main(String[] args) {

    }
}

class Solution_452 {

    //region version 1
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        for (int i=0;i<points.length;i++){

        }
        return 0;
    }
    //endregion

}
