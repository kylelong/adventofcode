with open("input1.txt", "r") as file:
    first, nums = [], {}
    for line in file:
        row = list(map(int, line.split()))
        a, b = row
        first.append(a)
        nums[b] = nums.get(b, 0) + 1
        

    res = 0
    for n in first:
        count = nums.get(n) if n in nums else 0
        res += n * count
    print(res)
