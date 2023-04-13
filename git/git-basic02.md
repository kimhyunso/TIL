1. Untracked
2. Tracked
    1. Unmodified
    2. Modified
    3. Staged

# Untracked
staged에 올리기 전 상태

관리대상이 아님 (U)

마지막 commit 기준으로 바뀐것이 없는 상황
# Tracked
staged에 올라간 상태


관리대상 (A)

# Unmodified
아무것도 수정하지 않은 상태

# Modified
파일을 수정한 상태

# Staged
커밋으로 저장소에 기록
> `Commit` => Unmodified 이동

# 파일의 상태확인
`$ git status`

# git add <파일명 or 폴더명>
Tracked됨

# root-commit
최상위 commit 된 곳

# git commit -a -m ""
add와 commit 동시에 진행함

# 로그보기
`$ git log`
## 최근 기록의 일정 로그 보기
`$ git log --oneline`
## 최근 기록의 일정 로그를 그래픽으로 보여주기
`$ git log --oneline --graph`


# ctrl + R
전에 썻던 명령어 search

# .bash_profile
## 별명설정
alias gl='git log --oneline --graph'
alias jn='jupyter notebook'

# 브랜치 (Branch)
## 브랜치 새로 생성하기
`$ git branch <브랜치명>`
## 브랜치 확인하기
`$ git branch`
## 브랜치 변경하기
`$ git switch <브랜치명>`
## 브랜치 생성 + 변경하기
`$ git branch -c <브랜치명>`

# HEAD
어디 브랜치에서 일을 할 것인가


# Merge
`$ git merge <브랜치명>`
1. FF (Fast-Forward) (commit : 새로운 commit 안함)
2. 자동 Merge (commit : 자동으로 함)
3. conflict (충돌) (commit : 수동으로 해야함)

## FF
한 개의 브런치가 완성된 시점에서 Master 브런치와 병합하는 경우
## 자동 Merge
두 개의 브런치가 완성된 시점에서 두 개의 브런치가 병합하는 경우
> 서로 다른 파일을 수정하고 있어야함
## Conflict (충돌)
두 개의 브런치가 완성된 시점에서 두 개의 브런치를 병합하는 경우
> 서로 같은 파일을 수정하고 있을 경우

## master => 정상동작 SW [배포되는 branch]

# 브랜치 삭제
`$ git branch -d <삭제할 브랜치명>`
## 브랜치 강제삭제
`$ git branch -D <삭제할 branch>`

# pull
Fetch + merge


