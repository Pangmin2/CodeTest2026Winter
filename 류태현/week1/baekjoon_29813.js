const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" "));

const N = input[0][0];
const people = input.slice(1).map(([name, num]) => [name, Number(num)]);

while (people.length !== 1) {
  const cur_people = people.shift();
  const pass = cur_people[1] - 1;

  for (let i = 0; i < pass; i++) {
    people.push(people.shift());
  }
  people.shift();
}
console.log(people[0][0]);
