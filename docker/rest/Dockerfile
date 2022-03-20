FROM registry.access.redhat.com/ubi8/ubi-minimal:8.5
WORKDIR /work/
COPY * /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]