FROM maven as builder
WORKDIR /etc/todo-backend
COPY pom.xml .
RUN mvn dependency:resolve-plugins
RUN mvn dependency:resolve
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jre-alpine
COPY --from=builder /etc/todo-backend/target/todo-backend*.jar /opt/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:+UseG1GC", "-jar", "/opt/app.jar"]