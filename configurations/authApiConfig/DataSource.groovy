dataSource {
    pooled = false //leave false, as pooling comes from C3PO driver maintained in resources.groovy
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
environments {
    development {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://localhost:3306/taulia?auto_reconnect=true&useGmtMillisForDatetimes=true"
            username = "root"
            password = ""
            dbCreate = "none"
            loggingSql = false
        }
    }
     
    test {
        dataSource {
            driverClassName = "org.hsqldb.jdbcDriver"
            url = "jdbc:hsqldb:mem:testDB"
            username = "sa"
            password = ""
            dbCreate = "create-drop"
            loggingSql = false
        }
    }
     
    dbdiff {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            dbCreate = "create"
            url = "jdbc:mysql://localhost:3306/taulia_platform_dbdiff"
            username = "root"
            password = ""
        }
    }
}
