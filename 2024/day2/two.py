res = 0
max_diff = 3
min_diff = 1
def isIncreasing(numbers):
    for i in range(1, len(numbers)):
        curr, prev = numbers[i], numbers[i - 1]
        diff = curr - prev
        valid = curr > prev and diff >= min_diff  and diff <= max_diff
        if not valid:
            return False
    return True

def isDecreasing(numbers):
    for i in range(1, len(numbers)):
        curr, prev = numbers[i], numbers[i - 1]
        diff = abs(curr - prev)
        valid = curr < prev and diff >= min_diff  and diff <= max_diff
        if not valid:
            return False
    return True

def all_combos(arr):
    return [arr[:i] + arr[i+1:] for i in range(len(arr))]

def one_is_valid(report):
    combos = all_combos(report)
    for c in combos:
        if isIncreasing(c) or isDecreasing(c):
            return True
    return False


with open("input.txt", "r") as file:
    for line in file:
        report = list(map(int, line.split()))
        if isIncreasing(report) or isDecreasing(report):
            res += 1
        else:
            if one_is_valid(report) is True:
                res += 1
print(res)




