import re
class Statement:
    def __init__(self, block:str, start:int, end: int):
        self.block = block
        self.start = start
        self.end = end
    
with open("input.txt", "r") as file:
    res = ''
    
    
   
    for line in file:
        res += line

    mem = []
    for i in range(len(res)):
        if res[i:i+len("do()")] == "do()":
            mem.append(Statement("do", i, i + 4))

        if res[i:i+len("don't()")] == "don't()":
            mem.append(Statement("don't", i, i + 7))


    matches = re.findall(r"mul\(\d+,\s*\d+\)", res)
    for m in matches:
        i, j = res.index(m), res.index(m) + len(m)
        mem.append(Statement(m, i, j))
       
    mem.sort(key=lambda statement: statement.start)
    process = True
    res = 0
    for m in mem:
        statement, start, end = m.block, m.start, m.end
        if process and statement.startswith('m'):
            s = statement
            s = s.replace('mul(', ' ')
            s = s.replace(')', ' ')
            numbers = s.split(',')
            a, b = int(numbers[0]), int(numbers[1])
            res += a * b
        if statement == "do":
            process = True
        if statement == "don't":
            process = False

    print(res)

 