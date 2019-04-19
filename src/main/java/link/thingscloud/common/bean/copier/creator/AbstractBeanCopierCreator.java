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

package link.thingscloud.common.bean.copier.creator;

import link.thingscloud.common.bean.BeanCopierOptions;

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public abstract class AbstractBeanCopierCreator<S, T> implements BeanCopierCreator<S, T> {

    protected final Class<S> sourceClazz;
    protected final Class<T> targetClazz;
    protected final BeanCopierOptions options;

    protected AbstractBeanCopierCreator(Class<S> sourceClazz, Class<T> targetClazz, BeanCopierOptions options) {
        this.sourceClazz = sourceClazz;
        this.targetClazz = targetClazz;
        this.options = options;
    }
}
