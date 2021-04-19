import java.io.*;

public class Q4358 {
    static StringBuilder ret = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Trie trie = new Trie();

        while((input = br.readLine()) != null) {
            insert(trie, input, 0);
            cnt++;
        }
        dfs(trie, new StringBuilder());
        System.out.println(ret);
    }

    static void dfs(Trie trie, StringBuilder sb) {
        if(trie.count != 0) {
            double rate = (double) trie.count / cnt * 100;
            ret.append(sb).append(" ").append(String.format("%.4f", rate)).append("\n");
        }

        for(int i = 0; i < 128; i++) {
            if(trie.children[i] == null) continue;
            sb.append((char)i);
            dfs(trie.children[i], sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static void insert(Trie trie, String s, int cur) {
        if(cur == s.length()) {
            trie.count++;
            return;
        }

        char c = s.charAt(cur);
        if (trie.children[c] == null)
            trie.children[c] = new Trie();

        insert(trie.children[c], s, cur + 1);
    }

    static class Trie {
        int count = 0;
        Trie[] children = new Trie[128];
    }
}