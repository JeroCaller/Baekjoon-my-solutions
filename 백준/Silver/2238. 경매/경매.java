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
        String[] firstLine = br.readLine().split(" ");
        final int U = Integer.parseInt(firstLine[0]);
        final int N = Integer.parseInt(firstLine[1]);

        int[] numberOfPeopleForPrice = new int[U + 1];  // index: price
        String[] namesForPrice = new String[U + 1];  // index: price

        for (int i = 0; i < N; ++i) {
            String[] inputs = br.readLine().split(" ");
            int price = Integer.parseInt(inputs[1]);

            ++numberOfPeopleForPrice[price];
            if (namesForPrice[price] == null) {
                namesForPrice[price] = inputs[0];
            }
        }

        int minPeople = 10001;
        int minPrice = U + 1;
        for (int i = 1; i < numberOfPeopleForPrice.length; ++i) {
            if (numberOfPeopleForPrice[i] == 0) {
                continue;
            }

            if (minPeople > numberOfPeopleForPrice[i]) {
                minPeople = numberOfPeopleForPrice[i];
                minPrice = i;
            }
        }

        bw.write(namesForPrice[minPrice] + " " + minPrice);

        /*
        bw.newLine();
        bw.write(Arrays.toString(numberOfPeopleForPrice));
        bw.newLine();
        bw.write(Arrays.toString(namesForPrice));
         */
    }
}
