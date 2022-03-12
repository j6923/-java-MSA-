FROM java:8
ARG JAR_FILE=target/demodocker-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} sample.war 
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/sample.war"]