class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> freqs = new HashSet<>();

        //보석(jewels) 종류 저장
        for(char j : jewels.toCharArray())
            freqs.add(j);

        //돌이(stones)이 보석인 경우 +1
        for(char s : stones.toCharArray())
            if(freqs.contains(s)) count++;

        return count;
    }
}