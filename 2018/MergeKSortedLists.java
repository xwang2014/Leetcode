

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;

        ListNode dummy = new ListNode(0);

        PriorityQueue<ListNode> heap = new PriorityQueue(1, new Comparator<ListNode>() {
            
            public int compare (ListNode b1, ListNode b2) {
                if (b1.val > b2.val) return 1;
                else if (b1.val < b2.val) return -1;
                else return 0;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }
        }

        ListNode cur = dummy;
        while (!heap.isEmpty()) {
            ListNode temp = heap.poll();

            if (temp.next != null) {
                heap.offer(temp.next);
                temp.next = null;
            }

            cur.next = temp;
            cur = cur.next;
        }

        return dummy.next;
    }

