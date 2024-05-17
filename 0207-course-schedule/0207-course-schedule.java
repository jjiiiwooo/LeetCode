class Solution {
    public boolean dfs(Map<Integer,List<Integer>>finishtoTakeMap, Integer finish, List<Integer> takes)
    {
        //완료해야 하는 노드가 처리해야 하는 노드에 이미 포함되어 있다면
        //그래프가 순환구조이므로 false 리턴
        if(takes.contains(finish))
            return false;
        
        //완료해야 하는 코스에 값이 있다면
        if(finishtoTakeMap.containsKey(finish)) {
            //처리해야 하는 노드에 현재 완료해야 하는 노드 추가
            takes.add(finish);

            //처리해야 하는 노드 순회 
            for(Integer take : finishtoTakeMap.get(finish)) {
                //재귀 DFS, 탐색 결과가 false라면 false를 리턴
                if(!dfs(finishtoTakeMap, take, takes))
                    return false;
            }

            //탐색 후에는 처리했으므로 노드 제거
            takes.remove(finish);
        }
        //코스에 문제가 없으므로 true리턴
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> finishtoTakeMap = new HashMap<>();

        //완료하기 위해 처리해야 하는 일정을 finish->take 형태의 그래프로 구성
        for(int pre[] : prerequisites)
        {
            //값이 존재하지 않을 경우 빈 리스트 생성
            finishtoTakeMap.putIfAbsent(pre[0], new ArrayList<>());
            //처리해야 하는 코스 추가
            finishtoTakeMap.get(pre[0]).add(pre[1]);
        }

        //처리해야 하는 노드를 저장하는 변수
        List<Integer> takes = new ArrayList<>();

        //완료해야 하는 노드 순회
        for(Integer finish : finishtoTakeMap.keySet())
        {
            //DFS 결과가 fasle라면 최종 결과도 false로 리턴
            if(!dfs(finishtoTakeMap, finish, takes))
            {
                return false;
            }
        }

        //모든 코스에 문제가 없으므로 true 리턴
        return true;
    }
}