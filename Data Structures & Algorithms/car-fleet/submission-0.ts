class Solution {
    /**
     * @param {number} target
     * @param {number[]} position
     * @param {number[]} speed
     * @return {number}
     */
    carFleet(target: number, position: number[], speed: number[]): number {
        const posAndSpeed: number[][] = [];
        for (let i = 0; i < position.length; i++) {
            posAndSpeed.push([position[i], speed[i]]);
        }
        posAndSpeed.sort((a, b) => b[0] - a[0]);

        const stack = [];
        for (const item of posAndSpeed) {
            const [pos, speed] = item;
            const time = (target - pos) / speed;
            if (!stack.length) {
                stack.push(time);
                continue;
            }
            const topTime = stack[stack.length - 1];
            if (time > topTime) {
                stack.push(time);
            }
        }

        return stack.length;
    }
}
