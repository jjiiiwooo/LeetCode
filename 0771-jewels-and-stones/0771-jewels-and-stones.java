class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Map<Character,Integer> freqs = new HashMap<>();

        //돌(S)의 빈도수 계산
        for(char s : stones.toCharArray())
        {
            //만약 이미 계산한 돌이면 기존 값+1
            if(freqs.containsKey(s))
                freqs.put(s,freqs.get(s)+1);
            //만약 처음보는 돌이면 1
            else
                freqs.put(s,1);
        }

        //보석(J)의 빈도수 합산
        for(char j: jewels.toCharArray())
        {
            //보석과 일치하는 돌의 개수를 합산 
            if(freqs.containsKey(j))
                count+=freqs.get(j);
        }

        return count;
    }
}