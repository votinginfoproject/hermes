FROM quay.io/democracyworks/clojure-api-build:latest

ADD ./ /hermes/

WORKDIR /hermes

VOLUME ["/servers/hermes/"]

ADD resources/immutant/hermes.clj /servers/hermes/

CMD ["script/build-ima"]
