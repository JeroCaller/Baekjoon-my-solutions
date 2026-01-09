import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        MaxHeap maxHeap = new MaxHeap(N);

        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write("0");
                } else {
                    bw.write(String.valueOf(maxHeap.poll()));
                }

                bw.newLine();
            } else {
                maxHeap.offer(num);
            }
        }
    }
}

class MaxHeap {
    private int[] heapArray;
    private int pointer = 0;

    public MaxHeap(int size) {
        this.heapArray = new int[size + 1];
    }

    public boolean isEmpty() {
        return pointer < 1;
    }

    public void offer(int value) {
        heapArray[++pointer] = value;
        int currentIdx = pointer;
        int parentIdx = currentIdx / 2;

        while (parentIdx >= 1) {
            if (heapArray[currentIdx] <= heapArray[parentIdx]) {
                break;
            }

            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx /= 2;
        }
    }

    public int poll() {
        if (pointer < 1) {
            return -1;
        }

        int result = heapArray[1];
        heapArray[1] = heapArray[pointer];
        heapArray[pointer--] = 0;
        int currentIdx = 1;

        while (isInRange(currentIdx)) {
            int leftChildIdx = currentIdx * 2;
            int rightChildIdx = currentIdx * 2 + 1;
            int largerValueChildIdx;

            if (!isInRange(leftChildIdx)) {
                break;
            }

            if (!isInRange(rightChildIdx)) {
                largerValueChildIdx = leftChildIdx;
            } else {
                largerValueChildIdx = (heapArray[leftChildIdx] > heapArray[rightChildIdx]) ?
                    leftChildIdx : rightChildIdx;
            }

            if (heapArray[currentIdx] >= heapArray[largerValueChildIdx]) {
                break;
            }

            swap(currentIdx, largerValueChildIdx);
            currentIdx = largerValueChildIdx;
        }

        return result;
    }

    private void swap(int index1, int index2) {
        int temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    private boolean isInRange(int index) {
        return index > 0 && index <= pointer;
    }
}