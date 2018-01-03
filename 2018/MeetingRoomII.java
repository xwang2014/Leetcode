
    // refer : https://segmentfault.com/a/1190000003894670
    // 把每一个interval铺到时间轴上，统计每个开始点、结束点的room number，然后再做一遍统计，看看在各个时间点上，最大的room number是什么。
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (Interval in : intervals) {
            if (map.containsKey(in.start)) {
                map.put(in.start, map.get(in.start) + 1);
            } else {
                map.put(in.start, 1);
            }
            
            if (map.containsKey(in.end)) {
                map.put(in.end, map.get(in.end) - 1);
            } else {
                map.put(in.end, -1);
            }
        }
        
        int room = 0, maxRoom = 0;
        List<Integer> points = new ArrayList<Integer>( map.keySet() );
        Collections.sort(points);
        
        for(Integer point : points) {
            room += map.get(point);
            maxRoom = Math.max(room, maxRoom);
        }
        
        return maxRoom;
    }

