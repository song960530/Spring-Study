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



## 싱글톤 컨테이너🧐
![싱글톤 컨테이너](https://user-images.githubusercontent.com/52727315/164393275-63ceefa3-39a7-40a2-b100-7e8f121e099b.png)
- 스프링 컨테이너는 싱글톤 컨테이너 역할을 한다
- 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 객체 인스턴스를 1개만 생성하여 관리한다
  - 이렇게 생성하고 관리하는 기능을 싱글톤 레지스트리라고 한다
- 싱글톤 패턴을 위한 지저분한 코드가 들어가지 않아도 되고, DIP/OCP 원칙, private 생성자로부터 자유롭게 사용할 수 있게 된다
- 요청이 올 때 마다 객체를 생성하는것이 아닌 만들어진 객체를 공유하여 효율적으로 재사용한다
- ps. 스프링의 기본 빈 등록방식은 싱글톤이나, 다른 방식도 제공한다



## 싱글톤 방식의 주의사항
- 🔥객체 인스턴스를 하나만 생성해서 공유하는 방식은 여러 클라이언트가 하나의 객체 인스턴스를 공유하기 때문에 상태를 **유지(stateful)** 하게 설계하면 안된다
- 🔥무상태(stateless)로 설계해야한다
  - 특정 클라이언트에 의존적인 필드가 있으면 안된다
  - 클라이언트 변경할 수 있는 필드가 있으면 안된다
  - 읽기만 가능해야 하며 필드 대신 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다
- 공유되어 사용하는 필드가 있을 경우 큰 장애로 이어진다

------------------------------------------------------------------------------------------------------------------------------------

## @Configuration과 바이트코드 조작의 마법🧐
```java
@Configuration
class AppConfig {
  .
  .
  .
  
  @Bean
  public MemberService memberService() {
    return new MemberSeviceImpl(memberRepository());
  }
  
  @Bean
  public MemberRepository memberRepository() {
    return new MemberRepository();
  }
}
```
- 위코드만 봤을 때 아래 코드의 repo1과 repo2를 찍어볼경우 당연히 서로 다른 객체가 조회되어야한다
```java
MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);

MemberRepository repo1 = memberService.getMemberRepository();
MemberRepository repo2 = ac.getBean("memberRepository",MemberRepository.class);
```
- 근데 막상 찍어보면 동일한 객체가 조회된다. 왜일까?
  - ✨스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용하여 AppConfig 클래스를 상속받아 임의의 다른 클래스를 만들고, 그 다른 클래스를 빈으로 등록한것이다

![CGLIB](https://user-images.githubusercontent.com/52727315/164414430-16055725-9c08-4cd7-b780-aa0eb2a1bb6a.png)
- 위 사진처럼 @Configuration이 붙은 클래스는 CGLIB가 바이트 코드를 조작하여 임의의 다른 클래스파일로 등록한다.  
이 과정에서 아래와 같이 내부 코드도 변경될 것 이다

![CBLIB 예상 코드](https://user-images.githubusercontent.com/52727315/164414769-f90178f2-ee32-4f03-af67-a037da479df5.png)
- 이런 식으로 @Bean이 붙은 메서드마다 존재하면 존재하는 빈을 반환하고 없으면 생성후 등록하여 반환하는 코드가 동적으로 만들어진다
- 이러한 과정 적분에 싱글톤이 보장되는 것 이다




## 만약 @Configuration 없이 @Bean을 사용하면 어떻게 될까?🤔
- @Bean만 사용해도 스프링 빈으로 등록은 되지만 싱글톤을 보장하지 않는다.
- 실제로 만들어진 스프링 빈을 getClass()로 찍어보면 CGLIB로 만들어진 객체가 아닌 실제 객체가 찍히게 된다

### ✨스프링 빈을 등록할 땐 크게 고민할 것 없이 항상 @Configuration 어노테이션을 사용하도록 하자
------------------------------------------------------------------------------------------------------------------------------------


## @ComponentScan🧐

![componentScan](https://user-images.githubusercontent.com/52727315/164644656-fa2f9928-d512-49aa-aed5-06912ede8b5f.png)
- @Component가 붙은 모든 클래스를 스프링 빈으로 등록한다
  - 기본 전략 : 스프링 빈의 이름은 클래스명의 앞글자를 소문자로 바꿔 사용한다
  - 직접 지정 : @Component("빈이름") 이렇게 사용하면 직접 빈 이름을 지정해줄 수 있다

```java
@ComponentScan(
  /**
   * 탐색할 패키지의 시작 위치를 지정. 해당 패키지 포함 하위 패키지를 모두 탐색
   * 지정하지 않으면 해당 클래스의 위치가 시작위치
   */
  basePackage = "hello.core" 
  
  /**
   * 직접만든 @MyIncludeComponent를 스프링 빈 등록 대상으로 지정한다
   */
  includeFilters = @Filter(type=FilterType.ANNOTATION, classes=MyIncludeComponent.class)
  
  /**
   * 직접만든 @MyExcludeComponent를 스프링 빈 등록 대상에서 제외한다
   */
  excludeFilters = @Filter(type=FilterType.ANNOTATION, classes=MyExcludeComponent.class)
)
```
- @SpringBootApplication 안에 @ComponentScan 어노테이션이 존재한다
  - 때문에 @ComponentScan을 사용할 경우에는 최상위 패키지의 위치에 두는것이 관례이다 (스프링부트에서도 이 방법을 기본으로 제공한다)
- ✔스프링 부트에서 컴포넌트 스캔을 기본적으로 제공하므로 개인적으로 옵션을 변경하여 사용하기 보단  
최대한 기본 설정에 맞추어 사용하는것을 권장한다




## @ComponentScan 대상🧐
- @Component : 컴포넌트 스캔에서 사용
- @Controller : 스프링MVC 컨트롤러에서 사용
  - 스프링 MVC 컨트롤러로 인식
- @Service : 스프링 비즈니스 로직에서 사용
  - 특별한 부가기능은 없고, 핵심 비즈니스 로직이 있다는 인식을 할 수 있게 도와줌
- @Repository : 스프링 데이터 접근 계층에서 사용
  - 스프링 데이터 접근 계층으로 인식하여 데이터계층의 예외를 스프링 예외로 변환해준다👍
    - 만약 DB가 바뀌었을 경우 내뱉는 에러가 바뀌게 되어 서비스단에서도 변경처리를 해줘야 하는데 이러한 예외를 공통 예외로 변환해주는 것 이다
- @Configuration : 스프링 설정 정보에서 사용
  - 스프링 빈이 싱글톤을 유지하도록 추가처리를 한다



## 스프링 빈 등록 시 충돌
- 자동 빈 등록 vs 자동 빈 등록 (컴포넌트 스캔에 의해 자동으로 스프링 빈이 중복 등록되는 경우)
  - ConflictingBeanDefinitionException 발생
- 수동 빈 등록 vs 자동 빈 등록
  - 수동 빈 등록이 우선권을 갖는다 (오버라이딩 해버림)
  - ```Overriding bean definition for bean 'memoryMemberRepository' with a different definition: replacin```  
로그가 남으면서 오버라이딩
- 만약 이렇게 오버라이딩 되면 이후에 찾을 수 없는 버그가 생겨버린다  
이러한 상황때문에 스프링 부트에서는 충돌이 나면 오류가 발생하도록 기본값을 바꾸었다

------------------------------------------------------------------------------------------------------------------------------------


## 의존관계 주입 방법
- 생성자 주입
- 수정자 주입(setter주입)
- 필드 주입
- 일반 메서드 주입 (이건 사용하지 않아 설명을 추가하지 않겠다)


## 생성자 주입(✨권장✨)
- 생성자를 통하여 의존 관계를 주입받는 방법
- 생성자 호출 시점에 딱 1번만 호출되는것이 보장된다
- 불변, 필수 의존관계에 사용
  - 불변
    - 대부분의 의존관계 주입은 어플리케이션 종료 시점까지 변하면 안된다
    - 수정자 주입을 사용하면 set메서드를 열어두어야한다
    - 변경하면 안되는 메서드를 열어두는것은 좋은 설계 방법이 아니다
    - 생성자 주입으로 객체를 생성할 경우 딱 1번만 호출되므로 불변하게 설계할 수 있다
- 순환참조문제를 실행시점에 잡아낼 수 있다
- 이 외에 여러가지 이유가 있지만, 프레임워크에 의존하지 않고, 순수한 자바 언어의 특징을 가장 잘 살리는 방법이다
```java
/**
 * 인강에서 나왔던 내용
 */
private final MemberRepository memberRepository;

@Autowired // 생성자가 1개일 경우 @Autiwired 는 생략 가능
public MemberServiceImpl(MemberRepository memberRepository) {
  this.memberRepository = memberRepository;
}

///////////////////////////

/**
 * 요즘 추천하는 방법
 * @Requiredargsconstructor 가 final이 붙은 필드를 대상으로 생성자를 만들어준다
 * 때문에 별도의 생성자 메서드 없이 주입을 받을 수 있다
 */
 
 @Service
 @Requiredargsconstructor
 public class MemberServiceImpl implements MemverService {
  private final MemberRepository memberRepository;
  
  .
  .
  .
 }
```



## Setter 주입
- setter 수정자 메서드를 사용하여 의존관계를 주입하는 방법
- 선택, 변경 가능성이 있는 의존고나계에 사용
- 자바 빈 프로퍼티 규약의 수정자 메서드를 사용하는 방법이다
```java
private MemberRepository memberRepository;

@Autowired 
public void setMemberRepository(MemberRepository memberRepository) {
  this.memberRepository = memberRepository;
}
```



## 필드 주입 (비추)
- 필드에 바로 주입하는 방법
- 코드가 간결해지는 것 이외의 장점은 없다
  - 테스트하기가 힘들어지고, 순환참조문제를 실행시점에 잡아낼 수 없다
- DI 프레임워크가 없으면 아무것도 할 수 없다
- Autowired(required=false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
```java
@Autowired
private MemberRepository memberRepository;
```




## 조회빈이 2개이상일 경우 의존관계 주입 방법🧐
- @Autowired
  - 1.타입으로 매칭 시도
  - 2.필드 이름, 파라미터 이름으로 빈 이름을 추가 매칭 시도
- @Qualifier 
  - 빈 등록하는곳과, 주입해주는 곳에 모두 선언해줘야한다
  - 1.@Qualifier끼리 매칭 시도
  - 2.빈 이름으로 매칭 시도
- @Primary
  - 여러 빈이 조회될 때 우선권을 부여해준다
  - 스프링 빈 등록 시 @Primary를 추가해주면 된다.
- @Primary, @Qualifier 활용
  - DB커넥션을 획득할땔 예로 들면 메인 커넥션에 @Primary를 적용해주고, 서브 커넥션을 획득해야 할 경우 @Qualifier를 지정하여 명시적으로 획득한다
  - @Primary는 기본값처럼 동작하는 것 이고 @Qualifier는 상세하게 동작한다 이러한 경우 넓은 범위의 선택권보단 좁은 범우의 선택권이 우선순위가 높다 따라서 @Qualifier가 우선권이 높다




## 자동, 수동 스프링 빈 등록 뭐가 더 좋을까?🧐
- 편리한 자동 기능을 기본으로 사용하자
- 관리할 빈이 많아서 설정 정보가 커지면 설정 정보를 관리하는 것 자체가 부담이 된다. 그리고 결정적으로 자동 빈 등록을 사용해도 OCP, DIP를 지킬 수 있다
- 그러면 수동 빈 등록은 언제 사용하면 좋을까?
  - 직접 등록하는 기술 지원 객체는 수동 등록
  - 주로 비즈니스 로직에 쓰일때의 업무 로직 빈과 프로젝트에 전체적으로 영향을 미치는 기술 지원 빈 으로 나눴을 때, 명확하게 한눈에 보여야 ㅎ는 기술 지원 빈을 등록할 때 수동 빈 등록을 사용해주면 좋다
- 다형성을 적극 활용하는 비즈니스 로직은 수동 등록을 고민해보자




## 스프링 빈의 생명주기
- ```스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료```



## 스프링 빈 생명주기 콜백 지원
- 크게 인터페이스(InitializingBean, DisposableBean), 설정 정보에 초기화 메서드, 종료 메서드 지정, @PostConstruct, @PreDestroy 애노테이션 지원 3가지 방법으로 지원한다
- 인터페이스(InitializingBean, DisposableBean)
  - InitializingBean 인터페이스를 상속받아 afterPropertiesSet() 메서드로 초기화를 지원한다.
  - DisposableBean 인터페이스를 상속받아 destroy() 메서드로 소멸을 지원한다.
  - 초기화, 소멸 인터페이스 단점
    - 스프링 빈 전용 인터페이스에 의존하게 된다
    - 초기화, 소멸 메서드의 이름을 변경할 수 없다
    - 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다
  -  인터페이스를 사용하는 초기화, 종료 방법은 스프링 초창기에 나온 방법이다. 지금은 다음의 더 좋은 방법들이 있어서 거의 사용하지 않는다























