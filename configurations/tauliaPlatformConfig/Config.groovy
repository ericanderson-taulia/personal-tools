grails.debug.productionOverride = 's'
grails {
  converters.xml.default.deep = true

  /* =========== MAIL DEFAULTS =========== */
  mail {
    host = "smtp.gmail.com"
    port = 587
    username = "portal@taulia.com"
    password = ""
    props = ["mail.smtp.auth": "true",
      "mail.smtp.starttls.enable": "true",
      "mail.smtp.socketFactory.port": "587",
      "mail.smtp.socketFactory.fallback": "false"]
    allowedTestDomains = ['gmail.com', 'taulia.com']
    allowSendingToAllDomains = false
    userConfigEmailTypes = [2, 100, 111, 113, 122, 135, 162, 163, 169]
    //see email/user config setup wiki page for configuration details
  }
  mail.default.from = "portal@taulia.com"

  /* =========== MIME HANDLING =========== */
  mime {
    file.extensions = true // enables the parsing of file extensions from URLs into the request format
    use.accept.header = false

    types = [html: ['text/html', 'application/xhtml+xml'],
      text: 'text-plain',
      js: 'text/javascript',
      rss: 'application/rss+xml',
      atom: 'application/atom+xml',
      css: 'text/css',
      csv: 'text/csv',
      all: '*/*',
      json: ['application/json', 'text/json'],
      form: 'application/x-www-form-urlencoded',
      multipartForm: 'multipart/form-data',
      htc: 'text/x-component'
    ]
  }

  /* =========== VIEW CONFIG =========== */
  // The default codec used to encode data with ${}
  views {
    gsp.encoding = "UTF-8"
    javascript.library = "jquery"
  }
  views.default.codec = "html" // none, html, base64
  converters.encoding = "UTF-8"

  // enabled native2ascii conversion of i18n properties files
  enable.native2ascii = true
  // enable Sitemesh preprocessing of GSP pages
  views.gsp.sitemesh.preprocess = true
  // scaffolding templates configuration
  scaffolding.templates.domainSuffix = 'Instance'
  json.legacy.builder = false
  port.http = 80
  port.https = 443

  /* =========== 'DOMAIN' CLASS CONFIG =========== */
  validateable.classes = [com.taulia.www.enroll.question.Question]

//  serverURL="http://localhost:8080"
  plugin {
    databasemigration.changelogFileName = "changelog.xml"
  }

  plugin {
    aws {
      credentials {
        accessKey = 'AKIAJIY3DFMMC4HCAHNA'
        secretKey = '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'
      }
      ses {
        enabled = true
        from = "portal@taulia.com"
      }
      verifyCheckEveryXDays = 1
    }
  }
}

jquery.sources = 'jquery'
jawr.debug.on = true

// encryption settings
jasypt.password = "set in local config.groovy"
// execute the initial encryption of unencrypted fields during startup (true=execute initial encryption, false=don't execute)
jasypt.alwaysExecuteEncryption = true

/* =========== LOGGING =========== */
log4j = {
  def logFolder = "${System.getProperty("catalina.base", "")}/logs/"
  appenders {
    console name: 'console', layout: pattern(conversionPattern: '%d %-5p [%t] %c %x - %m%n')
  }
  root {
    additivity = false
    info 'console'
  }
  error 'org.codehaus.groovy.grails.web.pages', //  GSP
    'org.codehaus.groovy.grails.web.sitemesh', //  layouts
    'org.codehaus.groovy.grails.commons', // core / classloading
    "org.codehaus.groovy.grails.scaffolding",
    'org.springframework.security', //security
    'org.codehaus.groovy.grails.plugins', // plugins
    'com.mysql',
    'org.mortbay.log',
    "grails.app",
    'org.codehaus.groovy.grails.web.servlet',  //  controllers
    'org.codehaus.groovy.grails.web.mapping.filter', // filter URL mapping
    'org.codehaus.groovy.grails.web.mapping', // URL mapping
    "filter.UrlMappingsFilter"

  warn 'org.codehaus.groovy.grails.webflow',
    'org.codehaus.groovy.grails.plugins', // plugins
    'org.springframework',
    'org.hibernate',
    'org.springframework.webflow.persistence',
    'org.springframework.webflow.execution',
    'org.springframework.webflow',
    "grails.app.bootstrap",
    "grails.app.domain",
    "grails.app.tagLib",
    'grails.app.controller',
    "grails.app.tagLib",
    "grails.app.service",
    'org.apache.shiro',
    "grails.app.realm",
    'org.codehaus.groovy.grails.orm.hibernate' // hibernate integration

  info "grails.app.filters.com.taulia.www.filters",
    'com.taulia.www.comm.xmlrpc',
    'grails.app.controller.com.taulia',
    "grails.app.tagLib.com.taulia",
    "grails.app.service.com.taulia"

  debug 'com.taulia.www.srv.v1_2_9.invoice.InvoiceUpdate_1_2_9_Service'

  additivity.StackTrace = true
}

/* =========== FCKEDITOR =========== */
fckeditor {
  upload {
    basedir = "/uploads/"
    overwrite = false
    link {
      browser = true
      upload = false
      allowed = []
      denied = ['html', 'htm', 'php', 'php2', 'php3', 'php4', 'php5', 'phtml', 'pwml', 'inc', 'asp', 'aspx', 'ascx', 'jsp',
        'cfm', 'cfc', 'pl', 'bat', 'exe', 'com', 'dll', 'vbs', 'js', 'reg',
        'cgi', 'htaccess', 'asis', 'sh', 'shtml', 'shtm', 'phtm']
    }
    image {
      browser = true
      upload = false
      allowed = ['jpg', 'gif', 'jpeg', 'png']
      denied = []
    }
    flash {
      browser = false
      upload = false
      allowed = ['swf']
      denied = []
    }
    media {
      browser = false
      upload = false
      allowed = ['mpg', 'mpeg', 'avi', 'wmv', 'asf', 'mov']
      denied = []
    }
  }
}

/* =========== archiverix - archive settings =========== */
archiverix {
  encryptNewFiles = false
  cryptoAlgorithm = "PBEWithMD5AndDES"
  cryptoKeyProvider = "com.taulia.archiverix.crypto.SimpleKeyProvider"
  currentDataStore = 's3DataStoreService'
  s3 {
    accessKey = 'AKIAJIY3DFMMC4HCAHNA'
    secretKey = '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'
    defaultBucket = 'archiverix.dev.test'
  }
}

/* =========== taulia =========== */

taulia {

  clamav {
    serverUrl = 'https://qetest-intapi.taulia.com/clamavApi/'
  }

  imageMagick {
    path = '/usr/local/bin'
  }

  ticketMgt {
    serverUrl = 'http://localhost:8888/'
  }

/* ======== Company API ======== */
 company {
   client {
     keystoreFile = './test/integration/com/taulia/certs/company-appserver.pfx'
     keystorePassphrase = 'password'
     truststoreFile = './test/integration/com/taulia/certs/company-serverstore.jks'
     truststorePassphrase = 'password'
     serverUrl = 'https://localhost:9415'
     maxPoolSize = 10
     timeout = 10000
    }
  }

/* ======== email API ========== */
  emailApi {
    client {
      url = "localhost:8430"
      keystoreFile = "./test/integration/com/taulia/certs/email_appserver.pfx"
      keystorePassphrase = "password"
      truststoreFile = "./test/integration/com/taulia/certs/email_serverstore.jks"
      truststorePassphrase = "password"
      timeout = 60000
      maxPoolSize = 10
    }
  }

/* ========= Virus API =========*/
  virusScan {
    client {
      keystoreFile = './test/integration/com/taulia/certs/virusScan_appserver.pfx'
      keystorePassphrase = 'password'
      truststoreFile = './test/integration/com/taulia/certs/virusScan_serverstore.jks'
      truststorePassphrase = 'password'
      serverUrl = 'https://localhost:8488'
      maxPoolSize = 10
      timeout = 10000
    }
  }

/* ======== Document API ======= */
  documentGeneration {
    client {
      url = "localhost:10040"
      keystoreFile = "./test/integration/com/taulia/certs/documentGeneration_appserver.pfx"
      keystorePassphrase = "password"
      truststoreFile = "./test/integration/com/taulia/certs/documentGeneration_serverstore.jks"
      truststorePassphrase = "password"
      timeout = 60000
      maxPoolSize = 10
    }
  }

/* ======== Message API ========*/
  messageClient {
    server = "localhost"
    port = 11235
    clientCertificateLocation = "./test/integration/com/taulia/certs/message_appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "./test/integration/com/taulia/certs/message_serverstore.jks"
    trustStorePassword = "password"
  }

/* ======== Purchase Order API ======== */
  purchaseOrderApi {
    server = "localhost"
    port = 8688
    clientCertificateLocation = "./test/integration/com/taulia/certs/po_appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "./test/integration/com/taulia/certs/po_serverstore.jks"
    trustStorePassword = "password"
  }

/* =========== TrustedComponent API =========== */
  trustedClient {
    clientCertificateLocation = "/Users/ericanderson/config/monolith_tc/appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "/Users/ericanderson/config/monolith_tc/serverstore.jks"
    trustStorePassword = "password"
    server = "localhost"
    port = 8488
  }
  /* ======== Early Payment API ======== */
  earlyPaymentApi {
    server = "https://localhost:8490"
    port = 8490
    clientCertificateLocation = "./test/integration/com/taulia/certs/ep_appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "./test/integration/com/taulia/certs/ep_serverstore.jks"
    trustStorePassword = "password"
  }

  metrics {
    clientCertificateLocation = "./test/integration/com/taulia/certs/metrics_appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "./test/integration/com/taulia/certs/metrics_serverstore.jks"
    trustStorePassword = "password"
    server = "localhost"
    port = 8492
  }

/* =========== Internal API =========== */
  intapi {
    connectionAttempts = 2
    serverUrl = 'https://qetest-intapi-blue.taulia.com/pdfGen/'
  }

/* ======== Funder API ========*/
  funderApi {
    server = "localhost"
    port = 10010
    clientCertificateLocation = "./test/integration/com/taulia/certs/funder_appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "./test/integration/com/taulia/certs/funder_serverstore.jks"
    trustStorePassword = "password"
  }

/* ======= Invoice API ======== */
  invoiceClient {
    url = "https://localhost:8491"
    clientCertificateLocation = "./test/integration/com/taulia/certs/invoice_appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "./test/integration/com/taulia/certs/invoice_serverstore.jks"
    trustStorePassword = "password"
    timeout = 60000
    maxPoolSize = 10
    caching = true
  }

  /* ======== Marketplace API ======== */
  marketplace {
    clientCertificateLocation = "./test/integration/com/taulia/certs/marketplace_appserver.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "./test/integration/com/taulia/certs/marketplace_serverstore.jks"
    trustStorePassword = "password"
    server = "https://localhost:8420"
  }

  /* =========== LANGUAGES/LOCALES =========== */
  // Strings for java.util.Locale constants (e.g. Locale.US)
  locales {
    supportedLocales = ['US']
    defaultLocale = 'US'
  }

  /* =========== Remote Auth =========== */
  authApi {
    server = "localhost"
    port = 8090
    contextPath = "authApi"
    maxPoolSize = 10
    timeout = 10000
    version = "v3"
    clientCertificateLocation = "/Users/ericanderson/config/authapi_monolith.pfx"
    clientCertificatePassword = "password"
    trustStoreLocation = "/Users/ericanderson/config/authapi_serverstore.jks"
    trustStorePassword = "password"
  }

  auth {
    client {
      keystoreFile = './test/integration/com/taulia/certs/auth_appserver.pfx'
      keystorePassphrase = 'password'
      truststoreFile = './test/integration/com/taulia/certs/auth_serverstore.jks'
      truststorePassphrase = 'password'
      serverUrl = 'https://localhost:8094'
      maxPoolSize = 10
      timeout = 10000
    }
  }

  /* ========== Parameter Encryption ========== */
  parameterEncryptorService {
    password = 'configure-me'
  }

  /* =========== eInvoices signed via TrustWeaver web service =========== */
  trustweaver {
    signAndValidateUrl = "https://tseiod-dev.trustweaver.com/ts/svs.asmx"
    storageUrl = "https://twa-dev-db.trustweaver.com/ta_hubservices/Storage/StorageService.svc"
    adminStorageUrl = "https://twa-dev-db.trustweaver.com/ta_hubservices/Admin/AdminService.svc"
  }

  queueServer {
    url = 'vm://localhost'
    username = ''
    password = ''
  }

  /* =========== Platform Hook - runtime injection ========
    This should be used with caution as it allows code injection from platform admin!!
   */
  hooks {
    enableEmbeddedHooks = false
  }

  prochains = [
    'Aggregation Log Items': [
      'aggregationLogItemsQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Asynchronous Document Download': [
      'asyncDocumentDownloadQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Asynchronous Metrics': [
      'asyncMetricsTrackingQueueJsonChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Asynchronous REST Submission (Audit Logging)': [
      'auditLoggingQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Early Payment Request Confirm': [
      'earlyPaymentRequestConfirmJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Early Payment Update': [
      'earlyPaymentJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Early Payment Funder Response': [
      'earlyPaymentFunderResponseJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'ExactTarget Email Request': [
      'exactTargetEmailRequestJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'ExactTarget Subscriber Update': [
      'userIdQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Invoice Purchase Order Linking': [
      'invoicePurchaseOrderLinkChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Invoice Submission': [
      'invoiceSubmissionJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Invoice Update': [
      'coreDataInvoiceJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Latest Created Document': [
      'latestCreatedDocumentQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Payment Record Update': [
      'coreDataPaymentRecordJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'paymentItemJsonChannel': [
        enabled: true,
        concurrency: 1
      ],
      'updateCompleteJsonChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Purchase Order Reconciliation': [
      'purchaseOrderReconciliationChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Purchase Order Update': [
      'coreDataPurchaseOrderAttachmentSyncQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'coreDataPurchaseOrderObjectLinkUpdateQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'purchaseOrderAttachmentSyncQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'purchaseOrderObjectLinkUpdateQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'REST Buyer API': [
      'invoicePersistenceRpcJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'persistCoreDataPaymentRecordRequestRpcJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'persistCoreDataPurchaseOrderRequestRpcJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'persistCoreDataInvoiceFieldConfigRequestRpcJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'persistCoreDataSupplierEnrollmentRequestIssueJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'enrollVendorJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ],
      'persistPurchaseOrderAttachmentJsonQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'TrustWeaver Validation': [
      'trustWeaverInvoiceValidationQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Vendor Enrollment Handling': [
      'vendorEnrollmentQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ],
    'Vendor Master Change Tracking': [
      'vendorMasterChangeQueueChannel': [
        enabled: true,
        concurrency: 1
      ]
    ]
  ]

  /* =========== Validation Parameters =========== */
  validation {
    invoice {
      lineItems {
        max = 950
      }
      number {
        max = 16
      }
    }
  }

/*=========== Trigger parameters for quartz Jobs ===========*/
  quartzJobs {
    availableJobs = [
      "asnSubmissionStatusCheck",
      "asynchronousInvoiceSubmission",
      "attachmentSubmissionStatusCheck",
      "automatedEarlyPaymentRequest",
      "boardingSupplierUpdate",
      "documentSubmissionAggregationReport",
      "asyncDocumentDownloadExpirationCheck",
      "earlyPaymentStatusUpdate",
      "invoiceDataWithoutPurchaseOrder",
      "invoiceSubmissionStatusCheck",
      "inviteApprovedSupplierEnrollment",
      "cashPlannerAccessLogAggregation",
      "invoiceAccessLogAggregation",
      "loginLogAggregation",
      "masterDataAccessLogAggregation",
      "messageAccessLogAggregation",
      "paymentAccessLogAggregation",
      "paymentTermsNotification",
      "paymentTermsOfferReminder",
      "poAccessLogAggregation",
      "newPayment",
      "neverLoggedOn",
      "notLoggedOnRecently",
      "newConversationMessage",
      "userPasswordResetTokenCleanUp",
      "invoicePaymentRecordSynch",
      "exactTargetLostEmailRequest",
      "paymentRecordBankDataEncryption"
    ]

    asnSubmissionStatusCheck {
      autoStart = false
      startDelay = 10 * 1000
      cronExpression = "0 0 * * * ?"
      attemptsThreshold = 3
      delayThresholdInHours = 6
    }

    asynchronousInvoiceSubmission {
      autoStart = false
      cronExpression = "0 1 0 * * ?"
    }

    attachmentSubmissionStatusCheck {
      autoStart = false
      startDelay = 10 * 1000
      cronExpression = "0 0 * * * ?"
      attemptsThreshold = 3
      delayThresholdInHours = 6
    }

    automatedEarlyPaymentRequest {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    boardingSupplierUpdate {
      autoStart = false
      cronExpression = "0 0 2 * * ?"
    }

    documentSubmissionAggregationReport {
      autoStart = false
      cronExpression = "0 0 0 * * ?"
    }

    asyncDocumentDownloadExpirationCheck {
      autoStart = false
      cronExpression = "0 0 0/6 * * ?"
    }

    earlyPaymentStatusUpdate {
      expirationLookAhead = 7
      autoStart = false
      cronExpression = "0 1 0 * * ?"
    }

    invoiceDataWithoutPurchaseOrder {
      autoStart = false
      startDelay = 90 * 1000
      cronExpression = "0 0/2 * * * ?"
    }

    invoiceSubmissionStatusCheck {
      autoStart = false
      startDelay = 10 * 1000
      cronExpression = "0 0 * * * ?"
      attemptsThreshold = 3
      delayThresholdInHours = 6
    }

    inviteApprovedSupplierEnrollment {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    cashPlannerAccessLogAggregation {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    invoiceAccessLogAggregation {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    loginLogAggregation {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    masterDataAccessLogAggregation {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    messageAccessLogAggregation {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    paymentAccessLogAggregation {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    paymentRecordBankDataEncryption {
      autoStart = false
      cronExpression = "* * * * * ?"
    }

    paymentTermsNotification {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 10 * 1000
    }

    paymentTermsOfferReminder {
      autoStart = false
      cronExpression = "0 0 2 * * ?"
    }

    poAccessLogAggregation {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
    }

    newEarlyPayment {
      autoStart = false
      cronExpression = "0 0 2 * * ?"
      hoursBackToCheck = 24
    }

    newPayment {
      autoStart = false
      cronExpression = "0 0 2 * * ?"
    }

    neverLoggedOn {
      autoStart = false
      startDelay = 10 * 1000
      cronExpression = "0 0 2 * * ?"
      createdDateSolicitationThreshold = 7
    }

    notLoggedOnRecently {
      autoStart = false
      startDelay = 10 * 1000
      cronExpression = "0 0 2 * * ?"
      previousLoginThresholdInDays = 30
    }

    newConversationMessage {
      autoStart = false
      createdDateSolicitationThreshold = 5 //minutes
      repeatInterval = 5000
    }

    userPasswordResetTokenCleanUp {
      autoStart = false
      startDelay = 10 * 1000
      repeatInterval = 5000
      // time for which the password reset token should remain valid in days
      validityThreshold = 1
    }

    invoicePaymentRecordSynch {
      autoStart = false
      cronExpression = "0 0 3 * * ?"
    }

    exactTargetLostEmailRequest {
      autoStart = false
      startDelay = 1000 * 15
      repeatInterval = 1000 * 60 * 60
      atLeastOldMillis = 1000 * 60 * 50
      atMostOldMillis = 1000 * 60 * 60 * 24
      maxQueryResultSize = 300
    }

  }

  //count of size for transaction saves before flush should happen
  maxTransactionSize = 100

  // session timeout interval in seconds (applied to session after logon)
  sessionTimeout = 45 * 60

  //SSL Secured paths - providing the controller name and the list of actions of * for all actions
  sslRequiredMap = [
    login: ['*']
  ]

  numberOfEnrollQuestions = 1

  tools {
    //codec info
    codec {
      noSpace.substituteChar = "_"
      noSpace.substituteCharMiddle = "~"
    }
  }

  widget {
    allowedTypes = [
      'button',
      'inline',
      'page'
    ]

    allowedWidgets = [
      'button': [
        'commCreateMessage'
      ],
      'inline': [
        'commNewMessagesAvailable',
        'commNewMessagesAvailableShort',
        'invoiceFinanceStatus',
        'invoiceFinanceStatusShort',
        'invoiceStatus',
        'invoiceStatusShort',
        'purchaseOrderStatus',
        'purchaseOrderStatusShort'
      ],
      'page': [
        'commCreateMessage',
        'earlyPaymentRequest',
        'invoiceDetails'
      ]
    ]
  }

  // if set to true, the messages .csv file will not be reloaded upon platform startup
  messageService.disableUpdateOnStart = false

}

/* ========= Environment specific settings ========= */
environments {
  development {
    taulia {
      //No ssl for development machines
      sslRequiredMap = []
    }
    grails {
      plugin {
        databasemigration.updateOnStart = true
        databasemigration.updateOnStartFileNames = ["changelog.xml"]
      }
      port.http = Integer.parseInt(System.getProperty('server.port', '8080'))
      port.https = 8443
      appName = "tauliaPlatform"
      serverURL = "http://localhost:${port.http}/${appName}"
    }
  }
  test {
    taulia {
      //No ssl for development machines
      sslRequiredMap = []
    }
    grails {
      plugin {
        databasemigration.updateOnStart = false
        databasemigration.updateOnStartFileNames = ["changelog.xml"]
      }
      port.http = Integer.parseInt(System.getProperty('server.port', '8080'))
      port.https = 8443
      appName = "tauliaPlatform"
      serverURL = "http://localhost:${port.http}/${appName}"
    }
  }
}
