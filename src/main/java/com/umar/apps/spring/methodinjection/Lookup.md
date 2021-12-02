# @Lookup

An annotation that indicates 'lookup' methods, to be overridden by the container to redirect them back to the `BeanFactory` for a `getBean()` call.
This is essentially an annotation-based version of the XML `lookup-method` attribute, resulting in the same runtime arrangement.

The resolution of the target bean can either be based on the return type `(getBean(Class))` or on a suggested bean name `(getBean(String))`, 
in both cases passing the method's arguments to the `getBean()` call for applying them as target factory method arguments or constructor arguments.

Such lookup methods can have default (stub) implementations that will simply get replaced by the container, 
or they can be declared as `abstract` - for the container to fill them in at runtime. In both cases, 
the container will generate runtime subclasses of the method's containing class via CGLIB, 
which is why such lookup methods can only work on:
1. Beans that the container instantiates through regular constructors.
2. Lookup methods cannot be applied on beans returned from factory methods. 

### Recommendations for typical Spring configuration scenarios
1. When a concrete class may be needed in certain scenarios, consider providing stub implementations of your lookup methods.
2. Lookup methods won't work on beans returned from @Bean methods in configuration classes; you'll have to resort to `@Inject Provider<TargetBean>` or the like instead.



