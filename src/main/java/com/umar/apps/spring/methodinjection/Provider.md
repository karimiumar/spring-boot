# Provider

A `Provider` interface in Spring is defined as 
```java
package javax.inject;
public interface Provider<T> {
    T get();
}
```

As per the specification, a `Provider.get()` call will always return the new instance of a `Prototype` scoped bean.

### An example of @Inject Provider<TargetBean>

Below is a `@Scope("prototype")` scoped Spring bean which returns a `LocalDateTime`

```java
import java.time.LocalDateTime;

@Scope("prototype")
class PrototypeBean {

    private LocalDateTime now = LocalDateTime.now();
    
    public LocalDateTime getNow() {
        return now; 
    }
}
```

Now let's `@Autowire` the `@Scope("prototype")` scoped Spring bean in a `@Scope("singleton")` using a `Provider`

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Scope("singleton")
class SingletonBean {
    @Autowired Provider<PrototypeBean> prototypeBeanProvider;
    
    public void showCurrentTime() {
        var bean = prototypeBeanProvider.get();
        System.out.println(bean);
    }
}
```

Now time to see it in action:

```java
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
class App {

    @Bean
    PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    SingletonBean singletonBean() {
        return new SingletonBean();
    }

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(App.class);
        var bean = ctx.getBean(SingletonBean.class);
        bean.showCurrentTime();
        Thread.sleep(1000);;
        
        bean = ctx.getBean(SingletonBean.class);
        bean.showCurrentTime();
    }
}
```