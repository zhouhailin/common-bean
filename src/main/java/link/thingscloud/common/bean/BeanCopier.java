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

import link.thingscloud.common.bean.copier.creator.BeanCopierCreator;
import link.thingscloud.common.bean.copier.factory.BeanCopierFactory;

/**
 * Bean对象复制
 *
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public class BeanCopier<S, T> {

    private final BeanCopierCreator<S, T> beanCopierCreator;

    private BeanCopier(BeanCopierCreator<S, T> beanCopierCreator) {
        this.beanCopierCreator = beanCopierCreator;
    }

    public static <S, T> BeanCopier<S, T> create(Class<S> sourceClazz, Class<T> targetClazz) {
        return create(sourceClazz, targetClazz, BeanCopierOptions.defaultOptions());
    }

    public static <S, T> BeanCopier<S, T> create(Class<S> sourceClazz, Class<T> targetClazz, BeanCopierOptions options) {
        return new BeanCopier<>(BeanCopierFactory.getInstance().create(sourceClazz, targetClazz, options));
    }

    /**
     * 复制原对象，返回新对象
     *
     * @param source 原对象
     * @return 新目标对象
     */
    public S copy(S source) {
        return beanCopierCreator.copy(source);
    }

    /**
     * 复制原对象，返回新对象
     *
     * @param source 原对象
     * @param target 目标对象
     * @return 新目标对象
     */
    public T copy(S source, T target) {
        return beanCopierCreator.copy(source, target);
    }

}
