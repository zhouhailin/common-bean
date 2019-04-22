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

package link.thingscloud.common.bean.copier;

import link.thingscloud.common.bean.BeanCopierOptions;
import link.thingscloud.common.bean.copier.creator.AbstractBeanCopierCreator;
import link.thingscloud.common.bean.copier.creator.impl.DefaultBeanCopierCreatorImpl;
import link.thingscloud.common.bean.copier.creator.impl.FastJsonBeanCopierCreatorImpl;
import link.thingscloud.common.bean.util.Assert;

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public class BeanCopierFactory {

    private static final BeanCopierFactory BEAN_COPIER_FACTORY = new BeanCopierFactory();

    public static BeanCopierFactory getInstance() {
        return BEAN_COPIER_FACTORY;
    }

    public <S, T> AbstractBeanCopierCreator<S, T> create(Class<S> sourceClazz, Class<T> targetClazz, BeanCopierOptions options) {
        Assert.notNull(sourceClazz, "Source Class must not be null");
        Assert.notNull(targetClazz, "Target Class must not be null");

        switch (options.beanCopierCreatorImpl()) {
            case DEFAULT:
                return new DefaultBeanCopierCreatorImpl<>(sourceClazz, targetClazz, options);
            case FAST_JSON:
                return new FastJsonBeanCopierCreatorImpl<>(sourceClazz, targetClazz, options);
            default:
                return new DefaultBeanCopierCreatorImpl<>(sourceClazz, targetClazz, options);
        }
    }

}
