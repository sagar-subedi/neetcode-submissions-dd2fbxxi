class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        list_of_sets_for_rows = [set() for _ in range(len(board))]
        list_of_sets_for_columns = [set() for _ in range(len(board))]
        list_of_sets_for_boxes = [set() for _ in range(len(board))]

        for i in range(len(board)):
            for j in range(len(board[i])):
                current_char = board[i][j]
                box_no_for_current_char = (i // 3) * 3 + (j // 3)
                if(current_char != '.'):
                    if current_char not in list_of_sets_for_rows[i] and current_char not in list_of_sets_for_columns[j] and current_char not in list_of_sets_for_boxes[box_no_for_current_char] :
                        list_of_sets_for_rows[i].add(current_char)
                        list_of_sets_for_columns[j].add(current_char)
                        list_of_sets_for_boxes[box_no_for_current_char].add(current_char)
                    else:
                        return False
        return True