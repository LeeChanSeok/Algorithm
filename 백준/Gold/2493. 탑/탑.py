N = int(input())
Height = list(map(int, input().split()))

Stack = []
result = []
for i, h in enumerate(Height):
    while Stack != []:
        if Stack[-1][1] > h:
            result.append(Stack[-1][0]+1)
            break
        Stack.pop()
    if Stack == []:
        result.append(0)
    Stack.append((i,h))


print(*result)