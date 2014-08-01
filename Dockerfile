FROM quay.io/democracyworks/clojure-api:latest
MAINTAINER Democracy Works, Inc. <dev@democracy.works>

# cache dependencies if project.clj hasn't changed
ADD ./project.clj /hermes/project.clj
WORKDIR /hermes
RUN lein deps

ADD ./ /hermes/

VOLUME ["/servers/hermes/"]

ADD resources/immutant/hermes.clj /servers/hermes/

CMD ["script/build-ima"]
