# hermes-processor

Processes queue messages from s3-ftp, and sends file information to Metis.

## Setup

You'll need a config.edn file available as a resource with the
following shape:

```clojure
{:aws {:creds {:access-key "your AWS access key"
               :secret-key "your AWS secret key"}
       :s3 {:bucket "S3-bucket-name-where-USPS-data-is-stored"}
       :sqs {:region #aws/region "AWS_region_enum" ; see below
             :queue "your-sqs-queue"
             :fail-queue "your-sqs-failure-queue"}}
 :metis {:login-url "http://metis.votinginfoproject.org/login"
         :feed-url "http://metis.votinginfoproject.org/feeds"
         :username "hermes-username"
         :password "hermes-password"}
```
                                          
The valid values for `:aws :sqs :region` are the enum values listed in the API documentation for [com.amazonaws.regions.Regions](http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/regions/Regions.html)
                                                                   
## License

Copyright © 2014 Democracy Works, Inc.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
