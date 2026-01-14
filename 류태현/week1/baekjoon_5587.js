const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const n = input[0];
let sg_cards = input.slice(1);
let gs_cards = [];

for (let i = 1; i <= 2 * n; i++) {
  if (!sg_cards.includes(i)) gs_cards.push(i);
}

sg_cards.sort((a, b) => a - b);
gs_cards.sort((a, b) => a - b);

// 1 6 7 9 10.
// 2 3 4 5 8
// 1,2 / 6,8 / 9,없 -> 7,없 -> 10,없

let topCard = sg_cards.shift();

while (sg_cards.length > 0 && gs_cards.length > 0) {
  // 근상이가 내는거임. 근상이 낼거 없으면 탑카드 초기화하고 상근이꺼 젤 작은거 내면 됨.
  for (let i = 0; i <= gs_cards.length; i++) {
    if (i === gs_cards.length) {
      topCard = 0;
      break;
    } else if (gs_cards[i] > topCard) {
      topCard = gs_cards.splice(i, 1)[0];
      break;
    }
  }

  //상근이가 내는거
  for (let i = 0; i <= sg_cards.length; i++) {
    if (i === sg_cards.length) {
      topCard = 0;
      break;
    } else if (sg_cards[i] > topCard) {
      topCard = sg_cards.splice(i, 1)[0];
      break;
    }
  }
}
console.log(gs_cards.length);
console.log(sg_cards.length);
