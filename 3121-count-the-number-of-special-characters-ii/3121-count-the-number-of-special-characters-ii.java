class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                if (!mp.containsKey(ch)) {
                    mp.put(ch, i);
                }
            } else {
                mp.put(ch, i);
            }
        }
        int count = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char lower = Character.toLowerCase(ch);

            if (mp.containsKey(ch) && mp.containsKey(lower)) {
                if (mp.get(lower) < mp.get(ch)) {
                    count++;
                }
            }
        }

        return count;
    }
}