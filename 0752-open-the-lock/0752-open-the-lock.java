class Solution {
    public int openLock(String[] deadends, String target) {

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        String start = "0000";

        if (dead.contains(start)) {
            return -1;
        }

        if (start.equals(target)) {
            return 0;
        }

        q.add(start);
        visited.add(start);

        int turns = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int j = 0; j < size; j++) {

                String s = q.poll();

                StringBuilder str = new StringBuilder(s);

                for (int i = 0; i < 4; i++) {

                    char ch = s.charAt(i);

                    // Increment the wheel
                    char nextChar = (ch == '9')
                                    ? '0'
                                    : (char)(ch + 1);

                    str.setCharAt(i, nextChar);

                    String tempStr = str.toString();

                    if (!dead.contains(tempStr) &&
                        !visited.contains(tempStr)) {

                        if (tempStr.equals(target)) {
                            return turns + 1;
                        }

                        visited.add(tempStr);
                        q.add(tempStr);
                    }

                    char prevChar = (ch == '0')
                                    ? '9'
                                    : (char)(ch - 1);

                    str.setCharAt(i, prevChar);

                    tempStr = str.toString();

                    if (!dead.contains(tempStr) &&
                        !visited.contains(tempStr)) {

                        if (tempStr.equals(target)) {
                            return turns + 1;
                        }

                        visited.add(tempStr);
                        q.add(tempStr);
                    }

                    str.setCharAt(i, ch);
                }
            }

            turns++;
        }

        return -1;
    }
}