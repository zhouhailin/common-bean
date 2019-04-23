# common-bean

[![Jdk Version](https://img.shields.io/badge/JDK-1.8-green.svg)](https://img.shields.io/badge/JDK-1.8-green.svg)
[![Build Status](https://travis-ci.org/zhouhailin/common-bean.svg?branch=master)](https://travis-ci.org/zhouhailin/common-bean)
[![Coverage Status](https://img.shields.io/codecov/c/github/zhouhailin/common-bean/master.svg)](https://codecov.io/github/zhouhailin/common-bean?branch=master&view=all#sort=coverage&dir=asc)  
[![GitHub release](https://img.shields.io/github/release/zhouhailin/common-bean.svg)](https://github.com/zhouhailin/common-bean/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

## 版本迭代

- [x] fastjson实现 - 1.0.x
- [ ] 注解实现 - 1.1.x
- [ ] 反射实现 - 1.2.x
- [ ] 动态代理实现 1.3.x

## 快速使用

- java version

```
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```

- ### maven

```
<dependency>
  <groupId>link.thingscloud</groupId>
  <artifactId>common-bean</artifactId>
  <version>1.0.0.BETA</version>
</dependency>
```

- example

```
BeanCopier<BeanObject1, BeanObject2> beanCopier = BeanCopier.create(BeanObject1.class, BeanObject2.class,
            BeanCopierOptions.defaultOptions()
                    .ignoreFields("short2"));

    BeanObject1 beanObject1 = new BeanObject1()
            .setStr1("str1").setStr2("str2")
            .setShort1((short) 1).setShort2((short) 2)
            .setLong1(1L).setLong2(2L)
            .setDouble1(1D).setDouble2(2D)
            .setDate1(new Date(System.currentTimeMillis())).setDate2(new Date(System.currentTimeMillis()));

    @Test
    public void copy() {
        BeanObject1 copy = beanCopier.copy(beanObject1);
        System.out.println(copy);
    }

    @Test
    public void copy1() {
        BeanObject2 copy1 = beanCopier.copy(beanObject1, new BeanObject2());
        System.out.println(copy1);
    }
```

- source & target object

```
@Data
@Accessors(chain = true)
public class BeanObject1 {
    private String str1;
    private String str2;
    private Short short1;
    private Short short2;
    private Long long1;
    private Long long2;
    private Date date1;
    private Date date2;
    private Double double1;
    private Double double2;
}

@Data
@Accessors(chain = true)
public class BeanObject1 {
    private String str1;
    private String str2;
    private Short short1;
    private Short short2;
    private Long long1;
    private Long long2;
    private Date date1;
    private Date date2;
    private Double double1;
    private Double double2;
}
```

## License

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html) Copyright (C) Apache Software Foundation
