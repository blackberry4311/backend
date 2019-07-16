FROM maven:3.3-jdk-8 as builder
USER root

WORKDIR /app

COPY pom.xml ./
RUN mvn -B -f pom.xml dependency:resolve

COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/papafoodBackend-*.jar ./papafoodBackend.jar

EXPOSE 8080

ENV JAVA_OPTS_XMS 256m
ENV JAVA_OPTS_XMX 600m
ENV JAVA_OPTS_MAX_METASPACE 512m
ENV JAVA_OPTS_MIN_HEAP_FREE_RATIO 10
ENV JAVA_OPTS_MAX_HEAP_FREE_RATIO 90
ENV JAVA_OPTS_GC_TIME_RATIO 99
ENV JAVA_OPTS_ADAPTIVE_SIZE_POLICY_WEIGHT 90

ENTRYPOINT exec java \
    -server \
    -Xms$JAVA_OPTS_XMS \
    -Xmx$JAVA_OPTS_XMX \
    -XX:MaxMetaspaceSize=${JAVA_OPTS_MAX_METASPACE} \
    -XX:+UseParallelGC \
    -XX:MinHeapFreeRatio=${JAVA_OPTS_MIN_HEAP_FREE_RATIO} \
    -XX:MaxHeapFreeRatio=${JAVA_OPTS_MAX_HEAP_FREE_RATIO} \
    -XX:GCTimeRatio=${JAVA_OPTS_GC_TIME_RATIO} \
    -XX:AdaptiveSizePolicyWeight=${JAVA_OPTS_ADAPTIVE_SIZE_POLICY_WEIGHT} \
    -Djava.security.egd=file:/dev/./urandom -jar ./papafoodBackend.jar