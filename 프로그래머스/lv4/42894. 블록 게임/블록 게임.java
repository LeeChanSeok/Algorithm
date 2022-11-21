class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int N = board.length;

        boolean isRemove = true;
        while (isRemove) {
            isRemove = false;

            // 1. |
            if (case1(board, N)) {
                isRemove = true;
                ++answer;
                continue;
            }
            // 2. ㅡ
            if (case2(board, N)) {
                isRemove = true;
                ++answer;
                continue;
            }
            // 3. ._.
            if (case3(board, N)) {
                isRemove = true;
                ++answer;
                continue;
            }
        }

        return answer;
    }

    private boolean case3(int[][] board, int N) {
        int i, num;
        for (int j = 0; j < N - 2; ++j) {
            i = 0;
            while (i < N && board[i][j] == 0 && board[i][j + 2] == 0) ++i;
            if (i == N || i == 0) continue;
            if (board[i][j] == 0 || board[i][j + 2] == 0) continue;
            --i;

            num = board[i][j + 1];
            if (board[i + 1][j] == num && board[i + 1][j + 1] == num && board[i + 1][j + 2] == num) {
                board[i][j + 1] = board[i + 1][j] = board[i + 1][j + 1] = board[i + 1][j + 2] = 0;
                return true;
            }

        }

        return false;
    }

    private boolean case2(int[][] board, int N) {
        int i, num;
        for (int j = 0; j < N - 1; ++j) {
            i = 0;
            while (i < N && board[i][j] == 0 && board[i][j + 1] == 0) ++i;
            if (i == N || i == 0) continue;
            if (board[i][j] == 0 || board[i][j + 1] == 0) continue;
            --i;

            if (j == 0) {
                num = board[i][j + 2];
                if (board[i + 1][j] == num && board[i + 1][j + 1] == num && board[i + 1][j + 2] == num) {
                    board[i][j + 2] = board[i + 1][j] = board[i + 1][j + 1] = board[i + 1][j + 2] = 0;
                    return true;
                }
            } else if (j == N - 2) {
                num = board[i][j - 1];
                if (board[i + 1][j - 1] == num && board[i + 1][j] == num && board[i + 1][j + 1] == num) {
                    board[i][j - 1] = board[i + 1][j - 1] = board[i + 1][j] = board[i + 1][j + 1] = 0;
                    return true;
                }
            } else {
                num = board[i][j + 2];
                if (board[i + 1][j] == num && board[i + 1][j + 1] == num && board[i + 1][j + 2] == num) {
                    board[i][j + 2] = board[i + 1][j] = board[i + 1][j + 1] = board[i + 1][j + 2] = 0;
                    return true;
                }
                num = board[i][j - 1];
                if (board[i + 1][j - 1] == num && board[i + 1][j] == num && board[i + 1][j + 1] == num) {
                    board[i][j - 1] = board[i + 1][j - 1] = board[i + 1][j] = board[i + 1][j + 1] = 0;
                    return true;
                }
            }

        }

        return false;
    }

    private boolean case1(int[][] board, int N) {

        int i, num;
        for (int j = 0; j < N; ++j) {
            i = 0;
            while (i < N && board[i][j] == 0) ++i;
            if (i == N || i == 0 || i == 1) continue;

            --i;

            num = board[i + 1][j];
            if (j == 0) {

                if (board[i - 1][j + 1] == num && board[i][j + 1] == num && board[i + 1][j + 1] == num) {
                    board[i + 1][j] = board[i - 1][j + 1] = board[i][j + 1] = board[i + 1][j + 1] = 0;
                    return true;
                }
            } else if (j == N - 1) {
                if (board[i - 1][j - 1] == num && board[i][j - 1] == num && board[i + 1][j - 1] == num) {
                    board[i + 1][j] = board[i - 1][j - 1] = board[i][j - 1] = board[i + 1][j - 1] = 0;
                    return true;
                }
            } else {
                if (board[i - 1][j + 1] == num && board[i][j + 1] == num && board[i + 1][j + 1] == num) {
                    board[i + 1][j] = board[i - 1][j + 1] = board[i][j + 1] = board[i + 1][j + 1] = 0;
                    return true;
                }
                if (board[i - 1][j - 1] == num && board[i][j - 1] == num && board[i + 1][j - 1] == num) {
                    board[i + 1][j] = board[i - 1][j - 1] = board[i][j - 1] = board[i + 1][j - 1] = 0;
                    return true;
                }
            }

        }

        return false;
    }
}