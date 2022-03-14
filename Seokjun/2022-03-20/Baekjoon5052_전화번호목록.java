import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon5052_전화번호목록 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(br.readLine());
        // t 번 반복
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            String[] phoneList = new String[n];

            for (int i = 0; i < n; i++) {
                phoneList[i] = br.readLine();
            }

            Arrays.sort(phoneList, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    if (s1.length() == s2.length())
                        return s1.compareTo(s2);
                    return s1.length() - s2.length();
                }
            });

            Trie trie = new Trie();

            boolean flag = true;

            for (String phone : phoneList) {
                flag = trie.insert(phone);
                if (!flag)
                    break;
            }

            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode thisNode = this.root;
        // System.out.println("word : " + word);
        for (int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            // System.out.println(thisNode.getIsLastChar());
            if (thisNode.getIsLastChar()) {
                return false;
            }
        }

        thisNode.setIsLastChar(true);
        return true;
    }
}

class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;

    TrieNode() {
        childNodes = new HashMap<>();
        isLastChar = false;
    }

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean getIsLastChar() {
        return isLastChar;
    }

    public void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}