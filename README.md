# 스프링 핵심 원리 - 기본편

## 스프링 이란🧐
- 📝스프링의 역사
  - 2003년 스프링 프레임워크 1.0 출시 (XML)
  - 2006년 스프링 프레임워크 2.0 출시 (XML 편의 기능 지원)
  - 2009년 스프링 프레임워크 3.0 출시 (XML -> 자바 설정)
  - 2013년 스프링 프레임워크 4.0 출시 (자바8)
  - 2014년 스프링 부트 1.0 출시
  - 2017년 스프링 프레임워크 5.0 출시, 스프링 부트 2.0 출시 (리엑티브 프로그래밍 지원)
  - 2020년 스프링 프레임워크 5.2.x, 스프링 부트 2.3.x ...

- 🛠스프링 프레임워크 기술
  - 핵심 기술 : DI, AOP, 이벤트, ...
  - 웹 기술 : MVC, WebFlux...
  - 데이터 접근 기술 : 트랜잭션, JDBC, ORM, XML ...
  - 기술 통합 : 캐시, 이메일, 스케쥴링, 원격접근 ...

- 🎇스프링 부트
  - 스프링을 편리하게 사용할 수 있도록 지원
  - 내장 웹 서버가 있어서 별도의 웹 서버가 필요 없음
  - 손쉬운 빌드 구성을 위한 starter 종속성 제공
  - 써드파티 라이브러리 자동 구성
  - 관례에 의한 간결한 설정

- ✨스프링의 핵심
  - 자바 언어 기반의 프레임 워크
  - 객체지향 언어가 가진 강력한 특징을 살려내는 프레임워크
  - 좋은 객체 지향 어플리케이션을 개발할 수 있도록 도와주는 프레임워크




## 좋은 객체 지향 프로그래밍이란🧐
- 추상화, 캡슐화, 상속, 다형성이 있지만 제일 중요한건 다형성✨
- 객체를 설계할 때 역할과 구현을 명확히 분리
  - 역할 : 인터페이스
  - 구현 : 인터페이스를 구현한 클래스, 객체
  - 유연하며 변경이 용이해지고 확장이 가능해진다
  - 클라이언트에게 영향을 주지 않는 변경이 가능해진다
- 스프링의 객체 지향
  - 스프링은 다형성을 극대화해서 개발에 용이하게 도와준다
  - 제어의 역전(IoC), DI 모두 다형성을 화용하여 역할과 구현을 편리하게 다룰 수 있또록 지원한다.(마치 레고 블럭을 조립하듯이)




## 좋은 객체지향 설계의 5가지 원칙(로버트 마틴)🧐
### ✨이 내용은 개발을 처음할땐 전혀 이해가 안갔으나, 이제와서 다시 보니 이해가되어서 신기했으며, 좋은 원칙이라는걸 다시금 느끼게 되었다✨
- ✨SRP (Single Responsibility Principle) 단일 책임 원칙
  - 하나의 클래스는 하나의 책임만 가져야 한다
    - 다만 하나의 책임이라는것이 클 수 있고, 작을 수 있으므로 문맥과 상황에 따라 다를 수 있다
  - 중요한건 변경인데. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것 이다.👍👍👍  
- ✨OCP (Open/Closed Principle) 개방-폐쇄 원칙
  - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다
  - 🤔 아무리 다형성을 활용하여도 구현객체를 변경하려면 클라이언트 코드를 변경해야 하는 문제가 생기는데.. 이러면 원칙을 못지키는 것 아닌가?  
    -> ✔이 문제는 스프링의 DI가 해결해준다!  
- ✨LSP (Liskov Substitution Principle) 리스코프 치환 원칙
  - 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다
  - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야한다는 의미
  - EX) 자동차로 비유했을 때 엑셀이란 인터페이스는 앞으로 가라는 의미이다.  
  -> 만약 뒤로 간다던가 멈추게 된다면 LSP 원칙을 위반한것이다. 느리더라도 앞으로 가야한다
- ✨ISP (Interface Segregation Principle) 인터페이스 분리 원칙
  - 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다
  - 각 클라이언트에 맞게 분리를 하면 인터페이스가 명확해지고, 대체 가능성이 높아진다 또한 인터페이스가 변경이 되더라도 다른 클라이언트에 영향을 주지 않는다
- ✨DIP (Dependency Inversion Principle) 의존 관계 역전 원칙
  - 프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다" 의존성 주입은 해당 원칙을 따르는 방법 중 하나이다👍
  - 클라이언트가 인터페이스에 의존을 해야 유연하게 구현체를 변경할 수 있게된다
  - 🤔 다만 OCP와 마찬가지로 구현클래스가 변경되면 클라이언트 코드도 변경해야 하는 문제가 생긴다.. 이러면 원칙을 못지키는 것 아닌가?  
  -> ✔이 문제도 스프링이 해결해준다!

### ✨단순 다형성 만으론 위 5가지 원칙 중 OCP와 DIP를 지킬 수 없지만, 스프링이 가능하도록 지원해준다!



## 제어의 역전 IoC (Inversion of Control)🧐
- 직접 프로그램의 제어 흐름을 제어하는것이 아니라 외부에서 관리하는 것을 제어의 역전 이라 한다
- Tip. 프레임워크 vs 라이브러리
  - 내가 작성한 코드를 제어하고, 대신 실행하면 프레임워크
  - 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 라이브러리



## 스프링 컨테이너
- BeanFactory, ApplicationContext를 구분해서 이야기한다. 일반적으로 ApplicationContext를 스프링 컨테이너라 한다.

## 스프링 빈 등록시 주의 사항
- 빈 이름은 메서드 이름을 사용한다
- 빈 이름을 직접 부여할 수 있다
  - @Bean(name="{beanName}")
- **🔥빈 이름은 항상 다른 이름을 부여해야 한다.** 같은 이름을 부여하면 다른 빈이 무시되거나 덮어쓰여저 버린다



## 스프링 빈 전체 조회 하기
```java
// AppConfig는 @Configuration 어노테이션이 선언되어 있구 내부에 @Bean어노테이션들이 붙은 메서드가 있는 상태임 (소스 넣기 귀찮아서 설명 추가)
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
.
.
.
void findApplicationBean() {
  String[] beans = ac.getBeanDefinitionNames();
  for (String bean : beans) {
    BeanDefinition beanDefinition = ac.getBeanDefinition(bean);
    
    // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
    // Role Role_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
    if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
      Object object = ac.getBean(bean);
      // bean과 object를 출력하면 이름과 빈으로 등록된 구현부 객체가 출력된다
    }
  }
}
```


## 스프링 빈 개별적으로 조회하기
- getBean(빈이름,타입)
- getBean(타입)
- 조회 대상이 없을 경우 
  - NoSuchBeanDefinitionException: No bean named 'xxxx' available
```java
ac.getBean("memberService",MemberServiceImpl.class); // 안좋은 케이스. 구체화에 의존하면 안된다
ac.getBean("memberService",MemberService.class);
ac.getBean(MemberService.class);
```


## 스프링 빈 특정 타입을 모두 조회하기
```java
Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class); // MemberRepository타입의 빈이 Map에 모두 담긴다
```


## 스프링 빈 관련 오류
- 조회 대상이 없을 경우 
  - NoSuchBeanDefinitionException: No bean named 'xxxx' available...
- 조회 대상이 2개 이상일 경우
  - NoUniqueBeanDefinitionException: No qualifying bean of type 'xxxxxx' avaliable...


## BeanFactory와 ApplicationContext🧐
![applicationContext상속](https://user-images.githubusercontent.com/52727315/164372282-cdc4182d-ea75-412e-8d00-3f23f6a04216.png)
- BeanFactory
  - 스프링 컨테이너의 최상위 인터페이스. 빈을 관리하고 조회하는 역할을 담당한다
  - BeanFactory를 직접 사용할 일은 거의 없으며, 부가그닝이 포함된 ApplicationContext를 사용한다
- ApplicationContext
  - BeanFactory를 상속받아 제공한다
  - 빈의 조회 관리 뿐만아니라 수 많은 부가 기능을 제공한다
- BeanFactory나 ApplicationContext를 스프링 컨테이너라 지칭한다





------------------------------------------------------------------------------------------------------------------------------------
✔재밌는거 시작합니다

# 싱글톤 컨테이너 (디자인 패턴 중 하나)

## 웹 어플리케이션과 싱글톤🧐
- 스프링은 기업용 온라인 서비스 기술을 지원하기 위해 만들어졌었다.
- 웹 어플리케이션은 보통 여러 고객이 동시에 요청을 한다.
  - 🔥이 상황에서 싱글톤패턴 없이 사용할 경우 요청이 들어올때 마다 객체가 생성되고 소멸된다 -> 메모리 낭비가 심하다
    - ✔해결방안으로 1개의 객체만 생성하고 공유하도록 설계하면 된다 -> 싱글톤 패턴



## 싱글톤 패턴이란🧐
- 클래스의 인스턴스가 딱 1개만 생성되는것을 보장하는 디자인 패턴
- 따라서 객체 인스턴스를 2개이상 생성하지 못하도록 막아야 한다
  - private 생성자를 사용하여 외부에서 new 키워드로 객체를 생성하지 못하게 막는다
```java
// static 영역에 1개만 생성
private static final SingletonService instance = new SingletonService();

// private으로 선선하여 외부에서 객체 생성을 못하게 한다
private SingletonService() {}

// SingletonService 객체를 사용해야 할 경우 해당 메스드로만 조회할 수 있도록 한다
public static SingletonService getInstance(){return instance;}
```
- 싱글톤 패턴을 적용하면 요청이 들어올때마다 이미 만들어진 객체를 공유하기때문에 효율적으로 사용할 수 있다
- 🔥하지만 싱글톤 패턴은 많은 문제점을 가지고 있다
  - 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다
  - 의존관계 상 클라이언트가 구체 클래스에 의존한다 -> DIP 위반
  - 클라이언트가 구체 클래스에 의존하게 되어 OCP 원칙을 위반할 가능성이 높다
  - 테스트 하기가 어렵다
  - 내부 속성 변경이나 초기화가 어렵다
  - private생성자로 자식 클래스를 만들기 어렵다
  - 유연성이 떨어진다
  - 안티패턴으로 불리기도 한다
- ✨위와같은 수많은 단점을 갖고있지만 스프링 컨테이너가 이런 단점들을 다 해결해준다

------------------------------------------------------------------------------------------------------------------------------------








