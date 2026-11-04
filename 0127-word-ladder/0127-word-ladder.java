class Solution {
    void changeWord(String str,int index,Set<String> set,Queue<String> q){
        char ch = str.charAt(index);
        StringBuilder temp = new StringBuilder(str);
        for(char i = 'a';i<='z';i++){
            if(ch == i){
                continue;
            }
            temp.setCharAt(index,i);
            if(set.contains(temp.toString())){
                q.add(temp.toString());
                set.remove(temp.toString());
            }
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();

        Set<String> set = new HashSet<>(wordList);

        q.add(beginWord);
        set.remove(beginWord);

        if(!set.contains(endWord)){
            return 0;
        }

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int j = 0;j<size;j++){
                String str = q.poll();

                if(str.equals(endWord)){
                    return level;
                }
                for(int i = 0;i<str.length();i++){
                    changeWord(str,i,set,q);
                }
            }
            level++;
        }
        return 0;
    }
}