import java.util.HashSet;
import java.util.Scanner;

// create our (x, y) points that add up to our target
class Point {
    int x, y;

    // our constructor
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Main {

    // this will allow us to find the two sums in O(n) time with sorted array
    static Point getCandidatePair(int A[], int target) {

        // our indexes for our array at the beginning and end
        int left = 0;
        int right = A.length - 1;

        // check if we've found a match
        boolean found = false;

        // while the right index doesn't reach the beginning of the array and the left
        // side doesn't reach the end of the array
        while (right > -1 && left < A.length) {

            // if the sum of the left and right elements in the array are less than the
            // target, increase the left index
            if (A[left] + A[right] < target) {
                left++;
            }

            // if the sum is greater than the target, decrease the right index
            else if (A[left] + A[right] > target) {
                right--;
            }

            // otherwise we found our point and we can break out of the loop
            else {
                found = true;
                break;
            }
        }

        // if we found a match, then return the points
        if (found) {
            Point point = new Point(A[left], A[right]);
            return point;
        } else { // means we didn't find a match
            // otherwise return (0, 0)
            Point point = new Point(0, 0);
            return point;
        }

    }

    // allow us to find the two sums in O(n) time with an unsorted array using a
    // hashset
    static Point getCandidatePairUnsorted(int A[], int target) {

        // create a hash set that could potentially have one of our points
        HashSet<Integer> hashSet = new HashSet<>();
        // once again check if we've found a pair
        boolean found = false;

        // our 2 points which we initalize to 0
        int point1 = 0;
        int point2 = 0;

        // loop through the array
        for (int i = 0; i < A.length; i++) {
            // the magic number (also just known as the complement of the number)
            int sum = target - A[i];

            // if our hashset has the magic number, then we know that it is the point we
            // need to add up to the target
            if (hashSet.contains(sum)) {
                // say we've found the pair and set x = the number we stopped on while looping
                // through the array and y = the magic number in our hashset
                found = true;
                point1 = A[i];
                point2 = sum;
                break;
            } else {
                // otherwise we keep adding to our hashset
                hashSet.add(A[i]);
            }
        }

        // if we've found our pair, make them points
        if (found) {
            Point point = new Point(point1, point2);
            return point;
        } else {
            // otherwise return (0, 0) meaning we didn't find a pair
            Point point = new Point(0, 0);
            return point;
        }

    }

    public static void main(String[] args) {

        // initalize our scanner
        Scanner scanner = new Scanner(System.in);

        // get the number of test cases we'll need
        int numQueries = scanner.nextInt();

        // initalize our variables
        int games[];
        int target;

        // for each test case...
        for (int i = 0; i < numQueries; i++) {
            // get whether or not we use the sorted method or unsorted method for finding
            // our pair
            int isSorted = scanner.nextInt();
            // get the number of games that we'll be adding to our array of games
            int numGames = scanner.nextInt();
            // make the array of games the correct size
            games = new int[numGames];
            // now for each game get each of points needed and add them to the games array
            for (int j = 0; j < numGames; j++) {
                int pointsForGame = scanner.nextInt();
                games[j] = pointsForGame;
            }
            // now we need to get our target
            target = scanner.nextInt();

            // if we specified that the array is not sorted, we'll use the hashset method
            if (isSorted == 0) {
                // get our pair
                Point point = getCandidatePairUnsorted(games, target);
                // if both points are 0 that means we couldn't find a pair so we print that out, otherwise print out our pair values
                if (point.x == 0 && point.y == 0) {
                    System.out.println("Test case#" + (i + 1) + ": No way you can spend exactly " + target + " points.");
                } else {
                    System.out.println(
                            "Test case#" + (i + 1) + ": Spend " + target + " points by playing the games with "
                                    + Math.min(point.x, point.y)
                                    + " points and " + Math.max(point.x, point.y) + " points.");
                }
            }
            // otherwise use the two tracker method
            else if (isSorted == 1) {
                Point point = getCandidatePair(games, target);
                if (point.x == 0 && point.y == 0) {
                    System.out.println("Test Case#" + (i + 1) + ": No way you can spend exactly " + target + " points.");
                }
                System.out.println("Test case#" + (i + 1) + ": Spend " + target + " points by playing the games with "
                        + Math.min(point.x, point.y)
                        + " points and " + Math.max(point.x, point.y) + " points.");
            }
        }

    }
}