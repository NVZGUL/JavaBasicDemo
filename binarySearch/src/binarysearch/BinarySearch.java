package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch <T extends Number> {

    private List<T> arr;

    public BinarySearch(List<T> arr) {
        this.arr = arr;
    }

    public int getElementId (T el) {
        int low = 0;
        int high = arr.size();
        int mid;
        int res = -1;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr.get(mid).byteValue() == el.byteValue()) {
                res = mid;
                break;
            } else{
              if (arr.get(mid).byteValue() > el.byteValue()) {
                  high = mid;
              } else {
                  low = mid + 1;
              }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinarySearch<Integer> bs = new BinarySearch(Arrays.asList(0,1,2,32,44,54,64,74));
        System.out.println(bs.getElementId(new Integer(54)));
    }
}
