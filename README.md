# lein-sqs

A Leiningen plugin that runs an in-memory instance of Amazon's Simple Queue Service (SQS) using [Elastic MQ](https://github.com/adamw/elasticmq).

## Usage

Put `[lein-sqs "0.1.0"]` into the `:plugins` vector of your project.

Start the sqs service when running lein by specifying it before the other tasks that you are running, for example:

    $ lein sqs run

Once the task completes, the sqs service will be terminated.

If you want to run the plugin by itself you can invoke it like this:

    $ lein sqs
    
When you want to stop it just press <kbd>Ctrl</kbd>+<kbd>C</kbd>.

## Configuration

```clojure
(defproject my-project "1.0.0-SNAPSHOT"
  ...
  :plugins [[lein-sqs "0.1.0"]]
  ...
  :sqs {:port 12345 ; optional -port on which the service listens, default value 8084
        :limits "strict" ; optional - specifies sqs limits approach, either "strict" or "relaxed", default is "relaxed"
       }
  ...
)
```

## License

Copyright © 2015 Matthew Daley

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
