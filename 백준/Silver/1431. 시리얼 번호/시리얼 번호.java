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
        String[] serialNumbers = new String[N];

        for (int i = 0; i < N; ++i) {
            serialNumbers[i] = br.readLine();
        }

        for (int i = 1; i < N; ++i) {
            for (int j = i; j > 0; --j) {
                Condition condition = Condition.builder(serialNumbers[j-1], serialNumbers[j])
                    .conditionOne()
                    .conditionTwo()
                    .conditionThree()
                    .getInstance();

                if (condition.getIsLeftLessThenRight()) {
                    break;
                }

                String temp = serialNumbers[j-1];
                serialNumbers[j-1] = serialNumbers[j];
                serialNumbers[j] = temp;
            }
        }

        for (String serialNumber : serialNumbers) {
            bw.write(serialNumber);
            bw.newLine();
        }
    }
}

class Condition {

    private Boolean isLeftLessThenRight;

    public Condition(Boolean isLeftLessThenRight) {
        this.isLeftLessThenRight = isLeftLessThenRight;
    }

    public Boolean getIsLeftLessThenRight() {
        return isLeftLessThenRight;
    }

    public static ConditionBuilder builder(String strOne, String strTwo) {
        return new ConditionBuilder(strOne, strTwo);
    }

    public static class ConditionBuilder {

        private String strOne;
        private String strTwo;
        private Boolean isLeftLessThenRight;

        public ConditionBuilder(String strOne, String strTwo) {
            this.strOne = strOne;
            this.strTwo = strTwo;
        }

        public ConditionBuilder conditionOne() {
            if (strOne.length() != strTwo.length()) {
                isLeftLessThenRight = strOne.length() < strTwo.length();
            }

            return this;
        }

        public ConditionBuilder conditionTwo() {
            if (isLeftLessThenRight != null) {
                return this;
            }

            int strOneResult = getSumFromString(strOne);
            int strTwoResult = getSumFromString(strTwo);

            if (strOneResult != strTwoResult) {
                isLeftLessThenRight = strOneResult < strTwoResult;
            }

            return this;
        }

        public ConditionBuilder conditionThree() {
            if (isLeftLessThenRight != null) {
                return this;
            }

            isLeftLessThenRight = strOne.compareTo(strTwo) < 0;
            return this;
        }

        public Condition getInstance() {
            return new Condition(isLeftLessThenRight);
        }

        private int getSumFromString(String str) {
            int total = 0;

            for (int i = 0; i < str.length(); ++i) {
                char currentChar = str.charAt(i);

                if ('0' <= currentChar && currentChar <= '9') {
                    total += currentChar - '0';
                }
            }

            return total;
        }
    }
}