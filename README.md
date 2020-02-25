





# java lambda快速入门



## lambda是什么？

匿名函数。是一种函数式编程的风格。

- 函数式编程强调是做什么。不强调怎么做。





## lambda可以作为值传递

匿名函数，匿名方法差不多。

方法怎么写。



## lambda语法

`(参数列表) -> {代码逻辑}`



### 一个参数使用

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface  OneParam{

    void show(int i);
}

public class OneParamDemo {

    public static void main(String[] args) {
        // lambda它能够类型推断，知道你这里面是一个int 类型的数据。
        OneParam oneParam = (i) -> {
            System.out.println(i * 2);
        };
        oneParam.show(3);
    }
}

```



### 两个参数还有返回值

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface SumInterface{
    int sum(int x ,int y);
}

public class SumMain {

    public static void main(String[] args) {
        SumInterface sumInterface = (x,y) -> {return x + y;};
        int sum = sumInterface.sum(3, 5);
        System.out.println(sum);
    }
}

```





### 省略{}情况

如果其逻辑只有一个语句，可以省略{}

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface  OneParam{

    void show(int i);
}

public class OneParamDemo {

    public static void main(String[] args) {
        OneParam oneParam = (i) -> System.out.println(i*2);
        oneParam.show(3);
    }
}

```

### 省略()情况

如果只有一个参数，那么这个括号也可以省略

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface  OneParam{

    void show(int i);
}

public class OneParamDemo {
    public static void main(String[] args) {

        OneParam oneParam = i -> System.out.println(i*2);
        oneParam.show(3);
    }
}

```



### 省略return情况

下面的写法是错误的。

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface SumInterface{
    int sum(int x ,int y);
}

public class SumMain {

    public static void main(String[] args) {
        SumInterface sumInterface = (x,y) -> return x + y;
        int sum = sumInterface.sum(3, 5);
        System.out.println(sum);
    }
}

```



下面的省略了return是正确的。

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface SumInterface{
    int sum(int x ,int y);
}

public class SumMain {

    public static void main(String[] args) {
        SumInterface sumInterface = (x,y) ->  x + y;
        int sum = sumInterface.sum(3, 5);
        System.out.println(sum);
    }
}

```

## 为什么它这么聪明？

推断。

写的接口都是函数式接口。

只有一个抽象方法的接口就是函数式接口。

我们下面这么玩就不行，无法唯一确定。

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */
interface  NoGood{
    void good(int x);
    
    void bad(int y);
}

public class NoGoodDemo {

    public static void main(String[] args) {
        NoGood n = (x) -> {};
    }
}

```



## 应该使用函数式接口注解标记

```java
@FunctionalInterface
interface  NoGood{
//    void good(int x);

    void bad(int y);
}
```

此时编译器就能够检查。





如果定义了多个方法真的不行吗？

下面的是允许的

```java
@FunctionalInterface
interface  NoGood{
    void good(int x);

    String toString();
}
```



默认实现。





## 克隆集合，null元素不要。

```java
package com.github.qiudaozhang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 邱道长
 * 2020/2/25
 */
public class OldStyleNonEle {

    public static void main(String[] args) {
        List<String> l = Arrays.asList("james",null,"bosh",null,"wade");
        List<String> strings = nonNull(l);
        System.out.println(strings);
    }
    public static List<String> nonNull (List<String> l) {
        List<String> result = new ArrayList<>();

        for(String s:l) {
            if(s != null) {
                result.add(s);
            }
        }

        return result;
    }
}

```



lambda风格实现。

```java
package com.github.qiudaozhang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 邱道长
 * 2020/2/25
 */
public class LambdaStyleNonEle {

    public static void main(String[] args) {
        List<String> l = Arrays.asList("james",null,"bosh",null,"wade");
        List<String> strings = nonNull(l);
        System.out.println(strings);
    }

    public static  List<String> nonNull(List<String> l) {
        List<String> result = new ArrayList<>(l);
        result.removeIf(it -> it == null);// 最终以布尔类型取决
        // 传入一个谓词，是不是。
        return result;
    }
}

```

removeIf必然默默的走了循环。



## 方法引用

lambda里面可以使用 `::`引用法。



- 实例方法引用 `实例::方法名`
- 静态方法引用 `类名::方法名`
- 构造方法引用`类名::new`



### 实例引用

```java
package com.github.qiudaozhang;

import java.util.function.Consumer;

/**
 * 邱道长
 * 2020/2/25
 */
public class ConsumerDemo {

    public static void main(String[] args) {
//
//        Consumer consumer = (it) -> {
//            System.out.println(it);
//        };
//        consumer.accept("love");
        Consumer consumer = System.out::println;
        consumer.accept("love");

    }
}

```



### 静态引用

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface  StaticRef{
    void show();
}
public class StaticRefMain {


    public static void main(String[] args) {
        StaticRef staticRef = StaticRefMain::myShow;
        staticRef.show();
    }

    public static void myShow() {
        System.out.println("爱老婆很好");
    }
}

```



### 构造引用

```java
package com.github.qiudaozhang;

import java.util.function.Supplier;

/**
 * 邱道长
 * 2020/2/25
 */

class User{
    String name;
    String age;


    public User() {
        System.out.println("我是构造方法哦");
    }
}

public class SupplierMain {

    public static void main(String[] args) {

//        Supplier supplier = () -> new Object();
        Supplier<User> supplier = User::new;
        User user = supplier.get();
    }
}

```





## Consumer

```java
package com.github.qiudaozhang;

import java.util.function.Consumer;

/**
 * 邱道长
 * 2020/2/25
 */
public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer consumer = (it) -> {
            System.out.println(it);
        };
        consumer.accept("love");

    }
}

```



对于处理参数没有过多额外逻辑情况下，可以用方法引用，参数都可以不写。

自我推断。





## Supplier

```java
package com.github.qiudaozhang;

import java.util.function.Supplier;

/**
 * 邱道长
 * 2020/2/25
 */
public class SupplierMain {

    public static void main(String[] args) {
        
        Supplier supplier = () -> new Object();
    }
}

```



## ToIntFunction

```java
package com.github.qiudaozhang;

import java.util.function.ToIntBiFunction;

/**
 * 邱道长
 * 2020/2/25
 */
public class ToIntFunctionMain {

    public static void main(String[] args) {
        ToIntBiFunction<String,String> toIntBiFunction = (x,y) -> Integer.parseInt(x) + Integer.parseInt(y);
        int i = toIntBiFunction.applyAsInt("37", "77");
        System.out.println(i);
    }
}

```





## 参数类型不能省略情况

```java
package com.github.qiudaozhang;

import java.util.function.Consumer;

/**
 * 邱道长
 * 2020/2/25
 */
public class ParamTypeNeed {

    public static void main(String[] args) {
        show("ss",t -> {
            System.out.println(t);
        });
    }


    public static void show(CharSequence s , Consumer<CharSequence> consumer) {
        System.out.println(1);
        consumer.accept(s);
    }

    public static void show(String s , Consumer<String> consumer) {
        System.out.println(2);
        consumer.accept(s);
    }

}

```







```java
package com.github.qiudaozhang;

import java.util.function.Consumer;

/**
 * 邱道长
 * 2020/2/25
 */
public class ParamTypeNeed {

    public static void main(String[] args) {
        show("ss",(CharSequence t) -> {
            System.out.println(t);
        });
    }


    public static void show(CharSequence s , Consumer<CharSequence> consumer) {
        System.out.println(1);
        consumer.accept(s);
    }

    public static void show(String s , Consumer<String> consumer) {
        System.out.println(2);
        consumer.accept(s);
    }

}

```



或者

```java
package com.github.qiudaozhang;

import java.util.function.Consumer;

/**
 * 邱道长
 * 2020/2/25
 */
public class ParamTypeNeed {

    public static void main(String[] args) {
        show("ss",(String t) -> {
            System.out.println(t);
        });
    }


    public static void show(CharSequence s , Consumer<CharSequence> consumer) {
        System.out.println(1);
        consumer.accept(s);
    }

    public static void show(String s , Consumer<String> consumer) {
        System.out.println(2);
        consumer.accept(s);
    }

}

```



## java 闭包

Java的闭包比JS肯定要弱的，Java只能部分实现闭包的概念。考虑现实的问题。折中方案来适应开发需求。



未来

- oop基石
- 配合函数式编程风格辅助



## lambda和内部类

不是一回事。

- lambda里面不能访问非常量。

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */


public class LambdaCanAccess {

    public static void main(String[] args) {

        int a = 3;
        a = 4;
        Greeting g = () -> {
            System.out.println(a);//错误，不能访问
        };
    }
}

```

下面的写法还是不行的。

```java
package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */


public class LambdaCanAccess {

    public static void main(String[] args) {

        int a = 3;
        Greeting g = () -> {
            System.out.println(a);
        };
        a = 4;
    }
}

```



- lambda没有自己的this，内部类是有的
- lambda仅仅是方法级别，内部类是类级别
- 内部类可以继承其它类，还可以实现很多接口，lambda只能搞一个函数式接口
- 内部类也是有class文件的，lambda最终只是外部类的一个私有方法
- 内部类jar会大一些，lambda会小一些

有的功能是必须要用内部类。



## 缺点

- 调试来讲灾难，导致堆栈很长，javac支持较好，JVM层面。
- 你必须要适应函数式编程风格。





















