/*
Leetcod 127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

 */

import java.util.*;

public class WordLadder {


    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};
//        String[] words =  {"hot","dot","dog","lot","log"};
//        String[] words = {"hot", "dog"};
        List<String> wordList = Arrays.asList(words);
        String beginWord = "hit";
        String endWord = "cog";

        System.out.println("This is the ladder length for input " + ladderLength(beginWord, endWord, wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        Map<String, List<String>> wordMap = populateMap(wordList);
//
//        List<String> words = new LinkedList<>();
//        for (String word: wordList) {
//            if(difference(beginWord.toCharArray(),word.toCharArray()) == 1) {
//                words.add(word);
//                wordMap.put(beginWord,words);
//            }
//        }

        Set<String> transformTrace = new HashSet<>();

        Deque<String> wordQueue = new LinkedList<>();

        wordQueue.add(beginWord);
        transformTrace.add(beginWord);

        int count = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            for (int i =0; i < size; i++) {
                String currentWord = wordQueue.poll();
                System.out.println("current word " + currentWord + " and count is " + count + " and i : " + i);
                if (currentWord.equals(endWord)) {
                    return count;
                }
                char[] currentWordArray = currentWord.toCharArray();
                for (int j = 0; j < currentWordArray.length; j++) {
                    char temp = currentWordArray[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        currentWordArray[j] = c;

                        String transformedWord = new String(currentWordArray);
                        System.out.println("this is the transformed word " + transformedWord);
                        if (wordList.contains(transformedWord)) {
                            if(!transformTrace.contains(transformedWord)) {
                                transformTrace.add(transformedWord);
                                wordQueue.offer(transformedWord);
                                System.out.println("adding new word " + transformedWord);
                            }

                        }
                    }
                    currentWordArray[j] = temp;

                }

//                List<String> transformWords = wordMap.get(currentWord);
//                if (transformWords != null) {
//                    for(String word: transformWords) {
//                        //if we have not used this word before
//                        if(!transformTrace.contains(word)) {
//                            transformTrace.add(word);
//                            wordQueue.offer(word);
//                            System.out.println("adding new word " + word);
//                        }
//                    }
//                }


            }
            count++;

        }

        //a match cannot be found, return 0
        return 0;


    }

    public static int difference(char[] input1, char[] input2) {
        int counter = 0;
        for (int i = 0; i < input1.length; i++) {
            if (input1[i] != input2[i]) {
                counter++;
            }
        }

        return counter;
    }

    public static Map<String,List<String>> populateMap(List<String> wordList) {
        Map<String,List<String>> wordMap = new HashMap<>();
        for (String word: wordList) {

            for (String transformWord: wordList) {
                if(word.equals(transformWord)) {
                    continue;
                }
                //if the difference between the two string is just one character,
                //add to the map
                if (difference(word.toCharArray(),transformWord.toCharArray()) == 1) {
                    List<String> words;
                    if(wordMap.get(word) == null) {
                        words  = new LinkedList<>();
                    } else {
                        words = wordMap.get(word);
                    }
                        words.add(transformWord);
                        wordMap.put(word,words);
                }
            }
        }

        return wordMap;
    }

}
