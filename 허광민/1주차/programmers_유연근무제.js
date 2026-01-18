function solution(workTimes, records, firstDay) {
    const total = workTimes.length;

    const sat = (6 - firstDay + 7) % 7;
    const sun = (7 - firstDay + 7) % 7;

    const limitTimes = workTimes.map(time => {
        let h = Math.floor(time / 100);
        let m = time % 100;

        m += 10;
        if (m >= 60) {
            h += 1;
            m -= 60;
        }
        return [h, m];
    });

    let count = 0;

    for (let i = 0; i < total; i++) {
        let passed = true;
        const [limitH, limitM] = limitTimes[i];

        for (let d = 0; d < records[i].length; d++) {
            if (d === sat || d === sun) continue;

            const time = records[i][d];
            const logH = Math.floor(time / 100);
            const logM = time % 100;

            if (!checkTime(limitH, limitM, logH, logM)) {
                passed = false;
                break;
            }
        }

        if (passed) count++;
    }

    return count;
}

function checkTime(hLimit, mLimit, hLog, mLog) {
    if (hLimit > hLog) return true;
    if (hLimit === hLog && mLimit >= mLog) return true;
    return false;
}

