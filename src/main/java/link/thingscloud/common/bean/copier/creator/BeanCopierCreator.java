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

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public interface BeanCopierCreator<S, T> {

    enum Impl {
        /**
         * 自定义 - Getting And Setting
         */
        DEFAULT,
        /**
         * FastJSON
         */
        SIMPLE
    }

    /**
     * 复制原对象，返回新对象
     *
     * @param source 原对象
     * @return 新目标对象
     */
    S copy(S source);

    /**
     * 复制原对象，返回新对象
     *
     * @param source 原对象
     * @param target 目标对象
     * @return 新目标对象
     */
    T copy(S source, T target);

}
