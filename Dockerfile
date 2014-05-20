FROM quay.io/democracyworks/clojure-api-build:latest

ADD ./ /hermes-processor/

WORKDIR /hermes-processor

VOLUME ["/servers/hermes-processor/"]

ADD resources/immutant/hermes-processor.clj /servers/hermes-processor/

CMD ["script/build-ima"]
