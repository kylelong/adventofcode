import re
with open("input.txt", "r") as file:
    res = 0
    s = 0
    for line in file:
        matches = re.findall(r"mul\(\d+,\s*\d+\)", line)
        s += len(matches)
        for m in matches:
            m = m.replace('mul(', ' ')
            m = m.replace(')', ' ')
            numbers = m.split(',')
            a, b = int(numbers[0]), int(numbers[1])
            res += a * b
    print(res)
    print(s)