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
        Heap heap = new Heap(N);

        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (heap.isEmpty()) {
                    bw.write("0");
                } else {
                    bw.write(String.valueOf(heap.dequeue()));
                }

                bw.newLine();
            } else {
                heap.enqueue(num);
            }
        }
    }
}

class Heap {
    private int[] heapArray;  // one-based index
    private int pointer = 0;

    public Heap(int size) {
        this.heapArray = new int[size + 1];
    }

    public boolean isEmpty() {
        return (pointer < 1);
    }

    public void enqueue(int number) {
        heapArray[++pointer] = number;
        int currentIdx = pointer;
        int parentIdx = pointer / 2;

        while (parentIdx >= 1) {
            if (heapArray[currentIdx] < heapArray[parentIdx]) {
                swap(currentIdx, parentIdx);
            } else {
                break;
            }

            currentIdx = parentIdx;
            parentIdx /= 2;
        }
    }

    public int dequeue() {
        if (heapArray[1] == 0) {
            return -1;
        }

        int result = heapArray[1];
        int currentIdx = 1;
        heapArray[1] = heapArray[pointer];
        heapArray[pointer--] = 0;

        while (isInRange(currentIdx)) {
            int leftChildIdx = currentIdx * 2;
            int rightChildIdx = currentIdx * 2 + 1;
            int smallestValueChildIdx = -1;

            if (!isInRange(leftChildIdx)) {
                break;
            }

            if (!isInRange(rightChildIdx)) {
                if (heapArray[currentIdx] > heapArray[leftChildIdx]) {
                    swap(currentIdx, leftChildIdx);
                }

                break;
            }

            smallestValueChildIdx = (heapArray[leftChildIdx] < heapArray[rightChildIdx]) ?
                leftChildIdx : rightChildIdx;

            if (heapArray[currentIdx] <= heapArray[smallestValueChildIdx]) {
                break;
            }

            swap(currentIdx, smallestValueChildIdx);
            currentIdx = smallestValueChildIdx;
        }

        return result;
    }

    private void swap(int index1, int index2) {
        int temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    private boolean isInRange(int index) {
        return (index > 0 && index <= pointer);
    }
}