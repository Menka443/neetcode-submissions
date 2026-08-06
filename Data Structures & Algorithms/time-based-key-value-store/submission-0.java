

class TimeMap {

    class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList<>()); // Create drawer if needed

        map.get(key).add(new Pair(timestamp, value)); // Put the new pair in the drawer
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int start = 0;
        int end = list.size() - 1;

        String ans = "";

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}