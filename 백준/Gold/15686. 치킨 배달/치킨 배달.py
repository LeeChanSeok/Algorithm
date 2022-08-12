from itertools import combinations

INF = int(1e9)

def calc_dist(p1, p2):
    return abs(p1[0]-p2[0]) + abs(p1[1] - p2[1])

T = 1
ans = 0
for t in range(1, T+1):

    n, m = map(int, input().split())
    graph = []

    for _ in range(n):
        graph.append(list(map(int, input().split())))

    home = []
    chicken = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1:
                home.append((i, j))
            elif graph[i][j] == 2:
                chicken.append((i, j))

    chic_dist = [[INF]*len(chicken) for _ in range(len(home))]

    for i, h in enumerate(home):
        for j, c in enumerate(chicken):
            chic_dist[i][j] = calc_dist(h, c)

    total_min_dist = 0
    if len(chicken) == m:
        for cd in chic_dist:
            total_min_dist += min(cd)
    else:
        indexL = [i for i in range(len(chicken))]
        comb = list(combinations(indexL, m))

        total_min_dist = INF
        for c in comb:
            comb_min_dist = 0
            for h_c in chic_dist:
                min_dist = INF
                for index in c:
                    min_dist = min(min_dist, h_c[index])

                comb_min_dist += min_dist
            total_min_dist = min(total_min_dist, comb_min_dist)


    ans = total_min_dist

    print(ans)
    #print(f"${t} {ans}")