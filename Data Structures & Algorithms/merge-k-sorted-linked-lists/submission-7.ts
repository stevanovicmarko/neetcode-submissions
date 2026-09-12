type Comparator<T> = (a: T, b: T) => number;

class PriorityHeap<T> {
    private heap: T[] = [];
    private readonly compare: Comparator<T>;

    /**
     * @param compare Function returning:
     *  - A negative number if `a` has higher priority than `b`
     *  - A positive number if `b` has higher priority than `a`
     *  - 0 if priorities are equal
     */
    constructor(compare: Comparator<T>) {
        this.compare = compare;
    }

    /**
     * Number of elements in the heap.
     */
    get size(): number {
        return this.heap.length;
    }

    /**
     * Checks if the heap is empty.
     */
    isEmpty(): boolean {
        return this.heap.length === 0;
    }

    /**
     * Returns the top priority element without removing it.
     */
    peek(): T | undefined {
        return this.heap[0];
    }

    /**
     * Adds an element to the heap.
     */
    push(val: T): void {
        this.heap.push(val);
        this.siftUp(this.heap.length - 1);
    }

    /**
     * Removes and returns the top priority element.
     */
    pop(): T | undefined {
        if (this.isEmpty()) return undefined;

        const top = this.heap[0];
        const bottom = this.heap.pop()!;

        if (this.heap.length > 0) {
            this.heap[0] = bottom;
            this.siftDown(0);
        }

        return top;
    }

    /**
     * Moves the element at `index` up to restore heap order.
     */
    private siftUp(index: number): void {
        let current = index;
        while (current > 0) {
            const parent = Math.floor((current - 1) / 2);
            // If current element has higher priority than parent, swap
            if (this.compare(this.heap[current], this.heap[parent]) < 0) {
                this.swap(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }

    /**
     * Moves the element at `index` down to restore heap order.
     */
    private siftDown(index: number): void {
        let current = index;
        const length = this.heap.length;

        while (true) {
            const leftChild = 2 * current + 1;
            const rightChild = 2 * current + 2;
            let highestPriority = current;

            if (
                leftChild < length &&
                this.compare(this.heap[leftChild], this.heap[highestPriority]) < 0
            ) {
                highestPriority = leftChild;
            }

            if (
                rightChild < length &&
                this.compare(this.heap[rightChild], this.heap[highestPriority]) < 0
            ) {
                highestPriority = rightChild;
            }

            if (highestPriority !== current) {
                this.swap(current, highestPriority);
                current = highestPriority;
            } else {
                break;
            }
        }
    }

    private swap(i: number, j: number): void {
        const temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode[]} lists
     * @return {ListNode}
     */
    mergeKLists(lists: ListNode[]): ListNode {
        const heap = new PriorityHeap<ListNode>((a, b) => a.val - b.val);
        for (const list of lists) {
            if (list) {
                heap.push(list);
            }
        }
        const dummy = new ListNode();
        let tail = dummy;

        while (!heap.isEmpty()) {
            const smallest = heap.pop()!;
            tail.next = smallest;
            tail = tail.next;
            if (smallest.next) {
                heap.push(smallest.next);
            }
        }

        return dummy.next;
    }
}
