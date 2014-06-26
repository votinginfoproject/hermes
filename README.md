# hermes

Processes queue messages from [s3-ftp](https://github.com/turbovote/s3-ftp), and sends file information to Metis.

## Setup

You'll need a config.edn file available as a resource with the
following shape:

```clojure
{:aws {:creds {:access-key "your AWS access key"
               :secret-key "your AWS secret key"}
       :sqs {:region #aws/region "AWS_region_enum" ; see below
             :queue "your-sqs-queue"
             :fail-queue "your-sqs-failure-queue"}}
 :metis {:login-url "http://metis.votinginfoproject.org/login"
         :feed-url "http://metis.votinginfoproject.org/services/feeds"
         :username "hermes-username"
         :password "hermes-password"}}
```

The valid values for `:aws :sqs :region` are the enum values listed in the API documentation for [com.amazonaws.regions.Regions](http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/regions/Regions.html)

## Running in Docker

### Setup

1. Check out [immutant-docker][immutant-docker] in a sibling directory to Hermes.
1. If you've never done it, run `./script/build-dev` in the
   immutant-docker directory.

Then you can run `./script/docker-run` from this project's root whenever you like.

[immutant-docker]: https://github.com/turbovote/immutant-docker

## License

Copyright © 2014, The Pew Charitable Trusts

Distributed under the BSD 3-clause License. See LICENSE file for details.

## Contributors

Developed by Democracy Works, Inc. <dev@democracy.works>
