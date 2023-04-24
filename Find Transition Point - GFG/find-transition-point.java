//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int transitionPoint(int arr[], int n)
    {
int lb=0;
int ub=n-1;
  while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (arr[mid] == 0)
                lb = mid + 1;
            else if (arr[mid] == 1) {
                if (mid == 0
                    || (mid > 0 &&
                       arr[mid - 1] == 0))
                    return mid;
                ub = mid - 1;
            }
        }
        return -1;
    }
}