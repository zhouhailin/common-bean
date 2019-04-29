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

package link.thingscloud.common.bean.copier.creator.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import link.thingscloud.common.bean.copier.creator.AbstractBeanCopierCreator;
import link.thingscloud.common.bean.copier.creator.BeanMapper;
import link.thingscloud.common.bean.util.Assert;

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public class FastJsonBeanCopierCreatorImpl<S, T> extends AbstractBeanCopierCreator<S, T> {

    public FastJsonBeanCopierCreatorImpl(BeanMapper<S, T> beanMapper) {
        super(beanMapper);
    }

    @Override
    public S copy(S source) {
        JSONObject sourceObject = (JSONObject) JSONObject.toJSON(source);
        beanMapper.getOptions().ignoreFields().forEach(sourceObject::remove);
        return JSON.parseObject(sourceObject.toJSONString(), beanMapper.getSourceClazz());
    }

    @Override
    public T copy(S source, T target) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        JSONObject sourceObject = (JSONObject) JSONObject.toJSON(source);
        JSONObject targetObject = (JSONObject) JSONObject.toJSON(target);
        beanMapper.getOptions().ignoreFields().forEach(sourceObject::remove);
        targetObject.putAll(sourceObject);
        return JSON.parseObject(targetObject.toJSONString(), beanMapper.getTargetClazz());
    }
}
