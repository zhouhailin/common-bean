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

import link.thingscloud.common.bean.copier.BeanCopierCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public class BeanCopierOptions {

    private List<String> ignoreFields = new ArrayList<>(8);

    private BeanCopierCreator.Impl beanCopierCreatorImpl = BeanCopierCreator.Impl.FAST_JSON;

    private BeanCopierOptions() {
    }

    public static BeanCopierOptions defaultOptions() {
        return new BeanCopierOptions();
    }

    public BeanCopierCreator.Impl beanCopierCreatorImpl() {
        return beanCopierCreatorImpl;
    }

    public BeanCopierOptions beanCopierCreatorImpl(BeanCopierCreator.Impl beanCopierCreatorImpl) {
        this.beanCopierCreatorImpl = beanCopierCreatorImpl;
        return this;
    }

    public List<String> ignoreFields() {
        return ignoreFields;
    }

    public BeanCopierOptions ignoreFields(String... ignoreFields) {
        if (ignoreFields == null) {
            return this;
        }
        for (String ignoreField : ignoreFields) {
            if (ignoreField != null && !ignoreField.isEmpty() && !this.ignoreFields.contains(ignoreField)) {
                this.ignoreFields.add(ignoreField);
            }
        }
        return this;
    }
}
