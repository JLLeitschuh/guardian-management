/*
 * Copyright 2010 Guardian News and Media
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.gu.management.database.logging;

import com.google.common.base.Predicate;

import java.lang.reflect.Method;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;


public class TimeableMethodPredicate implements Predicate<Method> {

    private final Set<String> timeableMethodNames = newHashSet("execute", "executeQuery", "executeUpdate");

    @Override
    public boolean apply(Method method) {
        return timeableMethodNames.contains(method.getName());
    }
}
