FROM gradle:6.8.3-jdk8

ENV APP_HOME=/opt/app/

WORKDIR $APP_HOME

COPY . .

RUN gradle build -x test

RUN cp -R /opt/app/build/libs/* $APP_HOME/tarefas-api.jar

RUN gradle clean

EXPOSE $PORT

CMD ["java", "-jar", "-Dspring.profiles.active=${PROFILES_ACTIVE}" , "tarefas-api.jar"]

# -------------| Documentação |--------------
# criar a imagem:
# docker build -t tarefas:1.0

# executar imagem profile prod:
# docker run -p 8080:8080  -e PROFILES_ACTIVE=prod -e PORT=8080 -e CORS_URI=http://localhost:4200  tarefas:1.0