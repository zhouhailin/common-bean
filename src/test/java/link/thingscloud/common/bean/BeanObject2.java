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

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
@Data
@Accessors(chain = true)
public class BeanObject2 {

    private String str1;
    private String str3;
    private Short short1;
    private Short short2;
    private Long long1;
    private Long long2;
    private Date date1;
    private Date date2;
    private Double double1;
    private Double double2;

}
