# hermes

Processes queue messages from [s3-ftp](https://github.com/turbovote/s3-ftp), and sends file information to [Metis](https://github.com/votinginfoproject/Metis).

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

```sh
docker build -t hermes .
```

```sh
docker run -v /path/to/config-dir:/hermes/resources hermes
```

## License

Copyright © 2014, The Pew Charitable Trusts

Distributed under the BSD 3-clause License. See LICENSE file for details.

## Contributors

Developed by Democracy Works, Inc. <dev@democracy.works>
