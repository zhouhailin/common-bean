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

package link.thingscloud.common.bean.copier.annotation;

import java.lang.annotation.*;

/**
 * 复制 A 对象 为 B 对象
 * 对象 B 上注解 - 在目标对象字段注解
 *
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 *
 * BeanCopierField( sourceName = "name1", defaultSourceValue = "1", ignoreSource = true)
 * 复制 B 对象 为 A 对象
 * 对象 B 上注解 - 在源始对象字段注解
 * BeanCopierField( targetName = "name1", defaultTargetValue = "1", ignoreTarget = true)
 * <p>
 * 复制 A 对象 为 B 对象
 * 1、如果A对象上有target优先级高于 B 对象上source
 * 2、如果B对象上有source优先级高于 A 对象上target
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface BeanCopierField {

    // ****** source *******//

    String sourceName() default "";

    String defaultSourceValue() default "";

    boolean ignoreSource() default false;

    // ****** target *******//

    String targetName() default "";

    String defaultTargetValue() default "";

    boolean ignoreTarget() default false;

}
