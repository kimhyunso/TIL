
def solution(common):
    answer = common[0]
    
    if abs(answer) - abs(common[1]) == 1:
        answer += common[len(common) - 1]
    else:
        answer *= common[len(common) - 1]
        
    return answer