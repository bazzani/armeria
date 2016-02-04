/*
 * Copyright 2015 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.armeria.client;

import java.net.InetAddress;
import java.util.Map;

import io.netty.resolver.HostsFileEntriesResolver;

/**
 * Default {@link HostsFileEntriesResolver} that resolves hosts file entries only once.
 */
final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    // TODO(trustin): Remove this fork once Netty 4.1.0.CR2 is out.
    private final Map<String, InetAddress> entries = HostsFileParser.parseSilently();

    @Override
    public InetAddress address(String inetHost) {
        return entries.get(inetHost);
    }
}
