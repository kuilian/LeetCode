package class06;

/**
 * @Date 21:14 2022/8/3
 * @Param
 * @return
 * @Description: 堆
 */
public class Code02_Heap {
    //    大根堆
    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }


        // 新加进来的数，现在停在了index位置，请依次往上移动，
        // 移动到0位置，或者干不掉自己的父亲了，停！
        private void heapInsert(int[] arr, int index) {
            //出去有两个条件 index位置的值小于他父节点的值 index == 0 时 两边都是0也会出去
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        // 从index位置，往下看，不断的下沉
        // 停：较大的孩子都不再比index位置的数大；已经没孩子了
        private void heapify(int[] arr, int index, int heapSize) {
            int left = (index * 2) + 1;
            while (left < heapSize) //如果有左孩子  可能有右孩子 也可能没有
            {   //两个子结点最大值的位置
                int largest = (left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left;
                //最大值跟index的值比较 如果大于index 则他两交换
                largest = arr[largest] > arr[index] ? largest : index;
//                int max  = arr[largest] > arr[index] ? largest : index;
//                if (max == index)
                if (largest == index) {
                    break;
                }
                swap(arr, largest, index);
                left = (index * 2) + 1;

            }
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

    }

}