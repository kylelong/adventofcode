def makeList(num):
    list = []
    while num != 0:
        list.append(num % 10)
        num /= 10
    return list

def increasing(list):
    list = list[::-1]
    for i in range(0, len(list) - 1):
        if(list[i] > list[i + 1]):
            return False
    return True

def adjacent(list):
    list = list[::-1]
    for i in range(0, len(list) - 1):
        if(list[i] == list[i + 1]):
            return True
    return False
count = 0
for i in range(234208, 765870):
    num = i
    list = makeList(num)
    if(increasing(list) and adjacent(list)):
        count = count + 1
    
print(count)

