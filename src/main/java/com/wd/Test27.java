package com.wd;

import java.util.*;
import java.util.stream.Collectors;

public class Test27 {


    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        int sum = 0;
        boolean flag = false;
        int length = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            length = Math.min(length, strs[i].length());
        }

        for (int i = 0; i < length; i++) {
            if (flag) {
                break;
            }
            String str = strs[0];
            for (int j = 1; j < strs.length; j++) {
                if (str.charAt(i) == strs[j].charAt(i)) {
                    if (j == strs.length - 1) {
                        sum++;
                    }
                } else {
                    flag = true;
                    break;
                }
            }
        }
        return strs[0].substring(0, sum);
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("") || s1[i].equals(" ")) {
                continue;
            }
            sb.append(s1[i]).append(" ");

        }
        return sb.substring(0, sb.length() - 1);

    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        String[] arr = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            arr[i] = "";
        }

        boolean isDirect = true;
        int startIndex = 0;
        while (startIndex < s.length()) {
            String substring;
            if (startIndex + numRows - 2 > s.length() - 1) {
                substring = s.substring(startIndex);

            } else {
                substring = s.substring(startIndex, startIndex + numRows - 1);

            }

            if (isDirect) {
                for (int i = 0; i < substring.length(); i++) {
                    arr[i] = arr[i] + substring.charAt(i);
                }
            } else {
                for (int i = 0; i < substring.length(); i++) {
                    arr[numRows - i - 1] = arr[numRows - i - 1] + substring.charAt(i);
                }
            }
            isDirect = !isDirect;
            startIndex = startIndex + numRows - 1;
        }

        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i]);
        }
        return stringBuffer.toString();
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public static int strStrV2(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }

        int length = needle.length();
        int index = -1;
        for (int i = 0; i <= haystack.length() - length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    count++;
                }
            }
            if (count == length) {
                index = i;
                break;
            }
        }
        return index;
    }


//    public static void main(String[] args) {
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//        fullJustify(words, 16);
//        System.out.println();
//
//    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int offSet = 0;
        for (int i = 0; i < words.length; i++) {
            int startIndex = i;
            offSet = i;
            int count = words[startIndex].length();
            int totalLength = 0;
            int num = 0;
            StringBuilder str = new StringBuilder();
            while (count <= maxWidth && offSet + 1 < words.length) {
                count = count + words[offSet + 1].length() + 1; // 这个1是空格
                totalLength = totalLength + words[offSet].length();
                num++;
                offSet++;
            }
            i = offSet;

            if (num == 1) {
                str.append(words[startIndex]);
                while (str.length() > maxWidth) {
                    str.append(" ");
                }
                list.add(str.toString());
            }

            if (num > 1) {
                if (startIndex + num == words.length - 1) { //说明计算的是最后一行
                    for (int j = 0; j < num; j++) {
                        str.append(words[startIndex + j]);
                        str.append(" ");
                    }
                    while (str.length() > maxWidth) {
                        str.append(" ");
                    }
                    list.add(str.toString());
                } else {
                    int a = (maxWidth - totalLength) / (num - 1);
                    int b = (maxWidth - totalLength) % (num - 1);
                    if (b == 0) {
                        for (int k = 0; k < num; k++) {
                            str.append(words[startIndex + k]);
                            if (k == num - 1) {
                                break;
                            }
                            for (int j = 0; j < a; j++) {
                                str.append(" ");
                            }
                        }
                    } else {
                        for (int k = 0; k < num; k++) {
                            str.append(words[startIndex + k]);
                            if (k == num - 1) {
                                break;
                            }
                            for (int j = 0; j < a; j++) {
                                str.append(" ");
                            }
                            if (b > 0) {
                                str.append(" ");
                                b--;
                            }
                        }
                    }
                    list.add(str.toString());
                }
            }
        }
        return list;
    }

    public boolean isPalindrome(String s) {
        return false;
    }

//    public static void main(String[] args) {
//        String s = "abc";String t = "ahbgdc";
//        System.out.println(isSubsequence(s,t));
//    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        if (s.length() == t.length()) {
            return s.equals(t);
        }

        int before = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i), before);
            before = index;
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = 0;
        boolean flag = true;
        for (int i = 0; i < numbers.length; i++) {
            int need = target - numbers[i];
            if (i + 1 < numbers.length && need < numbers[i + 1]) {
                flag = false;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (need < numbers[i + 1]) {
                    break;
                }
                if (need == numbers[j]) {
                    left = i;
                    right = j;
                }

            }

            if (!flag) break;
        }
        return new int[]{left + 1, right + 1};
    }

    public static int[] twoSumV2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length;
        int max = 0;
        while (left < right) {
            max = Math.max((right - left) * Math.min(height[left], height[right]), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        Boolean isLeft = null;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (isLeft != null) {
                    if (isLeft && nums[left] == nums[left - 1]) {
                        left++;
                        isLeft = true;
                        continue;
                    } else if (!isLeft && nums[right] == nums[right + 1]) {
                        right--;
                        isLeft = false;
                        continue;
                    }
                }
                if (nums[left] + nums[right] + num == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    if (!lists.contains(list)) {
                        lists.add(list);
                    }
                    left++;
                    isLeft = true;
                } else if (nums[left] + nums[right] + num > 0) {
                    right--;
                    isLeft = false;
                } else {
                    left++;
                    isLeft = true;
                }
            }
        }
        return lists.stream().distinct().collect(Collectors.toList());
    }


    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while (right <= nums.length - 1) {
            sum += nums[right++];
            while (sum >= s) {
                len = Math.min(right - left, len);
                sum -= nums[left];
                left++;
            }
        }
        return len;
    }


    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                int start = s.indexOf(s.charAt(right), left);
                for (int i = left; i < start; i++) {
                    set.remove(s.charAt(i));
                }
                if (start + 1 == right) {
                    left = right;
                } else {
                    left = start + 1;
                }
                right++;
            } else {
                len = Math.max(right - left + 1, len);
                set.add(s.charAt(right++));
            }

        }
        return len;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int slen = s.length();
        int wordLen = words.length;
        int length = words[0].length();
        List<Integer> list = new ArrayList<>();

        HashMap<String, Integer> map1 = new HashMap<>();
        for (String word : words) {
            int count = map1.getOrDefault(word, 0);
            map1.put(word, count + 1);
        }

        for (int i = 0; i < slen - wordLen * length + 1; i++) {
            int sum = 0;
            int l = 0;
            String subString;
            HashMap<String, Integer> map2 = new HashMap<>();
            while (i + length + l <= slen && map1.containsKey(subString = s.substring(i + l, i + length + l))) {
                if (map1.containsKey(subString)) {
                    map2.put(subString, map2.getOrDefault(subString, 0) + 1);
                    if (map2.get(subString) > map1.get(subString)) {
                        break;
                    }
                    l = l + length;
                    sum++;
                } else {
                    break;
                }
            }
            if (sum == wordLen) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> findSubstringV2(String s, String[] words) {
        int wordNum = words.length;
        int wordLen = words[0].length();

        int totalLen = wordLen * wordNum;

        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i + totalLen <= s.length(); i++) {
            HashMap<String, Integer> newMap = new HashMap<>();
            int startIndex = i;
            int num = 0;
            String str;
            while (startIndex + wordLen <= s.length() && map.containsKey(str = s.substring(startIndex, startIndex + wordLen))) {
                newMap.put(str, newMap.getOrDefault(str, 0) + 1);
                if (newMap.get(str) > map.get(str)) {
                    break;
                }
                num++;
                startIndex = startIndex + wordLen;
            }
            if (num == wordNum) {
                list.add(i);
            }

        }
        return list;
    }


    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;

        while (right < s.length()) {
            if (need[s.charAt(right)] > 0) {
                count--;
            }
            need[s.charAt(right)]--;


            if (count == 0) {
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }

                if (right - left + 1 < left) {
                    start = left;
                    length = right - left + 1;
                }

                left++;
                need[s.charAt(left)]++;
                count++;
            }
            right++;
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }


    public boolean isValidSudoku(char[][] board) {
        int[] heng = new int[9];
        int[] lie = new int[9];
        int[] group = new int[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '*') continue;
                int value = 1 << (int) c;
                if ((heng[i] & value) != 0) return false;
                if ((lie[j] & value) != 0) return false;
                int groupIndex = (i / 3) * 3 + j / 3;
                if ((group[groupIndex] & value) != 0) return false;
                heng[i] |= value;
                lie[i] |= value;
                group[groupIndex] |= value;
            }
        }
        return true;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;

        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int startNum = matrix[0][0];
        int direct = 1;
        while (list.size() < l1 * l2) {
            if (direct == 1) {
                for (int i = 0; i < l2; i++) {
                    if (set.add(++startNum)) {
                        list.add(startNum);
                    } else {
                        startNum--;
                        direct = 2;
                        break;
                    }
                }
                direct = 2;

            }

            if (direct == 2) {
                for (int i = 1; i < l1; i++) {
                    startNum += l2;
                    if (set.add(startNum)) {
                        list.add(startNum);
                    } else {
                        direct = 3;
                        startNum -= l2;
                        break;
                    }
                }
                direct = 3;
            }

            if (direct == 3) {
                for (int i = 1; i < l2; i++) {
                    startNum--;
                    if (set.add(startNum)) {
                        list.add(startNum);
                    } else {
                        direct = 4;
                        startNum++;
                        break;
                    }
                }
                direct = 4;
            }

            if (direct == 4) {
                for (int i = 1; i < l1; i++) {
                    startNum -= l2;
                    if (set.add(startNum)) {
                        list.add(startNum);
                    } else {
                        direct = 1;
                        startNum += l2;
                        break;
                    }
                }
                direct = 1;
            }
        }

        return list;
    }

    public static void rotate(int[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;

        for (int i = 0; i < l2; i++) {
            int temp;
            for (int j = 0; j < l1 / 2; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[l1 - 1 - j][i];
                matrix[l1 - 1 - j][i] = temp;
            }
        }

        for (int i = 0; i < l1; i++) {
            int temp;
            for (int j = 0; j <= i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (Objects.equals(matrix[i][j], 0)) {
                    s1.add(i);
                    s2.add(j);
                }
            }
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (s1.contains(i)) {
                    matrix[i][j] = 0;
                }

                if (s2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        int l1 = board.length;
        int l2 = board[0].length;

        int[] neighbors = new int[]{-1, 0, 1};

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {

                int neighbor = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int offset1 = neighbors[k];
                        int offset2 = neighbors[l];
                        if (offset1 != 0 && offset2 != 0) {
                            if (i + offset1 >= 0 && i + offset1 < l1 && j + offset2 < l2 && j + offset2 >= 0 && Math.abs(board[i + offset1][j + offset2]) == 1) {
                                neighbor++;
                            }
                        }
                    }
                }

                if (board[i][j] == 1 && (neighbor < 2 || neighbor > 3)) {
                    board[i][j] = -1;
                }

                if (board[i][j] == 0 && neighbor == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

    }

    public void gameOfLifeV2(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[] neighbors = new int[]{-1, 0, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int offset1 = neighbors[i];
                        int offset2 = neighbors[j];
                        if (offset1 != 0 && offset2 != 0) {
                            if (row + offset1 >= 0 && row + offset1 < rows && col + offset2 < cols && col + offset2 >= 0 && Math.abs(board[row + offset1][col + offset2]) == 1) {
                                liveNeighbors++;
                            }
                        }


                    }
                }

                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1;
                }

                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] charArray = magazine.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character character : charArray) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        char[] charArray1 = ransomNote.toCharArray();
        for (Character character : charArray1) {
            Integer integer = map.get(character);
            if (integer == null || integer == 0) {
                return false;
            }
            integer--;
            map.put(character, integer);
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> charMap = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            Character character = charMap.get(sChar);
            if (character == null) {
                charMap.put(sChar, tChar);
                reverseMap.put(tChar, sChar);
            } else {
                if (character != tChar) {
                    return false;
                }

                Character character1 = reverseMap.get(character);
                if (sChar != character1) {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if (pattern.length() != sArray.length) {
            return false;
        }
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> stringMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if ((charMap.get(pattern.charAt(i)) != null && !charMap.get(pattern.charAt(i)).equals(sArray[i])) || (stringMap.get(sArray[i]) != null && stringMap.get(sArray[i]) != pattern.charAt(i))) {
                return false;
            } else {
                charMap.put(pattern.charAt(i), sArray[i]);
                stringMap.put(sArray[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> l1 = new HashMap<>();
        HashMap<Character, Integer> l2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            l1.put(s.charAt(i), l1.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            l2.put(t.charAt(i), l2.getOrDefault(t.charAt(i), 0) + 1);
        }


        return l1.equals(l2);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);
        }
        return new ArrayList<>(map.values());
    }

    public int[] twoSumV3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] ints = new int[2];

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                ints[0] = left;
                ints[1] = right;
                break;
            }
        }
        return ints;

    }


    public static boolean isHappy(int n) {
        int fastNum = nextCount(n);
        int lowNum = n;
        while (lowNum != fastNum) {
            fastNum = nextCount(nextCount(fastNum));
            lowNum = nextCount(lowNum);
        }
        return lowNum == 1;
    }

    public static int nextCount(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        int c1 = n % 10;
        return sum + c1 * c1 + nextCount(n / 10);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!Objects.isNull(map.get(nums[i]))) {
                min = Math.min(i - map.get(nums[i]), min);
            }
            map.put(nums[i], i);
        }
        return min <= k;
    }

    public static int longestConsecutive(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int j : nums) {
            if (!list.contains(j)) {
                list.add(j);
            }
        }

        list = list.stream().sorted().collect(Collectors.toList());

        if (list.size() == 0) {
            return 0;
        }

        if (list.size() == 1) {
            return 1;
        }

        int max = 1;
        int num = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) + 1 == list.get(i)) {
                num++;
                max = Math.max(num, max);
            } else {
                num = 1;
            }
        }
        return max;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> anotherList = new ArrayList<>();
            anotherList.add(nums[i]);
            list.add(anotherList);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] + 1 == nums[j]) {
                    anotherList.add(nums[j]);
                } else {
                    i = j - 1;
                    break;
                }
                i = j;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> integerList = list.get(i);
            if (integerList.size() == 1) {
                stringList.add(String.valueOf(integerList.get(0)));
            } else {
                stringList.add(integerList.get(0) + "->" + integerList.get(integerList.size() - 1));
            }
        }
        return stringList;

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> intList = new ArrayList<>(Arrays.asList(intervals));
        intList.add(newInterval);
        intList.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intList.size() - 1; i++) {
            if (intList.get(i)[1] >= intList.get(i + 1)[0]) {
                intList.get(i + 1)[0] = intList.get(i)[0];
                intList.get(i + 1)[1] = Math.max(intList.get(i + 1)[1], intList.get(i)[1]);
            } else {
                list.add(intList.get(i));
            }
        }
        list.add(intList.get(intList.size() - 1));
        return list.toArray(new int[list.size()][]);
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int position = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > position) {
                count++;
                position = points[i][1];
            }
        }
        return count;
    }


    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                Character character = map.get(s.charAt(i));
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == null) {
                    return false;
                } else {
                    if (pop != character) {
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }

    public static String simplifyPath(String path) {
        if (path.length() == 1 || path.length() == 0) {
            return path;
        }
        String[] split = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                continue;
            }
            if (!s.equals("") && !s.equals(".")) {
                stack.offer(s);
            }
        }

        StringBuilder str = new StringBuilder();
        if (stack.isEmpty()) {
            str.append("/");
        } else {
            while (!stack.isEmpty()) {
                str.append("/").append(stack.pollFirst());
            }
        }
        return str.toString();

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if ("+".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i1 + i2);
            } else if ("-".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i2 - i1);
            } else if ("*".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i1 * i2);
            } else if ("/".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i2 / i1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static int calculate(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (' ' != s.charAt(i)) {
                list.add(String.valueOf(s.charAt(i)));
            }
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String c = list.get(i);
            if (c.equals(")")) {
                int sum = Integer.parseInt(stack.pop());
                String pop = stack.pop();
                while (!pop.equals("(")) {
                    if (pop.equals("+")) {
                        sum += Integer.parseInt(stack.pop());
                    } else {
                        sum = Integer.parseInt(stack.pop()) - sum;
                    }
                    pop = stack.pop();
                }
                stack.push(String.valueOf(sum));
            } else {
                stack.push(String.valueOf(c));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals("+")) {
                sum += Integer.parseInt(stack.pop());
            } else if (pop.equals("-")) {
                sum += -Integer.parseInt(stack.pop());
            } else {
                sum += Integer.parseInt(pop);
            }
        }
        return sum;
    }

//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null){
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//
//        while (fast != slow){
//            if (fast == null || fast.next == null){
//                return false;
//            }
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return true;
//    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode pre = new ListNode();
//        ListNode next = new ListNode();
//        pre.next = next;
//        int up = 0;
//        while (l1 != null || l2 != null || up != 0) {
//            int t1 = 0, t2 = 0;
//            if (l1 != null) {
//                t1 = l1.val;
//            }
//            if (l2 != null) {
//                t2 = l2.val;
//            }
//
//            int sum = t1 + t2 + up;
//            int value = sum % 10;
//            up = sum / 10;
//            next.next = new ListNode(value);
//            next = next.next;
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//        }
//        return pre.next.next;
//    }
//
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode nextNode = new ListNode();
//        ListNode head = nextNode;
//        while (list1 != null || list2 != null) {
//            int value = 0;
//            if (list1 != null && list2 != null) {
//                if (list1.val > list2.val){
//                    value =list2.val;
//                    list2 = list2.next;
//                }else {
//                    value =list1.val;
//                    list1 = list1.next;
//                }
//            }else {
//                if (list1 == null){
//                    value = list2.val;
//                    list2 = list2.next;
//                }else {
//                    value = list1.val;
//                    list1 = list1.next;
//                }
//            }
//            ListNode next = new ListNode(value);
//            nextNode.next = next;
//            nextNode = next;
//        }
//        return head.next;
//    }

//    public Node copyRandomList(Node head) {
//        Node preNode = new Node(0);
//        Node pre = preNode;
//
//        Node current = head;
//        HashMap<Node, Node> map = new HashMap<>();
//        while (current != null){
//            Node next = new Node(current.val);
//            pre.next = next;
//            map.put(current, next);
//            pre = next;
//            current = current.next;
//        }
//
//        current = head;
//        pre = preNode;
//        while (current != null){
//            if (current.random != null){
//                pre.next.random = map.get(current.random);
//            }
//            pre = pre.next;
//            current = current.next;
//        }
//        return preNode.next;
//    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode();
        pre.next = head;

        ListNode first = pre;
        for (int i = 0; i < left - 1; i++) {
            first = first.next;
        }

        ListNode middle = first.next;
        ListNode middleTemp = middle;
        for (int i = 0; i < right - left; i++) {
            middleTemp = middleTemp.next;
        }
        ListNode tailHead = middleTemp.next;
        ListNode listNode = reverseNode(middle);

        first.next = listNode;
        ListNode node = listNode;
        while (node.next != null) {
            node = node.next;
        }
        node.next = tailHead;
        return pre.next;
    }

    private ListNode reverseNode(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        pre.next = head;
        return null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;

        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        int num = count - n;

        ListNode current = pre;
        for (int i = 0; i < num; i++) {
            current = current.next;
        }
        if (current.next == null) {
            return pre.next;
        }
        current.next = current.next.next;
        return pre.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode current = pre.next;
        ListNode preNode = pre;
        while (current != null) {
            ListNode next = current.next;
            if (next == null) {
                current = next;
                continue;
            }
            if (current.val == next.val) {
                int value = current.val;
                while (next != null && next.val == value) {
                    next = next.next;
                }
                preNode.next = next;
                current = next;
            } else {
                ListNode temp = current;
                preNode = temp;
                current = next;
            }
        }
        return pre.next;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        if (count == 0) {
            return head;
        }
        int num = count - k % count;
        current = head;
        for (int i = 0; i < num - 1; i++) {
            current = current.next;
        }
        ListNode tailNode = current.next;
        if (tailNode == null) {
            return head;
        }
        current.next = null;
        ListNode tempTailNode = tailNode;
        while (tempTailNode.next != null) {
            tempTailNode = tempTailNode.next;
        }
        tempTailNode.next = pre.next;
        return tailNode;
    }

    public static ListNode partition(ListNode head, int x) {
        List<Integer> bigList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                smallList.add(current.val);
            } else {
                bigList.add(current.val);
            }
            current = current.next;
        }

        current = head;
        smallList.addAll(bigList);
        int count = 0;
        while (current != null) {
            current.val = smallList.get(count);
            count++;
            current = current.next;
        }
        return head;
    }

    private List<TreeNode> nodeList = new ArrayList<>();

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        nodeList.add(root);
        List<TreeNode> tempList = new ArrayList<>();
        while (nodeList.size() != 0) {
            sum++;
            tempList.clear();
            for (int i = 0; i < nodeList.size(); i++) {
                TreeNode treeNode = nodeList.get(i);
                if (treeNode.left != null) tempList.add(treeNode.left);
                if (treeNode.right != null) tempList.add(treeNode.right);
            }
            nodeList.clear();
            nodeList.addAll(tempList);
        }
        return sum;
    }

    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepthV2(root.left);
            int rightDepth = maxDepthV2(root.right);
            return Math.max(leftDepth, rightDepth);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        return check(root.left, root.right);

    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);

    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right, int inorder_left) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int inorder_root = indexMap.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left);
        root.right = myBuildTree(preorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1);
        return root;
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        // 构造哈希映射，帮助我们快速定位根节点
//        indexMap = new HashMap<Integer, Integer>();
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//        return myBuildTree(preorder, 0, n - 1, 0);
//    }

    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new LinkedHashMap<>();
    private int count = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = postorder.length - 1; i >= 0; i--) {
            list.add(postorder[i]);
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Integer rootIndex = map.get(list.get(count));
        count++;
        return buildMyTree(rootIndex, 0, inorder.length, inorder);
    }

    public TreeNode buildMyTree(int rootIndex, int leftStart, int rightEnd, int[] inorder) {
        TreeNode root = new TreeNode(inorder[rootIndex]);
        if (leftStart == rootIndex - 1) {
            root.left = new TreeNode(inorder[leftStart]);
        } else {
            Integer number = map.get(list.get(count++));
            root.left = buildMyTree(number, leftStart, rootIndex - 1, inorder);
        }

        if (rightEnd == rootIndex + 1) {
            root.right = new TreeNode(inorder[rightEnd]);
        } else {
            Integer number = map.get(list.get(count++));
            root.right = buildMyTree(number, rootIndex + 1, rightEnd, inorder);
        }
        return root;
    }

    public Node connect(Node root) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size() != 0) {
            rebuildList(nodes);
            nodes = getNodeList(nodes);
        }
        return root;
    }

    public List<Node> getNodeList(List<Node> nodeList) {
        List<Node> list = new ArrayList<>();
        for (Node node : nodeList) {
            if (Objects.isNull(node)) {
                continue;
            }
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
        return list;
    }

    public void rebuildList(List<Node> list) {
        if (list.size() == 0 || list.size() == 1) {
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
    }

    private List<Integer> integerList = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        getAllInteger(root);
        root.left = null;
        TreeNode temp = root;
        for (int i = 1; i < integerList.size(); i++) {
            temp.right = new TreeNode(integerList.get(i));
            temp = temp.right;
        }
    }

    private void getAllInteger(TreeNode root) {
        if (root == null) {
            return;
        }
        integerList.add(root.val);
        getAllInteger(root.left);
        getAllInteger(root.right);
    }

    private List<List<Integer>> newList = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        i = root.val + i * 10;
        if (root.left == null && root.right == null) {
            return i;
        }

        return dfs(root.left, i) + dfs(root.right, i);
    }

    private int sumCount = 0;

    public int countNodes(TreeNode root) {
        if (root != null) {
            sumCount++;
            countNodes(root.left);
            countNodes(root.right);
        }
        return sumCount;
    }

    private Map<TreeNode, TreeNode> hashMap = new HashMap<>();
    private Map<TreeNode, Integer> hashMapV2 = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hashMap.put(root, null);
        hashMapV2.put(root, 0);
        findMapNode(root, 0);
        Integer count1 = hashMapV2.get(p);
        Integer count2 = hashMapV2.get(q);
        while (!count2.equals(count1)) {
            if (count1 > count2) {
                p = hashMap.get(p);
                count1 = hashMapV2.get(p);
            } else {
                q = hashMap.get(q);
                count2 = hashMapV2.get(q);
            }
        }

        while (p.val != q.val) {
            p = hashMap.get(p);
            q = hashMap.get(q);
        }
        return p;
    }

    private void findMapNode(TreeNode root, int num) {
        if (root != null) {
            if (root.right != null) {
                hashMap.put(root.right, root);
                hashMapV2.put(root.right, num + 1);
            }
            if (root.left != null) {
                hashMap.put(root.left, root);
                hashMapV2.put(root.left, num + 1);
            }
            findMapNode(root.left, num + 1);
            findMapNode(root.right, num + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> lastNodeList = new ArrayList<>();
        getLastNodeList(Collections.singletonList(root), lastNodeList);

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < lastNodeList.size(); i++) {
            if (lastNodeList.get(i).size() > 0) {
                integerList.add(lastNodeList.get(i).get(lastNodeList.get(i).size() - 1));
            }

        }
        return integerList;
    }

    private void getLastNodeList(List<TreeNode> rootList, List<List<Integer>> lastNodeList) {
        if (rootList.size() == 0) {
            return;
        }

        List<Integer> nodeList = new ArrayList<>();
        List<TreeNode> anotherList = new ArrayList<>();
        for (int i = 0; i < rootList.size(); i++) {
            TreeNode treeNode = rootList.get(i);
            if (treeNode == null) {
                continue;
            }
            nodeList.add(treeNode.val);
            if (treeNode.left != null) {
                anotherList.add(treeNode.left);
            }

            if (treeNode.right != null) {
                anotherList.add(treeNode.right);
            }
        }

        lastNodeList.add(nodeList);
        getLastNodeList(anotherList, lastNodeList);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> lastNodeList = new ArrayList<>();
        getLastNodeList(Collections.singletonList(root), lastNodeList);

        List<Double> doubleList = new ArrayList<>();

        for (int i = 0; i < lastNodeList.size(); i++) {
            List<Integer> integerList = lastNodeList.get(i);
            if (integerList.size() == 0) {
                continue;
            }
            double d = 0d;
            for (int j = 0; j < integerList.size(); j++) {
                d += integerList.get(j);
            }
            doubleList.add(d / integerList.size());
        }

        return doubleList;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        return null;
    }

    public int getMinimumDifference(TreeNode root) {
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int v1 = root.val;
        int v2 = Integer.MAX_VALUE;
        int v3 = Integer.MAX_VALUE;
        if (root.left != null) {
            v2 = root.left.val;
        }

        if (root.right != null) {
            v3 = root.right.val;
        }

        int min1 = Math.min(Math.abs(v1 - v2), Math.abs(v1 - v3));
        int min2 = Math.min(getMin(root.left), getMin(root.right));
        return Math.min(min1, min2);
    }

    private List<Integer> numList = new ArrayList<>();

    public int getMinimumDifferenceV2(TreeNode root) {
        int min = Integer.MAX_VALUE;
        getInOrderNum(root);
        for (int i = 0; i < numList.size() - 1; i++) {
            min = Math.min(Math.abs(numList.get(i) - numList.get(i + 1)), min);
        }
        return min;
    }

    public int kthSmallest(TreeNode root, int k) {
        getInOrderNum(root);
        return numList.get(k - 1);
    }

    private void getInOrderNum(TreeNode root) {
        if (root == null) {
            return;
        }
        getInOrderNum(root.left);
        numList.add(root.val);
        getInOrderNum(root.right);
    }


    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }

    private boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }

        int v1 = root.val;
        if (root.left != null) {
            if (root.left.val >= v1) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= v1) {
                return false;
            }
        }

        return isValid(root.left) && isValid(root.right);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsFoundLand(grid, i, j);
                }

            }
        }
        return count;
    }

    private void dfsFoundLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';

        dfsFoundLand(grid, i + 1, j);
        dfsFoundLand(grid, i - 1, j);
        dfsFoundLand(grid, i, j + 1);
        dfsFoundLand(grid, i, j - 1);
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfsFoundX(board, i, 0);
            }

            if (board[i][col - 1] == 'O') {
                dfsFoundX(board, i, col - 1);
            }
        }

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfsFoundX(board, 0, i);
            }

            if (board[row - 1][i] == 'O') {
                dfsFoundX(board, row - 1, i);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfsFoundX(char[][] board, int i, int i1) {
        if (i < 0 || i >= board.length || i1 < 0 || i1 >= board[0].length || board[i][i1] != 'O') {
            return;
        }
        board[i][i1] = 'E';
        dfsFoundX(board, i + 1, i1);
        dfsFoundX(board, i - 1, i1);
        dfsFoundX(board, i, i1 + 1);
        dfsFoundX(board, i, i1 - 1);
    }


    private HashMap<String, List<wNode>> nodeHashMap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            nodeHashMap.putIfAbsent(a, new ArrayList<>());
            nodeHashMap.putIfAbsent(b, new ArrayList<>());
            nodeHashMap.get(a).add(new wNode(b, values[i]));
            nodeHashMap.get(b).add(new wNode(a, 1 / values[i]));
        }
        double[] doubles = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            doubles[i] = dfsCalc(a, b, 1.0d, new HashSet<String>(), nodeHashMap.get(a));
        }
        return doubles;

    }

    private double dfsCalc(String start, String end, double weight, HashSet<String> set, List<wNode> nextList) {
        if (!nodeHashMap.containsKey(start) || !nodeHashMap.containsKey(end)) {
            return -1.0d;
        }

        if (start.equals(end)) {
            return weight;
        }

        set.add(start);
        for (int i = 0; i < nextList.size(); i++) {
            double result = -1.0d;

            if (!set.contains(nextList.get(i).val)) {
                result = dfsCalc(nextList.get(i).val, end, weight * nextList.get(i).weight, set, nodeHashMap.get(nextList.get(i).val));
            }
            if (result != -1.0d) {
                return result;
            }
        }

        set.remove(start);
        return -1.0d;
    }



    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;

        Test27 test27 = new Test27();
    }
}



class wNode {
    public String val;
    public double weight;

    public wNode(String _val, double _weight) {
        val = _val;
        weight = _weight;
    }
}

class BSTIterator {
    private List<Integer> list;
    private Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        getAllNumber(root);
        iterator = list.iterator();
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void getAllNumber(TreeNode root) {
        if (root == null) {
            return;
        }
        getAllNumber(root.left);
        list.add(root.val);
        getAllNumber(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode pre;

    ListNode() {
    }

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    private ListNode pre;
    private int size;
    private int length;

    public LRUCache(int capacity) {
        pre = new ListNode();
        size = capacity;
    }

    public int get(int key) {
        ListNode current = pre.next;
        while (current != null) {
            if (current.key == key) {
                ListNode preNode = current.pre;
                if (current.next == null) {
                    preNode.next = null;
                    current.pre = null;
                } else {
                    current.pre = null;
                    preNode.next = current.next;
                    current.next.pre = preNode;
                    current.next = null;
                }
                length--;
                ListNode listNode = new ListNode(key, current.val);
                putFirst(listNode);
                return current.val;
            }
            current = current.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        boolean flag = false;
        ListNode current = pre.next;
        while (current != null) {
            if (current.key == key) {
                current.val = value;
                flag = true;

                ListNode preNode = current.pre;
                if (current.next == null) {
                    preNode.next = null;
                    current.pre = null;
                } else {
                    current.pre = null;
                    preNode.next = current.next;
                    current.next.pre = preNode;
                    current.next = null;
                }
                length--;
                putFirst(current);


                break;
            }
            current = current.next;
        }
        if (!flag) { // 没找到
            putFirst(new ListNode(key, value));
            if (length > size) {
                removeLast();
            }
        }
    }

    public void putFirst(ListNode node) {
        ListNode oldFirst = pre.next;
        pre.next = node;
        node.pre = pre;
        if (oldFirst != null) {
            node.next = oldFirst;
            oldFirst.pre = node;
        }
        length++;
    }

    public void removeLast() {
        length--;
        ListNode current = pre.next;
        while (current.next != null) {
            current = current.next;
        }
        ListNode preNode = current.pre;
        preNode.next = null;
        current.pre = null;
    }
}

class LRUCacheV2 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCacheV2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
