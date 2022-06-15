package com.andersenlab.autotests.core.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ProxyInfo {
    String ip;
    Double latency;
}
