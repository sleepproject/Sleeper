# Sleeper
자야 하는 시간에 과도한 핸드폰 사용으로 늦게 잠드는 사람들을 위해 특정시간 핸드폰 사용을 제한함으로서 수면시간을 보장시켜주는 앱

## 1. 개요
스마트폰의 보급화로 인해 남녀노소 할 것 없이 스마트폰을 쉽게 접하는 세상. 적당한 사용은 사람에게 편리함과 다양한 이점을 줄 수 있지만</br>
과도한 사용은 결국 중독으로 이어져 나의 일상생활까지 망칠 수 있습니다.</br>
자야 할 시간에 숙면을 취하지 않고 핸드폰 사용하는 것을 방지해 잠을 충분히 잘 수 있게 도와주고자 개발하였습니다.

### 1-1.프로젝트 기간
2021-03 ~ 2021-11

### 1-2.개발 환경
  * 운영체제
    - Windows 10
  * IDE  
    - Android Studio
    - IntelliJ
  - 버전관리
    - Github
  - DB
    - MariaDB 1.8.0

### 1-3. 개발 언어
  - Java(Android App, DB Server)
  - Xml(Android App)
 

 ## 2. APP 기능
 ### 로그인
  - 구글 계정을 이용한 로그인 (구현 완료)
 ### 수면 관리
 - 목표 수면 시간 설정 <b>(구현 완료)</b>
 - 기상 예약 시간 설정 <b>(구현 완료)</b>
 - 수면시간 동안의 화면 잠금 기능 <b>(구현 완료)</b>
 - 정해진 시각 알림 울림 <b>(구현 완료)</b>
 - 모닝콜 문제 기능 <b>(구현 완료)</b>
 - 자주 사용하는 시간 세팅 <b>(구현 완료)</b>
### 음악 기능
  - 음악 재생 <b>(구현 완료)</b>
  - 음악 일시정지 <b>(구현 완료)</b>
### 통계
  - 수면 시간 통계 그래프 확인 <b>(구현 완료)</b>
  - 기간별 수면시간 검색 <b>(구현 완료)</b>
### 시스템 설정
  - 로그인 정보 확인 <b>(구현 완료)</b>
  - 알림음 설정 <b>(미구현)</b>
  - 모닝콜 문제 On/Off 설정 <b>(구현 완료)</b>
  - 밝기 조절 기능 <b>(미구현)</b>
  - 어플 푸시알림 설정 <b>(구현완료)</b>
  - 선택적 어플 잠금 설정 <b>(미구현)</b>

## 3. 개발 후기
  - 21년도 2월에 주제를 정하고 3월에 프로젝트를 시작했을때는 위의 앱 기능들을 설계하고, 가능할거라는 생각과 의욕이 가득한 상태에서 프로젝트를 시작했습니다. 개발을 진행하며 막상 동일한 기능을 다른 앱에서 사용할때는 너무나 간단해 보였는데 직접 구현하는건 상당히 어려운 일이라는것을 깨달았습니다. <br><br>
  어렵지만 부딪혀가며 밤을 지새우고, 때론 학교 정규과목 수업때도 제대로 집중하지 못한채 막힌 문제를 고민하기도 하며 하나하나 구현해 나가며 "아, 이런 기능을 구현할 수 있다면, 나는 다른 A앱에서의 동일한 기능도 구현할 수 있겠구나!" 하는 깨달음을 얻는 과정이 너무 재밌었던 것 같습니다.  
  특히 수면시간동안 화면을 잠궈 다른 앱 사용을 하지 못하게 하는 기능을 구현할때는 수면시간이 해제될때까지 Sleeper 앱의 패키지명이 아닌 다른 앱이 실행됬다면, 실행된 다른 앱 위에 백그라운드로 전환된 Sleeper 앱을 다시 포그라운드로 호출하는 스레드를 반복 실행하는 방식으로 다른 앱의 실행을 체크하였습니다. 그 과정에서 여러번 해당 화면의 로직을 통채로 날린적도 있었고, 때론 서치하여 나온 로직의 구조를 파악하고 Sleeper 앱에 적용해가며 많은 시행착오를 겪었지만, 결국 성공하였을때는 소리지르며 기뻐했던 기억이 남습니다.<br><br> 
  물론 설계했던 기능들을 전부 구현하진 못했지만, 메인 기능인 수면관리 기능과 통계 기능을 성공적으로 구현하였으며 발표까지 무사히 마쳤을때는 이루 말할 수 없는 뿌듯함과 성취감을 느끼는 졸업작품이였습다.  
  이번 졸업작품에서 앱을 개발해보며 앞으로 안드로이드 앱 개발자가 되어야겠다는 길을 찾았고, 더욱 많이 공부하여 나의 개발자 커리어를 안드로이드 개발자로 시작해야겠다는 포부를 가지게 되는 좋은 기회였다고 생각합니다.