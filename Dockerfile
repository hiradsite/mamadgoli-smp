FROM eclipse-temurin:8-jre

WORKDIR /server

RUN apt-get update \
    && apt-get install -y curl \
    && rm -rf /var/lib/apt/lists/*

RUN curl -fL "https://fill-data.papermc.io/v1/objects/e67da4851d08cde378ab2b89be58849238c303351ed2482181a99c2c2b489276/paper-1.16.5-794.jar" \
    -o paper.jar

COPY . .

RUN chmod +x start.sh

EXPOSE 25565

CMD ["./start.sh"]
