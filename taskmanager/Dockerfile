FROM anapsix/alpine-java
MAINTAINER subramaniambala063@gmail.com
COPY target/taskmanager.jar /opt/fse/lib/
ENTRYPOINT ["java"]
CMD ["-jar", "/opt/fse/lib/taskmanager.jar"]
VOLUME /var/lib/fse/capsule
EXPOSE 8081