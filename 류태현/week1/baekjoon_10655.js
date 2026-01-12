const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const N = input[0][0];
const points = input.slice(1);
let minDistance = Infinity;

let originTotalDistance = 0;
for (let i = 0; i < N - 1; i++) {
  originTotalDistance +=
    Math.abs(points[i][0] - points[i + 1][0]) +
    Math.abs(points[i][1] - points[i + 1][1]);
}

for (let i = 1; i < N - 1; i++) {
  const a_b =
    Math.abs(points[i - 1][0] - points[i][0]) +
    Math.abs(points[i - 1][1] - points[i][1]);

  const b_c =
    Math.abs(points[i][0] - points[i + 1][0]) +
    Math.abs(points[i][1] - points[i + 1][1]);

  const a_c =
    Math.abs(points[i - 1][0] - points[i + 1][0]) +
    Math.abs(points[i - 1][1] - points[i + 1][1]);

  const saveDistance = a_b + b_c - a_c;
  const newDistance = originTotalDistance - saveDistance;

  if (newDistance < minDistance) minDistance = newDistance;
}

console.log(minDistance);
