# git
> 분산 버전 프로그램
> **백업**,**복구**,**협업**을 위해 사용
## CLI
> command line interface, 터미널을 통해 사용자와 컴퓨터가 상호작용하는 방식
### 터미널 명령어 정리
`mkdir` = 폴더 생성
`touch` = 파일 생성(*.txt , *.md 등등)
`ls`    = 현재 폴더의 파일 목록 출력
`cd`    = 다른 폴더로 이동
`rm`    = 파일 삭제 / 폴더 삭제 (-r로 사용하기도 함)
## Visual Studio code
> 텍스트 에디터, 도구
> 아주 맨처음 시작시 윈도우는 powersell(=cmd)로 설정되어 있어 통일을 위해 git bash를 선택
- 초기세팅 : MARKDOWN + korean팩
- 초기세팅(git)
  ```bash
    git config ---global user.name "이름"
    git config ---global user.email "메일주소"
    ```
### VSCode를 통한 git 사용법
> 내가 배운 것들은 90프로가 VSC를 통해서 이루어진다.
> 나머지는 바탕화면에서 vash를 사용한다.
1. git init
    - git init은 지금 작업중인 폴더 아래로는 git으로 관리한다는 명령어이다
    - git init을 명령하고나면 터미널에 (master)라고 표기됨
    - fork를 통한 것 말고는 시작할때 명령해줌
2. git status
    - git의 현재 상태에 대해 알려주는 명령어
    - 조언도 해준다
3. git add
    - 내가 세이브한 파일을 WD에서 SA로 올려주는 명령어
    - git이 해당 파일을 추적 할 수 있도록 만든다(파일 옆에 M이 A로 변함, 반댄가?)
    - add 시킨 후 SA로 잘 갔는지 확인은 status로 확인해 보면 초록 메시지로 뜸
4. git commit
    - SA로 올라온 파일의 변경 사항을 하나의 버전으로 저장하는 명령어
    - 그냥 commit만 쓰면 터미널이 진짜로 지저분해짐
    - commit -m "massage" or 'massage'를 애용하자
5. git log
    - commit 내역을 조회할 수 있는 명령어
    - 얘도 그냥 쓰면 지저분해진다
    - git log --oneline --all --graph 등등으로 뒤에 추가로 붙이면 한줄로도 나오고 숨겨진 애도 나오고 짝대기 그래프로도 나온다
6. git config --global core.autocrlf true
    - 이건 초기설정에 사용하는건데 줄바꿈 관련되서 쓰는거다 이거를 설정하지 않으면 윈도우에서는 `\r\n`이 동시에 들어가는데 맥에서는 `\n`만 들어가므로 설정 차이가 남
    - 이걸 설정하면 gitHub에 올릴땐 윈도우에서는 `\r\n`이 `\n`이 되고 불러올때는 `\n`이 `\r\n`으로 자동으로 바뀌어서 온다
7. ls -al
    - 현재 폴더안의 파일들을 다 표현해줌
    