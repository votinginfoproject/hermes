FROM quay.io/democracyworks/clojure-api:latest
MAINTAINER Democracy Works, Inc. <dev@democracy.works>

# cache dependencies if project.clj hasn't changed
ADD ./project.clj /hermes/project.clj
WORKDIR /hermes
RUN lein deps

ADD ./src /hermes/src

CMD ["lein", "with-profile", "production", "run"]
