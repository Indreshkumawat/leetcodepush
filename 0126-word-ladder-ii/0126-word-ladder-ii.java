
class Solution {

    Map<String, List<String>> parent = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(
            String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return ans;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        set.remove(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();
            Set<String> visitedThisLevel = new HashSet<>();

            for (int j = 0; j < size; j++) {

                String word = q.poll();
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) continue;

                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (set.contains(newWord)) {

                            parent.putIfAbsent(newWord, new ArrayList<>());
                            parent.get(newWord).add(word);

                            if (visitedThisLevel.add(newWord)) {
                                if (newWord.equals(endWord)) {
                                    found = true;
                                } else {
                                    q.offer(newWord);
                                }
                            }
                        }
                    }

                    arr[i] = original;
                }
            }

            set.removeAll(visitedThisLevel);
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);

            dfs(endWord, beginWord, path);
        }

        return ans;
    }

    public void dfs(String word, String beginWord, List<String> path) {

        if (word.equals(beginWord)) {

            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            ans.add(result);

            return;
        }

        if (!parent.containsKey(word)) return;

        for (String prev : parent.get(word)) {

            path.add(prev);

            dfs(prev, beginWord, path);

            path.remove(path.size() - 1);
        }
    }
}
