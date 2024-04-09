package com.jarvisbot.sdk.common.utils;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class TrustAllCertificates implements X509TrustManager {
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public void checkClientTrusted(X509Certificate[] certs, String authType) {
    }

    public void checkServerTrusted(X509Certificate[] certs, String authType) {
    }
}