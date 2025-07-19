import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

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
        PriorityQueue<Candidate> pq = new PriorityQueue<>(
            (a, b) -> b.getNumVotes() - a.getNumVotes()
        );
        final int N = Integer.parseInt(br.readLine());
        Candidate dasom = new Candidate(1, Integer.parseInt(br.readLine()));

        for (int i = 2; i <= N; ++i) {
            int votes = Integer.parseInt(br.readLine());
            pq.offer(new Candidate(i, votes));
        }

        int answer = 0;
        if (!pq.isEmpty()) {
            while (dasom.getNumVotes() <= pq.peek().getNumVotes()) {
                Candidate target = pq.poll();
                target.setNumVotes(target.getNumVotes() - 1);
                dasom.setNumVotes(dasom.getNumVotes() + 1);
                pq.offer(target);
                ++answer;
            }
        }

        bw.write(String.valueOf(answer));
    }
}

class Candidate {

    private int id;
    private int numVotes;

    public Candidate(int id, int numVotes) {
        this.id = id;
        this.numVotes = numVotes;
    }

    public int getId() {
        return id;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }
}