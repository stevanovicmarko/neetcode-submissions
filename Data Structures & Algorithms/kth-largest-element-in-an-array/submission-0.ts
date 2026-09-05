class MinHeap<T> {
  private a: T[] = [];
  constructor(private cmp: (x: T, y: T) => number = (x, y) => (x as any) - (y as any)) {}

  size(): number { return this.a.length; }
  peek(): T | undefined { return this.a[0]; }

  push(v: T): void {
    this.a.push(v);
    let i = this.a.length - 1;
    while (i > 0) {
      const p = (i - 1) >> 1;
      if (this.cmp(this.a[i], this.a[p]) >= 0) break;
      [this.a[i], this.a[p]] = [this.a[p], this.a[i]];
      i = p;
    }
  }

  pop(): T | undefined {
    if (this.a.length === 0) return undefined;
    const top = this.a[0];
    const last = this.a.pop()!;
    if (this.a.length > 0) {
      this.a[0] = last;
      let i = 0;
      while (true) {
        const l = 2 * i + 1, r = l + 1;
        let s = i;
        if (l < this.a.length && this.cmp(this.a[l], this.a[s]) < 0) s = l;
        if (r < this.a.length && this.cmp(this.a[r], this.a[s]) < 0) s = r;
        if (s === i) break;
        [this.a[i], this.a[s]] = [this.a[s], this.a[i]];
        i = s;
      }
    }
    return top;
  }
}

class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number}
     */
    findKthLargest(nums: number[], k: number): number {
        const minHeap = new MinHeap<number>();
        for (const num of nums) {
            minHeap.push(num);
            if (minHeap.size() > k) {
                minHeap.pop();
            }
            //console.log(minHeap);
        }
        return minHeap.peek();

    }
}
