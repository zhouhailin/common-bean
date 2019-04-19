/*
 * Copyright 2019 ThingsCloud.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package link.thingscloud.common.bean;

import org.junit.Test;

import java.util.Date;

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public class BeanCopierTest {

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
}