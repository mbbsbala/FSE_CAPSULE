FROM alpine-java:base
MAINTAINER baeldung.com
COPY target/taskmanager.jar /opt/fse/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/fse/lib/taskmanager.jar"]
VOLUME /var/lib/fse/capsule
EXPOSE 8081