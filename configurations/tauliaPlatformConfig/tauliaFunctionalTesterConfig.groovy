taulia {
  usingEc2 = true
  db {
    sim {
      driver = 'com.mysql.jdbc.Driver'
      url = 'jdbc:mysql://qetest-percona-xtradb-cluster-green.taulia.com:3306/taulia_sim?useGmtMillisForDatetimes=true&verifyServerCertificate=false&useSSL=true&requireSSL=true'
      username = 'nEkUFQSUoZHW'
      password = 'VG68ihUypfbOskdPFQOf'
      hibernateDbVariant = 'MYSQL'
    }
    authApi {
      driver = 'com.mysql.jdbc.Driver'
      url = 'jdbc:mysql://qetest-percona-xtradb-cluster-green.taulia.com:3306/taulia-platform-trunk?useGmtMillisForDatetimes=true&verifyServerCertificate=false&useSSL=true&requireSSL=true'
      username = 'nEkUFQSUoZHW'
      password = 'VG68ihUypfbOskdPFQOf'
      hibernateDbVariant = 'MYSQL'
    }
    platform {
      driver = 'com.mysql.jdbc.Driver'
      url = 'jdbc:mysql://qetest-percona-xtradb-cluster-green.taulia.com:3306/taulia-platform-trunk?useGmtMillisForDatetimes=true&verifyServerCertificate=false&useSSL=true&requireSSL=true&sessionVariables=wsrep_sync_wait=1'
      username = 'nEkUFQSUoZHW'
      password = 'VG68ihUypfbOskdPFQOf'
      hibernateDbVariant = 'MYSQL'
    }
    trustedComponent {
      driver = 'com.mysql.jdbc.Driver'
      url = 'jdbc:mysql://na1-qetest-ted-xtradb-cluster.taulia.com:3306/taulia_trusted_component_green?useGmtMillisForDatetimes=true&verifyServerCertificate=false&useSSL=true&requireSSL=true'
      username = 'nEkUFQSUoZHW'
      password = 'VG68ihUypfbOskdPFQOf'
      hibernateDbVariant = 'MYSQL'
    }
    earlyPayment {
      driver = 'com.mysql.jdbc.Driver'
      url = 'jdbc:mysql://qetest-percona-xtradb-cluster-green.taulia.com:3306/taulia-early-payment?useGmtMillisForDatetimes=true&verifyServerCertificate=false&useSSL=true&requireSSL=true'
      username = 'nEkUFQSUoZHW'
      password = 'VG68ihUypfbOskdPFQOf'
      hibernateDbVariant = 'MYSQL'
    }
    authClient {
      driver = 'com.mysql.jdbc.Driver'
      url = 'jdbc:mysql://qetest-percona-xtradb-cluster-green.taulia.com:3306/taulia_auth?useGmtMillisForDatetimes=true&verifyServerCertificate=false&useSSL=true&requireSSL=true'
      username = 'nEkUFQSUoZHW'
      password = 'VG68ihUypfbOskdPFQOf'
      hibernateDbVariant = 'MYSQL'
    }
  }
  jasypt {
    algorithm = 'PBEWITHSHA256AND256BITAES-CBC-BC'
    providerName = 'BC'
    password = 'uatCryptoPassword'
    keyObtentionIterations = 1000
  }
  test {
    authApi {
      baseUri = 'https://qetest-authapi-green.taulia.com/authApi/'
    }
    restApi {
      baseUri = 'https://qetest-extapi-green.taulia.com/'
    }
    platform {
      baseUri = 'https://qetest-portal-green.taulia.com/'
    }
    restBuyerApi {
      baseUri = 'https://qetest-extapi-green.taulia.com/buyerApi/'
    }
    ticketMgt {
      contextPath = '/ticketApi/0.1'
      server = 'qetest-intapi-green.taulia.com'
      port = 443
      scheme = 'https'
    }
    soapApi {
      baseUri = 'https://qetest-api-green.taulia.com:12443/'
    }
    funderApi {
      server = 'qetest-intapi-funder-green.taulia.com'
      port = 10010
      clientCertificateLocation = 'src/test/resources/certs/funder/qetest/smoketest_funder_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/funder/qetest/smoketest_funder_qetest_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
    }
    sim {
      clientCertificateLocation = 'src/test/resources/certs/sim/smoketest_sim_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/sim/truststore.qetest-green.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'sim.qetest-green.k8s.tauliaint.com'
      port = 443
    }
    simV2 {
      clientCertificateLocation = 'src/test/resources/certs/sim/smoketest_sim_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/sim/truststore.qetest-green.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'https://sim.qetest-green.k8s.tauliaint.com:443'
      maxPoolSize = 100
      timeout = 10000
    }
    purchaseOrderClient {
      server = 'qetest-intapi-purchaseorderconf-green.taulia.com'
      port = 8688
      clientCertificateLocation = 'src/test/resources/certs/purchaseOrder/qetest/smoketest_purchase_order_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/purchaseOrder/qetest/smoketest_purchase_order_qetest_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
    }
    earlyPaymentApi {
      server = 'https://earlypayment.qetest-green.k8s.tauliaint.com:443'
      port = 443
      clientCertificateLocation = 'src/test/resources/certs/earlyPayment/qetest/smoketest_ep_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/earlyPayment/qetest/smoketest_ep_qetest_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
    }
    xmlRpc {
      protocol = 'https'
      port = 11443
      host = 'qetest-xmlrpc-green.taulia.com'
      path = '/xmlrpc'
      trustStore = 'pod/ssl/pod_truststore'
      defaultVersion = '1.2.9'
      multiErpFlow = false
    }
    authClient {
      serverUrl = 'https://qetest-intapi-auth-green.taulia.com:8094'
      keystoreFile = 'src/test/resources/certs/authClient/qetest/smoketest_authclient_qetest_clientstore.p12'
      keystorePassphrase = 'rGaMNB7pAwTQ745uYgTs'
      truststoreFile = 'src/test/resources/certs/authClient/qetest/smoketest_authclient_qetest_truststore.jks'
      truststorePassphrase = 'd8dJsCnfbzaI0oA7yxHrp'
    }
    message {
      clientCertificateLocation = 'src/test/resources/certs/message/smoketest_message_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/message/taulia_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'message.qetest-green.k8s.tauliaint.com'
      port = 443
      maxPoolSize = 100
      timeout = 10000
    }
    marketPlace {
      clientCertificateLocation = 'src/test/resources/certs/marketPlace/qetest/smoketest_marketplace_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/marketPlace/qetest/smoketest_marketplace_qetest_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'https://marketplace.qetest-green.k8s.tauliaint.com:443'
      port = 443
      maxPoolSize = 100
      timeout = 10000
    }
    company {
      clientCertificateLocation = 'src/test/resources/certs/company/qetest/smoketest_company_qetest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/company/qetest/smoketest_company_qetest_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'https://company.qetest-green.k8s.tauliaint.com:443'
      port = 443
      maxPoolSize = 100
      timeout = 10000
    }
    invoice {
      serverUrl = 'https://invoice.qetest-green.k8s.tauliaint.com:443'
      clientCertificateLocation = 'src/test/resources/certs/invoice/qetest/smoketest_invoice_qetest_clientstore.p12'
      clientCertificatePassword = 'taulia'
      trustStoreLocation = 'src/test/resources/certs/invoice/qetest/smoketest_invoice_qetest_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'https://invoice.qetest-green.k8s.tauliaint.com:443'
      port = 443
      maxPoolSize = 100
      timeout = 10000
    }
    outboundTracker {
      serverUrl = 'https://outboundtracker.qetest-green.k8s.tauliaint.com:443'
      clientCertificateLocation = 'src/test/resources/certs/outboundTracker/qetest/outboundtracker_smoketest_clientstore.p12'
      clientCertificatePassword = 'taulia'
      trustStoreLocation = 'src/test/resources/certs/outboundTracker/qetest/taulia_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'https://outboundtracker.qetest-green.k8s.tauliaint.com:443'
      port = 443
      maxPoolSize = 100
      timeout = 10000
    }

    ppm {
      clientCertificateLocation = 'src/test/resources/certs/ppm/qetest/ppm_smoketest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/ppm/qetest/taulia_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'https://qetest-intapi-ppm-green.taulia.com:10070'
      maxPoolSize = 10
      timeout = 180000
    }

    ticketManagement {
      clientCertificateLocation = 'src/test/resources/certs/ticketManagement/ticket_management_smoketest_clientstore.p12'
      clientCertificatePassword = 'rGaMNB7pAwTQ745uYgTs'
      trustStoreLocation = 'src/test/resources/certs/ticketManagement/ticket_management_smoketest_truststore.jks'
      trustStorePassword = 'd8dJsCnfbzaI0oA7yxHrp'
      server = 'https://qetest-intapi-ticketmanagement-green.taulia.com:9191'
      maxPoolSize = 10
      timeout = 10000
    }
    trustedComponentApi {
      server = 'qetest-ted-green.taulia.com'
      port = 443
      clientCertificateLocation = 'src/test/resources/certs/trusted/qetest/smoketest_ted_qetest_clientstore.p12'
      clientCertificatePassword = 's9yDMafCQdR5YVppg6xk'
      trustStoreLocation = 'src/test/resources/certs/trusted/qetest/smoketest_ted_qetest_truststore.jks'
      trustStorePassword = 'WfM2y894dpgR8KAVbay4'
    }
    trustedComponentSchedulerApi {
      server = 'qetest-ted-scheduler-green.taulia.com'
      port = 443
      clientCertificateLocation = 'src/test/resources/certs/trusted/qetest/smoketest_ted_qetest_clientstore.p12'
      clientCertificatePassword = 's9yDMafCQdR5YVppg6xk'
      trustStoreLocation = 'src/test/resources/certs/trusted/qetest/smoketest_ted_qetest_truststore.jks'
      trustStorePassword = 'WfM2y894dpgR8KAVbay4'
    }
    extapiBuyerIntegration {
      server = 'qetest-extapi-buyerintegration-green.taulia.com'
      port = 9502
      protocol = 'https'
    }
    scf {
      funderBuyerId = 'GRE'
      invoiceCount = 1000
      funderId = '484718cc5dd5f72ede9ada135fabf114'
      e2e {
        timeout = 300
      }
    }
  }
}

