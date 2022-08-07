N = int(input())

room_time = []
for _ in range(N):
    s, e = map(int, input().split())
    room_time.append((s, e))
room_time.sort(key= lambda x:[x[1], x[0]])

end_time = -1
cnt = 0
for s, e in room_time:
    if s >= end_time:
        cnt+=1
        end_time = e

print(cnt)
