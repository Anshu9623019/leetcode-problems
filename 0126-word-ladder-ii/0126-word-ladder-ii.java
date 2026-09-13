class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordLt) {

        List<List<String>> result = new ArrayList<>();

        Set<String> wordList = new HashSet<>(wordLt);

        if (!wordList.contains(endWord)) {
            return result;
        }

        // distance of each word from beginWord
        Map<String, Integer> dis = new HashMap<>();

        // next -> list of previous words
        Map<String, List<String>> parents = new HashMap<>();

        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        dis.put(beginWord, 0);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String current = q.poll();

                int currentDis = dis.get(current);

                char[] newWord = current.toCharArray();

                for (int j = 0; j < newWord.length; j++) {

                    char orgChar = newWord[j];

                    for (char k = 'a'; k <= 'z'; k++) {

                        if (k == orgChar) {
                            continue;
                        }

                        newWord[j] = k;

                        String next = new String(newWord);

                        if (!wordList.contains(next)) {
                            continue;
                        }

                        // First time visiting next
                        if (!dis.containsKey(next)) {

                            dis.put(next, currentDis + 1);

                            parents
                                .computeIfAbsent(
                                    next,
                                    x -> new ArrayList<>()
                                )
                                .add(current);

                            q.offer(next);
                        }

                        // Another shortest path to next
                        else if (dis.get(next) == currentDis + 1) {

                            parents
                                .computeIfAbsent(
                                    next,
                                    x -> new ArrayList<>()
                                )
                                .add(current);
                        }

                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }

                    newWord[j] = orgChar;
                }
            }
        }

        // endWord was never reached
        if (!dis.containsKey(endWord)) {
            return result;
        }

        // Backtrack from endWord to beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(
            endWord,
            beginWord,
            parents,
            path,
            result
        );

        return result;
    }


    private void backtrack(
            String current,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> result) {

        // Reached beginWord
        if (current.equals(beginWord)) {

            List<String> completePath =
                    new ArrayList<>(path);

            Collections.reverse(completePath);

            result.add(completePath);

            return;
        }

        if (!parents.containsKey(current)) {
            return;
        }

        for (String parent : parents.get(current)) {

            path.add(parent);

            backtrack(
                parent,
                beginWord,
                parents,
                path,
                result
            );

            // Backtracking
            path.remove(path.size() - 1);
        }
    }
}