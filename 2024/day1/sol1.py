with open("input1.txt", "r") as file:
    first, second = [], []
    for line in file:
        row = list(map(int, line.split()))
        a, b = row
        first.append(a)
        second.append(b)
    first.sort()
    second.sort()

    res = 0
    for i in range(len(first)):
        res += abs(first[i] - second[i])
    print(res)
