FROM tomcat:latest

COPY ./target/backend.war /usr/local/tomcat/webapps/

RUN apt-get update && apt-get install -y netcat-traditional


COPY ./wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["/wait-for-it.sh", "postgre", "5432", "--", "/usr/local/tomcat/bin/startup.sh"]