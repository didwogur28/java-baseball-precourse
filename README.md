# 숫자 야구 게임

## 🔍 진행 방법
***
* 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 📖 과제 제출 과정
***
* 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  * GitHub을 활용한 제출방법은 [프리코스 과제 제출](https://github.com/next-step/nextstep-docs/tree/master/precourse) 문서를 참고해 제출한다. 
* GitHub에 미션을 제출한후 [우테캠 Pro지원 플랫폼](https://apply.techcourse.co.kr/)을 통해 과제를 최종 제출한다.
* Pull Request만 보내고, 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.

## ❌ 과제 제출 전 체크리스트 - 0점 방지
***
* 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
* 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 통과하는지 확인한다.

## 🚀 기능 요구사항
***
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, <br> 
 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다. 
  * [예] 상대방(컴퓨터)의 수가 425일 때
    * 123을 제시한 경우 : 1스트라이크 
    * 456을 제시한 경우 : 1볼 1스트라이크 
    * 789를 제시한 경우 : 낫싱
* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. <br> 
 게임 플 레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 게임 플레이어가 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
 
### 난수 생성 
* 1부터 9까지 서로 다른 임의의 난수 생성
  * 주어진 Random 함수 사용 
  * 각 자리의 수는 중복 되면 안됨  
  
### 입력 
* 3자리 수 
  * 3자리의 수 가 아닐경우 exception 처리
* 게임이 끝난 후 재시작(1) 또는 종료(2)의 수

### 판정
* 미리 생성 된 난수와 입력 된 세자리 수 비교 
  * 같은 자리에 같은 숫자 존재 ->  **스트라이크**
  * 다른 자리에 같은 숫자 존재 -> **볼**
  * 둘다 존재 x -> **낫싱**
* 3스트라이크까지 반복

### 출력 
  
* 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
> 예) 1볼 2스트라이크 
* 맞춘 숫자가 하나도 없는 경우 
> 낫싱
* 모두 다 맞춘경우
> 3스트라이크<br> 
> 3개의 숫자를 모두 맞추셨습니다! 게임종료

## 💻 프로그래밍 요구사항
***
* 프로그램을 실행하는 시작점은 Application의 main()이다.
* JDK 8 버전에서 실행 가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다.
* JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  * Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  * 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * https://naver.github.io/hackday-conventions-java
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
* else 예약어를 쓰지 않는다.
  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 프로그램 구현을 완료했을 때 src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다. <br>
 테스트가 실패할 경우 0점 처리한다.

## ✍🏻 과제 진행 요구사항 
***
* 미션은 https://github.com/next-step/java-baseball-precourse 저장소를 fork/clone해 시작한다.
* 기능을 구현하기 전에 docs/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 docs/README.md 파일에 정리한 기능 목록 단위 또는 의미있는 단위로 Commit
  한다.


