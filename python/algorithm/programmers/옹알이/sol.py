import os
import sys

sys.stdin = open("input.txt")


def solution(babbling):
    answer = 0
    result = 0
    says = ['aya', 'ye', 'woo', 'ma']
    for baby in babbling:
        for say in says:
            result = baby.find(say)
        if result != -1:
            answer += 1
    return answer


ex = [
    ["aya", "yee", "u", "maa", "wyeoo"],
    ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]
]
for tc in ex:
    print(solution(tc))

