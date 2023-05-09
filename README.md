# songa
# 송아송아 송아쌤과 함께하는 스진초 2기!

## 파이널 PR 리뷰 for 주문 도메인 구현까지 중...(2023년 5월 1일)
[✔️]주문 설계 "디비" 꼼꼼히 챙겨서, 리드미에 erd까지 

![image](https://user-images.githubusercontent.com/111734043/235489737-fe8b1e86-a7e6-4469-b903-1935b6173c49.png)

## 1.구현을 시.작.합니다 :: Entity 설계 및 구현 (2023년 4월 13일 목요일)
- 여러분들이 생각할 때 쇼핑몰의 도메인이 상품 / 주문 / 회원 ... 이렇게 나뉜다고 하셨죠? 그래서 우리는 이 중에 음식🍝 (상품) 부터 구현하고, 주문 구현 해볼텐데요
- 현업에선 거의 대부분 Entity로 DDD를 구현하고 있어요
- 그래서 DDD의 도메인 모델(객체)도 그냥 Entity 부르고, DB의 1:1 맵핑되는 객체도 Entity 라고 불러요
- 정확히는 도메인 Entity 를 만드는 게 먼저고, 이 친구가 DB에 맵핑 되는 Entity 개념이 그 다음입니다
   
[✔️] 여러분들의 웹 사이트를 흘러다닐 음식 Entity를 구상해주세요. 마.음.대.로🌟

[✔️] 실제로 음식 Entity 클래스를 구현해주세요!

[✔️] 프로젝트에서 Entity 클래스 하나 구현해서 PR 하나 던져주세요 👀


## 2.모델을 만드셨으니! 이제 모델이 흘러다닐 길을 만들어 볼까요? (2023년 4월 14일 금요일)
- 거창하게 도메인 주도 설계 안에 '모델 주도 설계'라고도 부릅니다.😎

[✔️] 모델(Model; 마~들)은 새로운 게 아니고, 그냥 도메인을 객체화한 걸 부르는 또다른 표현이라고 생각하시면 됩니다. 👀 

- 예를 들어, 음식 도메인이니까 모델은 음식이 되겠죠?

[✔️] 즉, 음식이란 모델(객체)이 프로그램(웹)을 흘러다닐거고, 우린 그 흘러다닐 길을 정해주면 되는 겁니다!

[✔️]다음 길(요청)에 대해 직접 URL을 지어주세요 

  (1) 음식 등록 : /foods -> POST

  (2) 음식 전체 조회 : /foods -> GET

  (3) 음식 단일 조회 : /foods/{id} -> GET

  (4) 음식 수정 : /foods/{id} -> PUT

  (5) 음식 삭제 : /foods/{id} -> DELETE
  
  
 ## 3.스프링 3계층은..🔥 도메인 별로, FoodController / OrderController ... 이런식으로 세세하게, 국룰 ::  (2023년 4월 19일 수요일)
- 우리는 Controller와 Service가 직접 '객체'를 생성하는 것이 아니라, 스프링에게 '의존성을 주입'해달라고 대신 요청할텐데요~!
- 요청하는 방법 즉, DI를 구현하는 방법으로는 크게 3가지가 있는데~ 권장되는 방식인 생성자를 통한 의존성 주입 아래 등장~
- 🌟100만개🌟 생성자를 통한 의존성 주입은 '컴파일 타임에 확인이 가능'합니다!! 런타임 시 의존성 주입 오류가 발생할 확률 줄어드는 소리 들려~~~

[✔️] '생성자'를 통한 의존성 주입 방법으로! 코드에 Controller - Service - Repository를 만들고, 각 계층에게 필요한 의존성 주입도 해볼게요~


 ## 4.내 프로젝트에 JPA 연결시키기 (2023년 4월 20일 목요일)
- 지금까지 음식 도메인의 기본 DB 셋팅과, 스프링 패키지 기본 셋팅까지 모두 끝냈으니.. 이제 본격 구현 들어가볼까요?

[✔️] JPA(인터페이스에요.. 인터페이스.. 인터페이스라구요..)로 Repository 구현해주세요

[✔️] 음식 조회 기능을 구현해주세요

[✔️] 음식 등록 기능을 구현해주세요

