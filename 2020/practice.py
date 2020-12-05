import sys
with open(sys.argv[1], 'r') as f:
    lines = []
    for l in f:
    	lines.append(l)
    	data = l.split(" ")
    	print(data[-1].rstrip())