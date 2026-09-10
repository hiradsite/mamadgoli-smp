FROM eclipse-temurin:8-jre

WORKDIR /server

RUN apt-get update \
    && apt-get install -y curl \
    && rm -rf /var/lib/apt/lists/*

RUN curl -fL \
    "https://api.papermc.io/v2/projects/paper/versions/1.16.5/builds/794/downloads/paper-1.16.5-794.jar" \
    -o paper.jar

COPY . .

RUN chmod +x start.sh

EXPOSE 25565

CMD ["./start.sh"]
