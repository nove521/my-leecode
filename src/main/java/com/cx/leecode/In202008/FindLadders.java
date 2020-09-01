package com.cx.leecode.In202008;

import java.util.*;

public class FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dist = new HashSet<>();
        boolean flag = false;
        for (String s : wordList) {
            if (endWord.equals(s)){
                flag = true;
            }
            if (beginWord.equals(s)){
                continue;
            }
            dist.add(s);
        }
        if (!flag){
            return Collections.emptyList();
        }
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> preStrList = new LinkedList<>();
        preStrList.addLast(beginWord);
        dbf(res,dist,beginWord,endWord,wordList,preStrList);
        return res;
    }

    private void dbf(List<List<String>> res,HashSet<String> dist,String beginWord, String endWord, List<String> wordList,LinkedList<String> preStrList){

        List<Map<String,Object>> tree = new ArrayList<>();
        Map<String,Object> item = new HashMap<>();
        item.put("preStrList",preStrList);
        item.put("word",beginWord);
        tree.add(item);


        List<Map<String,Object>> newTree = new ArrayList<>();
        Map<String,Integer> hash = new HashMap<>();
        int cen = 1;

        while(!tree.isEmpty()){
            for (Map<String, Object> stringObjectMap : tree) {
                LinkedList<String> nPreStrList = (LinkedList<String>) stringObjectMap.get("preStrList");

                for (String s : nPreStrList) {
                    dist.remove(s);
                }
                if (dist.isEmpty()){
                    return;
                }
                String nBeginWord = (String) stringObjectMap.get("word");
                List<String> next = getNext(nBeginWord, dist);
                for (String word : next) {
                    Integer h = hash.get(word);
                    if (Objects.nonNull(h) && h < cen){
                        continue;
                    }
                    if (word.equals(endWord)){
                        nPreStrList.addLast(word);
                        res.add(nPreStrList);
                        continue;
                    }
                    Map<String,Object> treeItem = new HashMap<>();
                    treeItem.put("word",word);
                    nPreStrList.addLast(word);
                    treeItem.put("preStrList",new LinkedList<>(nPreStrList));
                    nPreStrList.removeLast();
                    newTree.add(treeItem);
                    hash.put(word,cen);
                }

                dist.addAll(nPreStrList);
            }
            if (res.size() > 0){
                return;
            }
            tree = newTree;
            newTree = new ArrayList<>();
            cen++;
        }

    }

    private List<String> getNext(String cur,HashSet<String> dist){
        char[] chars = cur.toCharArray();
        List<String> res = new ArrayList<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            for (int j = 'a'; j <= 'z'; j++) {
                if (c == j) {
                    continue;
                }
                chars[i] = (char) j;
                String newStr = new String(chars);
                if (dist.contains(newStr)){
                    res.add(newStr);
                }
                chars[i] = c;
            }
        }
        return res;
    }

    private void pp(List<List<String>> res, LinkedList<String> item, LinkedList<String> wordList, int size,String beginWord, String endWord){

        Iterator<String> iterator = wordList.iterator();
        while (iterator.hasNext()){
            String word = iterator.next();

            if (d(beginWord,word)){
                item.addLast(word);
                if (item.size() > 1 && endWord.equals(word)){
                    if (!res.isEmpty()) {
                        if (res.get(0).size() > item.size()) {
                            res.clear();
                        }else if (res.get(0).size() < item.size()){
                            item.removeLast();
                            return;
                        }
                    }
                    res.add(new ArrayList<>(item));
                    item.removeLast();
                    return;
                }
                iterator.remove();
                pp(res,item,new LinkedList<>(wordList),wordList.size(),word,endWord);
                item.removeLast();
            }

        }
    }

    private boolean d(String a,String b){
        int count = 0;
        int len = a.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)){
                if (count > 1)
                    return false;
                count++;
            }
        }
        if (count == 1){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
//        String []n = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String []n = {"hot","dot","dog","lot","log","cog"};
//        String []n = {"a","b","c"};
        System.out.println(findLadders.findLadders("hit", "cog", Arrays.asList(n)));
    }

    //[[hit, hot, dot, dog, log, cog]
    //[hit, hot, dot, dog, cog]
    //[hit, hot, dot, lot, log, cog]
    //[hit, hot, lot, log, dog, cog]
    //[hit, hot, lot, log, cog]]

}
