package com.platform.papafood.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Getter
@Setter
public class AppProperties {
    private Datasource datasource;

    @ConfigurationProperties(prefix = "datasource")
    @Getter
    @Setter
    public static class Datasource {
        private DatasourceProperties modelsMaster;

        public DatasourceProperties getModelsMaster() {
            return modelsMaster;
        }

        public void setModelsMaster(DatasourceProperties modelsMaster) {
            this.modelsMaster = modelsMaster;
        }

        @Getter
        @Setter
        public static class DatasourceProperties {
            private String driverClassName;
            private String url;
            private String username;
            private String password;
            private int initialSize;
            private int minIdle;
            private int maximumPoolSize;
            private boolean showSql;
            private int batchSize;
        }
    }

    @ConfigurationProperties(prefix = "logging")
    public static class Logging {
        private String file;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }

}
